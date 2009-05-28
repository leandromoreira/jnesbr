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
Some codes for Cpu were implemented by beeing "inspired" on Cpu from http://code.google.com/p/juicynes/ GREAT project.
 */
package jnesbr.processor;

import jnesbr.processor.instructions.types.*;
import jnesbr.processor.instructions.*;
import jnesbr.core.Emulator;
import jnesbr.debugger.AssemblerLine;
import jnesbr.debugger.BreakpointException;
import jnesbr.debugger.Debugger;
import jnesbr.processor.memory.Memory;
import jnesbr.util.JNesUtil;
import static jnesbr.util.JNesUtil.*;

/**
 * @author dreampeppers99
 */
public final class Cpu2A03 {

    public short accumulator,  registerX,  registerY;
    public short stackPointer;
    private short processorStatus;
    public int programCounter,  oldProgramCounter;
    private int lastProgramCounter;
    public byte flagCarry,  flagZero,  flagIRQ,  flagDecimalMode,  flagBreak,  flagNotUsed,  flagOverflow,  flagSign;
    public static final int InterruptNMI = 0xFFFA;
    public static final int InterruptRESET = 0xFFFC;
    public static final int InterruptIRQBRK = 0xFFFE;
    public int cycles;
    private Instruction[] instructionSet = new Instruction[0x100];
    public String actualLineDebug;
    private Instruction executeInstruction;
    private Memory memory = Memory.getMemory();

    public Cpu2A03() {
        reset();
        initInstructionTable();
    }

    public final void enterDisassemblerMode() {
        lastProgramCounter = programCounter;
        programCounter = 0x8000;
    }

    public final void leaveDisassemblerMode() {
        programCounter = lastProgramCounter;
    }

    public final short pull() {
        stackPointer++;
        stackPointer = (short) (stackPointer & 0xFF);
        return memory.read(stackPointer + 0x100);
    }

    public final void push(short value) {
        memory.write(stackPointer + 0x100, value);
        stackPointer--;
        stackPointer = (short) (stackPointer & 0xFF);
    }

    public final short processorStatus() {
        mergeProcessorStatus();
        return processorStatus;
    }

    public final void setProcessorStatus(short p) {
        processorStatus = p;
        updateFlags();
    }

    private final boolean iNesRomIsOnePRGBank() {
        return (Emulator.getInstance().rom().PRGROM16KPageCount == 1);
    }

    private final void normalDisassembler() {
        int opCode = memory.read(programCounter);
        Instruction actualInstruction = getInstructionFrom(opCode);
        actualLineDebug = actualInstruction.disassembler();
        programCounter += actualInstruction.size();
    }

    private final void updateFlags() {
        flagBreak = giveMeBit4From(processorStatus);
        flagCarry = giveMeBit0From(processorStatus);
        flagDecimalMode = giveMeBit3From(processorStatus);
        flagIRQ = giveMeBit2From(processorStatus);
        flagNotUsed = giveMeBit5From(processorStatus);
        flagOverflow = giveMeBit6From(processorStatus);
        flagSign = giveMeBit7From(processorStatus);
        flagZero = giveMeBit1From(processorStatus);
    }

    public final void mergeProcessorStatus() {
        processorStatus = (short) (((flagSign) << 7) |
                ((flagOverflow) << 6) |
                ((flagNotUsed) << 5) |
                ((flagBreak) << 4) |
                ((flagDecimalMode) << 3) |
                ((flagIRQ) << 2) |
                ((flagZero) << 1) |
                ((flagCarry) & 0x1));
    }

    public final void reset() {
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
        programCounter = get16BitLittleEndian(memory.read(InterruptRESET), memory.read(InterruptRESET + 1));
        cycles = 0;
    }

    public final void nmi() {
        flagBreak = 0;
        push((short) (((programCounter + 1) >> 8) & 0xFF));
        push((short) ((programCounter + 1) & 0xFF));
        push(processorStatus());
        flagIRQ = 1;
        programCounter = get16BitLittleEndian(memory.read(InterruptNMI), memory.read(InterruptNMI + 1));
        cycles += 7;
    }

