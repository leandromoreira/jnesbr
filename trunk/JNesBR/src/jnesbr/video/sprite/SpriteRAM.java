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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dreampeppers99
 */
public class SpriteRAM {

    private static SpriteRAM instance;
    private Sprite[] sprites = new Sprite[64];
    private int index;

    public static SpriteRAM getInstance() {
        if (instance == null) {
            instance = new SpriteRAM();
        }
        return instance;
    }
    private short[] spriteMemory = new short[0x100];

    private SpriteRAM() {
        index = 0;
        for (short i = 0 ; i < 64 ; i++){
            sprites[i] = new Sprite(i);
        }
    }

    public void add(short address, short value) {
        spriteMemory[address & 0xFF] = value;
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
        sprites[index].populate(spriteMemory[index * 4],
                spriteMemory[index * 4 + 1],
                spriteMemory[index * 4 + 2],
                spriteMemory[index * 4 + 3]);
        return sprites[index];
    }

    public final List<Sprite> spriteEvaluation(final int y,final int situation) {
        List<Sprite> list = new ArrayList<Sprite>();
        //TODO: make this to 8x16 size sprite

        for (int i = 0; i < 64; i++) {
            Sprite actual = getSprite(i);
            if (actual.backgroundPriority == situation &&
                    (y >= actual.yCoordinate &&
                     y <= (actual.yCoordinate+7) &&
                     actual.yCoordinate != -1)
                    ) {
                list.add(actual);
            }
            /*if (actual.backgroundPriority == situation &&
                    y >= actual.yCoordinate && y <= (actual.yCoordinate + 15) {
                list.add(actual);
            }*/
        }
        return list;
    }

    public void doDMA(short[] array, int length) {
    }
}
