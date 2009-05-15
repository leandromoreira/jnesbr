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
package jnesbr.joystick.handlers;

import jnesbr.core.Emulator;
import jnesbr.joystick.StandardControl;
import jnesbr.processor.memory.Memory;
import jnesbr.processor.memory.handler.Handler;

/**
 * @author dreampeppers99
 */
public class Joystick2Handler implements Handler {

    private int readNumber = 0;
    private short value;
    private Memory memory = Memory.getMemory();
    private StandardControl joystickManager = Emulator.getInstance().joystick;

    public void writeAt(int address, short value) {
        memory.writeUnhandled(address, value);
    }

    public short readFrom(int address) {
        value = joystickManager.status2Of(readNumber);
        readNumber = (readNumber + 1) & 7;
        return value;
    }
}
