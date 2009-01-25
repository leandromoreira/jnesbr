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
package jnesbr.rom;

/**
 * @author dreampeppers99
 */
public class INesMapperUtil {

    private static String[] helpers = new String[0xFF];
    static{
        helpers[0]="No Mapper";
        helpers[1]="MMC1";
        helpers[2]="UNROM";
        helpers[3]="CNROM";
        helpers[4]="MMC3";
        helpers[5]="MMC5";
        helpers[6]="FFE";
        helpers[7]="AOROM";
        helpers[8]="FFE";
        helpers[9]="MMC2";
        helpers[10]="MMC4";
    }
    public static String getName(int code){
        if (code>=0xFF) throw new IllegalArgumentException("There is mapped mappers for this code ["+code+"]");
        return (helpers[code]!=null?helpers[code]:"Not Found");
    }
/*
Mapper 11: Color Dreams - PRG/32K, VROM/8K
Mapper 12: FFE F6xxx - Not specified, NT, IRQ
Mapper 13: CPROM - 16K VRAM
Mapper 15: X-in-1 - PRG/32K/16K, NT
Mapper 16: Bandai - PRG/16K, VROM/1K, IRQ, EPROM
Mapper 17: FFE F8xxx - PRG/8K, VROM/1K, NT, IRQ
Mapper 18: Jaleco SS8806 - PRG/8K, VROM/1K, NT, IRQ, EXT
Mapper 19: Namcot 106 - PRG/8K, VROM/1K/VRAM, IRQ, SOUND
Mapper 20: Disk System - PRG RAM, BIOS, DISK, IRQ, SOUND
Mapper 21: Konami VRC4A/VRC4C - PRG/8K, VROM/1K, NT, IRQ
Mapper 22: Konami VRC2A - PRG/8K, VROM/1K, NT
Mapper 23: Konami VRC2B/VRC4E - PRG/8K, VROM/1K, NT, (IRQ)
Mapper 24: Konami VRC6A - PRG/16K/8K, VROM/1K, NT, IRQ, SOUND
Mapper 25: Konami VRC4B/VRC4D - PRG/8K, VROM/1K, NT, IRQ
Mapper 26: Konami VRC6B - PRG/16K/8K, VROM/1K, NT, IRQ, SOUND
Mapper 32: Irem G-101 - PRG/8K, VROM/1K, NT
Mapper 33: Taito TC0190/TC0350 - PRG/8K, VROM/1K/2K, NT, IRQ
Mapper 34: Nina-1 - PRG/32K, VROM/4K
Mapper 40: FDS-Port - Lost Levels
Mapper 41: Caltron 6-in-1
Mapper 42: FDS-Port - Mario Baby
Mapper 43: X-in-1
Mapper 44: 7-in-1 MMC3 Port A001h
Mapper 45: X-in-1 MMC3 Port 6000hx4
Mapper 46: 15-in-1 Color Dreams
Mapper 47: 2-in-1 MMC3 Port 6000h
Mapper 48: Taito TC190V
Mapper 49: 4-in-1 MMC3 Port 6xxxh
Mapper 50: FDS-Port - Alt. Levels
Mapper 51: 11-in-1
Mapper 52: 7-in-1 MMC3 Port 6800h with SRAM
Mapper 56: Pirate SMB3
Mapper 57: 6-in-1
Mapper 58: X-in-1
Mapper 61: 20-in-1
Mapper 62: X-in-1
Mapper 64: Tengen RAMBO-1 - PRG/8K, VROM/2K/1K, NT
Mapper 65: Irem H-3001 - PRG/8K, VROM/1K, NT, IRQ
Mapper 66: GNROM - PRG/32K, VROM/8K
Mapper 67: Sunsoft3 - PRG/16K, VROM/2K, IRQ
Mapper 68: Sunsoft4 - PRG/16K, VROM/2K, NT-VROM
Mapper 69: Sunsoft5 FME-7 - PRG/8K, VROM/1K, NT ctrl, SRAM, IRQ
Mapper 70: Bandai - PRG/16K, VROM/8K, NT
Mapper 71: Camerica - PRG/16K
Mapper 72: Jaleco Early Mapper 0 - PRG-LO, VROM/8K
Mapper 73: Konami VRC3 - PRG/16K, IRQ
Mapper 74: Whatever MMC3-style
Mapper 75: Jaleco SS8805/Konami VRC1 - PRG/8K, VROM/4K
Mapper 76: Namco 109 - PRG/8K, VROM/2K
Mapper 77: Irem - PRG/32K, VROM/2K, VRAM 6K+2K
Mapper 78: Irem 74HC161/32 - PRG/16K, VROM/8K
Mapper 79: AVE Nina-3 - VROM/8K
Mapper 80: Taito X-005 - PRG/8K, VROM/2K/1K, NT
Mapper 81: AVE Nina-6
Mapper 82: Taito X1-17 - PRG/8K, VROM/2K/1K
Mapper 83: Cony
Mapper 84: Whatever
Mapper 85: Konami VRC7A/B - PRG/16K/8K, VROM/1K, NT, IRQ, SOUND
Mapper 86: Jaleco Early Mapper 2 - PRG/32K, VROM/8K
Mapper 87: Jaleco/Konami 16K VROM - VROM/8K
Mapper 88: Namco 118
Mapper 89: Sunsoft Early - PRG/16K, VROM/8K
Mapper 90: Pirate MMC5-style
Mapper 91: HK-SF3 - PRG/8K, VROM/2K, IRQ
Mapper 92: Jaleco Early Mapper 1 - PRG-HI, VROM/8K
Mapper 93: 74161/32 - PRG/16K
Mapper 94: 74161/32 - PRG/16K
Mapper 95: Namcot MMC3-Style
Mapper 96: 74161/32
Mapper 97: Irem - PRG HI
Mapper 99: VS Unisystem Port 4016h - VROM/8K
Mapper 100: Whatever
Mapper 105: X-in-1 MMC1
Mapper 112: Asder - PRG/8K, VROM/2K/1K
Mapper 113: Sachen/Hacker/Nina
Mapper 114: Super Games
Mapper 115: MMC3 Cart Saint
Mapper 116: Whatever
Mapper 117: Future
Mapper 118: MMC3 with different Name Tables
Mapper 119: MMC3 TQROM with VROM+VRAM Pattern Tables
Mapper 122: Whatever
Mapper 133: Sachen
Mapper 151: VS Unisystem - PRG/8K, VROM/4K
Mapper 152: Whatever
Mapper 160: Same as Mapper 90
Mapper 161: Same as Mapper 1
Mapper 180: Nihon Bussan - PRG HI
Mapper 182: Same as Mapper 114
Mapper 184: Sunsoft - VROM/4K
Mapper 185: VROM-disable
Mapper 187: No Info
Mapper 188: UNROM-reversed
Mapper 189: MMC3 Variant
Mapper 222: Dragon Ninja
Mapper 225: X-in-1
Mapper 226: X-in-1
Mapper 227: X-in-1
Mapper 228: X-in-1 Homebrewn
Mapper 229: 31-in-1
Mapper 230: X-in-1 plus Contra
Mapper 231: 20-in-1
Mapper 232: 4-in-1 Quattro Camerica
Mapper 233: X-in-1 plus Reset
Mapper 234: Maxi-15
Mapper 240: C&E/Supertone - PRG/32K, VROM/8K
Mapper 241: X-in-1 Education
Mapper 242: Waixing - PRG/32K, NT
Mapper 243: Sachen Poker - PRG/32K, VROM/8K
Mapper 244: C&E - PRG/32K, VROM/8K
Mapper 245: No Info (seems to be some sort of MMC3 variant)
Mapper 246: C&E - PRG/8K, VROM/2K, SRAM
Mapper 248: No Info
Mapper 249: No Info
Mapper 250: No Info
Mapper 251: No Info
Mapper 252: No Info
Mapper 254: No Info
Mapper 255: X-in-1 - (Same as Mapper 225)*/
}
