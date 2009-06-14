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
package jnesbr.video.color;

import java.awt.Color;

/**
 * @author dreampeppers99
 */
public final class NesPalette {
    private static Color[] nesColors = new Color[64];
    private static float[][] rgb = new float[64][3];
    public static final int RED = 0 , GREEN = 1, BLUE = 2;

    public final static Color getColor(int index) {
        return nesColors[index];
    }

    public final static float[] getRGBAt(final int index) {
        return rgb[index];
    }
    public final static float getRedAt(final int index) {
        return rgb[index][RED];
    }
    public final static float getGreenAt(final int index) {
        return rgb[index][GREEN];
    }
    public final static float getBlueAt(final int index) {
        return rgb[index][BLUE];
    }

    private final static Color getColor(final int red, final int green, final int blue) {
        float[] hsb = Color.RGBtoHSB(red, green, blue, null);
        return Color.getHSBColor(hsb[0], hsb[1], hsb[2]);
    }

    private final static void setRGBMatrix(final int index){
        rgb[index][RED] = nesColors[index].getRGBColorComponents(null)[RED];
        rgb[index][GREEN] = nesColors[index].getRGBColorComponents(null)[GREEN];
        rgb[index][BLUE] = nesColors[index].getRGBColorComponents(null)[BLUE];
    }

    static {
        int index = 0x00;
        nesColors[index++] = getColor(0x75, 0x75, 0x75);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0x27, 0x1B, 0x8F);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0x00, 0x00, 0xAB);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0x47, 0x00, 0x9F);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0x8F, 0x00, 0x77);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0xAB, 0x00, 0x13);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0xA7, 0x00, 0x00);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0x7F, 0x0B, 0x00);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0x43, 0x2F, 0x00);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0x00, 0x47, 0x00);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0x00, 0x51, 0x00);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0x00, 0x3F, 0x17);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0x1B, 0x3F, 0x5F);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0x00, 0x00, 0x00);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0x05, 0x05, 0x05);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0x05, 0x05, 0x05);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0xBC, 0xBC, 0xBC);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0x00, 0x73, 0xEF);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0x23, 0x3B, 0xEF);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0x83, 0x00, 0xF3);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0xBF, 0x00, 0xB3);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0xE7, 0x00, 0x5B);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0xDB, 0x2B, 0x00);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0xCB, 0x4F, 0x0F);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0x8B, 0x73, 0x00);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0x00, 0x97, 0x00);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0x00, 0xAB, 0x00);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0x00, 0x93, 0x3B);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0x00, 0x83, 0x8B);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0x21, 0x21, 0x21);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0x09, 0x09, 0x09);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0x09, 0x09, 0x09);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0xFF, 0xFF, 0xFF);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0x3F, 0xBF, 0xFF);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0x5F, 0x97, 0xFF);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0xA7, 0x8B, 0xFD);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0xF7, 0x7B, 0xFF);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0xFF, 0x77, 0xB7);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0xFF, 0x77, 0x63);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0xFF, 0x9B, 0x3B);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0xF3, 0xBF, 0x3F);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0x83, 0xD3, 0x13);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0x4F, 0xDF, 0x4B);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0x58, 0xF8, 0x98);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0x00, 0xEB, 0xDB);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0x5E, 0x5E, 0x5E);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0x0D, 0x0D, 0x0D);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0x0D, 0x0D, 0x0D);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0xFF, 0xFF, 0xFF);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0xAB, 0xE7, 0xFF);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0xC7, 0xD7, 0xFF);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0xD7, 0xCB, 0xFF);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0xFF, 0xC7, 0xFF);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0xFF, 0xC7, 0xDB);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0xFF, 0xBF, 0xB3);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0xFF, 0xDB, 0xAB);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0xFF, 0xE7, 0xA3);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0xE3, 0xFF, 0xA3);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0xAB, 0xF3, 0xBF);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0xB3, 0xFF, 0xCF);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0x9F, 0xFF, 0xF3);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0xDD, 0xDD, 0xDD);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0x11, 0x11, 0x11);
        setRGBMatrix(index-1);
        nesColors[index++] = getColor(0x11, 0x11, 0x11);
        setRGBMatrix(index-1);
    }
}
