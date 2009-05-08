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
package jnesbr.test;

import jnesbr.video.memory.handler.NameTableMirroringManagement;

/**
 * @author dreampeppers99
 */
public class Test {

    public static void main(String[] args) {
        testHorizontal(0x2000, 0x2000, 0x2400);
        testHorizontal(0x23F0, 0x2000, 0x2400);
        testHorizontal(0x23FF, 0x2000, 0x2400);
        testHorizontal(0x2400, 0x2000, 0x2400);
        testHorizontal(0x25F0, 0x2000, 0x2400);
        testHorizontal(0x27FF, 0x2000, 0x2400);

        testHorizontal(0x2800, 0x2400, 0x27FF);
        testHorizontal(0x290E, 0x2400, 0x27FF);
        testHorizontal(0x2B0A, 0x2400, 0x27FF);
        testHorizontal(0x2BFF, 0x2400, 0x27FF);
        testHorizontal(0x2CFF, 0x2400, 0x27FF);
        testHorizontal(0x2FFF, 0x2400, 0x27FF);

    }

    public static void testHorizontal(int address, int min, int max) {
        address = NameTableMirroringManagement.translateAddressHorizontalMirroring(address);
        String result = (address >= min & address <= max) ? "Pass" : "Fail";
        if (result.equals("Pass")) {
            System.out.println(result);
        } else {
            System.err.println(result);
        }
    }
}
