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
package jnesbr.video.memory.handler;

/**
 * @author dreampeppers99
 */
public final class NameTableMirroringManagement {

    public static byte horizontal,  vertical,  fourScreen,  singleScreen;

    public static void fourScreenSelected() {
        horizontal = vertical = singleScreen = 0;
        fourScreen = 1;
    }

    public static void horizontalSelected() {
        fourScreen = vertical = singleScreen = 0;
        horizontal = 1;
    }

    public static void verticalSelected() {
        fourScreen = horizontal = singleScreen = 0;
        vertical = 1;
    }

    public static void singleSelected() {
        fourScreen = horizontal = vertical = 0;
        singleScreen = 1;
    }

    public final static int translateAddressSingleMirroring(int address) {
        if (address >= 0x2400 & address <= 0x27FF) {
            address &= 0x23FF;
        } else if (address >= 0x2800 & address <= 0x2BFF) {
            address -= 0x800;
        } else if (address >= 0x2C00 & address <= 0x2FFF) {
            address -= 0xC00;
        }
        return address;
    }

    public final static int translateAddressHorizontalMirroring(int address) {
        if (address >= 0x2400 & address <= 0x27FF) {
            address &= 0x23FF;
        } else if (address >= 0x2800 & address <= 0x2BFF) {
            address -= 0x400;
        } else if (address >= 0x2C00 & address <= 0x2FFF) {
            address -= 0x800;
        }
        return address;
    }

    public final static int translateAddressVerticalMirroring(int address) {
        if (address >= 0x2800 & address <= 0x2BFF) {
            address &= 0x23FF;
        } else if (address >= 0x2C00 & address <= 0x2FFF) {
            address -= 0x800;
        }
        return address;
    }
}
