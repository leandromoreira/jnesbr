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

import jnesbr.core.Command;

/**
 * @author dreampeppers99
 */
public final class NameTableMirroringManagement {

    public final static byte horizontal = 0 ,  vertical = 1,  fourScreen = 2,  singleScreen = 3;
    private static byte actual;
    private static Command[] kindsOfMirroring = new Command[4];

    static{
        kindsOfMirroring[horizontal] = new Command() {
            public int execute(int address) {
                return translateAddressHorizontalMirroring(address);
            }
        };
        kindsOfMirroring[vertical] = new Command() {
            public int execute(int address) {
                return translateAddressVerticalMirroring(address);
            }
        };
        kindsOfMirroring[fourScreen] = new Command() {
            public int execute(int address) {
                return address;
            }
        };
        kindsOfMirroring[singleScreen] = new Command() {
            public int execute(int address) {
                return translateAddressSingleMirroring(address);
            }
        };
    }

    public final static int translate(final int address){
        return kindsOfMirroring[actual].execute(address);
    }

    public static void fourScreenSelected() {
        actual = fourScreen;
    }

    public static void horizontalSelected() {
        actual =horizontal;
    }

    public static void verticalSelected() {
        actual = vertical;
    }

    public static void singleSelected() {
        actual = singleScreen;
    }

    private final static int translateAddressSingleMirroring(int address) {
        if (address >= 0x2400 & address <= 0x27FF) {
            address &= 0x23FF;
        } else if (address >= 0x2800 & address <= 0x2BFF) {
            address -= 0x800;
        } else if (address >= 0x2C00 & address <= 0x2FFF) {
            address -= 0xC00;
        }
        return address;
    }

    private final static int translateAddressHorizontalMirroring(int address) {
        if (address >= 0x2400 & address <= 0x27FF) {
            address &= 0x23FF;
        } else if (address >= 0x2800 & address <= 0x2BFF) {
            address -= 0x400;
        } else if (address >= 0x2C00 & address <= 0x2FFF) {
            address -= 0x800;
        }
        return address;
    }

    private final static int translateAddressVerticalMirroring(int address) {
        if (address >= 0x2800 & address <= 0x2BFF) {
            address &= 0x23FF;
        } else if (address >= 0x2C00 & address <= 0x2FFF) {
            address -= 0x800;
        }
        return address;
    }
}