    public final void irq() {
        if (flagBreak == 1) {
            return;
        }

        flagBreak = 0;
        push((short) (((programCounter + 1) >> 8) & 0xFF));
        push((short) ((programCounter + 1) & 0xFF));
        push(processorStatus());
        flagIRQ = 1;
        programCounter = get16BitLittleEndian(memory.read(InterruptIRQBRK), memory.read(InterruptIRQBRK + 1));
        cycles += 7;
    }

    public final void initInstructionTable() {
        //Register to Register Transfer.
        instructionSet[0xA8] = new TAYImplied(this);
        instructionSet[0xAA] = new TAXImplied(this);
        instructionSet[0xBA] = new TSXImplied(this);
        instructionSet[0x98] = new TYAImplied(this);
        instructionSet[0x8A] = new TXAImplied(this);
        instructionSet[0x9A] = new TXSImplied(this);
        //Load Register from Memory.
        instructionSet[0xA9] = new LDAImmediate(this);
        instructionSet[0xA5] = new LDAZeroPage(this);
        instructionSet[0xB5] = new LDAZeroPageX(this);
        instructionSet[0xAD] = new LDAAbsolute(this);
        instructionSet[0xBD] = new LDAAbsoluteIndexedX(this); //this check page change
        instructionSet[0xB9] = new LDAAbsoluteIndexedY(this); //this check page change
        instructionSet[0xA1] = new LDAIndexedIndirectX(this);
        instructionSet[0xB1] = new LDAIndirectIndexedY(this); //this check page change
        instructionSet[0xA2] = new LDXImmediate(this);
        instructionSet[0xA6] = new LDXZeroPage(this);
        instructionSet[0xB6] = new LDXZeroPageY(this);
        instructionSet[0xAE] = new LDXAbsolute(this);
        instructionSet[0xBE] = new LDXAbsoluteY(this);
        instructionSet[0xA0] = new LDYImmediate(this);
        instructionSet[0xA4] = new LDYZeroPage(this);
        instructionSet[0xB4] = new LDYZeroPageIndexed(this);
        instructionSet[0xAC] = new LDYAbsolute(this);
        instructionSet[0xBC] = new LDYAbsoluteIndexed(this); //this check page change
        //Store Register in Memory.
        instructionSet[0x85] = new STAZeroPage(this);
        instructionSet[0x95] = new STAZeroPageIndexedX(this);
        instructionSet[0x8D] = new STAAbsolute(this);
        instructionSet[0x9D] = new STAAbsoluteX(this);
        instructionSet[0x99] = new STAAbsoluteY(this);
        instructionSet[0x81] = new STAIndexedIndirect(this); //observe this and try to replicate
        instructionSet[0x91] = new STAIndirectIndexedY(this);//observe this and try to replicate
        instructionSet[0x86] = new STXZeroPage(this);
        instructionSet[0x96] = new STXZeroPageY(this);
        instructionSet[0x8E] = new STXAbsolute(this);
        instructionSet[0x84] = new STYZeroPage(this);
        instructionSet[0x94] = new STYZeroPageX(this);
        instructionSet[0x8C] = new STYAbsolute(this);
        //Push/Pull.
        instructionSet[0x48] = new PHAImplied(this);
        instructionSet[0x08] = new PHPImplied(this);
        instructionSet[0x68] = new PLAImplied(this);
        instructionSet[0x28] = new PLPImplied(this);
        //Add memory to accumulator with carry.
        instructionSet[0x69] = new ADCImmediate(this);
        instructionSet[0x65] = new ADCZeroPage(this);
        instructionSet[0x75] = new ADCZeroPageX(this);
        instructionSet[0x6D] = new ADCAbsolute(this);
        instructionSet[0x7D] = new ADCAbsoluteIndexedX(this); //this check page change
        instructionSet[0x79] = new ADCAbsoluteIndexedY(this); //this check page change
        instructionSet[0x61] = new ADCIndexedIndirect(this);
        instructionSet[0x71] = new ADCIndirectIndexed(this);//this check page change
        //Subtract memory from accumulator with borrow.
        instructionSet[0xE9] = new SBCImmediate(this);
        instructionSet[0xE5] = new SBCZeroPage(this);
        instructionSet[0xF5] = new SBCZeroPageIndexedX(this);
        instructionSet[0xED] = new SBCAbsolute(this);
        instructionSet[0xFD] = new SBCAbsoluteIndexedX(this);//this check page change
        instructionSet[0xF9] = new SBCAbsoluteIndexedY(this);//this check page change
        instructionSet[0xE1] = new SBCIndexedIndirect(this);
        instructionSet[0xF1] = new SBCIndirectIndexed(this);//this check page change
        //Logical AND memory with accumulator.
        instructionSet[0x29] = new AndImmediate(this);
        instructionSet[0x25] = new ANDZeroPage(this);
        instructionSet[0x35] = new ANDZeroPageX(this);
        instructionSet[0x2D] = new ANDAbsolute(this);
        instructionSet[0x3D] = new ANDAbsoluteIndexedX(this);//this check page change
        instructionSet[0x39] = new ANDAbsoluteIndexedY(this);//this check page change
        instructionSet[0x21] = new ANDIndexedIndirect(this);
        instructionSet[0x31] = new ANDIndirectIndexed(this);//this check page change
        //Exclusive-OR memory with accumulator.
        instructionSet[0x49] = new EORImmediate(this);
        instructionSet[0x45] = new EORZeroPage(this);
        instructionSet[0x55] = new EORZeroPageX(this);
        instructionSet[0x4D] = new EORAbsolute(this);
        instructionSet[0x5D] = new EORAbsoluteX(this);//this check page change
        instructionSet[0x59] = new EORAbsoluteY(this);//this check page change
        instructionSet[0x41] = new EORIndexedIndirect(this);
        instructionSet[0x51] = new EORIndirectIndexed(this);//this check page change
        //Logical OR memory with accumulator.
        instructionSet[0x09] = new ORAImmediate(this);
        instructionSet[0x05] = new ORAZeroPage(this);
        instructionSet[0x15] = new ORAZeroPageX(this);
        instructionSet[0x0D] = new ORAAbsolute(this);
        instructionSet[0x1D] = new ORAAbsoluteX(this);//this check page change
        instructionSet[0x19] = new ORAAbsoluteY(this);//this check page change
        instructionSet[0x01] = new ORAIndirectIndexedX(this);
        instructionSet[0x11] = new ORAIndirectIndexedY(this);//this check page change
        //Compare.
        instructionSet[0xC9] = new CMPImmediate(this);
        instructionSet[0xC5] = new CMPZeroPage(this);
        instructionSet[0xD5] = new CMPZeroPageX(this);
        instructionSet[0xCD] = new CMPAbsolute(this);
        instructionSet[0xDD] = new CMPAbsoluteX(this);//this check page change
        instructionSet[0xD9] = new CMPAbsoluteY(this);//this check page change
        instructionSet[0xC1] = new CMPIndirectIndexedX(this);
        instructionSet[0xD1] = new CMPIndirectIndexedY(this);//this check page change
        instructionSet[0xE0] = new CPXImmediate(this);
        instructionSet[0xE4] = new CPXZeroPage(this);
        instructionSet[0xEC] = new CPXAbsolute(this);
        instructionSet[0xC0] = new CPYImmediate(this);
        instructionSet[0xC4] = new CPYZeroPage(this);
        instructionSet[0xCC] = new CPYAbsolute(this);
        //Bit Test.
        instructionSet[0x24] = new BITZeroPage(this);
        instructionSet[0x2C] = new BITAbsolute(this);
        //Increment by one.
        instructionSet[0xE6] = new INCZeroPage(this);
        instructionSet[0xF6] = new INCZeroPageIndexed(this);
        instructionSet[0xEE] = new INCAbsolute(this);
        instructionSet[0xFE] = new INCAbsoluteX(this);
        instructionSet[0xE8] = new INXImplied(this);
        instructionSet[0xC8] = new INYImplied(this);
        //Decrement by one.
        instructionSet[0xC6] = new DECZeroPage(this);
        instructionSet[0xD6] = new DECZeroPageX(this);
        instructionSet[0xCE] = new DECAbsolute(this);
        instructionSet[0xDE] = new DECAbsoluteX(this);
        instructionSet[0xCA] = new DEXImplied(this);
        instructionSet[0x88] = new DEYImplied(this);
        //Shift Left.
        instructionSet[0x0A] = new ASLAccumulator(this);
        instructionSet[0x06] = new ASLZeroPage(this);
        instructionSet[0x16] = new ASLZeroPageX(this);
        instructionSet[0x0E] = new ASLAbsolute(this);
        instructionSet[0x1E] = new ASLAbsoluteX(this);
        //Shift Right.
        instructionSet[0x4A] = new LSRAccumulator(this);
        instructionSet[0x46] = new LSRZeroPage(this);
        instructionSet[0x56] = new LSRZeroPageX(this);
        instructionSet[0x4E] = new LSRAbsolute(this);
        instructionSet[0x5E] = new LSRAbsoluteX(this);
        //Rotate Left through Carry.
        instructionSet[0x2A] = new ROLAccumulator(this);
        instructionSet[0x26] = new ROLZeroPage(this);
        instructionSet[0x36] = new ROLZeroPageX(this);
        instructionSet[0x2E] = new ROLAbsolute(this);
        instructionSet[0x3E] = new ROLAbsoluteX(this);
        //Rotate Right through Carry.
        instructionSet[0x6A] = new RORAccumulator(this);
        instructionSet[0x66] = new RORZeroPage(this);
        instructionSet[0x76] = new RORZeroPageX(this);
        instructionSet[0x6E] = new RORAbsolute(this);
        instructionSet[0x7E] = new RORAbsoluteX(this);
        //Normal Jumps.
        instructionSet[0x4C] = new JMPAbsolute(this);
        instructionSet[0x6C] = new JMPIndirect(this);
        instructionSet[0x20] = new JSRAbsolute(this);
        instructionSet[0x40] = new RTIImplied(this);
        instructionSet[0x60] = new RTSImplied(this);
        //Conditional Branch Instructions.
        instructionSet[0x10] = new BPLRelative(this);
        instructionSet[0x30] = new BMIRelative(this);
        instructionSet[0x50] = new BVCRelative(this);
        instructionSet[0x70] = new BVSRelative(this);
        instructionSet[0x90] = new BCCRelative(this);
        instructionSet[0xB0] = new BCSRelative(this);
        instructionSet[0xD0] = new BNERelative(this);
        instructionSet[0xF0] = new BEQRelative(this);
        //Interrupts] = Exceptions] = Breakpoints.
        instructionSet[0x00] = new BRKImplied(this);
        //CPU Control.
        instructionSet[0x18] = new CLCImplied(this);
        instructionSet[0x58] = new CLIImplied(this);
        instructionSet[0xD8] = new CLDImplied(this);
        instructionSet[0xB8] = new CLVImplied(this);
        instructionSet[0x38] = new SECImplied(this);
        instructionSet[0x78] = new SEIImplied(this);
        instructionSet[0xF8] = new SEDImplied(this);
        //No Operation.
        instructionSet[0xEA] = new NOPImplied(this);


    //#######ILLEGAL 6502 OPCODES#############



    //NUL/NOP and KIL/JAM/HLT
       /* instructionSet[0x1A] = new NOPImplied(this);
    instructionSet[0x3A] = new NOPImplied(this);
    instructionSet[0x5A] = new NOPImplied(this);
    instructionSet[0x7A] = new NOPImplied(this);
    instructionSet[0xDA] = new NOPImplied(this);
    instructionSet[0xFA] = new NOPImplied(this);
    instructionSet[0x80] = new NOPImmediate(this);
    instructionSet[0x82] = new NOPImmediate(this);
    instructionSet[0x89] = new NOPImmediate(this);
    instructionSet[0xC2] = new NOPImmediate(this);
    instructionSet[0xE2] = new NOPImmediate(this);
    instructionSet[0x04] = new NOPZeroPage(this);
    instructionSet[0x44] = new NOPZeroPage(this);
    instructionSet[0x64] = new NOPZeroPage(this);
    instructionSet[0x14] = new NOPZeroPageIndexedX(this);
    instructionSet[0x34] = new NOPZeroPageIndexedX(this);
    instructionSet[0x54] = new NOPZeroPageIndexedX(this);
    instructionSet[0x74] = new NOPZeroPageIndexedX(this);
    instructionSet[0xD4] = new NOPZeroPageIndexedX(this);
    instructionSet[0xF4] = new NOPZeroPageIndexedX(this);
    instructionSet[0x0C] = new NOPAbsolute(this);
    instructionSet[0x1C] = new NOPAbsoluteX(this); //check page change
    instructionSet[0x3C] = new NOPAbsoluteX(this); //check page change
    instructionSet[0x5C] = new NOPAbsoluteX(this); //check page change
    instructionSet[0x7C] = new NOPAbsoluteX(this); //check page change
    instructionSet[0xDC] = new NOPAbsoluteX(this); //check page change
    instructionSet[0xFC] = new NOPAbsoluteX(this); //check page change
    instructionSet[0x02] = new KILImplied(this);
    instructionSet[0x12] = new KILImplied(this);
    instructionSet[0x22] = new KILImplied(this);
    instructionSet[0x32] = new KILImplied(this);
    instructionSet[0x42] = new KILImplied(this);
    instructionSet[0x52] = new KILImplied(this);
    instructionSet[0x62] = new KILImplied(this);
    instructionSet[0x72] = new KILImplied(this);
    instructionSet[0x92] = new KILImplied(this);
    instructionSet[0xB2] = new KILImplied(this);
    instructionSet[0xD2] = new KILImplied(this);
    instructionSet[0xF2] = new KILImplied(this);*/
    }

