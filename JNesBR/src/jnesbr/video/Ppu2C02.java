/*
This file is part of JNesBR.

JNesBR is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

JNesBR is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with JNesBR.  If not, see <http://www.gnu.org/licenses/>.
 */
package jnesbr.video;

import java.util.HashMap;
import java.util.Map;
import jnesbr.core.Emulator;
import jnesbr.processor.Cpu2A03;

/**
 * @author dreampeppers99
 */
public class Ppu2C02 {

    public final static int CYCLES_TO_SCANLINE = 114;
    public final static int NUMBER_OF_SCANLINES = 240 + 3;
    public final static int CYCLES_TO_VBLANK = CYCLES_TO_SCANLINE * 20;
    public final static int MS_BY_FRAME = 17;
    private final static int RENDERING_SCANLINE = 0;
    private int actualScanLine = 0;
    private short pixelCounter = 0;
    private static Ppu2C02 instance;
    public PPUControll ppuControl = new PPUControll();
    public PPUStatus ppuStatus = new PPUStatus();
    public PPUMask ppuMask = new PPUMask();
    public PPUAddress pPUAddress = new PPUAddress();
    public PPUData pPUData = new PPUData();
    public PPUScroll ppuScroll = new PPUScroll();
    public PPUOAMAddress ppuOAMAddress = new PPUOAMAddress();
    public PPUOAMData ppuOAMdata = new PPUOAMData();
    private Map<Integer, int[][]> patternTable = new HashMap<Integer, int[][]>();
    private Frame frame = Frame.getInstance();
    private Map<Integer, Scanline> scanlines;
    private int x,  y;
    private Cpu2A03 cpu = Emulator.getInstance().getCpu();

    public static Ppu2C02 getInstance() {
        if (instance == null) {
            instance = new Ppu2C02();
        }
        return instance;
    }

    public void reset() {
        Emulator.getInstance().getVideoMemory().reset();
    }

    private Ppu2C02() {
        //ppuStatus.verticalBlankStarted = PPUStatus.InVBlank;
        initScanlineModel();
    }

    public int actualScanline(){
        return actualScanLine;
    }

    public void initPatternTable() {
        if (Emulator.getInstance().havePatternTable()) {
            short[] chr_rom = Emulator.getInstance().giveMePatternTable();
            int addressComplement = 0;
            for (int index = 0; index < chr_rom.length; addressComplement += 16, index += 16) {
                int[][] tile = new int[8][8];
                for (byte row = 0; row < 8; row++) {
                    for (byte collumn = 7; collumn >= 0; collumn--) {
                        tile[row][collumn] = ((chr_rom[row + addressComplement + 8] >> collumn & 0x1) << 1) | (chr_rom[row + addressComplement] >> collumn & 0x1);
                    }
                }
                getPatternTable().put(addressComplement / 16, tile);
            }

        }
    }

    public Map<Integer, int[][]> getPatternTable(short[] chr_rom) {
        Map<Integer, int[][]> patternTableFromRom = new HashMap<Integer, int[][]>();
        int addressComplement = 0;
        for (int index = 0; index < chr_rom.length; addressComplement += 16, index += 16) {
            int[][] tile = new int[8][8];
            for (byte row = 0; row < 8; row++) {
                for (byte collumn = 7; collumn >= 0; collumn--) {
                    tile[row][collumn] = ((chr_rom[row + addressComplement + 8] >> collumn & 0x1) << 1) | (chr_rom[row + addressComplement] >> collumn & 0x1);
                }
            }
            patternTableFromRom.put(addressComplement / 16, tile);
        }
        return patternTableFromRom;
    }

    public Map<Integer, int[][]> getPatternTable() {
        return patternTable;
    }

    public void scanLine() {
        get(actualScanLine).scanline();
    }

    private final Scanline get(final int scanLineNumber){
        return (scanLineNumber>=0 & scanLineNumber<=239) ? scanlines.get(RENDERING_SCANLINE) : scanlines.get(actualScanLine);
    }

    private void initScanlineModel() {
        scanlines.put(RENDERING_SCANLINE, new Scanline() {

            public void scanline() {
                // 0-239 - Rendering Scanline
                actualScanLine++;
            }
        });
        scanlines.put(240, new Scanline() {

            public void scanline() {
                // 240 - Idle Scanline
                actualScanLine++;
            }
        });
        scanlines.put(-1, new Scanline() {

            public void scanline() {
                // -1 - Prerender Scanline
                ppuStatus.moreThan8ObjectsOnScanLine = 0;
                ppuStatus.sprite0Hit = 0;
                ppuStatus.verticalBlankStarted = PPUStatus.NotInVBlank;
                actualScanLine++;
            }
        });
        for (int i = 242; i < 241 + 20; i++) {
            scanlines.put(i, new Scanline() {

                public void scanline() {
                    // 242 - 260 - VBlank period
                    actualScanLine++;
                }
            });
        }
        scanlines.put(241, new Scanline() {

            public void scanline() {
                // 241 - First scanline of VBlank period
                ppuStatus.verticalBlankStarted = PPUStatus.InVBlank;
                actualScanLine++;
                if (ppuControl.executeNMIOnVBlank == 1) {
                    cpu.nmi();
                }
            }
        });
        scanlines.put(261, new Scanline() {

            public void scanline() {
                // 261 - Last scanline of VBlank period
                actualScanLine = -1;
            }
        });
    }

    private final int nameTable(int tileIndex) {
        return 0;
    }

    private void realScanline() {
        //will fetch data from name, attribute, and pattern tables
        //during a scanline to produce an image on the screen
        y = actualScanLine - 1;
        for (x = 0; x < 256; x++) {
            int tileIndex = (int) x / 8;
            int tileNumber = nameTable(tileIndex);
            frame.setPixel(new float[]{1f, 2f, 3f}, x, y);
        }
        actualScanLine++;
    }
}
