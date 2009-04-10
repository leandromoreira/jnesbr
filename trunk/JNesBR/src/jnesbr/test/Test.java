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
        int value = Integer.valueOf("00111001", 2);
        System.out.println(Integer.toBinaryString(value));
        System.out.println(Integer.toBinaryString((value & 0x3)));
        System.out.println(Integer.toBinaryString((value >> 2) & 0x3 ));
        System.out.println(Integer.toBinaryString((value >> 4) & 0x3 ));
        System.out.println(Integer.toBinaryString((value >> 6) & 0x3 ));
    }
}
