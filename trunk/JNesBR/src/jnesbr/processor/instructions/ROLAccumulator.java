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
public class ROLAccumulator extends GeneralInstruction {

    public ROLAccumulator(Cpu2A03 cpu) {
        super(cpu);
    }

    @Override
    public void interpret() {
        if (cpu.accumulator >= 0x80) {
            cpu.flagCarry = 1;
        } else {
            cpu.flagCarry = 0;
        }
        cpu.accumulator <<= 1;
        cpu.accumulator &= 0xFF;
        if (cpu.flagCarry == 1) {
            cpu.accumulator |= 1;
        }
        cpu.setupFlagSign(cpu.accumulator);
        cpu.setupFlagZero(cpu.accumulator);
        cpu.programCounter++;
    }

    @Override
    public String disassembler() {
        return "ROL A";
    }

    @Override
    public short size() {
        return 1;
    }

    @Override
    public short cycles() {
        return 2;
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
