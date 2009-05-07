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
//        3F00h-3F1Fh   Background and Sprite Palettes (25 entries used)
//        3F20h-3FFFh   Mirrors of 3F00h-3F1Fh
        int initPalette = 0x3F00, endPalette = 0x3F1F;
        //11111100000000
        //11111100011111
        int initPaletteMirror = 0x3F20, endPaletteMirror = 0x3FFF;
        System.out.println("There is " + (endPalette - initPalette) + " palette's entry." );
        int testAddress = initPaletteMirror;
        System.out.println( Integer.toHexString(testAddress & endPalette).toUpperCase());
        testAddress++;
        System.out.println( Integer.toHexString(testAddress & endPalette).toUpperCase());
    }
}
