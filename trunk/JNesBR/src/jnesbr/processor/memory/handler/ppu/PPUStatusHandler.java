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
 * As Mapped IO to address $2002. Should be read-only.
 */
public class PPUStatusHandler implements Handler {

    private Memory memory = Memory.getMemory();
    private Ppu2C02 ppu = Ppu2C02.getInstance();
    private short value;

    public final void writeAt(final int address, final short value) {
        memory.writeUnhandled(address, value);
    }

    public final short readFrom(final int address) {
        value = (short) ((ppu.ppuStatus.verticalBlankStarted << 7) | (ppu.ppuStatus.sprite0Hit << 6) | (ppu.ppuStatus.moreThan8SpritesInOneScanLine << 5));
        ppu.ppuStatus.verticalBlankStarted = PPUStatus.NotInVBlank; //resets the vblank indicator
        ppu.ppuStatus.flipflop = 0; //resets the flip-flop (or toggle)
        return value;
    }
}
