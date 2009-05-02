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

/**
 * @author dreampeppers99
 */
public abstract class GeneralInstruction implements Instruction {

    protected Cpu2A03 cpu;

    public GeneralInstruction(Cpu2A03 cpu) {
        this.cpu = cpu;
    }

    public abstract void interpret();

    public abstract String disassembler();

    public abstract short size();

    public abstract short cycles();

    public abstract short getOperand();

    public abstract int getOperandAddress();

    public void debug() {
        cpu.actualLineDebug = disassembler();
        interpret();
    }
}
