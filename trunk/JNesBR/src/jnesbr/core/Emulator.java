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
import javax.swing.JTable;
import javax.swing.table.TableModel;
import jnesbr.gui.debugger.DebuggerDecoratorBuilder;
import jnesbr.processor.Cpu2A03;
import jnesbr.processor.memory.Memory;
import jnesbr.rom.Loader;
import jnesbr.util.JNesUtil;
import jnesbr.video.Ppu2C02;
import jnesbr.video.memory.VideoMemory;

/**
 * @author dreampeppers99
 */
public class Emulator implements Runnable {
    private static Emulator emulator;
    private Loader loader;
    private Cpu2A03 cpu;
    private Ppu2C02 gpu;
    private Memory memory;
    private final static int CYCLES_TO_SCANLINE = 114;

    public static Emulator getInstance() {
        if (emulator == null) {
            emulator = new Emulator();
        }
        return emulator;
    }

    private Emulator() {
        cpu = new Cpu2A03();
        gpu = Ppu2C02.getInstance();
        memory = Memory.getMemory();
    }

    public Cpu2A03 getCpu() {
        return cpu;
    }

    public Ppu2C02 getPPU(){
        return gpu;
    }

    public String getRomHeader() {
        return loader.getHeader();
    }

    public static TableModel getMemoryModel(JTable jTMemory,int start, int end) {
        TableModel memoryTable = new DebuggerDecoratorBuilder(jTMemory).getMemoryViewer();
        int line = 0, col = 0;
        
        for (int i = start; i <= end; i++) {

            if (col == 0x0) {
                String address = JNesUtil.fillIfNeedsWith(4, "0", Integer.toHexString(i).toUpperCase());
                memoryTable.setValueAt(address, line, col++);
                String value = JNesUtil.fillIfNeedsWith(2, "0", Integer.toHexString(Memory.getMemory().readFrom(i)).toUpperCase());
                memoryTable.setValueAt(value, line, col++);
            } else {
                String value = JNesUtil.fillIfNeedsWith(2, "0", Integer.toHexString(Memory.getMemory().readFrom(i)).toUpperCase());
                memoryTable.setValueAt(value, line, col);

                if (col == 16) {
                    line++;
                    col = 0;
                } else {
                    col++;
                }
            }

        }

        return memoryTable;
    }

        public static TableModel getMemoryVideoModel(JTable jTMemory,int start, int end) {
        TableModel memoryTable = new DebuggerDecoratorBuilder(jTMemory).getMemoryViewer();
        int line = 0, col = 0;

        for (int i = start; i <= end; i++) {

            if (col == 0x0) {
                String address = JNesUtil.fillIfNeedsWith(4, "0", Integer.toHexString(i).toUpperCase());
                memoryTable.setValueAt(address, line, col++);
                String value = JNesUtil.fillIfNeedsWith(2, "0", Integer.toHexString(VideoMemory.getMemory().readFrom(i)).toUpperCase());
                memoryTable.setValueAt(value, line, col++);
            } else {
                String value = JNesUtil.fillIfNeedsWith(2, "0", Integer.toHexString(VideoMemory.getMemory().readFrom(i)).toUpperCase());
                memoryTable.setValueAt(value, line, col);

                if (col == 16) {
                    line++;
                    col = 0;
                } else {
                    col++;
                }
            }

        }

        return memoryTable;
    }

    public boolean haveTablePattern() {
        return loader.getGame().CHR_ROMPageCount8K != 0;
    }

    public short[] giveMeTablePattern(){
        return  java.util.Arrays.copyOf(loader.getGame().chr_rom, loader.getGame().chr_rom.length) ;
    }

    public void load(ByteBuffer rom) {
        loader = new Loader();
        loader.load(rom);
        cpu.reset();
        Emulator.getInstance().getPPU().initPatternTable();
    }

    public void pause() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void stepDebugger() {
        if (cpu.cycles >= CYCLES_TO_SCANLINE){
            //i can even draw here
            System.out.println("I should throw an interrupter NMI here?");
        }
        cpu.debugStep();
    }
    public String actualLine(){
        return cpu.actualLineDebug;
    }

    public Memory getMemory() {
        return memory;
    }
}
