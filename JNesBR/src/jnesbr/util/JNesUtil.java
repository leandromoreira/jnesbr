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
public final class JNesUtil {

    public final static short get8FirstBits(final int value) {
        return (short) (value & 0xFF);
    }

    public final static short get8SecondBits(final int value) {
        return (short) (value >> 8);
    }

    public final static int get16BitLittleEndian(final short byte1, final short byte2) {
        return (byte2 << 8) | byte1;
    }
    public final static int get16BitLittleEndian(final int byte1, final int byte2) {
        return (byte2 << 8) | byte1;
    }

    public final static short readNextUnsignedByteFrom(final ByteBuffer readbuffer) {
        return (short) (readbuffer.get() & 0xff);
    }

    public final static short readUnsignedByte(final byte value) {
        return (short) (value & 0xff);
    }

    public final static byte giveMeBit0From(final short value) {
        return (byte) (value & 0x1);
    }

    public final static byte giveMeBit1From(final short value) {
        return (byte) ((value >> 1) & 0x1);
    }

    public final static byte giveMeBit2From(final short value) {
        return (byte) ((value >> 2) & 0x1);
    }

    public final static byte giveMeBit3From(final short value) {
        return (byte) ((value >> 3) & 0x1);
    }

    public final static byte giveMeBit4From(final short value) {
        return (byte) ((value >> 4) & 0x1);
    }

    public final static byte giveMeBit5From(final short value) {
        return (byte) ((value >> 5) & 0x1);
    }

    public final static byte giveMeBit6From(final short value) {
        return (byte) ((value >> 6) & 0x1);
    }

    public final static byte giveMeBit7From(final short value) {
        return (byte) ((value >> 7) & 0x1);
    }

    public final static String fillIfNeedsWith(int times, final String word, String value) {
        times = times - value.length() + 1;
        for (int i = 1; i < times; i++) {
            value = word + value;
        }
        return value;
    }

    public final static String giveMeHexaStringFormattedWith4Space(final int value) {
        return fillIfNeedsWith(4, "0", Integer.toHexString(value).toUpperCase());
    }

    public final static String giveMeHexaStringFormattedWith2Space(final int value) {
        return fillIfNeedsWith(2, "0", Integer.toHexString(value).toUpperCase());
    }

    public final static String giveMeBinaryStringFormattedWith2Space(final int value) {
        return fillIfNeedsWith(2, "0", Integer.toBinaryString(value).toUpperCase());
    }

    public final static short rotateLeft(final short operand) {
        int carry = ((operand >> 7) & 0x1);
        int result = (operand << 1) & 0xFF;
        return (short) (result | carry);
    }

    public final static short rotateRight(final short operand) {
        int carry = (operand & 0x1);
        int result = (operand >> 1) & 0xFF;
        return (short) (result | (carry << 7));
    }

    public final static byte overflowInAddition(final int value) {
        byte result = (byte) (value & 0xFF);
        return (byte) ((result > 127 || result < -128) ? 1 : 0);
    }
}
