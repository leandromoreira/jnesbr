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
public abstract class RelativeInstruction extends GeneralInstruction {

    private byte cycl;
    protected short cycles;

    public RelativeInstruction(Cpu2A03 cpu) {
        super(cpu);
    }

    public void interpret(boolean conditional) {
        cycl = 3;
        //if branch and change of memory's page... cycl = 4
        if (conditional) {
            if (((cpu.programCounter + getOperand()) & 0xFF00) != (cpu.programCounter & 0xFF00)) {
                cycl++;
            }
        } else {
            cycl = 2;
        }
        cpu.programCounter += (conditional) ? (getOperand() + 2) : 2;
        cycles = (short) cycl;
    }

    public short getOperand() {
        /* Casting to byte to make the wraparound correctly! (according to Nesdoc.pdf)
         * For this purpose, the operand is interpreted as a signed byte, that is in
         * the range -128 to 127 to allow forward and backward branching.
         * */
        return (byte) Memory.getMemory().readFrom(cpu.programCounter + 1);
    }

    public short cycles() {
        return cycles;
    }
}
