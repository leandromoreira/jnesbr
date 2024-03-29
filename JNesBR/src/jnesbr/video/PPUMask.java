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
public class PPUMask {
    public byte intensifyBlues;
    public byte intensifyGreens;
    public byte intensifyReds;
    public byte spriteRenderingEnable;
    public byte backgroundRenderingEnable;
    public byte enableSpriteInLeftmost;
    public byte enableBackgroundInLeftmost;
        public static final byte CLIP = 0;
        public static final byte DISPLAY = 1;
    public byte grayscale;
        public static final byte NORMAL = 0;
        public static final byte MONOCHROMO = 1;
}
