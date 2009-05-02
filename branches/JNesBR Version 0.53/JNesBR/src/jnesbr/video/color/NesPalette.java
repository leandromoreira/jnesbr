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
public class NesPalette {
    private static Color[] nesColors = new Color[64];
    private static float[][] rgb = new float[64][3];

    public static Color getColor(int index) {
        return nesColors[index];
    }

    private final static Color getColor(int red, int green, int blue) {
        float[] hsb = Color.RGBtoHSB(red, green, blue, null);
        return Color.getHSBColor(hsb[0], hsb[1], hsb[2]);
    }

    public static float[] getColorRGB(int index){
        return rgb[index];
    }

    static {
        int index = 0x00;
        nesColors[index++] = getColor(0x75, 0x75, 0x75);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0x27, 0x1B, 0x8F);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0x00, 0x00, 0xAB);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0x47, 0x00, 0x9F);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0x8F, 0x00, 0x77);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0xAB, 0x00, 0x13);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0xA7, 0x00, 0x00);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0x7F, 0x0B, 0x00);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0x43, 0x2F, 0x00);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0x00, 0x47, 0x00);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0x00, 0x51, 0x00);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0x00, 0x3F, 0x17);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0x1B, 0x3F, 0x5F);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0x00, 0x00, 0x00);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0x05, 0x05, 0x05);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0x05, 0x05, 0x05);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0xBC, 0xBC, 0xBC);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0x00, 0x73, 0xEF);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0x23, 0x3B, 0xEF);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0x83, 0x00, 0xF3);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0xBF, 0x00, 0xB3);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0xE7, 0x00, 0x5B);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0xDB, 0x2B, 0x00);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0xCB, 0x4F, 0x0F);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0x8B, 0x73, 0x00);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0x00, 0x97, 0x00);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0x00, 0xAB, 0x00);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0x00, 0x93, 0x3B);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0x00, 0x83, 0x8B);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0x21, 0x21, 0x21);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0x09, 0x09, 0x09);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0x09, 0x09, 0x09);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0xFF, 0xFF, 0xFF);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0x3F, 0xBF, 0xFF);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0x5F, 0x97, 0xFF);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0xA7, 0x8B, 0xFD);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0xF7, 0x7B, 0xFF);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0xFF, 0x77, 0xB7);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0xFF, 0x77, 0x63);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0xFF, 0x9B, 0x3B);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0xF3, 0xBF, 0x3F);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0x83, 0xD3, 0x13);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0x4F, 0xDF, 0x4B);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0x58, 0xF8, 0x98);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0x00, 0xEB, 0xDB);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0x5E, 0x5E, 0x5E);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0x0D, 0x0D, 0x0D);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0x0D, 0x0D, 0x0D);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0xFF, 0xFF, 0xFF);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0xAB, 0xE7, 0xFF);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0xC7, 0xD7, 0xFF);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0xD7, 0xCB, 0xFF);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0xFF, 0xC7, 0xFF);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0xFF, 0xC7, 0xDB);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0xFF, 0xBF, 0xB3);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0xFF, 0xDB, 0xAB);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0xFF, 0xE7, 0xA3);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0xE3, 0xFF, 0xA3);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0xAB, 0xF3, 0xBF);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0xB3, 0xFF, 0xCF);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0x9F, 0xFF, 0xF3);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0xDD, 0xDD, 0xDD);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0x11, 0x11, 0x11);
        rgb[index-1] = getColorRGB(index-1);
        nesColors[index++] = getColor(0x11, 0x11, 0x11);
        rgb[index-1] = getColorRGB(index-1);
    }
}
