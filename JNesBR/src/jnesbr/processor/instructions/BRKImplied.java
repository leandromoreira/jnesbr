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
import jnesbr.processor.memory.Memory;
import jnesbr.util.JNesUtil;

/**
 * @author dreampeppers99
 */
public class BRKImplied extends GeneralInstruction {

    public BRKImplied(Cpu2A03 cpu) {
        super(cpu);
    }

    @Override
    public void interpret() {
        cpu.flagBreak = 1;
        cpu.push((short) (((cpu.programCounter + 1) >> 8) & 0xFF));
        cpu.push((short) ((cpu.programCounter + 1) & 0xFF));
        cpu.push(cpu.processorStatus());
        cpu.flagIRQ = 1;
        cpu.programCounter = JNesUtil.get16BitLittleEndian(Memory.getMemory().read(Cpu2A03.InterruptIRQBRK), Memory.getMemory().read(Cpu2A03.InterruptIRQBRK + 1));
    }

    @Override
    public String disassembler() {
        return "BRK";
    }

    @Override
    public short cycles() {
        return 7;
    }

    @Override
    public short size() {
        return 1;
    }

    @Override
    public short getOperand() {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public int getOperandAddress() {
        throw new UnsupportedOperationException("Not supported.");
    }
}
