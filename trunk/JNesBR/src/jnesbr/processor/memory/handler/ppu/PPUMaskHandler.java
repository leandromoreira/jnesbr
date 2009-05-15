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
import jnesbr.processor.memory.handler.Handler;
import static jnesbr.util.JNesUtil.*;
import jnesbr.video.Ppu2C02;

/**
 * @author dreampeppers99
 * As Mapped IO to address $2001. Should be only-written.
 */
public final class PPUMaskHandler implements Handler {
    private Memory memory = Memory.getMemory();
    private Ppu2C02 ppu = Ppu2C02.getInstance();

    public final void writeAt(final int address, final short value) {
        ppu.ppuMask.intensifyBlues = giveMeBit7From(value);
        ppu.ppuMask.intensifyGreens = giveMeBit6From(value);
        ppu.ppuMask.intensifyReds = giveMeBit5From(value);
        ppu.ppuMask.spriteRenderingEnable = giveMeBit4From(value);
        ppu.ppuMask.backgroundRenderingEnable = giveMeBit3From(value);
        ppu.ppuMask.enableSpriteInLeftmost = giveMeBit2From(value);
        ppu.ppuMask.enableBackgroundInLeftmost = giveMeBit1From(value);
        ppu.ppuMask.grayscale = giveMeBit0From(value);
        memory.writeUnhandled(address, value);

    }

    public final short readFrom(final int address) {
        return memory.readUnhandled(address);
    }
}
