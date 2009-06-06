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

import java.util.Iterator;
import java.util.List;
import jnesbr.video.sprite.Sprite;

/**
 * @author dreampeppers99
 */
public class RenderScanline implements Scanline {

    private Ppu2C02 ppu;
    private List<Sprite> behindSprites;
    private List<Sprite> frontSprites;
    private Frame frameManager;

    public RenderScanline(Ppu2C02 ppu,Frame frame) {
        this.ppu = ppu;
        this.frameManager = frame;
    }

    public void scanline() {
        // 0-239 - Rendering Scanline
        applyColourIntensisty();
        behindSprites = ppu.sprRAM.spriteEvaluation(ppu.actualScanLine, Sprite.BEHIND);
        frontSprites = ppu.sprRAM.spriteEvaluation(ppu.actualScanLine, Sprite.FRONT);

        if (behindSprites.size() + frontSprites.size() > 8){
            ppu.ppuStatus.moreThan8ObjectsOnScanLine = 1;
        }

        if (ppu.ppuMask.spriteRenderingEnable == 1) {
            render(behindSprites.iterator());
        }

        if (ppu.ppuMask.backgroundRenderingEnable == 1) {
            renderBackground();
        }

        if (ppu.ppuMask.spriteRenderingEnable == 1) {
            render(frontSprites.iterator());
        }
        ppu.actualScanLine++;
    }

    private final void applyColourIntensisty() {
        if(ppu.ppuMask.intensifyBlues==1){
        }
        if(ppu.ppuMask.intensifyGreens==1){
        }
        if(ppu.ppuMask.intensifyReds==1){
        }
    }

    private void render(final Iterator<Sprite> iterator) {
        while(iterator.hasNext()){
            Sprite sprite = iterator.next();
            if (sprite.index==0){
                
            }
        }
    }

    private final void renderBackground() {
        for (int actualTile = 0; actualTile < 32; actualTile++) {
            //1. Name table byte
            //2. Attribute table byte
            //3. Pattern table bitmap #0
            //4. Pattern table bitmap #1
        }
    }
}
