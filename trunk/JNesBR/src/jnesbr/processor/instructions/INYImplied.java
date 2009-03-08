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
package jnesbr.processor.instructions;

import jnesbr.processor.Cpu2A03;
import jnesbr.processor.instructions.types.GeneralInstruction;

/**
 * @author dreampeppers99
 */
public class INYImplied extends GeneralInstruction {

    public INYImplied(Cpu2A03 cpu) {
        super(cpu);
    }

    @Override
    public void interpret() {
        cpu.registerY = (short) ((cpu.registerY + 1) & 0xFF);
        cpu.setupFlagSign(cpu.registerY);
        cpu.setupFlagZero(cpu.registerY);
        cpu.programCounter++;
    }

    @Override
    public String disassembler() {
        return "INY";
    }

    @Override
    public short cycles() {
        return 2;
    }
}
