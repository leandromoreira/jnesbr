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
package jnesbr.rom.mapper;

/**
 * @author dreampeppers99
 */
public class NesMapperUtil {

    public void switchBank(short[] sour, short[] dest) {
        short[] matrix = new short[0xFFFF];
        short size = 256;
        int actual = 0;
        for (int i = 0; i < 256; i++) {
            actual = i;
            System.out.println("Bank : " + i);
            System.out.println("Init : " + (actual * size));
            System.out.println("End  : " + ((actual * size) + size));
            System.out.println("======================================");
        }
    }
}
