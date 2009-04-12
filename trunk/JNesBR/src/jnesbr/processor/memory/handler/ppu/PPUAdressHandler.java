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
import jnesbr.video.PPUAddress;
import jnesbr.video.Ppu2C02;

/**
 * @author dreampeppers99
 */
public class PPUAdressHandler implements Handler {

    private PPUAddress pPUAddress;
    private byte marker = 0;

    public void writeAt(int address, short value) {
        pPUAddress = Ppu2C02.getInstance().pPUAddress;
        if (marker == 0) {
            pPUAddress.firstData = value;
            marker++;
        } else {
            pPUAddress.secondData = value;
            pPUAddress.completeAddress = (pPUAddress.firstData<<8) | pPUAddress.secondData;
            marker--;
        }
        Memory.getMemory().writeUnhandled(address, value);
        mirror(address, value);
    }

    private void mirror(int address, short value) {
        while ((address + 0x08) <= MemoryMap.IO_MIRROR_END) {
            Memory.getMemory().writeUnhandled(address + 0x08, value);
            address += 8;
        }
    }

    public short readFrom(int address) {
        return Memory.getMemory().readUnhandled(address);
    }
}
