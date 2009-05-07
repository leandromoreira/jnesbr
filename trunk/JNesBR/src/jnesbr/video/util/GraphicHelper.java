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
package jnesbr.video.util;

/**
 * @author dreampeppers99
 */
public class GraphicHelper {

    public static int[][] flipHorizontal(int[][] tile) {
        int x = 0, y = 0;
        int[][] retorno = new int[8][8];
        for (y = 0; y < 8; y++) {
            for (x = 0; x < 8; x++) {
                retorno[y][abs(x - 7)] = tile[y][x];
            }
        }
        return retorno;
    }

    public final static int[][] flipVertical(int[][] tile) {
        int x = 0, y = 0;
        int[][] retorno = new int[8][8];
        for (y = 0; y < 8; y++) {
            for (x = 0; x < 8; x++) {
                retorno[abs(y - 7)][x] = tile[y][x];
            }
        }
        return retorno;
    }

    private static final int abs(int a) {
        return (a < 0) ? -a : a;
    }
}
