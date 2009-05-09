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

    private Memory memory = Memory.getMemory();
    private Ppu2C02 ppu = Ppu2C02.getInstance();
    private short value;

    public final void writeAt(final int address, final short value) {
        //$2002 it's read-only.
        memory.writeUnhandled(address, value);
    }

    public final short readFrom(final int address) {
        //todo: understand this... "When a read from $2002 occurs, bit 7 is reset to 0 as are $2005 and $2006."
        ppu.ppuStatus.flipflop = 0;
        value = (short) ((ppu.ppuStatus.verticalBlankStarted << 7) | (ppu.ppuStatus.sprite0Hit << 6) | (ppu.ppuStatus.moreThan8ObjectsOnScanLine << 5));
        ppu.ppuStatus.verticalBlankStarted = PPUStatus.NotInVBlank;
        //memory.writeUnhandled(address, (short) ((ppuStatus.verticalBlankStarted << 7) | (ppuStatus.sprite0Hit << 6) | (ppuStatus.moreThan8ObjectsOnScanLine << 5)));
        //return memory.readUnhandled(address);
        return value;
    }
}
