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

import jnesbr.util.JNesUtil;

/**
 * @author dreampeppers99
 */
public class Test {

    public static void main(String[] args) {
        int[] addresses = new int[4];
        //0000 - 3FFF = 4000 Real physic
        //4000 - 7FFF = 4000 mirroring
        // 4000 = 0  7FFE = 3FFE
        //8000 - BFFF = 4000 mirroring
        // 8103 = 0103  BCFE = 3CFE
        //C000 - FFFF = 4000 mirroring
        // 4000 = 0  7FFE = 3FFE
        addresses[0] = 0xFFFE;
        System.out.println(JNesUtil.giveMeHexaStringFormattedWith4Space(addresses[0] & 0x3FFF));
        addresses[1] = 0x8F00;
        addresses[2] = 0xF000;
        addresses[3] = 0xFFFF;
    }
}
