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

/**
 * @author dreampeppers99
 */
public class Test {

    public static void main(String[] args) {
//        (JMP)  $89FF                      LDA ($FF), Y (Y=3)
//	        $8900: $A2                        $0000: $9A
//	        $89FF: $3C                        $00FF: $24
//	        $8A00: $78                        $0100: $72
//	        PC = $A23C
        int word = 0xAAFF;
        int msb , lsb;
        msb = word >> 8;
        lsb = word & 0xFF;
        lsb = (lsb+1) & 0xFF;
        System.out.println("msb " + Integer.toHexString(msb).toUpperCase());
        System.out.println("lsb " + Integer.toHexString(lsb).toUpperCase());
        System.out.println(Integer.toHexString(msb << 8 | lsb).toUpperCase());



    }
}
