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
import jnesbr.processor.instructions.types.IndirectIndexedInstruction;
import jnesbr.processor.memory.Memory;
import jnesbr.util.JNesUtil;

/**
 * @author dreampeppers99
 */
public class LDAIndirectIndexedY extends IndirectIndexedInstruction {

    private byte cycles;

    public LDAIndirectIndexedY(Cpu2A03 cpu) {
        super(cpu);
    }

    @Override
    public void interpret() {
        cycles = 5;
        if (pageChanged()) {
            cycles++;
        }
        cpu.accumulator = Memory.getMemory().read(getOperandAddress());
        cpu.setupFlagSign(cpu.accumulator);
        cpu.setupFlagZero(cpu.accumulator);
        cpu.programCounter += 2;
    }

    @Override
    public String disassembler() {
        return "LDA ($" + Integer.toHexString(Memory.getMemory().read(cpu.programCounter + 1)).toUpperCase() + "),Y";
    }

    @Override
    public short cycles() {
        return cycles;
    }

    @Override
    public short size() {
        return 2;
    }

    private boolean pageChanged() {
        int bb = Memory.getMemory().read(cpu.programCounter + 1);
        short xx = Memory.getMemory().read((bb));
        short yy = Memory.getMemory().read((bb + 1));
        short op = (short) (JNesUtil.get16BitLittleEndian(xx, yy));
        return (((op & 0xFF) + cpu.registerY) > 0xFF);
    }
}
