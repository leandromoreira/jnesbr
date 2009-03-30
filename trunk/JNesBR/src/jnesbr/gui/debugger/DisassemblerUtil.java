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
package jnesbr.gui.debugger;

/**
 * @author dreampeppers99
 */
public class DisassemblerUtil {

    public static String giveMeComplementIfNeeds(int value) {
        String returnValue = "";
        if (value == 0x2000) {
            returnValue = "; Ppu Control";
        }
        if (value == 0x2001) {
            returnValue = "; Ppu Mask";
        }
        if (value == 0x2002) {
            returnValue = "; Ppu Status";
        }
        if (value == 0x2003) {
            returnValue = "; OAM Address";
        }
        if (value == 0x2004) {
            returnValue = "; OAM Data";
        }
        if (value == 0x2005) {
            returnValue = "; Ppu Scroll";
        }
        if (value == 0x2006) {
            returnValue = "; Ppu R/W Address";
        }
        if (value == 0x2007) {
            returnValue = "; Ppu R/W Data";
        }
        if (value == 0x4000) {
            returnValue = "; APU Ch. 1 (Rec) Vol/Decay";
        }
        if (value == 0x4001) {
            returnValue = "; APU Ch. 1 (Rec) Sweep";
        }
        if (value == 0x4002) {
            returnValue = "; APU Ch. 1 (Rec) Frequency";
        }
        if (value == 0x4003) {
            returnValue = "; APU Ch. 1 (Rec) Length";
        }
        if (value == 0x4004) {
            returnValue = "; APU Ch. 2 (Rec) Vol/Decay";
        }
        if (value == 0x4005) {
            returnValue = "; APU Ch. 2 (Rec) Sweep";
        }
        if (value == 0x4006) {
            returnValue = "; APU Ch. 2 (Rec) Frequency";
        }
        if (value == 0x4007) {
            returnValue = "; APU Ch. 2 (Rec) Length";
        }
        if (value == 0x4008) {
            returnValue = "; APU Ch. 3 (Tri) Linear Count.";
        }
        if (value == 0x4009) {
            returnValue = "; APU Ch. 3 (Tri) N/A";
        }
        if (value == 0x400A) {
            returnValue = "; APU Channel 3 (Tri) Frequency";
        }
        if (value == 0x400B) {
            returnValue = "; APU Ch. 3 (Tri) Length";
        }
        if (value == 0x400C) {
            returnValue = "; APU Ch. 4 (Noise) Volume/Decay";
        }
        if (value == 0x400D) {
            returnValue = "; APU Ch. 4 (Noise) N/A";
        }
        if (value == 0x400E) {
            returnValue = "; APU Ch. 4 (Noise) Frequency";
        }
        if (value == 0x400F) {
            returnValue = "; APU Ch. 4 (Noise) Length";
        }
        if (value == 0x4010) {
            returnValue = "; APU Ch. 5 (DMC) Play DMA freq.";
        }
        if (value == 0x4011) {
            returnValue = "; APU Ch. 5 (DMC) Delta";
        }
        if (value == 0x4012) {
            returnValue = "; APU Ch. 5 (DMC) Address";
        }
        if (value == 0x4013) {
            returnValue = "; APU Ch. 5 (DMC) Length";
        }
        if (value == 0x4014) {
            returnValue = "; SPR-RAM DMA";
        }
        if (value == 0x4015) {
            returnValue = "; DMC/IRQ/length";
        }
        if (value == 0x4016) {
            returnValue = "; Joypad #1";
        }
        if (value == 0x4017) {
            returnValue = "; Joypad #2/APU SOFTCLK";
        }
        return returnValue;
    }
}
