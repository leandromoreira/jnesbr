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
import jnesbr.video.color.NesPalette;

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
    private final static Frame instance = new Frame();

    public final static Frame getInstance() {
        return instance;
    }

    public final void setPixel(Color pixel, int x, int y) {
        frame[x][y] = pixel;
    }

    public final void resetLayers() {
        resetLayer(layer0);
        resetLayer(layer1);
        resetLayer(layer2);
    }

    private final void resetLayer(int[][] matrix) {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0 ; y < HEIGHT ; y++){
                matrix[x][y] = 0x0;
            }
        }
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
    public final float[] getRGBPixelAt(final int x, final int y) {
        return rgbFrame[x][y];
    }
    public final float getRedPixelAt(final int x, final int y) {
        return rgbFrame[x][y][NesPalette.RED];
    }
    public final float getGreenPixelAt(final int x, final int y) {
        return rgbFrame[x][y][NesPalette.GREEN];
    }
    public final float getBluePixelAt(final int x, final int y) {
        return rgbFrame[x][y][NesPalette.BLUE];
    }

    private Frame() {
    }
}
