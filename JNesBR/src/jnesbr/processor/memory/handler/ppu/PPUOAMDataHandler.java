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
package jnesbr.processor.memory.handler.ppu;

import jnesbr.processor.memory.Memory;
import jnesbr.processor.memory.MemoryMap;
import jnesbr.processor.memory.handler.Handler;
import jnesbr.video.Ppu2C02;
import jnesbr.video.SpriteRAM;

/**
 * @author dreampeppers99
 */
public class PPUOAMDataHandler implements Handler {

    public void writeAt(int address, short value) {
        SpriteRAM.getInstance().add(Ppu2C02.getInstance().ppuOAMAddress.address,value);
        Ppu2C02.getInstance().ppuOAMAddress.address++;
        Memory.getMemory().writeUnhandled(address, value);
        mirror(address, value);
    }

    public short readFrom(int address) {
        return SpriteRAM.getInstance().get(Ppu2C02.getInstance().ppuOAMAddress.address);
    }

    private void mirror(int address, short value) {
        while ((address + 0x08) <= MemoryMap.IO_MIRROR_END) {
            Memory.getMemory().writeUnhandled(address + 0x08, value);
            address += 8;
        }
    }
}
