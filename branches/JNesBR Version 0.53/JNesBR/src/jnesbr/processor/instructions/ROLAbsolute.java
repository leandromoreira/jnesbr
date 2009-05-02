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
import jnesbr.processor.instructions.types.AbsoluteInstruction;
import jnesbr.processor.memory.Memory;
import jnesbr.util.JNesUtil;

/**
 * @author dreampeppers99
 */
public class ROLAbsolute extends AbsoluteInstruction {

    public ROLAbsolute(Cpu2A03 cpu) {
        super(cpu);
    }

    @Override
    public void interpret() {
        short value = getOperand();
        if (value >= 0x80) {
            cpu.flagCarry = 1;
        } else {
            cpu.flagCarry = 0;
        }
        value <<= 1;
        value &= 0xFF;
        if (cpu.flagCarry == 1) {
            value |= 1;
        }
        Memory.getMemory().write(getOperandAddress(), value);
        cpu.setupFlagSign(cpu.accumulator);
        cpu.setupFlagZero(cpu.accumulator);
        cpu.programCounter += 3;
    }

    @Override
    public String disassembler() {
        return "ROL $" + JNesUtil.giveMeHexaStringFormattedWith4Space(getOperandAddress())+complement();
    }

    @Override
    public short size() {
        return 3;
    }

    @Override
    public short cycles() {
        return 6;
    }
}
