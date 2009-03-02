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
package jnesbr.video.memory;

import java.util.HashMap;
import java.util.Map;
import jnesbr.processor.memory.handler.Handler;
import jnesbr.video.memory.handler.HigherAddressHandler;

/**
 * @author dreampeppers99
 */
public class VideoMemory {

    private static VideoMemory instance;
    private short[] memory = new short[0x10000];
    private Map<Integer, Handler> handlers = new HashMap<Integer, Handler>();
    private static final int HIGHER = 1;

    private VideoMemory() {
        handlers.put(HIGHER, new HigherAddressHandler());
    }

    public static VideoMemory getMemory() {
        if (instance == null) {
            instance = new VideoMemory();
        }
        return instance;
    }

    public short read(int address) {
        return memory[address];
    }

    public void write(int address, short value) {
        memory[address] = value;
    }

    public void writeAt(int address, short value) {
        if (address >= 0x4000) {
            handlers.get(HIGHER).writeAt(address, value);
            return;
        }
        memory[address] = value;
    }

    public short readFrom(int address) {
        if (address >= 0x4000) {
            return handlers.get(HIGHER).readFrom(address);
        }
        return memory[address];
    }
}