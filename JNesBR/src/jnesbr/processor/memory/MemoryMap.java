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
package jnesbr.processor.memory;

/**
 * @author dreampeppers99
 */
public class MemoryMap {
    public final static int RAM_START = 0x0000;
        public final static int ZERO_PAGE_START = 0x0000;
        public final static int ZERO_PAGE_END = 0x00FF;
        public final static int STACK_START = 0x0100;
        public final static int STACK_END = 0x01FF;
        public final static int RAM_0_START = 0x0200;
        public final static int RAM_0_END = 0x07FF;
        public final static int MIRROR_0_START = 0x0800;
            public final static int MIRROR_0_ZERO_PAGE_START1 = 0x0800;
            public final static int MIRROR_0_ZERO_PAGE_END1 = 0x08FF;
            public final static int MIRROR_0_STACK_START1 = 0x0900;
            public final static int MIRROR_0_STACK_END1 = 0x09FF;
            public final static int MIRROR_0_RAM_0_START1 = 0x0A00;
            public final static int MIRROR_0_RAM_0_END1 = 0x0FFF;

            public final static int MIRROR_1_ZERO_PAGE_START1 = 0x1000;
            public final static int MIRROR_1_ZERO_PAGE_END1 = 0x10FF;
            public final static int MIRROR_1_STACK_START1 = 0x1100;
            public final static int MIRROR_1_STACK_END1 = 0x11FF;
            public final static int MIRROR_1_RAM_0_START1 = 0x1200;
            public final static int MIRROR_1_RAM_0_END1 = 0x17FF;

            public final static int MIRROR_2_ZERO_PAGE_START1 = 0x1800;
            public final static int MIRROR_2_ZERO_PAGE_END1 = 0x18FF;
            public final static int MIRROR_2_STACK_START1 = 0x1900;
            public final static int MIRROR_2_STACK_END1 = 0x19FF;
            public final static int MIRROR_2_RAM_0_START1 = 0x1A00;
            public final static int MIRROR_2_RAM_0_END1 = 0x1FFF;
        public final static int MIRROR_0_END = 0x1FFF;
    public final static int RAM_END = 0x1FFF;
    
    public final static int IO_REGISTERS_START = 0x2000;
        public final static int IO_REGISTERS1_START = 0x2000;
            public final static int PPU_CONTROL_REGISTER_1 = 0x2000;

        public final static int IO_REGISTERS1_END = 0x2007;
        public final static int IO_MIRROR_START = 0x2008;
        public final static int IO_MIRROR_END = 0x3FFF;
        public final static int IO_REGISTERS2_START = 0x4000;
        public final static int IO_REGISTERS2_END = 0x401F;
    public final static int IO_REGISTERS_END = 0x401F;

    public final static int EXPANSION_ROM_START = 0x4020;
    public final static int EXPANSION_ROM_END = 0x5FFF;
    
    public final static int SAVE_RAM_START = 0x6000;
    public final static int SAVE_RAM_END = 0x7FFF;

    public final static int PRG_ROM_START = 0x8000;
        public final static int LOWER_BANK_START = 0x8000;
        public final static int LOWER_BANK_END = 0xBFFF;
        public final static int UPPER_BANK_START = 0xC000;
        public final static int UPPER_BANK_END = 0xFFFF;
    public final static int PRG_ROM_END = 0xFFFF;
}

















