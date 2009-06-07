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
    //following the skinny scheme

    public int[] temp = new int[16];
    public int fineX;
    public int fineY;
    public int tileX;
    public int tileY;
    private Ppu2C02 ppu; //contains address and toggle (flipflop)

    public Scrolling(Ppu2C02 ppu) {
        this.ppu = ppu;
        this.ppu.scrolling = this;
    }

    public final int assemble() {
        return (temp[15] << 15) | (temp[14] << 14) | (temp[13] << 13) | (temp[12] << 12) | (temp[11] << 11) | (temp[10] << 10) | (temp[9] << 9) | (temp[8] << 8) | (temp[7] << 7) | (temp[6] << 6) | (temp[5] << 5) | (temp[4] << 4) | (temp[3] << 3) | (temp[2] << 2) | (temp[1] << 1) | (temp[0]);
    }
}
