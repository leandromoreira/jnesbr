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
import static jnesbr.processor.memory.MemoryMap.*;

/**
 * @author dreampeppers99
 */
public class Memory {

    private static Memory instance;
    private short[] memory = new short[0x10000];
    private Map<Integer, Handler> handlers = new HashMap<Integer, Handler>();
    private final static int ZERO_PAGE = 0xFFFF1,
                            FIRST_IO = 0xFFFF2,
                            ROM = 0xFFFF3;

    public static Memory getMemory() {
        if (instance == null) {
            instance = new Memory();
        }
        return instance;
    }

    private Memory() {
        handlers.put(ZERO_PAGE, new ZeroPageHandler());
        handlers.put(FIRST_IO, new FirstIOHandler());
        handlers.put(ROM, new RomlHandler());
    }

    public void writeAt(int address, short value) {
        getHandler(address).writeAt(address, value);
    }

    public short readFrom(int address) {
        return memory[address];
    }

    public void write(int address, short value) {
        memory[address] = value;
    }

    private Handler getHandler(int address) {
        Handler result = handlers.get(address);
        if (result != null) {
            return result;
        }
        if (address >= ZERO_PAGE_START & address <= ZERO_PAGE_END) {
            return handlers.get(ZERO_PAGE);
        }

        if (address >= IO_REGISTERS1_START & address <= IO_REGISTERS1_END) {
            return handlers.get(FIRST_IO);
        }

        if (address >= PRG_ROM_START & address <= PRG_ROM_END) {
            return handlers.get(ROM);
        }


        return null;
    }
}
