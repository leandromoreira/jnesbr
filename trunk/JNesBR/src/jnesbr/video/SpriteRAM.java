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
package jnesbr.video;

/**
 * @author dreampeppers99
 */
public class SpriteRAM {

    private static SpriteRAM instance;

    public static SpriteRAM getInstance() {
        if (instance == null) {
            instance = new SpriteRAM();
        }
        return instance;
    }
    private short[] spriteMemory = new short[0x100];

    private SpriteRAM() {
    }

    public void add(int address, short byt) {
        spriteMemory[address] = byt;
    }

    public short get(int address) {
        return spriteMemory[address];
    }

    public void doDMA(short[] array,int length){
    }
}
