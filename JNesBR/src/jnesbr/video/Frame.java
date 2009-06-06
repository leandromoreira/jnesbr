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
package jnesbr.video;

import java.awt.Color;

/**
 * @author dreampeppers99
 */
public final class Frame {

    private static final int WIDTH = 256,  HEIGHT = 240;
    private Color[][] frame = new Color[WIDTH][HEIGHT];
    private int[][] layer0 = new int[WIDTH][HEIGHT]; //behind sprite
    private int[][] layer1 = new int[WIDTH][HEIGHT]; //background
    private int[][] layer2 = new int[WIDTH][HEIGHT]; //front sprite
    private float[][][] rgbFrame = new float[WIDTH][HEIGHT][3];
    private static Frame instance;

    public final static Frame getInstance() {
        if (instance == null) {
            instance = new Frame();
        }
        return instance;
    }

    public final void setPixel(Color pixel, int x, int y) {
        frame[x][y] = pixel;
    }

    public final void resetLayers(){
        layer0 = new int[WIDTH][HEIGHT];
        layer1 = new int[WIDTH][HEIGHT];
        layer2 = new int[WIDTH][HEIGHT];
    }

    public final void setPixelLayer0(final int paletteIndex, final int x, final int y) {
        layer0[x][y] = paletteIndex;
    }

    public final void setPixelLayer1(final int paletteIndex, final int x, final int y) {
        layer1[x][y] = paletteIndex;
    }

    public final void setPixelLayer2(final int paletteIndex, final int x, final int y) {
        layer2[x][y] = paletteIndex;
    }

    public final int getPixelLayer0At(final int x, final int y) {
        return layer0[x][y];
    }

    public final int getPixelLayer1At(final int x, final int y) {
        return layer1[x][y];
    }

    public final int getPixelLayer2At(final int x, final int y) {
        return layer2[x][y];
    }

    public final void setPixel(float[] rgb, int x, int y) {
        rgbFrame[x][y] = rgb;
    }

    public final Color[][] getJava2DFrame() {
        return frame;
    }

    public final float[][][] getRGBFrame() {
        return rgbFrame;
    }

    private Frame() {
    }
}
