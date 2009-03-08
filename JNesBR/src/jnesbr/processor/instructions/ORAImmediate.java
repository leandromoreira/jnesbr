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
import jnesbr.processor.memory.Memory;
import jnesbr.util.JNesUtil;

/**
 * @author dreampeppers99
 */
public class ORAImmediate extends ImmediateInstruction {

    public ORAImmediate(Cpu2A03 cpu) {
        super(cpu);
    }

    @Override
    public void interpret() {
        cpu.accumulator |= getOperand();
        cpu.setupFlagSign(cpu.accumulator);
        cpu.setupFlagZero(cpu.accumulator);
        cpu.programCounter += 2;
    }

    @Override
    public String disassembler() {
        return "ORA #$" + JNesUtil.fillIfNeedsWith(2, "0", Integer.toHexString(Memory.getMemory().read(cpu.programCounter + 1)).toUpperCase());
    }

    @Override
    public short cycles() {
        return 2;
    }
}
