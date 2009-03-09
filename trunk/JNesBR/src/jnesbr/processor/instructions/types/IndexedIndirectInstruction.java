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
package jnesbr.processor.instructions.types;

import jnesbr.processor.Cpu2A03;
import jnesbr.processor.memory.Memory;
import jnesbr.util.JNesUtil;

/**
 * @author dreampeppers99
 */
public abstract class IndexedIndirectInstruction extends GeneralInstruction{
    public IndexedIndirectInstruction(Cpu2A03 cpu){
        super(cpu);
    }

    //on Nesdoc.pdf says that here is wraparound...
    //TODO: Check it out if the wraparound is about the operand or the values get from...
    public short getOperand(){
        short first = Memory.getMemory().read((byte)(cpu.programCounter+1+cpu.registerX));
        short second = Memory.getMemory().read((byte)(cpu.programCounter+2+cpu.registerX));
        return Memory.getMemory().read(JNesUtil.get16BitLittleEndian(first, second));
    }
}