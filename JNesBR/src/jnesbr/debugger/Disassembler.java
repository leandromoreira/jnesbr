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
package jnesbr.debugger;

import java.util.ArrayList;
import java.util.List;
import jnesbr.core.Emulator;
import jnesbr.processor.Cpu2A03;

/**
 * @author dreampeppers99
 */
public class Disassembler {

    public static List<AssemblerLine> disassembler() {
        List<AssemblerLine> assembler = new ArrayList<AssemblerLine>();
        Emulator.getInstance().getCpu().enterDisassemblerMode();
        AssemblerLine assemblerLine = Emulator.getInstance().getCpu().disassemblerStep();
        while (assemblerLine.pc < Cpu2A03.InterruptNMI) {
            assembler.add(assemblerLine);
            assemblerLine = Emulator.getInstance().getCpu().disassemblerStep();
        }
        Emulator.getInstance().getCpu().leaveDisassemblerMode();
        return assembler;
    }
}
