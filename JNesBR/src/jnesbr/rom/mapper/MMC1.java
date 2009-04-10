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

import java.util.Map;
import jnesbr.processor.memory.Memory;
import jnesbr.processor.memory.handler.Handler;
import jnesbr.rom.INesROM;
import static jnesbr.processor.memory.MemoryMap.*;

/**
 * @author dreampeppers99
 */
public class MMC1 implements Handler {
    private Register0 register0 = new Register0();
    private Register1 register1 = new Register1();
    private Register2 register2 = new Register2();
    private Register3 register3 = new Register3();
    
    public void fillPRG(INesROM game) {
        Memory mem = Memory.getMemory();
        int x = 0;
        for (int index = LOWER_BANK_START; index <= LOWER_BANK_END; index++) {
            mem.writeUnhandled(index, game.pgr_rom[x++]);
        }
        //TODO: continue evoluting this idea ! {this should be the last page}
        x = game.PRG_ROMPageCount16K * 16 * 1024;
        for (int index = UPPER_BANK_START; index <= UPPER_BANK_END; index++) {
            mem.writeUnhandled(index, game.pgr_rom[x++]);
        }
    }

    public void fillAddressRangeObserver(Map<Integer, Handler> handler) {
        //$8000 - $9FFF
        //$A000 - $BFFF
        //$C000 - $DFFF
        //$E000 - $FFFF
        for (int address = 0x8000 ; address <= 0xFFFF ; address++ ){
            handler.put(address, this);
        }
        //maybe a beautiful solution... is needed here
    }

    public void writeAt(int address, short value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public short readFrom(int address) {
        return Memory.getMemory().readUnhandled(address);
    }

    private class Register0 {
        public byte mirroringFlag;
            public final static byte HORIZONTAL = 0;
            public final static byte VERTICAL = 1;
    }

    private class Register1 {
    }

    private class Register2 {
    }

    private class Register3 {
    }
}
