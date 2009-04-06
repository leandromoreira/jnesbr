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
import jnesbr.video.PPUControll;
import jnesbr.video.PPUData;
import jnesbr.video.Ppu2C02;
import jnesbr.video.memory.VideoMemory;

/**
 * @author dreampeppers99
 */
public class PPUDataHandler implements Handler {

    private PPUData pPUData;

    public void writeAt(int address, short value) {
        pPUData = Ppu2C02.getInstance().pPUData;
        pPUData.data = value;
        VideoMemory.getMemory().write(Ppu2C02.getInstance().pPUAddress.completeAddress,
                pPUData.data);
        if (Ppu2C02.getInstance().ppuControl.port2007AddressIncrement == PPUControll.IncrementBy1) {
            Ppu2C02.getInstance().pPUAddress.completeAddress++;
        } else {
            Ppu2C02.getInstance().pPUAddress.completeAddress += 32;
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
        short value = VideoMemory.getMemory().read(Ppu2C02.getInstance().pPUAddress.completeAddress);
        if (Ppu2C02.getInstance().ppuControl.port2007AddressIncrement == PPUControll.IncrementBy1) {
            Ppu2C02.getInstance().pPUAddress.completeAddress++;
        } else {
            Ppu2C02.getInstance().pPUAddress.completeAddress += 32;
        }
        return value;
    }
}
