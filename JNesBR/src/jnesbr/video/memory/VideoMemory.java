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

import jnesbr.video.memory.handler.NameTableMirroringManagement;

/**
 * @author dreampeppers99
 */
public final class VideoMemory {
    private static VideoMemory instance;
    private short[] memory = new short[0x10000];

    private VideoMemory() {
    }

    public static VideoMemory getMemory() {
        if (instance == null) {
            instance = new VideoMemory();
        }
        return instance;
    }

    public final void reset() {
        memory = new short[0x10000];
    }

    public final short read(int address) {
        address &= 0x3FFF;// The Addresses $4000-$FFFF are a set of mirrorings from $0000-$3FFFF.

        if (address >= 0x3000 & address <= 0x3EFF) {
            address &= 0x2EFF;// The Name Table mirroring.
        }

        if (address >= 0x3F20 & address <= 0x3FFF) {
            address &= 0x3F1F;// The Palette mirroring.
        }

        if (address >= 0x2000 && address <= 0x2FFF){
            address = NameTableMirroringManagement.translate(address);
        }
        return memory[address];
    }

    public final short readUnhandled(final int address) {
        return memory[address];
    }

    public final void write(int address, short value) {
        address &= 0x3FFF;// The Addresses $4000-$FFFF are a set of mirrorings from $0000-$3FFFF.

        if (address >= 0x3000 & address <= 0x3EFF) {
            address &= 0x2EFF;// The Name Table mirroring.
        }

        if (address >= 0x3F20 & address <= 0x3FFF) {
            address &= 0x3F1F;// The Palette mirroring.
        }
        memory[address] = value;
    }

    public final void writeUnhandled(final int address, final short value) {
        memory[address] = value;
    }
}
