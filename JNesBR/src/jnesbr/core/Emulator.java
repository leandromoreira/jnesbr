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
package jnesbr.core;

import java.nio.ByteBuffer;
import jnesbr.processor.Cpu2A03;
import jnesbr.processor.memory.Memory;
import jnesbr.rom.INesROM;
import jnesbr.rom.Loader;
import jnesbr.video.PPUStatus;
import jnesbr.video.Ppu2C02;
import static jnesbr.video.Ppu2C02.*;
import jnesbr.video.sprite.SpriteRAM;
import jnesbr.video.memory.VideoMemory;

/**
 * @author dreampeppers99
 */
public class Emulator implements Runnable {

    private static Emulator emulator;
    private Loader loader;
    private Cpu2A03 cpu;
    private Ppu2C02 gpu;

    public static Emulator getInstance() {
        if (emulator == null) {
            emulator = new Emulator();
        }
        return emulator;
    }

    private Emulator() {
        cpu = new Cpu2A03();
        gpu = Ppu2C02.getInstance();
    }

    public Memory getMemory() {
        return Memory.getMemory();
    }

    public VideoMemory getVideoMemory() {
        return VideoMemory.getMemory();
    }

    public SpriteRAM getSpriteRAM() {
        return SpriteRAM.getInstance();
    }

    public Cpu2A03 getCpu() {
        return cpu;
    }

    public Ppu2C02 getPPU() {
        return gpu;
    }

    public String getRomHeader() {
        return loader.getHeader();
    }

    public boolean havePatternTable() {
        return loader.getGame().CHRROM8KPageCount != 0;
    }

    public short[] giveMePatternTable() {
        return java.util.Arrays.copyOf(loader.getGame().chr_rom, loader.getGame().chr_rom.length);
    }

    public void load(ByteBuffer rom) {
        loader = new Loader();
        loader.load(rom);
        cpu.reset();
        Emulator.getInstance().getPPU().initPatternTable();
    }

    public void reset() {
        Emulator.getInstance().getCpu().reset();
        Emulator.getInstance().getMemory().reset();
        Emulator.getInstance().getPPU().reset();
    }

    public INesROM rom() {
        return loader.getGame();
    }

    public void pause() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void unpause() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void stop() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void stepDebugger() {
        if (cpu.cycles >= CYCLES_TO_SCANLINE) {
            if (Ppu2C02.getInstance().ppuStatus.verticalBlankStarted == PPUStatus.NotInVBlank) {
                cpu.cycles = 0;
                Ppu2C02.getInstance().scanLine();
            }else{
                if (cpu.cycles >= CYCLES_TO_VBLANK ){
                    cpu.cycles = 0;
                    Ppu2C02.getInstance().ppuStatus.verticalBlankStarted = PPUStatus.NotInVBlank;
                }
            }
        }
        cpu.debugStep();
    }

    public String actualLine() {
        return cpu.actualLineDebug;
    }
}
