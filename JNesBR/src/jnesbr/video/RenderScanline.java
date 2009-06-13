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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jnesbr.video.sprite.Sprite;

/**
 * @author dreampeppers99
 */
public final class RenderScanline implements Scanline {

    private Ppu2C02 ppu;
    private List<Sprite> behindSprites;
    private List<Sprite> frontSprites;
    private Frame frameManager;
    private boolean settedTileYFrom2006;
    private int colourIntensity = 0;
    private int y,  spriteCount;

    public RenderScanline(Ppu2C02 ppu, Frame frame) {
        this.ppu = ppu;
        this.frameManager = frame;
        behindSprites = new ArrayList<Sprite>();
        frontSprites = new ArrayList<Sprite>();
    }

    public final void scanline() {
        if (ppu.actualScanLine == 0) {
            frameManager.resetLayers();
        }
        applyColourIntensisty();
        spriteEvaluation();
        renderLayer0(behindSprites.iterator());
        renderLayer1();
        renderLayer2(frontSprites.iterator());
        ppu.actualScanLine++;
    }

    private final void applyColourIntensisty() {
        colourIntensity = (ppu.ppuMask.intensifyReds << 2) |
                (ppu.ppuMask.intensifyGreens << 1) |
                (ppu.ppuMask.intensifyBlues);
        switch (colourIntensity) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
        }
    }
    private Sprite sprite1;

    private final void renderLayer0(final Iterator<Sprite> iterator) {
        if (ppu.ppuMask.spriteRenderingEnable == 1) {
            while (iterator.hasNext()) {
                sprite1 = iterator.next();
                if (sprite1.index == 0) {
                }
            }

        }
    }
    private Sprite sprite2;

    private final void renderLayer2(final Iterator<Sprite> iterator) {
        if (ppu.ppuMask.spriteRenderingEnable == 1) {
            while (iterator.hasNext()) {
                sprite2 = iterator.next();
                if (sprite2.index == 0) {
                }
            }
        }
    }

    private final void renderLayer1() {
        if (ppu.ppuMask.backgroundRenderingEnable == 0) {
            return;
        }
        for (int actualTile = 0; actualTile < 32; actualTile++) {
            //1. Name table byte
            //2. Attribute table byte
            //3. Pattern table bitmap #0
            //4. Pattern table bitmap #1
            while (ppu.scrolling.fineX < 8) {
                ppu.scrolling.fineX++;
            }
            ppu.scrolling.fineX &= 7;
            ppu.scrolling.tileX++;
            if (ppu.scrolling.tileX > 31) {
                ppu.scrolling.tileX &= 31;
                ppu.scrolling.temp[10] = ~ppu.scrolling.temp[10] & 1;
            }
        }

        ppu.scrolling.fineY++;
        settedTileYFrom2006 = (ppu.scrolling.tileY > 29);
        if (ppu.scrolling.fineY > 7) {
            ppu.scrolling.fineY &= 7;
            ppu.scrolling.tileY++;
        }

        if (ppu.scrolling.tileY > 29 && !settedTileYFrom2006) {
            ppu.scrolling.tileY &= 29;
            ppu.scrolling.temp[11] = ~ppu.scrolling.temp[11] & 1;
        }
        if (ppu.scrolling.tileY > 29 && settedTileYFrom2006) {
            ppu.scrolling.tileY &= 31;
        }
    }

    private Sprite actual;
    private final void spriteEvaluation() {
        //TODO: make this to 8x16 size sprite
        y = ppu.actualScanLine;
        spriteCount = 0;
        behindSprites.clear();
        frontSprites.clear();

        for (int n = 0; n < 64; n++) {
            actual = ppu.sprRAM.getSprite(n);
            if (actual.backgroundPriority == Sprite.BEHIND &&
                    (y >= actual.yCoordinate &&
                    y <= (actual.yCoordinate + 7)) &&
                    actual.yCoordinate != -1) {
                if (spriteCount == 8) {
                    ppu.ppuStatus.moreThan8ObjectsOnScanLine = 1;
                    break;
                }
                behindSprites.add(actual);
                spriteCount++;
            }
            if (actual.backgroundPriority == Sprite.FRONT &&
                    (y >= actual.yCoordinate &&
                    y <= (actual.yCoordinate + 7)) &&
                    actual.yCoordinate != -1) {
                if (spriteCount == 8) {
                    ppu.ppuStatus.moreThan8ObjectsOnScanLine = 1;
                    break;
                }
                frontSprites.add(actual);
                spriteCount++;
            }
        /*if (actual.backgroundPriority == situation &&
        y >= actual.yCoordinate && y <= (actual.yCoordinate + 15) {
        list.add(actual);
        }*/
        }
    }
}
