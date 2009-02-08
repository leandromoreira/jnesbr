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
import jnesbr.core.Emulator;
import jnesbr.video.memory.VideoMemory;
import static jnesbr.processor.memory.MemoryMap.*;

/**
 * @author dreampeppers99
 */
public class Loader {
    private static final short ONE_BANK = 1, TWO_BANKS = 2;
    private INesROM game;

    public void load(ByteBuffer rom) {
        game = new INesROM(rom);
        fillMainMemoryWith(game);
        fillPPUMemoryWith(game);
    }

    public INesROM getGame() {
        return game;
    }

    public String getHeader() {
        return game.toString();
    }
    private void fillMainMemoryWith(INesROM game) {
        switch (game.PRG_ROMPageCount16K) {
            case ONE_BANK:
                for (int i = 0; i < game.pgr_rom.length; i++) {
                    Emulator.getInstance().getMemory().writeAt(LOWER_BANK_START + i, game.pgr_rom[i]);
                    Emulator.getInstance().getMemory().writeAt(UPPER_BANK_START + i, game.pgr_rom[i]);
                }
                break;
            case TWO_BANKS:
                for (int i = 0; i < game.pgr_rom.length; i++) {
                    Emulator.getInstance().getMemory().writeAt(PRG_ROM_START + i, game.pgr_rom[i]);
                }
                break;
            default:
                //memory mapper dependent, memory.addHandler to ensure this!
                //each mapper has a way to fill initial and switch pages!
                int x = 0;
                for (int i = PRG_ROM_START ; i <= PRG_ROM_END; i++) {
                    Emulator.getInstance().getMemory().writeAt(PRG_ROM_START + x, game.pgr_rom[x++]);
                }
        }
    }
    private void fillPPUMemoryWith(INesROM game) {
        switch (game.CHR_ROMPageCount8K) {
            case ONE_BANK:
                for (int i = 0; i < game.chr_rom.length; i++) {
                    VideoMemory.getMemory().writeAt(i,game.chr_rom[i] );
                }
                break;
            default:
        }
    }
}
