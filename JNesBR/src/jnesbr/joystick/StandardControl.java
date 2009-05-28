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
public class StandardControl {

    private short value;

    // Joystick #01
    public int UP = KEYBOARD.UP_KEY;
    public int DOWN = KEYBOARD.DOWN_KEY;
    public int RIGTH = KEYBOARD.RIGHT_KEY;
    public int LEFT = KEYBOARD.LEFT_KEY;
    public int SELECT = KEYBOARD.SPACE_KEY;
    public int START = KEYBOARD.RETURN_KEY;
    public int A = KEYBOARD.Z_KEY;
    public int B = KEYBOARD.X_KEY;
    private byte[] joy1Status = new byte[8];

    // Joystick #02
    public int UP2 = KEYBOARD.UP_KEY;
    public int DOWN2 = KEYBOARD.DOWN_KEY;
    public int RIGTH2 = KEYBOARD.RIGHT_KEY;
    public int LEFT2 = KEYBOARD.LEFT_KEY;
    public int SELECT2 = KEYBOARD.SPACE_KEY;
    public int START2 = KEYBOARD.RETURN_KEY;
    public int A2 = KEYBOARD.Z_KEY;
    public int B2 = KEYBOARD.X_KEY;
    private byte[] joy2Status = new byte[8];

    public void check() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public short status1Of(int readNumber) {
        return joy1Status[readNumber];
    }

    public short status2Of(int readNumber) {
        return joy2Status[readNumber];
    }

    private class KEYBOARD {

        public static final int UP_KEY = 38;
        public static final int DOWN_KEY = 40;
        public static final int RIGHT_KEY = 39;
        public static final int LEFT_KEY = 37;
        public static final int SPACE_KEY = 32;
        public static final int RETURN_KEY = 13;
        public static final int X_KEY = 88;
        public static final int Z_KEY = 90;
    }

    public void pressedOnJoystick1(int key) {
        setValue(joy1Status, key, (byte) 1);
    }

    public void releasedOnJoystick1(int key) {
        setValue(joy1Status, key, (byte) 0);
    }

    public void pressedOnJoystick2(int key) {
        setValue(joy2Status, key, (byte) 1);
    }

    public void releasedOnJoystick2(int key) {
        setValue(joy2Status, key, (byte) 0);
    }

    private final void setValue(byte[] joy, int key, byte value) {
        if (key == A) {
            joy[0] = value;
            return;
        }
        if (key == B) {
            joy[1] = value;
            return;
        }
        if (key == SELECT) {
            joy[2] = value;
            return;
        }
        if (key == START) {
            joy[3] = value;
            return;
        }
        if (key == UP) {
            joy[4] = value;
            return;
        }
        if (key == DOWN) {
            joy[5] = value;
            return;
        }
        if (key == LEFT) {
            joy[6] = value;
            return;
        }
        if (key == RIGTH) {
            joy[7] = value;
            return;
        }
    }
}
