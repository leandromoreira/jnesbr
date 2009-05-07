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
import jnesbr.video.PPUAddress;
import jnesbr.video.PPUStatus;
import jnesbr.video.Ppu2C02;

/**
 * @author dreampeppers99
 */
public final class PPUAdressHandler implements Handler {

    private PPUAddress pPUAddress;
    private PPUStatus ppuStatus;
    private Ppu2C02 ppu = Ppu2C02.getInstance();
    private Memory memory = Memory.getMemory();

    public final void writeAt(final int address, final short value) {
        pPUAddress = ppu.pPUAddress;
        ppuStatus = ppu.ppuStatus;
        if (ppuStatus.flipflop == 0) {
            pPUAddress.firstData = value;
            ppuStatus.flipflop++;
        } else {
            pPUAddress.secondData = value;
            pPUAddress.completeAddress = (pPUAddress.firstData<<8) | pPUAddress.secondData;
            ppuStatus.flipflop--;
        }
        memory.writeUnhandled(address, value);
    }

    public final short readFrom(final int address) {
        return memory.readUnhandled(address);
    }
}
