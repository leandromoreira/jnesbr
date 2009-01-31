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
package jnesbr.processor.memory.handler;

import jnesbr.processor.memory.*;
import jnesbr.util.JNesUtil;

/**
 * @author dreampeppers99
 */
public class PPUControlRegister1Handler implements Handler {

    /* Bit7 Execute NMI on
    VBlank(0= Disabled, 1=Enabled)
    Bit6  PPU Master/Slave Selection        (0=Master, 1=Slave) (Not used in NES)
    Bit5  Sprite Size                       (0=8x8, 1=8x16)
    Bit4  Pattern Table Address Background  (0=VRAM 0000h, 1=VRAM 1000h)
    Bit3  Pattern Table Address 8x8 Sprites (0=VRAM 0000h, 1=VRAM 1000h)
    Bit2  Port 2007h VRAM Address Increment (0=Increment by 1, 1=Increment by 32)
    Bit1-0 Name Table Scroll Address        (0-3=VRAM 2000h,2400h,2800h,2C00h)
    (That is, Bit0=Horizontal Scroll by 256, Bit1=Vertical Scroll by 240)*/
    public byte executeNMIOnVBlank;
    public byte masterOrSlave;
    public byte spriteSize; 
    

    public void writeAt(int address, short value) {
        executeNMIOnVBlank = (byte) JNesUtil.giveMeBit7From(value);
        Memory.getMemory().write(address, value);
        mirror(address, value);
    }

    private void mirror(int address, short value) {
        while ((address + 0x08) <= MemoryMap.IO_MIRROR_END) {
            Memory.getMemory().write(address + 0x08, value);
            address += 8;
        }
    }
}
