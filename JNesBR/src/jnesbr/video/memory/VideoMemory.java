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
import jnesbr.processor.memory.handler.*;
import jnesbr.video.memory.handler.*;
import static jnesbr.video.memory.VideoMemoryMap.*;

/**
 * @author dreampeppers99
 */
public class VideoMemory {

    private static VideoMemory instance;
    private short[] memory = new short[0x10000];
    private Map<Integer, Handler> handlers = new HashMap<Integer, Handler>();
    private static final int NORMAL = 0xFFFF2,  PALETTE = 0xFFFF3,  NAMETABLE = 0xFFFF4;

    private VideoMemory() {
        handlers.put(NORMAL, new NormalHandler());
        handlers.put(PALETTE, new PaletteHandler());
        handlers.put(NAMETABLE, new PartialNameTableHandler());
    }

    private Handler getHandler(int address) {
        
        address &= 0x3FFF;// The Addresses $4000-$FFFF are a set of mirrorings from $0000-$3FFFF.

        if (address >= BG_SPR_PALLETE_START && address <= BG_SPR_PALLETE_END) {
            return handlers.get(PALETTE);
        }
        if (address >= 0x2000 && address <= 0x2EFF) {
            return handlers.get(NAMETABLE);
        }
        return handlers.get(NORMAL);
    }

    public static VideoMemory getMemory() {
        if (instance == null) {
            instance = new VideoMemory();
        }
        return instance;
    }

    public void reset() {
        memory = new short[0x10000];
    }

    public short read(int address) {
        return getHandler(address).readFrom(address);
    }

    public short readUnhandled(int address) {
        return memory[address];
    }

    public void write(int address, short value) {
        getHandler(address).writeAt(address, value);
    }

    public void writeUnhandled(int address, short value) {
        memory[address] = value;
    }
}
