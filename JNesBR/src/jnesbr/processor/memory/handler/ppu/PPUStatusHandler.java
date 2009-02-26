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
import jnesbr.video.PPUStatus;
import jnesbr.video.Ppu2C02;

/**
 * @author dreampeppers99
 */
public class PPUStatusHandler implements Handler {
    private PPUStatus ppuStatus;
    public void writeAt(int address, short value) {
        throw new UnsupportedOperationException("The address $2002 is just read-only.");
    }

    public short readFrom(int address) {
        ppuStatus = Ppu2C02.getInstance().ppuStatus;
        Memory.getMemory().write(0x2002,(short) ((ppuStatus.verticalBlankStarted << 7) | (ppuStatus.sprite0Hit << 6) | (ppuStatus.spriteOverflow << 5)));
        return Memory.getMemory().read(address);
    }

}
