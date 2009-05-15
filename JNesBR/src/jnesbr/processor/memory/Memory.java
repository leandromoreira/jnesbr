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

import java.util.HashMap;
import java.util.Map;
import jnesbr.joystick.handlers.Joystick1Handler;
import jnesbr.joystick.handlers.Joystick2Handler;
import jnesbr.processor.memory.handler.*;
import jnesbr.processor.memory.handler.ppu.*;
import static jnesbr.processor.memory.MemoryMap.*;

/**
 * @author dreampeppers99
 */
public final class Memory {

    private static Memory instance;
    private short[] memory = new short[0x10000];
    private Handler normal;
    private Handler result;
    private Map<Integer, Handler> handlers = new HashMap<Integer, Handler>();

    public static Memory getMemory() {
        if (instance == null) {
            instance = new Memory();
            instance.initHandlers();
        }
        return instance;
    }

    public short[] getUnhandled() {
        return memory;
    }

    public final void addMemoryHandler(final int address,final Handler handler) {
        handlers.put(address, handler);
    }

    public final short read(final int address) {
        return getHandler(address).readFrom(address);
    }

    public final short readUnhandled(final int address) {
        return memory[address];
    }

    public final void removeMemoryHandler(final int address) {
        handlers.remove(address);
    }

    private Memory() {
    }

    public final void reset() {
        for (int i = 0; i < memory.length; i++) {
            if (i < 0x8000) {
                memory[i] = 0;
            }
        }
    }

    public final void write(final int address, final short value) {
        getHandler(address).writeAt(address, value);
    }

    public final void writeUnhandled(final int address, final short value) {
        memory[address] = value;
    }

    private final Handler getHandler(int address) {

        //The $2008-$3FFF mirroring.
        if (address >= IO_MIRROR_START & address <= IO_MIRROR_END){
            address &= 0xE007;
        }

        result = handlers.get(address);
        if (result != null) {
            return result;
        }

        //The RAM mirroring.
        if (address >= MIRROR_0_START & address <= MIRROR_0_END) {
            address &= 0x07FF ;
        }

        return normal;
    }

    private final void initHandlers() {
        // #### Standard handler ####
        normal = new NormalHandler();

        // #### Ppu handlers ####
        handlers.put(PPU_CONTROL, new PPUControlHandler());                         //$2000
        handlers.put(PPU_MASK, new PPUMaskHandler());                               //$2001
        handlers.put(PPU_STATUS, new PPUStatusHandler());                           //$2002
        handlers.put(PPU_ADDRESS, new PPUAdressHandler());                          //$2006
        handlers.put(PPU_OAM_ADDRESS, new PPUOAMAddressHandler());                  //$2003
        handlers.put(PPU_OAM_DATA, new PPUOAMDataHandler());                        //$2004
        handlers.put(PPU_DATA, new PPUDataHandler());                               //$2007
        handlers.put(PPU_SCROLL, new PPUScrollHandler());                           //$2005
        handlers.put(DIRECT_MEMORY_ACCESS, new PPUDirectMemoryAccessHandler());     //$4014

        // #### Joystick handlers ####
        handlers.put(JOYSTICK1, new Joystick1Handler());                            //$4016
        handlers.put(JOYSTICK2, new Joystick2Handler());                            //$4017

        // #### APU handlers ####
    }
}
