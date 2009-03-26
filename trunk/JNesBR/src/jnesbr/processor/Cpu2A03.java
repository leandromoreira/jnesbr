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
Some codes for Cpu were implemented by looking on Cpu from http://code.google.com/p/juicynes/ GREAT project.
 */
package jnesbr.processor;

import jnesbr.processor.instructions.types.*;
import jnesbr.processor.instructions.*;
import java.util.HashMap;
import java.util.Map;
import jnesbr.debugger.AssemblerLine;
import jnesbr.processor.memory.Memory;
import static jnesbr.util.JNesUtil.*;

/**
 * @author dreampeppers99
 */
public class Cpu2A03 {

    public short accumulator,  registerX,  registerY;
    public short stackPointer;
    private short processorStatus;
    public int programCounter,  oldProgramCounter;
    public byte flagCarry,  flagZero,  flagIRQ,  flagDecimalMode,  flagBreak,  flagNotUsed,  flagOverflow,  flagSign;
    public static final int InterruptNMI = 0xFFFA;
    public static final int InterruptRESET = 0xFFFC;
    public static final int InterruptIRQBRK = 0xFFFE;
    public int cycles;
    private Map<Integer, Instruction> instructions = new HashMap<Integer, Instruction>();
    public String actualLineDebug;

    public Cpu2A03() {
        reset();
        initInstructionTable();
    }

    public short pull() {
        stackPointer++;
        stackPointer = (short) (stackPointer & 0xFF);
        return Memory.getMemory().read(stackPointer + 0x100);
    }

    public void push(short value) {
        Memory.getMemory().write(stackPointer + 0x100, value);
        stackPointer--;
        stackPointer = (short) (stackPointer & 0xFF);
    }

    public short processorStatus() {
        mergeProcessorStatus();
        return processorStatus;
    }


    public void setProcessorStatus(short p) {
        processorStatus = p;
        updateFlags();
    }

    private void updateFlags() {
        flagBreak =  giveMeBit4From(processorStatus);
        flagCarry = giveMeBit0From(processorStatus);
        flagDecimalMode = giveMeBit3From(processorStatus);
        flagIRQ = giveMeBit2From(processorStatus);
        flagNotUsed = giveMeBit5From(processorStatus);
        flagOverflow = giveMeBit6From(processorStatus);
        flagSign = giveMeBit7From(processorStatus);
        flagZero = giveMeBit1From(processorStatus);
    }

    public void mergeProcessorStatus() {
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
        stackPointer = 0xFF;
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
        programCounter = get16BitLittleEndian(Memory.getMemory().read(InterruptRESET), Memory.getMemory().read(InterruptRESET + 1));
        cycles = 0;
    }

