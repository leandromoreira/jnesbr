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
package jnesbr.processor.memory;

import java.util.HashMap;
import java.util.Map;
import jnesbr.processor.memory.handler.*;
import jnesbr.processor.memory.handler.ppu.*;
import static jnesbr.processor.memory.MemoryMap.*;

/**
 * @author dreampeppers99
 */
public class Memory {

    private static Memory instance;
    private short[] memory = new short[0x10000];
    //todo: should reset this ... where?
    private Map<Integer, Handler> handlers = new HashMap<Integer, Handler>();
    private final static int ZERO_PAGE_STACK_AND_RAM = 0xFFFF1,  NORMAL = 0xFFFF4;

    public static Memory getMemory() {
        if (instance == null) {
            instance = new Memory();
            instance.initHandlers();
        }
        return instance;
    }

    public short[] getUnhandled() {
        return memory;
    }

    public void addMemoryHandler(int address, Handler handler) {
        handlers.put(address, handler);
    }

    public short read(int address) {
        return getHandler(address).readFrom(address);
    }

    public short readUnhandled(int address) {
        return memory[address];
    }

    public void removeMemoryHandler(int address) {
        handlers.remove(address);
    }

    private Memory() {
    }

    public void reset() {
        for (int i = 0; i < memory.length; i++) {
            if (i < 0x8000) {
                memory[i] = 0;
            }
        }
    }

    public void write(int address, short value) {
        getHandler(address).writeAt(address, value);
    }

    public void writeUnhandled(int address, short value) {
        memory[address] = value;
    }

    private Handler getHandler(int address) {
        Handler result = handlers.get(address);
        if (result != null) {
            return result;
        }
        if (address >= ZERO_PAGE_START & address <= RAM_0_END) {
            return handlers.get(ZERO_PAGE_STACK_AND_RAM);
        }

        return handlers.get(NORMAL);
    }

    private void initHandlers() {
        handlers.put(NORMAL, new NormalHandler());
        handlers.put(ZERO_PAGE_STACK_AND_RAM, new RAMHandler());
        handlers.put(PPU_CONTROL, new PPUControlHandler());
        handlers.put(PPU_MASK, new PPUMaskHandler());
        handlers.put(PPU_STATUS, new PPUStatusHandler());
        handlers.put(PPU_ADDRESS, new PPUAdressHandler());
        handlers.put(PPU_OAM_ADDRESS, new PPUOAMAddressHandler());
        handlers.put(PPU_OAM_DATA, new PPUOAMDataHandler());
        handlers.put(PPU_DATA, new PPUDataHandler());
        handlers.put(DIRECT_MEMORY_ACCESS, new PPUDirectMemoryAccessHandler());
    }
}
