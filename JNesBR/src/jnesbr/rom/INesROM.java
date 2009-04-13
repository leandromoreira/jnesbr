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

import java.nio.ByteBuffer;
import jnesbr.util.JNesUtil;
import static jnesbr.util.JNesUtil.*;

/**
 * @author dreampeppers99
 */
public class INesROM {

    public String romId;
    public short formatId;
    public short PRGROM16KPageCount;
    public short CHRROM8KPageCount;
    public short cartridgeTypeLSB;
        public short mirroringType;
            public static final short HORIZONTAL = 0;
            public static final short VERTICAL = 1;
        public short batteryPresence;
        public short trainerPresence;
        public short fourScreenMirroring;
        public short mapperNumber;
    public short cartridgeTypeMSB;
        public short unisystemGame;
        public short pc10Game;
        public short msbReserved;
        public short msbMapperNumber;
    public short RAMPageCount8K;
    public short reserved0;
    public short reserved1;
    public short reserved2;
    public short reserved3;
    public short reserved4;
    public short reserved5;
    public short nonzero;

    public String titleRom;
    public short[] playChoiceZ80;
    public short[] trainer;
    public short[] pgr_rom;
    public int PRG_ROMsize;
    public short[] chr_rom;
    public int CHR_ROMsize;

    public INesROM(ByteBuffer rom) {
        romId = String.valueOf((char) readNextUnsignedByteFrom(rom)) + String.valueOf((char) readNextUnsignedByteFrom(rom)) + String.valueOf((char) readNextUnsignedByteFrom(rom));
        formatId = readNextUnsignedByteFrom(rom);

        if (!romId.equals("NES") || formatId != 0x1A ) throw new IllegalArgumentException("The file isn't a iNes!");

        PRGROM16KPageCount = readNextUnsignedByteFrom(rom);
        CHRROM8KPageCount = readNextUnsignedByteFrom(rom);
        cartridgeTypeLSB = readNextUnsignedByteFrom(rom);
            setCartridgeTypeLSBAttributes();
        cartridgeTypeMSB = readNextUnsignedByteFrom(rom);
            setCartridgeTypeMSBAttributes();
        RAMPageCount8K = readNextUnsignedByteFrom(rom);
        reserved0 = readNextUnsignedByteFrom(rom);
        reserved1 = readNextUnsignedByteFrom(rom);
        reserved2 = readNextUnsignedByteFrom(rom);
        reserved3 = readNextUnsignedByteFrom(rom);
        reserved4 = readNextUnsignedByteFrom(rom);
        reserved5 = readNextUnsignedByteFrom(rom);
        nonzero = readNextUnsignedByteFrom(rom);

        if (trainerPresence == 0x1) {
            fillTrainerWith512BytesFrom(rom);
        }
        fillPGR_ROMFrom(rom);
        fillCHR_ROMFrom(rom);
        if (pc10Game == 0x1){
            fillWith8KFrom(rom);
        }
    }

    private void fillPGR_ROMFrom(ByteBuffer rom) {
        PRG_ROMsize = PRGROM16KPageCount * 16 * 1024 ;
        pgr_rom = new short[PRG_ROMsize];
        for (int i = 0; i < PRG_ROMsize; i++) {
            pgr_rom[i] = readNextUnsignedByteFrom(rom);
        }
    }
    private void fillCHR_ROMFrom(ByteBuffer rom) {
        if (CHRROM8KPageCount == 0) return;

        CHR_ROMsize = CHRROM8KPageCount * 8 * 1024 ;
        chr_rom = new short[CHR_ROMsize];
        for (int i = 0; i < CHR_ROMsize; i++) {
            chr_rom[i] = readNextUnsignedByteFrom(rom);
        }
    }

    private void fillTrainerWith512BytesFrom(ByteBuffer rom) {
        trainer = new short[512];
        for (int i = 0; i < 512; i++) {
            trainer[i] = readNextUnsignedByteFrom(rom);
        }
    }

    private void fillWith8KFrom(ByteBuffer rom) {
        playChoiceZ80 = new short[8*1024];
        for (int i = 0; i < (8*1024); i++) {
            playChoiceZ80[i] = readNextUnsignedByteFrom(rom);
        }
    }

    private void setCartridgeTypeLSBAttributes() {
        mapperNumber = (short) (cartridgeTypeLSB >> 4);
        mirroringType = giveMeBit0From(cartridgeTypeLSB);
        batteryPresence = giveMeBit1From(cartridgeTypeLSB);
        trainerPresence = giveMeBit2From(cartridgeTypeLSB);
        fourScreenMirroring = giveMeBit3From(cartridgeTypeLSB);
    }

    private void setCartridgeTypeMSBAttributes() {
        unisystemGame = giveMeBit0From(cartridgeTypeMSB);
        pc10Game = giveMeBit1From(cartridgeTypeMSB);
        msbReserved = (short) ( (giveMeBit3From(cartridgeTypeMSB) << 1 ) & giveMeBit2From(cartridgeTypeMSB));
        msbMapperNumber = (short) (cartridgeTypeMSB >> 4);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("==========iNes Header==========\n");
        sb.append("Rom Id:\t\t"+romId+"\n");
        sb.append("Format Id:\t\t"+ JNesUtil.fillIfNeedsWith(2, "0", Integer.toHexString(formatId).toUpperCase()) +"\n");
        sb.append("Pages PRG16K:\t\t"+PRGROM16KPageCount+"\n");
        sb.append("Pages CHR8K:\t\t"+CHRROM8KPageCount+"\n");

        sb.append("Cartridge LSB:\n");
        sb.append("\tMirroring type:\t\t"+ ((mirroringType==0)?"Horizontal":"Vertical") +"\n");
        sb.append("\tBattery presence:\t\t"+ ((batteryPresence==1)?"Yes":"No") +"\n");
        sb.append("\tTrainer presence:\t\t"+ ((trainerPresence==1)?"Yes":"No") +"\n");
        sb.append("\tScreen Mirroring:\t\t"+ ((fourScreenMirroring==1)?"Yes":"No") +"\n");
        sb.append("\tMapper :\t\t"+ INesMapperUtil.getName(mapperNumber) +"\n");

        sb.append("Cartridge MSB:\n");
        sb.append("\tUnisystem game:\t\t"+ ((unisystemGame==1)?"Yes":"No") +"\n");
        sb.append("\tPC10 game:\t\t"+ ((pc10Game==1)?"Yes":"No") +"\n");
        sb.append("\tReserved:\t\t"+ msbReserved +"\n");
        sb.append("\tMapper Number:\t\t"+ msbMapperNumber +"\n");

        sb.append("Pages RAM8K:\t\t"+RAMPageCount8K+"\n");
        sb.append("Reserved0:\t\t"+reserved0+"\n");
        sb.append("Reserved1:\t\t"+reserved1+"\n");
        sb.append("Reserved2:\t\t"+reserved2+"\n");
        sb.append("Reserved3:\t\t"+reserved3+"\n");
        sb.append("Reserved4:\t\t"+reserved4+"\n");
        sb.append("Reserved5:\t\t"+reserved5+"\n");
        sb.append("Nonzero:\t\t"+nonzero+"\n");
        sb.append("==========iNes Header==========");
        
        return sb.toString();
    }
}