    public final Instruction getInstructionFrom(final int opCode) {
        return (instructionSet[opCode] == null ? new StillNotImplemented(this, opCode) : instructionSet[opCode]);
    }

    public final void setupFlagSign(final short value) {
        flagSign = (byte) ((value >> 7) & 0x1);
    }

    public final void setupFlagZero(final short value) {
        flagZero = (byte) ((value == 0) ? 1 : 0);
    }

    public final void step() {
        executeInstruction = getInstructionFrom(memory.read(programCounter));
        executeInstruction.interpret();
        cycles += executeInstruction.cycles();
    }

    public final void debugStep() {
        oldProgramCounter = programCounter;
        int opCode = memory.read(programCounter);
        Instruction actualInstruction = getInstructionFrom(opCode);
        actualInstruction.debug();
        cycles += actualInstruction.cycles();
        actualLineDebug = "0x" + fillIfNeedsWith(4, "0", Integer.toHexString(oldProgramCounter).toUpperCase()) + ":\t" + actualLineDebug + "\t;";
    }

    public final AssemblerLine disassemblerStep() {
        oldProgramCounter = programCounter;
        if (iNesRomIsOnePRGBank()) {
            if (programCounter == 0xBFFA ||
                    programCounter == 0xBFFC ||
                    programCounter == 0xBFFE) {
                actualLineDebug = "VECTOR TABLE";
                programCounter += 2;
            } else {
                normalDisassembler();
            }
        } else {
            if (programCounter == 0xBFFA ||
                    programCounter == 0xBFFC ||
                    programCounter == 0xBFFE) {

                short valueBFFA = memory.read(0xBFFA);
                short valueBFFC = memory.read(0xBFFC);
                short valueBFFE = memory.read(0xBFFE);

                short valueFFFA = memory.read(0xFFFA);
                short valueFFFC = memory.read(0xFFFC);
                short valueFFFE = memory.read(0xFFFE);

                if (valueBFFA == valueFFFA && valueBFFC == valueFFFC && valueBFFE == valueFFFE) {
                    actualLineDebug = "VECTOR TABLE";
                    programCounter += 2;
                } else {
                    normalDisassembler();
                }
            } else {
                normalDisassembler();
            }
        }
        return new AssemblerLine(oldProgramCounter, actualLineDebug);
    }
}
