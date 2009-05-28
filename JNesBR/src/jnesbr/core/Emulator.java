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
import jnesbr.debugger.BreakpointException;
import jnesbr.joystick.StandardControl;
import jnesbr.processor.Cpu2A03;
import jnesbr.processor.memory.Memory;
import jnesbr.rom.INesROM;
import jnesbr.rom.Loader;
import jnesbr.video.Ppu2C02;
import static jnesbr.video.Ppu2C02.*;
import jnesbr.video.sprite.SpriteRAM;
import jnesbr.video.memory.VideoMemory;

/**
 * @author dreampeppers99
 */
public final class Emulator implements Runnable {

    private static Emulator emulator;
    private Loader loader;
    private Cpu2A03 cpu;
    private Ppu2C02 ppu;
    public StandardControl joystick;
    private int index = 1;
    public boolean stopped,  paused,  running;

    public final static Emulator getInstance() {
        if (emulator == null) {
            emulator = new Emulator();
        }
        return emulator;
    }

    private Emulator() {
        cpu = new Cpu2A03();
        ppu = Ppu2C02.getInstance();
        stopped = false;
        paused = false;
        running = true;
        joystick = new StandardControl();
    }

    public final Memory getMemory() {
        return Memory.getMemory();
    }

    public final VideoMemory getVideoMemory() {
        return VideoMemory.getMemory();
    }

    public final SpriteRAM getSpriteRAM() {
        return SpriteRAM.getInstance();
    }

    public final Cpu2A03 getCpu() {
        return cpu;
    }

    public final Ppu2C02 getPPU() {
        return ppu;
    }

    public final String getRomHeader() {
        return loader.getHeader();
    }

    public final boolean havePatternTable() {
        return loader.getGame().CHRROM8KPageCount != 0;
    }

    public final short[] giveMePatternTable() {
        return java.util.Arrays.copyOf(loader.getGame().chr_rom, loader.getGame().chr_rom.length);
    }

    public final void load(ByteBuffer rom) {
        loader = new Loader();
        loader.load(rom);
        cpu.reset();
        Emulator.getInstance().getPPU().initPatternTable();
    }

    public final void reset() {
        Emulator.getInstance().getCpu().reset();
        Emulator.getInstance().getMemory().reset();
        Emulator.getInstance().getPPU().reset();
    }

    public final INesROM rom() {
        return loader.getGame();
    }

    public final void pause() {
        running = false;
        paused = true;
    }

    public final void unpause() {
        running = true;
        paused = false;
    }

    public final void stop() {
        running = false;
        paused = true;
        stopped = true;
    }

    @Override
    public final void run() {
        try {
            while (!stopped) {
                while (!paused) {
                    while (running) {
                        while (cpu.cycles < CYCLES_TO_SCANLINE) {
                            cpu.step();
                        }
                        cpu.cycles = cpu.cycles - CYCLES_TO_SCANLINE;
                        ppu.doScanline();
                        if (ppu.actualScanLine == 241) {
                            if (ppu.ppuControl.executeNMIOnVBlank == 1) {
                                cpu.nmi();
                            }
                            joystick.check();
                        }
                        CYCLES_TO_SCANLINE = SCANLINE[++index & 2];
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("Error on thread emulator: " + ex);
        }
    }

    public final void stepDebugger(){
        if (cpu.cycles < CYCLES_TO_SCANLINE) {
            cpu.debugStep();
            return;
        }
        cpu.cycles = cpu.cycles - CYCLES_TO_SCANLINE;
        ppu.doScanline();
    }

    public String actualLine() {
        return cpu.actualLineDebug;
    }
}
