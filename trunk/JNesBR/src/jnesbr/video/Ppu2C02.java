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
import jnesbr.video.sprite.SpriteRAM;

/**
 * @author dreampeppers99
 */
public class Ppu2C02 {

    public final static int CYCLES_TO_SCANLINE = 114;
    public final static int NUMBER_OF_SCANLINES = 240 + 3;
    public final static int CYCLES_TO_VBLANK = CYCLES_TO_SCANLINE * 20;
    public final static int MS_BY_FRAME = 17;
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
    private int x,y;

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
        ppuStatus.verticalBlankStarted = PPUStatus.InVBlank;
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
        if (actualScanLine >= 1 & actualScanLine <= 240) {
            realScanline();
            actualScanLine++;
        } else {
            switch (actualScanLine) {
                case 0:
                    ppuStatus.moreThan8ObjectsOnScanLine = 0;
                    ppuStatus.verticalBlankStarted = PPUStatus.NotInVBlank;
                    SpriteRAM.getInstance().reset();
                    actualScanLine++;
                    break;
                case 242:
                    actualScanLine++;
                    break;
            }
            //if is in vblank period...
            if ((actualScanLine >= 243 & actualScanLine <= 262)) {
                if (actualScanLine == 243) {
                    ppuStatus.verticalBlankStarted = PPUStatus.InVBlank;
                    if (ppuControl.executeNMIOnVBlank == 1) {
                        actualScanLine = (actualScanLine == 262) ? 0 : actualScanLine + 1;
                        Emulator.getInstance().getCpu().nmi();
                        return;
                    }
                }
                actualScanLine = (actualScanLine == 262) ? 0 : actualScanLine + 1;
            }
        }
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
    }


    
}
