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
public class PPUControll {
    public byte executeNMIOnVBlank;
    public byte masterOrSlave;
    public byte spriteSize;
        public final byte sprite8x8 = 0;
        public final byte sprite8x16 = 1;
   public byte patternTableAddressBackground ;
        public final byte VRAM0x0000 = 0;
        public final byte VRAM0x1000 = 1;
   public byte patternTableAddress8x8Sprites ;
   public byte port2007AddressIncrement;
        public final byte IncrementBy1 = 0;
        public final byte IncrementBy32 = 1;
   public byte nameTableAddress;
        public final byte VRAM2000 = 0;
        public final byte VRAM2400 = 1;
        public final byte VRAM2800 = 2;
        public final byte VRAM2C00 = 3;
   public byte horizontalScrollBy256;
   public byte verticalScrollBy240;
}
