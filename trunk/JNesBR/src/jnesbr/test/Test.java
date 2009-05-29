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
        short[] memory = new short[0x10000];
        memory[0xc1ff]=0x00;
        memory[0xc100]=0x23;
        memory[0xc101]=0x40;
        memory[0xc200]=0x23;
        int fullWord = 0xC100;
        int msb , lsb;
        msb = fullWord >> 8;
        lsb = fullWord & 0xFF;
        short lowByte = memory[fullWord];
        lsb = (lsb+1) & 0xFF;
        fullWord = msb << 8 | lsb;
        short highByte = memory[fullWord];
        System.out.println(Integer.toHexString(JNesUtil.get16BitLittleEndian(lowByte, highByte)).toUpperCase());
    }
}
