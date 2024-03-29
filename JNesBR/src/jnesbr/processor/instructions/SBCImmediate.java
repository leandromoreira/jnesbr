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
public class SBCImmediate extends ImmediateInstruction {

    public SBCImmediate(Cpu2A03 cpu) {
        super(cpu);
    }

    @Override
    public void interpret() {
        int result = (cpu.accumulator+cpu.flagCarry-1-getOperand());
        boolean overflowFlag = (((cpu.accumulator^result) & 0x80) != 0) &&
                               (((cpu.accumulator^getOperand()) & 0x80) != 0);
        cpu.flagOverflow = (byte) ((overflowFlag) ? 1 : 0);
        //C is set if the unsigned result was >= 0, and is cleared if the unsigned result was < 0.
        //from Disch (forum.nesdev.org)
        cpu.flagCarry = (byte) ((result >= 0) ? 1 : 0); //TODO: CHECK THIS OR >= 0XFF SEEN THIS IS UNSIGNED
        cpu.accumulator = (short) (result & 0xFF);
        cpu.setupFlagSign(cpu.accumulator);
        cpu.setupFlagZero(cpu.accumulator);
        cpu.programCounter += 2;
    }

    @Override
    public String disassembler() {
        return "SBC #$"+JNesUtil.fillIfNeedsWith(2, "0", Integer.toHexString(getOperand()).toUpperCase());
    }

    @Override
    public short cycles() {
        return 2;
    }

    @Override
    public short size() {
        return 2;
    }
}
