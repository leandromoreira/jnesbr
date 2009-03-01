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
package jnesbr.processor;

import jnesbr.processor.instructions.types.*;
import jnesbr.processor.instructions.*;
import java.util.HashMap;
import java.util.Map;
import jnesbr.processor.memory.Memory;
import jnesbr.util.JNesUtil;

/**
 * @author dreampeppers99
 */
public class Cpu2A03 {

    public short accumulator,  registerX,  registerY;
    public short stackPointer;
    private short processorStatus;
    public int programCounter,oldProgramCounter;
    public byte flagCarry,  flagZero,  flagIRQ,  flagDecimalMode,  flagBreak,  flagNotUsed,  flagOverflow,  flagSign;
    public static final int InterruptNMI = 0xFFFA;
    public static final int InterruptRESET = 0xFFFC;
    public static final int InterruptIRQBRK = 0xFFFE;
    public int cycles;
    private Map<Integer, Instruction> instructions = new HashMap<Integer, Instruction>();
    public String actualLineDebug;

    public Cpu2A03(){
        reset();
        initInstructionTable();
    }

    public short processorStatus(){
        mergeProcessorStatus();
        return processorStatus;
    }
    private void mergeProcessorStatus() {
        processorStatus = (short) (((flagSign) << 7) |
                ((flagOverflow) << 6) |
                ((flagNotUsed) << 5) |
                ((flagBreak) << 4) |
                ((flagDecimalMode) << 3) |
                ((flagIRQ) << 2) |
                ((flagZero) << 1) |
                ((flagCarry) & 0x1));
    }

    public void reset() {
        stackPointer = 0x1FF;
        accumulator = registerX = registerY = 0;
        flagBreak = 0;
        flagCarry = 0;
        flagDecimalMode = 0;
        flagIRQ = 0;
        flagNotUsed = 1;
        flagOverflow = 0;
        flagSign = 0;
        flagZero = 0;
        mergeProcessorStatus();
        programCounter = JNesUtil.get16BitLittleEndian(Memory.getMemory().readFrom(InterruptRESET), Memory.getMemory().readFrom(InterruptRESET + 1));
        cycles = 0;
    }

    public void initInstructionTable() {
        instructions.put(0xD8, new CLDImplied(this));
        instructions.put(0xA8, new TAYImplied(this));
        instructions.put(0x78, new SEIImplied(this));
        instructions.put(0x8D, new STAAbsolute(this));
        instructions.put(0x9A, new TXSImplied(this));
        instructions.put(0x29, new AndImmediate(this));

        //Load Register from Memory
        instructions.put(0xA9, new LDAImmediate(this));
        instructions.put(0xA5, new LDAZeroPage(this));
        instructions.put(0xB5, new LDAZeroPageX(this));
        instructions.put(0xAD, new LDAAbsolute(this));
        instructions.put(0xBD, new LDAAbsoluteIndexedX(this));
        instructions.put(0xB9, new LDAAbsoluteIndexedY(this));
        instructions.put(0xA1, new LDAIndexedIndirectX(this));
        instructions.put(0xB1, new LDAIndirectIndexedY(this));
        instructions.put(0xA2, new LDXImmediate(this));
        instructions.put(0xA6, new LDXZeroPage(this));
        instructions.put(0xA0, new LDYImmediate(this));
        
        //Conditional Branch Instructions
        instructions.put(0x10, new BPLRelative(this));
        instructions.put(0x30, new BMIRelative(this));
        instructions.put(0x50, new BVCRelative(this));
        instructions.put(0x70, new BVSRelative(this));
        instructions.put(0x90, new BCCRelative(this));
        instructions.put(0xB0, new BCSRelative(this));
        instructions.put(0xD0, new BNERelative(this));
        instructions.put(0xF0, new BEQRelative(this));


        instructions.put(0xC9, new CMPImmediate(this));
        instructions.put(0xCA, new DEXImplied(this));
        instructions.put(0x20, new JSRAbsolute(this));
        instructions.put(0x85, new STAZeroPage(this));
        instructions.put(0x86, new STXZeroPage(this));
        instructions.put(0xE0, new CPXImmediate(this));
        instructions.put(0x91, new STAIndirectIndexedY(this));
        instructions.put(0x88, new DEYImplied(this));
        instructions.put(0xC0, new CPYImmediate(this));
    }

    public Instruction getInstructionFrom(int opCode) {
        Instruction instruciton = (instructions.get(opCode)==null? new StillNotImplemented(this, opCode) :instructions.get(opCode));
        return instruciton;
    }

    public void setSP(short value) {
        //TODO : see the constraint around the wraparound here.
        stackPointer = (short) (value + 0x100);
    }

    public void setupFlagSign(short value) {
        flagSign = (byte) ((value >> 7) & 0x1);
    }

    public void setupFlagZero(short value) {
        flagZero = (byte) ((value == 0) ? 1 : 0);
    }

    public void step() {
        int opCode = Memory.getMemory().readFrom(programCounter);
        getInstructionFrom(opCode).interpret();
        cycles += getInstructionFrom(opCode).cycles();
    }

    public void debugStep() {
        oldProgramCounter = programCounter ;
        int opCode = Memory.getMemory().readFrom(programCounter);
        Instruction actualInstruction = getInstructionFrom(opCode);
        actualInstruction.debug();
        cycles += actualInstruction.cycles();
        actualLineDebug = "0x" + JNesUtil.fillIfNeedsWith(4, "0", Integer.toHexString(oldProgramCounter).toUpperCase()) + ":\t" + actualLineDebug+"\t;";
    }
}
