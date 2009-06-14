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
public final class GraphicHelper {

    public final static int[][] flipHorizontal(final int[][] tile) {
        int[][] retorno = new int[8][8];
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                retorno[x][abs(y - 7)] = tile[x][y];
            }
        }
        return retorno;
    }

    public final static int[][] flipVertical(final int[][] tile) {
        int[][] retorno = new int[8][8];
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                retorno[abs(x - 7)][y] = tile[x][y];
            }
        }
        return retorno;
    }

    private static final int abs(final int a) {
        return (a < 0) ? -a : a;
    }
}
