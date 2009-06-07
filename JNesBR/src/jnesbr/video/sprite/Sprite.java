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

/**
 * @author dreampeppers99
 */
import jnesbr.video.*;
import static jnesbr.util.JNesUtil.*;

public class Sprite {

    public Sprite(short index){
        this.index = index;
    }
    
    public Sprite(short byte0, short byte1, short byte2, short byte3) {
        yCoordinate = (short) (byte0 - 1);
        if (Ppu2C02.getInstance().ppuControl.spriteSize == PPUControll.SPRITE8x8) {
            tileNumer0 = byte1;
            patternTable = (byte) ((Ppu2C02.getInstance().ppuControl.patternTableAddressSprites == PPUControll.VRAM0x0000) ? 0 : 1);
        } else {
            tileNumer0 = (short) ((byte1 >> 1) * 2);
            tileNumer1 = (short) ((byte1 >> 1) * 2 + 1);
            patternTable = (byte) (((byte1 & 0x1) == 0) ? 0 : 1);
        }
        attributes = byte2;
        verticalFlip = giveMeBit7From(byte2);
        horizontalFlip = giveMeBit6From(byte2);
        backgroundPriority = giveMeBit5From(byte2);
        paletteUpperBitsColor = (byte) (giveMeBit1From(byte2) << 1 | giveMeBit0From(byte2));
        xCoordinate = byte3;
    }

    public void populate(short byte0, short byte1, short byte2, short byte3) {
        yCoordinate = (short) (byte0 - 1);
        if (Ppu2C02.getInstance().ppuControl.spriteSize == PPUControll.SPRITE8x8) {
            tileNumer0 = byte1;
            patternTable = (byte) ((Ppu2C02.getInstance().ppuControl.patternTableAddressSprites == PPUControll.VRAM0x0000) ? 0 : 1);
        } else {
            tileNumer0 = (short) ((byte1 >> 1) * 2);
            tileNumer1 = (short) ((byte1 >> 1) * 2 + 1);
            patternTable = (byte) (((byte1 & 0x1) == 0) ? 0 : 1);
        }
        attributes = byte2;
        verticalFlip = giveMeBit7From(byte2);
        horizontalFlip = giveMeBit6From(byte2);
        backgroundPriority = giveMeBit5From(byte2);
        paletteUpperBitsColor = (byte) (giveMeBit1From(byte2) << 1 | giveMeBit0From(byte2));
        xCoordinate = byte3;
    }
    public short index;
    public short yCoordinate;
    public short tileNumer0;
    public short tileNumer1;
    public byte patternTable;
    public short attributes;
    public byte verticalFlip;
    public byte horizontalFlip;
    public final static byte NORMAL = 0,  MIRROR = 1;
    public byte backgroundPriority;
    public final static byte FRONT = 0,  BEHIND = 1;
    public short notUsed;
    public byte paletteUpperBitsColor;
    public short xCoordinate;

    @Override
    public String toString() {
        return index + " x=" + xCoordinate + " y=" + yCoordinate;
    }


}

