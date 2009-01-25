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

/**
 * @author dreampeppers99
 */
public class Emulator implements Runnable {
    private static Emulator emulator;
    private Loader loader;
    private Cpu2A03 cpu;
    private Memory memory;

    public static Emulator getInstance() {
        if (emulator == null) {
            emulator = new Emulator();
        }
        return emulator;
    }

    private Emulator() {
        cpu = new Cpu2A03();
        memory = Memory.getMemory();
    }

    public Cpu2A03 getCpu() {
        return cpu;
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


    public void load(ByteBuffer rom) {
        loader = new Loader();
        loader.load(rom);
        cpu.reset();
    }

    public void pause() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void stepDebugger() {
        cpu.debugStep();
    }
    public String actualLine(){
        return cpu.actualLineDebug;
    }

    /**
     * @return the memory
     */
    public Memory getMemory() {
        return memory;
    }
}
