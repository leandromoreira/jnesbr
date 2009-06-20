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
package jnesbr.video.scrolls;

import jnesbr.video.Ppu2C02;

/**
 * @author dreampeppers99
 */
public final class Scrolling {
    //following the Loopy scheme!

    public int[] loopyT = new int[16]; // == Loopy_T
    public int loopyX; // == Loopy_X (or fineX)
    public int fineY;
    public int tileX;
    public int tileY;
    private Ppu2C02 ppu; //contains Loopy_V (or ppuAddress.completeAddress) and toggle (flipflop)

    public Scrolling(Ppu2C02 ppu) {
        this.ppu = ppu;
        this.ppu.scrolling = this;
    }

    public final int assemble() {
        return (loopyT[15] << 15) | (loopyT[14] << 14) | (loopyT[13] << 13) | (loopyT[12] << 12) | (loopyT[11] << 11) | (loopyT[10] << 10) | (loopyT[9] << 9) | (loopyT[8] << 8) | (loopyT[7] << 7) | (loopyT[6] << 6) | (loopyT[5] << 5) | (loopyT[4] << 4) | (loopyT[3] << 3) | (loopyT[2] << 2) | (loopyT[1] << 1) | (loopyT[0]);
    }
}
