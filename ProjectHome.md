# JnesBR Another-Yet-NES-Emulator-Debugger #
Another project about coding a NES (Famicom) emulator. This project have been developed using Java as language. A debug system is one of goals from this project too.
The PPU documentation (still WIP) http://docs.google.com/Doc?id=dgkczz7v_8cwncmfcn .

**News**

  1. You can check it out the earlier screenshots http://code.google.com/p/jnesbr/wiki/screenshots

# Curiosity #
With the smartest title **OO - The other end of the spectrum** you can read some opinions at address http://forums.thedailywtf.com/forums/p/11143/193235.aspx and see what they think of my project.

# Links #
  * http://nesdev.parodius.com
  * http://code.google.com/p/jnesbr
  * http://en.wikipedia.org/wiki/Picture_processing_unit
  * http://bobrost.com/nes/lectures/
  * http://www.qmtpro.com/~nes/
  * http://mdb.classicgaming.gamespy.com/m1/lvldata.htm
  * http://emutalk.net/
  * http://forums.ngemu.com/
  * http://nocash.emubase.de/everynes.htm
  * http://nesdev.parodius.com/NESDoc.pdf
  * http://www.brgames.org/tutoriais/nesasmbyOdin.pdf (portuguese)
  * http://en.wikibooks.org/wiki/NES_Programming
  * http://nesdev.parodius.com/nesgfx.txt
  * http://nesdev.parodius.com/NES%20emulator%20development%20guide.txt
  * http://nesdev.parodius.com/2C02%20technical%20reference.TXT
  * http://code.google.com/p/juicynes/
  * http://6502.org/
  * http://6502.org/tutorials/compare_instructions.html

# Logging #

**06-14-2009 14:34**
  * Sprite Rendering is almost full implemented, look the http://code.google.com/p/jnesbr/wiki/screenshots

**06-06-2009 14:34**
  * Finally the scrolling was made.
  * Lots of fixes and more refactorings than ever.
  * New nametable debug window, now it shows the tile view.
  * PPU implementation is more mature than ever too.

**05-09-2009 16:10**
  * Finally the nametable mirroring is working.
  * The most silly use for the Command (GoF) pattern on it.

**05-02-2009 16:10**
  * Introduction of jogl rendering way.
  * Scanline main model is on the way.

**04-24-2009 13:58**
  * Major fixes on instructions.
  * Start of redesign of main method of emulator.
  * New colors to $2D and $3D palette index.

**04-12-2009 15:03**
  * The OAM (sprite ram) viewer.
  * Sprite DMA and normal sprite handling.
  * General fixes (absolute indexed store.).
  * Better colors for name table/attribute table.

**04-09-2009 15:03**
  * The palette viewer was implemented.
  * The multi pattern table was implemented. (reading pattern tables from rom too!)
  * The name table was implemented.

**04-05-2009 21:41**
  * All legal opcodes and opcoes were implemented.
  * PPU emulations starts with force.
  * Palette Windows already shows the first drafts.

**04-04-2009 14:34**
  * Almost all opcodes and some illegal opcoes were implemented.

**03-28-2009 16:12**
  * Addition of special comment at IO mapped memory (ppu, apu, joystick).

**03-23-2009 10:36**
  * Refactoring and reviewing all instructions classes.

**03-07-2009 15:34**
  * Unique way to handle memory.
  * Dec and inx instructions, a lot of fix for comparison instruction.
  * Run n steps implemented on debug system.

**02-24-2009 11:25**
  * More refactorings.
  * All branches relatives implemented.
  * Ppu status and more debugger gui for ppu state view.
  * Pallete location on memory map.

**02-16-2009 22:56**
  * Gui icons.
  * Start ppu debug windows.
  * Ppu registers now change the state of ppu.

**02-07-2009 15:01**
  * Pattern Table viewer & Video Memory Viewer.

**01-30-2009 23:20**
  * Simpler and functional debugger.
  * Memory viewer now is working.
  * More instructions implemented (btw the addressing modes too).
  * General fixes, around wraparound, endianess, signed byte ...

**01-25-2009 21:30**
  * Rom reader , shows the header of iNes rom.
  * Memory viewer is visible and seems to works (at least with no mapper games).
  * Some few (around three) insctructions was implemented.
  * The base architecture is already done.
  * The initial debug system was started.