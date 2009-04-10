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
package jnesbr.util;

import java.nio.ByteBuffer;

/**
 * @author dreampeppers99
 */
public class JNesUtil {

    public static short get8FirstBits(int value) {
        return (short) (value & 0xFF);
    }

    public static short get8SecondBits(int value) {
        return (short) (value >> 8);
    }

    public static int get16BitLittleEndian(short byte1, short byte2) {
        return ((byte2 << 8) | byte1);
    }

    public static short readNextUnsignedByteFrom(ByteBuffer readbuffer) {
        return (short) (readbuffer.get() & 0xff);
    }

    public static short readUnsignedByte(byte value) {
        return (short) (value & 0xff);
    }

    public static byte giveMeBit0From(short value) {
        return (byte) (value & 0x1);
    }

    public static byte giveMeBit1From(short value) {
        return (byte) ((value >> 1) & 0x1);
    }

    public static byte giveMeBit2From(short value) {
        return (byte) ((value >> 2) & 0x1);
    }

    public static byte giveMeBit3From(short value) {
        return (byte) ((value >> 3) & 0x1);
    }

    public static byte giveMeBit4From(short value) {
        return (byte) ((value >> 4) & 0x1);
    }

    public static byte giveMeBit5From(short value) {
        return (byte) ((value >> 5) & 0x1);
    }

    public static byte giveMeBit6From(short value) {
        return (byte) ((value >> 6) & 0x1);
    }

    public static byte giveMeBit7From(short value) {
        return (byte) ((value >> 7) & 0x1);
    }

    public static String fillIfNeedsWith(int times, String word, String value) {
        times = times - value.length() + 1;
        for (int i = 1; i < times; i++) {
            value = word + value;
        }
        return value;
    }

    public static String giveMeHexaStringFormattedWith4Space(int value) {
        return fillIfNeedsWith(4, "0", Integer.toHexString(value).toUpperCase());
    }

    public static String giveMeHexaStringFormattedWith2Space(int value) {
        return fillIfNeedsWith(2, "0", Integer.toHexString(value).toUpperCase());
    }
    
    public static String giveMeBinaryStringFormattedWith2Space(int value) {
        return fillIfNeedsWith(2, "0", Integer.toBinaryString(value).toUpperCase());
    }

    public static short rotateLeft(short operand) {
        int carry = ((operand >> 7) & 0x1);
        int result = (operand << 1) & 0xFF;
        return (short) (result | carry);
    }

    public static short rotateRight(short operand) {
        int carry = (operand & 0x1);
        int result = (operand >> 1) & 0xFF;
        return (short) (result | (carry << 7));
    }
    //TODO: CHECK AND TEST THIS.
    public static byte overflowInAddition(int value){
        byte result = (byte)(value & 0xFF);
        return (byte) ((result > 127 || result < -128) ? 1 : 0);
    }
}
