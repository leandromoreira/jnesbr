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

import jnesbr.processor.memory.handler.*;
import jnesbr.processor.memory.*;
import static jnesbr.util.JNesUtil.*;
import jnesbr.video.PPUControll;
import jnesbr.video.Ppu2C02;

/**
 * @author dreampeppers99
 */
public class PPUControlHandler implements Handler {
    private PPUControll ppuControll;

    public void writeAt(int address, short value) {
        
        ppuControll = Ppu2C02.getInstance().ppuControl;
        ppuControll.executeNMIOnVBlank = giveMeBit7From(value);
        ppuControll.masterOrSlave = giveMeBit6From(value);
        ppuControll.spriteSize = giveMeBit5From(value);
        ppuControll.patternTableAddressBackground = giveMeBit4From(value);
        ppuControll.patternTableAddressSprites = giveMeBit3From(value);
        ppuControll.port2007AddressIncrement = giveMeBit2From(value);
        ppuControll.nameTableAddress = (byte)(giveMeBit0From(value) >> 1 | giveMeBit1From(value));
        ppuControll.horizontalScrollBy256 = giveMeBit0From(value);
        ppuControll.verticalScrollBy240 = giveMeBit1From(value);
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