    public void initInstructionTable() {
        //Register to Register Transfer.
        instructions.put(0xA8, new TAYImplied(this));
        instructions.put(0xAA, new TAXImplied(this));
        instructions.put(0xBA, new TSXImplied(this));
        instructions.put(0x98, new TYAImplied(this));
        instructions.put(0x8A, new TXAImplied(this));
        instructions.put(0x9A, new TXSImplied(this));
        //Load Register from Memory.
        instructions.put(0xA9, new LDAImmediate(this));
        instructions.put(0xA5, new LDAZeroPage(this));
        instructions.put(0xB5, new LDAZeroPageX(this));
        instructions.put(0xAD, new LDAAbsolute(this));
        instructions.put(0xBD, new LDAAbsoluteIndexedX(this)); //this check page change
        instructions.put(0xB9, new LDAAbsoluteIndexedY(this)); //this check page change
        instructions.put(0xA1, new LDAIndexedIndirectX(this));
        instructions.put(0xB1, new LDAIndirectIndexedY(this)); //this check page change
        instructions.put(0xA2, new LDXImmediate(this));
        instructions.put(0xA6, new LDXZeroPage(this));
        instructions.put(0xB6, new LDXZeroPageY(this));
        instructions.put(0xAE, new LDXAbsolute(this));
        instructions.put(0xBE, new LDXAbsoluteY(this));
        instructions.put(0xA0, new LDYImmediate(this));
        instructions.put(0xA4, new LDYZeroPage(this));
        instructions.put(0xB4, new LDYZeroPageIndexed(this));
        instructions.put(0xAC, new LDYAbsolute(this));
        instructions.put(0xBC, new LDYAbsoluteIndexed(this)); //this check page change
        //Store Register in Memory.
        





        instructions.put(0xD8, new CLDImplied(this));

        instructions.put(0x78, new SEIImplied(this));
        instructions.put(0x8D, new STAAbsolute(this));

        instructions.put(0x29, new AndImmediate(this));

        //Load Register from Memory

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

        instructions.put(0x8E, new STXAbsolute(this));
        instructions.put(0x84, new STYZeroPage(this));
        instructions.put(0xC6, new DECZeroPage(this));
        instructions.put(0xE8, new INXImplied(this));
        instructions.put(0x60, new RTSImplied(this));
        instructions.put(0xCC, new CPYAbsolute(this));
        instructions.put(0x11, new ORAIndirectIndexedY(this));
        instructions.put(0x2C, new BITAbsolute(this));
        instructions.put(0x99, new STAAbsoluteY(this));
        instructions.put(0xC8, new INYImplied(this));
        instructions.put(0x09, new ORAImmediate(this));

        instructions.put(0x4C, new JMPAbsolute(this));
        instructions.put(0xEE, new INCAbsolute(this));
        instructions.put(0x01, new ORAIndirectIndexedX(this));
        instructions.put(0xEC, new CPXAbsolute(this));
        instructions.put(0x41, new EORIndexedIndirect(this));
        instructions.put(0x68, new PLAImplied(this));
        instructions.put(0xDE, new DECAbsoluteX(this));
        instructions.put(0x8C, new STYAbsolute(this));
        instructions.put(0x40, new RTIImplied(this));
        
        instructions.put(0x9D, new STAAbsoluteX(this));
        instructions.put(0x4A, new LSRAccumulator(this));
        instructions.put(0xCE, new DECAbsolute(this));
        instructions.put(0xE6, new INCZeroPage(this));
        instructions.put(0x45, new EORZeroPage(this));
        instructions.put(0x18, new CLCImplied(this));
        instructions.put(0x7E, new RORAbsoluteX(this));
        instructions.put(0x48, new PHAImplied(this));
        instructions.put(0xC5, new CMPZeroPage(this));
        instructions.put(0x69, new ADCImmediate(this));
        instructions.put(0x31, new ANDIndirectIndexed(this));
        instructions.put(0x49, new EORImmediate(this));
        instructions.put(0x0A, new ASLAccumulator(this));
        instructions.put(0x00, new BRKImplied(this));
        instructions.put(0x81, new STAIndexedIndirect(this));
        instructions.put(0x05, new ORAZeroPage(this));
        instructions.put(0x95, new STAZeroPageIndexedX(this));


        instructions.put(0x28, new PLPImplied(this));
        instructions.put(0x38, new SECImplied(this));
        instructions.put(0x61, new ADCIndexedIndirect(this));
        instructions.put(0xE9, new SBCImmediate(this));
        instructions.put(0x0D, new ORAAbsolute(this));
        instructions.put(0xF6, new INCZeroPageIndexed(this));
        instructions.put(0xF8, new SEDImplied(this));
    }

    public Instruction getInstructionFrom(int opCode) {
        Instruction instruction = (instructions.get(opCode) == null ? new StillNotImplemented(this, opCode) : instructions.get(opCode));
        return instruction;
    }

    public void setupFlagSign(short value) {
        flagSign = (byte) ((value >> 7) & 0x1);
    }

    public void setupFlagZero(short value) {
        flagZero = (byte) ((value == 0) ? 1 : 0);
    }

    public void step() {
        int opCode = Memory.getMemory().read(programCounter);
        getInstructionFrom(opCode).interpret();
        cycles += getInstructionFrom(opCode).cycles();
    }

    public void debugStep() {
        oldProgramCounter = programCounter;
        int opCode = Memory.getMemory().read(programCounter);
        Instruction actualInstruction = getInstructionFrom(opCode);
        actualInstruction.debug();
        cycles += actualInstruction.cycles();
        actualLineDebug = "0x" + fillIfNeedsWith(4, "0", Integer.toHexString(oldProgramCounter).toUpperCase()) + ":\t" + actualLineDebug + "\t;";
    }

    public AssemblerLine disassemblerStep() {
        oldProgramCounter = programCounter;
        int opCode = Memory.getMemory().read(programCounter);
        Instruction actualInstruction = getInstructionFrom(opCode);
        actualLineDebug = actualInstruction.disassembler();
        programCounter += actualInstruction.size();
        return new AssemblerLine(oldProgramCounter, actualLineDebug);
    }
}
