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
package jnesbr.processor.memory.handler.ppu;

import jnesbr.processor.memory.handler.Handler;

/**
 * @author dreampeppers99
 */
public class PPUDirectMemoryAccessHandler implements Handler {

    public void writeAt(int address, short value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public short readFrom(int address) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
