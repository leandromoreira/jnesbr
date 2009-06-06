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
 */
public final class PPUAdressHandler implements Handler {

    private Ppu2C02 ppu = Ppu2C02.getInstance();
    private Memory memory = Memory.getMemory();

    public final void writeAt(final int address, final short value) {
        if (ppu.ppuStatus.flipflop == 0) {
            ppu.pPUAddress.firstData = value;
            ppu.ppuStatus.flipflop++;
            ppu.scrolling.temp[8] = (value & 0x3F) & 1;
            ppu.scrolling.temp[9] = ((value & 0x3F) >> 1) & 1;
            ppu.scrolling.temp[10] = ((value & 0x3F) >> 2) & 1;
            ppu.scrolling.temp[11] = ((value & 0x3F) >> 3) & 1;
            ppu.scrolling.temp[12] = ((value & 0x3F) >> 4) & 1;
            ppu.scrolling.temp[13] = ((value & 0x3F) >> 5) & 1;
            ppu.scrolling.temp[14] = 0;
        } else {
            ppu.pPUAddress.secondData = value;
            ppu.pPUAddress.completeAddress = (ppu.pPUAddress.firstData << 8) | ppu.pPUAddress.secondData;
            ppu.ppuStatus.flipflop--;
            ppu.scrolling.temp[0] = (value) & 1;
            ppu.scrolling.temp[1] = (value >> 1) & 1;
            ppu.scrolling.temp[2] = (value >> 2) & 1;
            ppu.scrolling.temp[3] = (value >> 3) & 1;
            ppu.scrolling.temp[4] = (value >> 4) & 1;
            ppu.scrolling.temp[5] = (value >> 5) & 1;
            ppu.scrolling.temp[6] = (value >> 6) & 1;
            ppu.scrolling.temp[7] = (value >> 7) & 1;
            ppu.pPUAddress.completeAddress = assemble(ppu.scrolling.temp);
        }
        memory.writeUnhandled(address, value);
    }

    public final short readFrom(final int address) {
        return memory.readUnhandled(address);
    }

    private final int assemble(final int[] temp) {
        return (temp[15] << 15) | (temp[14] << 14) | (temp[13] << 13) | (temp[12] << 12) | (temp[11] << 11) | (temp[10] << 10) | (temp[9] << 9) | (temp[8] << 8) | (temp[7] << 7) | (temp[6] << 6) | (temp[5] << 5) | (temp[4] << 4) | (temp[3] << 3) | (temp[2] << 2) | (temp[1] << 1) | (temp[0]);
    }
}
