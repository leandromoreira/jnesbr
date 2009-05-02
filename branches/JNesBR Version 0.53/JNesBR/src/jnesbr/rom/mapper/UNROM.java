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
package jnesbr.rom.mapper;

import jnesbr.processor.memory.Memory;
import jnesbr.rom.INesROM;
import static jnesbr.processor.memory.MemoryMap.*;

/**
 * @author dreampeppers99
 */
public class UNROM {
    public byte id = 2;

    public void fillMemory(INesROM rom){
        short firstBank  = 0;
        short lastBank = rom.PRGROM16KPageCount;

        int x = firstBank;
        for (int i = LOWER_BANK_START ; i <= LOWER_BANK_END ; i++ ){
            Memory.getMemory().write(i, rom.pgr_rom[x++]);
        }

        x = (lastBank-1) * 1024;
        for (int i = UPPER_BANK_START ; i <= UPPER_BANK_END ; i++ ){
            Memory.getMemory().write(i, rom.pgr_rom[x++]);
        }
    }
}
