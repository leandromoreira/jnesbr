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
public class RenderScanline implements Scanline {

    private Ppu2C02 ppu;

    public RenderScanline(Ppu2C02 ppu) {
        this.ppu = ppu;
    }

    public void scanline() {
        // 0-239 - Rendering Scanline
        if (ppu.ppuMask.backgroundRenderingEnable == 1) {
            renderBackground();
        }
        if (ppu.ppuMask.spriteRenderingEnable == 1) {
            renderSprite();
        }
        ppu.actualScanLine++;
    }

    private final void renderBackground() {
        for (int actualTile = 0; actualTile < 32; actualTile++) {
            //1. Name table byte
            //2. Attribute table byte
            //3. Pattern table bitmap #0
            //4. Pattern table bitmap #1
        }
    }

    private final void renderSprite() {
        for (int actualSprite = 0; actualSprite < 64; actualSprite++) {
        }
    }
}
