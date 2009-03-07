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
import jnesbr.processor.instructions.types.ImmediateInstruction;
import jnesbr.util.JNesUtil;

/**
 * @author dreampeppers99
 */
public class CPXImmediate extends ImmediateInstruction{
    public CPXImmediate(Cpu2A03 cpu){
        super(cpu);
    }

    @Override
    public void interpret() {
        cpu.setupFlagSign((short) (cpu.registerX - getOperand()));
        cpu.flagZero = (byte) ((cpu.registerX == getOperand()) ? 1 : 0);
        cpu.flagCarry = (byte) ((cpu.registerX >= getOperand()) ? 1 : 0);
        cpu.programCounter += 2;
    }

    @Override
    public String disassembler() {
        return "CPX #$"+ JNesUtil.fillIfNeedsWith(2, "0", Integer.toHexString(getOperand()).toUpperCase());
    }

    @Override
    public short cycles() {
        return 2;
    }
}
