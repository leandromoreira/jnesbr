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
public class ASLAccumulator extends GeneralInstruction {

    public ASLAccumulator(Cpu2A03 cpu) {
        super(cpu);
    }

    @Override
    public void interpret() {
        if (cpu.accumulator >= 0x80) {
            cpu.flagCarry = 1;
        } else {
            cpu.flagCarry = 0;
        }
        cpu.accumulator = (short) (cpu.accumulator << 1);
        cpu.setupFlagSign(cpu.accumulator);
        cpu.setupFlagZero(cpu.accumulator);
        cpu.programCounter++;
    }

    @Override
    public String disassembler() {
        return "ASL A";
    }

    @Override
    public short cycles() {
        return 2;
    }
}
