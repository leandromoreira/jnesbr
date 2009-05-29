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
import static jnesbr.util.JNesUtil.*;

/**
 * @author dreampeppers99
 */
public abstract class IndirectXInstruction extends GeneralInstruction {
    private int first,firstValue,second,secondValue;
    public IndirectXInstruction(Cpu2A03 cpu) {
        super(cpu);
    }

    @Override
    public short getOperand() {
       /* first = (memory.read((cpu.programCounter + 1 + cpu.registerX) & 0xFF));
        firstValue = memory.read(first);
        second = (memory.read((cpu.programCounter + 2 + cpu.registerX) & 0xFF));
        secondValue = memory.read(second);*/

        //the Nesdoc.pdf tells to do wrapround... however anothers docs says.... don't do..
        first = (memory.read((cpu.programCounter + 1 + cpu.registerX)));
        firstValue = memory.read(first);
        second = (memory.read((cpu.programCounter + 2 + cpu.registerX)));
        secondValue = memory.read(second);
        return memory.read(get16BitLittleEndian(firstValue, secondValue));
    }

    @Override
    public int getOperandAddress() {
        return memory.read(cpu.programCounter + 1);
    }
}
