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
import java.util.Random;
import jnesbr.processor.memory.Memory;
import jnesbr.video.color.NesPalette;
import jnesbr.video.memory.VideoMemoryMap;
import jnesbr.video.sprite.Sprite;
import static jnesbr.video.util.GraphicHelper.*;

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
        /*if (ppu.actualScanLine == 0) {
        frameManager.resetLayers();
        }*/
        applyColourIntensisty();
        spriteEvaluation();
        renderLayer(0, behindSprites.iterator());
        renderLayer1();
        renderLayer(2, frontSprites.iterator());
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
    private Sprite sprite;
    private int lineToRender;
    private int[][] tile;
    private int colorIndex;

    private final void realSpriteRendering(final int layer) {
        for (int x = 0; x < 8; x++) {
            if (layer == 0) {
                //behind sprites
                frameManager.setPixelLayer0((sprite.paletteUpperBitsColor << 2) | tile[x][lineToRender], sprite.xCoordinate + x, y);
                colorIndex = ppu.vram.readUnhandled(VideoMemoryMap.SPR_PALLETE_START + frameManager.getPixelLayer0At(sprite.xCoordinate + x, y));
            } else {
                //front sprites
                frameManager.setPixelLayer2((sprite.paletteUpperBitsColor << 2) | tile[x][lineToRender], sprite.xCoordinate + x, y);
                colorIndex = ppu.vram.readUnhandled(VideoMemoryMap.SPR_PALLETE_START + frameManager.getPixelLayer2At(sprite.xCoordinate + x, y));
            }
            //just rendering when the colour isn't the transparency one!
            if (colorIndex != ppu.vram.readUnhandled(VideoMemoryMap.SPR_PALLETE_START)) {
                frameManager.setPixel(NesPalette.getRGBAt(colorIndex), sprite.xCoordinate + x, y);
            }
        }
    }

    private final void realSpriteZeroRendering(final int layer) {
        for (int x = 0; x < 8; x++) {
            if (layer == 0) {
                //behind sprites for sprite #0
                frameManager.setPixelLayer0((sprite.paletteUpperBitsColor << 2) | tile[x][lineToRender], sprite.xCoordinate + x, y);
                colorIndex = ppu.vram.readUnhandled(VideoMemoryMap.SPR_PALLETE_START + frameManager.getPixelLayer0At(sprite.xCoordinate + x, y));
            } else {
                //front sprites for sprite #0
                frameManager.setPixelLayer2((sprite.paletteUpperBitsColor << 2) | tile[x][lineToRender], sprite.xCoordinate + x, y);
                colorIndex = ppu.vram.readUnhandled(VideoMemoryMap.SPR_PALLETE_START + frameManager.getPixelLayer2At(sprite.xCoordinate + x, y));
            }
            //just rendering when the colour isn't the transparency one!
            if (colorIndex != ppu.vram.readUnhandled(VideoMemoryMap.SPR_PALLETE_START)) {
                frameManager.setPixel(NesPalette.getRGBAt(colorIndex), sprite.xCoordinate + x, y);
                //The Sprite #0 Detection!
                if (frameManager.getPixelLayer1At(sprite.xCoordinate + x, y) != 0) {
                    ppu.ppuStatus.sprite0Hit = 1;
                }
            }
        }
    }

    private final void renderLayer(final int layer, final Iterator<Sprite> iterator) {
        if (ppu.ppuMask.spriteRenderingEnable == 1) {
            while (iterator.hasNext()) {
                sprite = iterator.next();

                lineToRender = y - sprite.yCoordinate;
                tile = ppu.getTile(sprite.patternTable, sprite.tileNumber0);
                //todo: who cames first? 
                if (sprite.horizontalFlip == 1) {
                    tile = flipHorizontal(tile);
                }
                if (sprite.verticalFlip == 1) {
                    tile = flipVertical(tile);
                }
                if (sprite.index == 0) {
                    realSpriteZeroRendering(layer);
                } else {
                    realSpriteRendering(layer);
                }
            }
        }
    }

    private final void renderLayer1() {
        //1. Name table byte
        //2. Attribute table byte
        //3. Pattern table bitmap #0
        //4. Pattern table bitmap #1

        //just render if it is enable!
        if (ppu.ppuMask.backgroundRenderingEnable != 0) {
            for (int pixel = 0; pixel < 256; pixel++) {

                int[][] bgTile = ppu.getTile(ppu.ppuControl.patternTableAddressBackground,
                        ppu.vram.read(
                        VideoMemoryMap.NAME_TABLE_0_START + (ppu.scrolling.tileY * 31 + ppu.scrolling.tileX)));
                frameManager.setPixelLayer1(bgTile[ppu.scrolling.fineX][ppu.scrolling.fineY], pixel, ppu.actualScanLine);
                colorIndex = ppu.vram.readUnhandled(
                        VideoMemoryMap.BG_PALLETE_START + frameManager.getPixelLayer1At(pixel, ppu.actualScanLine));
                frameManager.setPixel(NesPalette.getRGBAt(colorIndex),
                        pixel, ppu.actualScanLine);
                /*frameManager.setPixel(new float[]{(float)Math.random(),(float)Math.random(),(float)Math.random()},
                pixel, ppu.actualScanLine);*/

                //fine controls what pixel to start to rendering (0-7) from the tile.
                //when it reaches the 7 it will wrap to 0 and increase the tilex!-
                if (ppu.scrolling.fineX == 7) {
                    ppu.scrolling.tileX++;
                    if (ppu.scrolling.tileX > 31) {
                        ppu.scrolling.tileX &= 31;
                        ppu.scrolling.temp[10] = ~ppu.scrolling.temp[10] & 1; //flipping the low nametable bit.
                    }
                }
                //wrapping the finex...
                ppu.scrolling.fineX = (ppu.scrolling.fineX + 1) & 7;
            }
            ppu.scrolling.fineY++; //always after a scanline the finey is increase.
            settedTileYFrom2006 = (ppu.scrolling.tileY > 29);//checking it it was setted by $2006.
            if (ppu.scrolling.fineY > 7) {
                //when finey wraps to 0, the tiley is increased.
                ppu.scrolling.fineY &= 7;
                ppu.scrolling.tileY++;
            }

            if (ppu.scrolling.tileY > 29 && !settedTileYFrom2006) {
                ppu.scrolling.tileY = 0;
                ppu.scrolling.temp[11] = ~ppu.scrolling.temp[11] & 1; //flipping the high nametable bit.
            } else if (ppu.scrolling.tileY > 29 && settedTileYFrom2006) {
                ppu.scrolling.tileY = 0;
            }
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
