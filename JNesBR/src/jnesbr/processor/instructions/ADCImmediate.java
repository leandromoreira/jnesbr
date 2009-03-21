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
public class ADCImmediate extends ImmediateInstruction {

    public ADCImmediate(Cpu2A03 cpu) {
        super(cpu);
    }

    @Override
    public void interpret() {
        int value = getOperand();
        int result = cpu.accumulator + value + cpu.flagCarry;
        cpu.flagCarry = (byte) ((result > 0xFF) ? 1 : 0);
        if ((((cpu.accumulator ^ value) & 0x80) == 0) &&
                (((cpu.accumulator ^ result) & 0x80) != 0)) {
            cpu.flagOverflow = 1;
        } else {
            cpu.flagOverflow = 0;
        }
        result &= 0xFF;
        cpu.setupFlagSign((short) result);
        cpu.setupFlagZero((short) result);
        cpu.accumulator = (short) result;
        cpu.programCounter += 2;
    }

    @Override
    public String disassembler() {
        return "ADC #$" + JNesUtil.fillIfNeedsWith(2, "0", Integer.toHexString(getOperand()).toUpperCase());
    }

    @Override
    public short cycles() {
        return 2;
    }
}