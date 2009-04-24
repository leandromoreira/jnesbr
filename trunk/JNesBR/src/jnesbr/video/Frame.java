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
import java.util.Arrays;

/**
 * @author dreampeppers99
 */
public final class Frame {

    private static final int WIDTH = 256,  HEIGHT = 240;
    private Color[][] frame = new Color[WIDTH][HEIGHT];
    private static Frame instance;

    public static Frame getInstance() {
        if (instance == null) {
            instance = new Frame();
        }
        return instance;
    }

    public void setPixel(Color pixel, int x, int y) {
        frame[x][y] = pixel;
    }

    public Color[][] getFrame() {
        return Arrays.copyOf(frame, WIDTH * HEIGHT);
    }

    private Frame() {
    }
}
