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
public class JMPIndirect extends AbsoluteInstruction {
    private int fullWord, msb , lsb;
    private short lowByte,highByte;
    public JMPIndirect(Cpu2A03 cpu) {
        super(cpu);
    }

    @Override
    public void interpret() {
        fullWord = getOperandAddress();
        msb = fullWord >> 8;
        lsb = fullWord & 0xFF;
        lowByte = memory.read(fullWord);
        lsb = (lsb+1) & 0xFF;
        fullWord = msb << 8 | lsb;
        highByte = memory.read(fullWord);
        cpu.programCounter = JNesUtil.get16BitLittleEndian(lowByte, highByte);
    }

    @Override
    public String disassembler() {
        return "JMP ($" + JNesUtil.fillIfNeedsWith(4, "0", Integer.toHexString(getOperandAddress()).toUpperCase())+")";
    }

    @Override
    public short cycles() {
        return 5;
    }

    @Override
    public short size() {
        return 3;
    }
}
