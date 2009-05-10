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
package jnesbr.joystick;

/**
 * @author dreampeppers99
 */
public class StandartControl {
    public int UP = KEYBOARD.UP_KEY;
    public int DOWN = KEYBOARD.DOWN_KEY;
    public int RIGTH = KEYBOARD.RIGHT_KEY;
    public int LEFT = KEYBOARD.LEFT_KEY;
    public int SELECT = KEYBOARD.SPACE_KEY;
    public int START = KEYBOARD.RETURN_KEY;
    public int A = KEYBOARD.Z_KEY;
    public int B = KEYBOARD.X_KEY;

    private class KEYBOARD{
        public static final int UP_KEY = 38;
        public static final int DOWN_KEY = 40;
        public static final int RIGHT_KEY = 39;
        public static final int LEFT_KEY = 37;
        public static final int SPACE_KEY = 32;
        public static final int RETURN_KEY = 13;
        public static final int X_KEY = 88;
        public static final int Z_KEY = 90;
    }
}
