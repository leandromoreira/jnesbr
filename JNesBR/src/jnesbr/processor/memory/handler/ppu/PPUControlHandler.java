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
import jnesbr.video.Ppu2C02;

/**
 * @author dreampeppers99
 * As Mapped IO to address $2000. Should be only-written.
 */
public final class PPUControlHandler implements Handler {
    private Ppu2C02 ppu = Ppu2C02.getInstance();
    private Memory memory = Memory.getMemory();

    public final void writeAt(final int address, final short value) {
        ppu.ppuControl.executeNMIOnVBlank = giveMeBit7From(value);
        ppu.ppuControl.masterOrSlave = giveMeBit6From(value);
        ppu.ppuControl.spriteSize = giveMeBit5From(value);
        ppu.ppuControl.patternTableAddressBackground = giveMeBit4From(value);
        ppu.ppuControl.patternTableAddressSprites = giveMeBit3From(value);
        ppu.ppuControl.port2007AddressIncrement = giveMeBit2From(value);
        ppu.ppuControl.nameTableAddress = (byte)(giveMeBit0From(value) >> 1 | giveMeBit1From(value));
        ppu.ppuControl.horizontalScrollBy256 = giveMeBit0From(value);
        ppu.ppuControl.verticalScrollBy240 = giveMeBit1From(value);
        memory.writeUnhandled(address, value);
    }

    public final short readFrom(final int address) {
        return memory.readUnhandled(address);
    }
}
