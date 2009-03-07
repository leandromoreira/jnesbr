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
package jnesbr.processor.memory.handler;

import jnesbr.processor.memory.*;

/**
 * @author dreampeppers99
 */
public class FirstIOHandler implements Handler {

    public void writeAt(int address, short value) {
        Memory.getMemory().writeUnhandled(address, value);
        mirror(address,value);
    }

    public static void mirror(int address, short value) {
        for (int i = 0x0000 ; i < 0x1FF8 ; i += 8){
            Memory.getMemory().writeUnhandled(address+i, value);
        }
    }

    public short readFrom(int address) {
        return Memory.getMemory().readUnhandled(address);
    }

}
