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
        int init = 0x0000;
        int end = 0x07FF;

        System.out.println((0x0800 & end)==0x0);
        System.out.println((0x0802 & end)==0x2);
        System.out.println((0x08FF & end)==0xFF);
        System.out.println((0x09FF & end)==0x1FF);
        System.out.println((0x1000 & end)==0x0);
        System.out.println((0x1001 & end)==0x1);
        System.out.println(Integer.toHexString(0x1FFF & end));
    }
}
