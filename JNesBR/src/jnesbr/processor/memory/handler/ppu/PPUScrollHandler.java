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
import jnesbr.video.Ppu2C02;

/**
 * @author dreampeppers99
 * As Mapped IO to address $2005.
 */
public final class PPUScrollHandler implements Handler {

    private Ppu2C02 ppu = Ppu2C02.getInstance();
    private Memory memory = Memory.getMemory();

    public final void writeAt(final int address, short value) {
        if (ppu.ppuStatus.flipflop == 0) {
            ppu.ppuScroll.horizontalScrollOrigin = value;
            ppu.ppuStatus.flipflop++;
        } else {
            value = (short) ((value >= 240) ? value - 256 : value);
            ppu.ppuScroll.verticalScrollOrigin = value;
            ppu.ppuStatus.flipflop--;
        }
        memory.writeUnhandled(address, value);
    }

    public final short readFrom(final int address) {
        return memory.readUnhandled(address);
    }
}
