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
package jnesbr.video.memory;

/**
 * @author dreampeppers99
 */
public class VideoMemoryMap {
    public final static int PATTERN_TABLE_0_START = 0x0000;
    public final static int PATTERN_TABLE_0_END = 0x0FFF;
    public final static int PATTERN_TABLE_1_START = 0x1000;
    public final static int PATTERN_TABLE_1_END = 0x1FFF;
    public final static int NAME_TABLE_0_START = 0x2000;
    public final static int NAME_TABLE_0_END = 0x23FF;
    public final static int NAME_TABLE_1_START = 0x2400;
    public final static int NAME_TABLE_1_END = 0x27FF;
    public final static int NAME_TABLE_2_START = 0x2800;
    public final static int NAME_TABLE_2_END = 0x2BFF;
    public final static int NAME_TABLE_3_START = 0x2C00;
    public final static int NAME_TABLE_3_END = 0x2FFF;
    public final static int MIRROR0_START = 0x3000;
    public final static int MIRROR0_END = 0x3EFF;
    public final static int BG_SPR_PALLETE_START = 0x3F00;
        public final static int BG_PALLETE_START = 0x3F00;
        public final static int BG_PALLETE_END = 0x3F0F;
        public final static int SPR_PALLETE_START = 0x3F10;
        public final static int SPR_PALLETE_END = 0x3F1F;
    public final static int BG_SPR_PALLETE_END = 0x3F1F;
    public final static int MIRROR1_START = 0x3F20;
    public final static int MIRROR1_END = 0x3FFF;
}