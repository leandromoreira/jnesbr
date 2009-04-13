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

import jnesbr.core.Emulator;
import jnesbr.processor.memory.Memory;
import jnesbr.processor.memory.handler.Handler;
import jnesbr.video.Ppu2C02;
import jnesbr.video.SpriteRAM;

/**
 * @author dreampeppers99
 */
public class PPUDirectMemoryAccessHandler implements Handler {
//todo: understand this
/*Specifies the destination address 
 in Sprite RAM for use with Port 2004h (Single byte write),
 and Port 4014h (256 bytes DMA transfer).*/
    public void writeAt(int address, short value) {
        Memory.getMemory().writeUnhandled(address, value);
        fillSpriteRAM(value * 0x100);
        Emulator.getInstance().getCpu().cycles += 512;
    }

    public short readFrom(int address) {
        return Memory.getMemory().readUnhandled(address);
    }

    private void fillSpriteRAM(int firstAddress) {
        short address = Ppu2C02.getInstance().ppuOAMAddress.address;
        SpriteRAM sprMemory = SpriteRAM.getInstance();
        Memory mem = Memory.getMemory();
        int max = firstAddress + 0xFF;
        for (int index = firstAddress; index <= max; index++) {
            sprMemory.add((short)(address & 0xFF) ,mem.readUnhandled(index));
            address++;
        }
    }
}
