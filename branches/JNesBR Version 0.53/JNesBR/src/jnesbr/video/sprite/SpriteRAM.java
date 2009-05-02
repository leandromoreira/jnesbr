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
package jnesbr.video.sprite;

import java.util.Arrays;

/**
 * @author dreampeppers99
 */
public class SpriteRAM {

    private static SpriteRAM instance;
    private Sprite[] sprites = new Sprite[256];
    private int index;

    public static SpriteRAM getInstance() {
        if (instance == null) {
            instance = new SpriteRAM();
        }
        return instance;
    }
    private short[] spriteMemory = new short[0x100];

    public void reset() {
        spriteMemory = new short[0x100];
    }

    private SpriteRAM() {
        index = 0;
    }

    public void add(short address, short value) {
        spriteMemory[address] = value;
    }

    public short[] spriteRAM() {
        return Arrays.copyOf(spriteMemory, spriteMemory.length);
    }

    public void add(short byt) {
        spriteMemory[index++] = byt;
    }

    public short get(int index) {
        return spriteMemory[index];
    }

    public Sprite getSprite(int index) {
        return new Sprite(spriteMemory[index * 4],
                spriteMemory[index * 4 + 1],
                spriteMemory[index * 4 + 2],
                spriteMemory[index * 4 + 3]);
    }

    public void doDMA(short[] array, int length) {
    }
}
