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
            ppu.scrolling.loopyX = value & 0x07; //lower three bits
            ppu.scrolling.loopyT[0] = (value >> 3) & 1; //upper 5 bits
            ppu.scrolling.loopyT[1] = (value >> 4) & 1; //upper 5 bits
            ppu.scrolling.loopyT[2] = (value >> 5) & 1; //upper 5 bits
            ppu.scrolling.loopyT[3] = (value >> 6) & 1; //upper 5 bits
            ppu.scrolling.loopyT[4] = (value >> 7) & 1; //upper 5 bits
        } else {
            value = (short) ((value >= 240) ? value - 256 : value);
            //(Values of 240 to 255 are treated as -16 through -1 in a way, pulling tile data from the attribute table.) 
            ppu.ppuScroll.verticalScrollOrigin = value;
            ppu.ppuStatus.flipflop--;
            //ppu.scrolling.fineY = value & 0x07;
            ppu.scrolling.loopyT[12] = (value & 0x07) & 1;
            ppu.scrolling.loopyT[13] = ((value & 0x07) >> 1) & 1;
            ppu.scrolling.loopyT[14] = ((value & 0x07) >> 2) & 1;
            ppu.scrolling.loopyT[5] = (value >> 3) & 1;
            ppu.scrolling.loopyT[6] = (value >> 4) & 1;
            ppu.scrolling.loopyT[7] = (value >> 5) & 1;
            ppu.scrolling.loopyT[8] = (value >> 6) & 1;
            ppu.scrolling.loopyT[9] = (value >> 7) & 1;
        }
        memory.writeUnhandled(address, value);
    }

    public final short readFrom(final int address) {
        return memory.readUnhandled(address);
    }
}
