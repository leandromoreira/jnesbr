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

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;
import jnesbr.util.JNesUtil;
import jnesbr.video.Ppu2C02;
import jnesbr.video.memory.VideoMemory;
import jnesbr.video.memory.VideoMemoryMap;

/**
 *
 * @author Leandro
 */
public class NameTableWindow extends javax.swing.JFrame {

    private int rectangleSize = 15;
    private int initialX = 45;
    private int initialY = 32;
    private int pixelSize = 2;
    private int rectangleSizeTile = 8;
    private static Map<Integer, Color> colors = new HashMap<Integer, Color>();


    static {
        colors.put(0, Color.WHITE);
        colors.put(1, Color.RED);
        colors.put(2, Color.GREEN);
        colors.put(3, Color.BLUE);
    }

    /** Creates new form NameTableWindow */
    public NameTableWindow() {
        initComponents();
    }

    private void buildNameTable(int initialAddress) {
        int x = initialX;
        int y = initialY;
        Graphics grap = jPnNameTable.getGraphics();
        grap.setColor(Color.WHITE);
        grap.fillRect(0, 0, 800, 800);
        for (int line = 0; line < 30; line++) {
            for (int col = 0; col < 32; col++) {
                grap.setColor(Color.BLACK);
                grap.drawRect(x, y, rectangleSize, rectangleSize);
                grap.setColor(Color.orange);
                grap.fillRect(x, y, rectangleSize, rectangleSize);
                grap.setColor(Color.RED);
                short value = VideoMemory.getMemory().read(initialAddress++);
                grap.drawString(JNesUtil.giveMeHexaStringFormattedWith2Space(value), x, y + 12);
                x += rectangleSize + 1;
            }
            y += rectangleSize + 1;
            x = initialX;
        }
    }

    private void buildAttributeTable(int initialAddress) {
        int x = initialX;
        int y = initialY;
        int[] upperBitsColor = new int[1024];
        int initIndex = 0;
        Graphics grap = jPnNameTable.getGraphics();
        grap.setColor(Color.WHITE);
        grap.fillRect(0, 0, 800, 800);
        fillUpperBitColorMatrix(initialAddress, upperBitsColor);
        for (int line = 0; line < 30; line++) {
            for (int col = 0; col < 32; col++) {
                grap.setColor(Color.BLACK);
                grap.drawRect(x, y, rectangleSize, rectangleSize);
                grap.setColor(Color.orange);
                grap.fillRect(x, y, rectangleSize, rectangleSize);
                grap.setColor(Color.RED);
                grap.drawString(JNesUtil.giveMeBinaryStringFormattedWith2Space(upperBitsColor[initIndex++]), x, y + 12);
                x += rectangleSize + 1;
            }
            y += rectangleSize + 1;
            x = initialX;
        }
    }
    private int address;

    private void buildNameTableByTile(int initialAddress) {
        address = initialAddress;
        new Thread(new Runnable() {

            public void run() {
                int mineInitilaX = initialX + 100;
                int mineInitilaY = initialY + 100;
                int x = mineInitilaX;
                int y = mineInitilaY;
                Graphics grap = jPnNameTable.getGraphics();
                grap.setColor(Color.WHITE);
                grap.fillRect(0, 0, 600, 600);
                int nametableForBackGround = Ppu2C02.getInstance().ppuControl.patternTableAddressBackground;

                grap.setColor(Color.BLACK);
                grap.drawRect(x - 1, y - 1, 289, 271);

                for (int line = 0; line < 30; line++) {
                    for (int col = 0; col < 32; col++) {
                        short value = VideoMemory.getMemory().read(address++);
                        int[][] tile = Ppu2C02.getInstance().getTile(nametableForBackGround, value);
                        for (byte rowPosition = 0; rowPosition < 8; rowPosition++) {
                            int stepX = 0;
                            for (byte collumn = 7; collumn >= 0; collumn--) {
                                grap.setColor(colors.get(tile[rowPosition][collumn]));
                                grap.fillRect(stepX + x, rowPosition + y, pixelSize, pixelSize);
                                stepX++;
                            }
                        }
                        x += rectangleSizeTile + 1;
                    }
                    y += rectangleSizeTile + 1;
                    x = mineInitilaX;
                }
            }
        }).start();
    }

    private void fillUpperBitColorMatrix(int initialAddress, int[] upperBitsColor) {
        int initIndex = 0;
        for (int att = 0; att < 64; att++) {
            short value = VideoMemory.getMemory().read(initialAddress + att);
            //first 2 upper bits
            upperBitsColor[initIndex] = (value & 0x3);
            upperBitsColor[initIndex + 1] = (value & 0x3);
            upperBitsColor[initIndex + 32] = (value & 0x3);
            upperBitsColor[initIndex + 33] = (value & 0x3);
            //second 2 upper bits
            upperBitsColor[initIndex + 2] = ((value >> 2) & 0x3);
            upperBitsColor[initIndex + 3] = ((value >> 2) & 0x3);
            upperBitsColor[initIndex + 34] = ((value >> 2) & 0x3);
            upperBitsColor[initIndex + 35] = ((value >> 2) & 0x3);
            //third 2 upper bits
            upperBitsColor[initIndex + 64] = ((value >> 4) & 0x3);
            upperBitsColor[initIndex + 65] = ((value >> 4) & 0x3);
            upperBitsColor[initIndex + 96] = ((value >> 4) & 0x3);
            upperBitsColor[initIndex + 97] = ((value >> 4) & 0x3);
            //fourth 2 upper bits
            upperBitsColor[initIndex + 66] = ((value >> 6) & 0x3);
            upperBitsColor[initIndex + 67] = ((value >> 6) & 0x3);
            upperBitsColor[initIndex + 98] = ((value >> 6) & 0x3);
            upperBitsColor[initIndex + 99] = ((value >> 6) & 0x3);

            initIndex += 4;
            if (initIndex == 32) {
                initIndex = 128;
            }
            if (initIndex == 160) {
                initIndex = 256;
            }
            if (initIndex == 288) {
                initIndex = 384;
            }
            if (initIndex == 416) {
                initIndex = 512;
            }
            if (initIndex == 544) {
                initIndex = 640;
            }
            if (initIndex == 672) {
                initIndex = 768;
            }
            if (initIndex == 800) {
                initIndex = 896;
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnShwName0 = new javax.swing.JButton();
        jBtnShwName1 = new javax.swing.JButton();
        jBtnShwName2 = new javax.swing.JButton();
        jBtnShwName3 = new javax.swing.JButton();
        jPnNameTable = new javax.swing.JPanel();
        jBtnShwAttr0 = new javax.swing.JButton();
        jBtnShwAttr1 = new javax.swing.JButton();
        jBtnShwAttr2 = new javax.swing.JButton();
        jBtnShwAttr3 = new javax.swing.JButton();
        jBtnShowTile0 = new javax.swing.JButton();
        jBtnShowTile1 = new javax.swing.JButton();
        jBtnShowTile2 = new javax.swing.JButton();
        jBtnShowTile3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Name Table Viewer");
        setLocationByPlatform(true);
        setResizable(false);

        jBtnShwName0.setText("Show Name Table 0");
        jBtnShwName0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnShwName0ActionPerformed(evt);
            }
        });

        jBtnShwName1.setText("Show Name Table 1");
        jBtnShwName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnShwName1ActionPerformed(evt);
            }
        });

        jBtnShwName2.setText("Show Name Table 2");
        jBtnShwName2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnShwName2ActionPerformed(evt);
            }
        });

        jBtnShwName3.setText("Show Name Table 3");
        jBtnShwName3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnShwName3ActionPerformed(evt);
            }
        });

        jPnNameTable.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPnNameTableLayout = new javax.swing.GroupLayout(jPnNameTable);
        jPnNameTable.setLayout(jPnNameTableLayout);
        jPnNameTableLayout.setHorizontalGroup(
            jPnNameTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
        );
        jPnNameTableLayout.setVerticalGroup(
            jPnNameTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        jBtnShwAttr0.setText("Show Attr Table 0");
        jBtnShwAttr0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnShwAttr0ActionPerformed(evt);
            }
        });

        jBtnShwAttr1.setText("Show Attr Table 1");
        jBtnShwAttr1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnShwAttr1ActionPerformed(evt);
            }
        });

        jBtnShwAttr2.setText("Show Attr Table 2");
        jBtnShwAttr2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnShwAttr2ActionPerformed(evt);
            }
        });

        jBtnShwAttr3.setText("Show Attr Table 3");
        jBtnShwAttr3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnShwAttr3ActionPerformed(evt);
            }
        });

        jBtnShowTile0.setText("Tile");
        jBtnShowTile0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnShowTile0ActionPerformed(evt);
            }
        });

        jBtnShowTile1.setText("Tile");
        jBtnShowTile1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnShowTile1ActionPerformed(evt);
            }
        });

        jBtnShowTile2.setText("Tile");
        jBtnShowTile2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnShowTile2ActionPerformed(evt);
            }
        });

        jBtnShowTile3.setText("Tile");
        jBtnShowTile3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnShowTile3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPnNameTable, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jBtnShowTile0, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnShwAttr0, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnShwName0, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBtnShowTile1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnShwAttr1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnShwName1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBtnShowTile2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnShwAttr2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnShwName2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtnShowTile3, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                            .addComponent(jBtnShwAttr3, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                            .addComponent(jBtnShwName3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPnNameTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnShwName0)
                    .addComponent(jBtnShwName1)
                    .addComponent(jBtnShwName2)
                    .addComponent(jBtnShwName3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnShwAttr0)
                    .addComponent(jBtnShwAttr1)
                    .addComponent(jBtnShwAttr2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnShwAttr3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnShowTile0)
                    .addComponent(jBtnShowTile1)
                    .addComponent(jBtnShowTile2)
                    .addComponent(jBtnShowTile3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnShwName0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnShwName0ActionPerformed
        buildNameTable(VideoMemoryMap.NAME_TABLE_0_START);
    }//GEN-LAST:event_jBtnShwName0ActionPerformed

    private void jBtnShwName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnShwName1ActionPerformed
        buildNameTable(VideoMemoryMap.NAME_TABLE_1_START);
    }//GEN-LAST:event_jBtnShwName1ActionPerformed

    private void jBtnShwName2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnShwName2ActionPerformed
        buildNameTable(VideoMemoryMap.NAME_TABLE_2_START);
    }//GEN-LAST:event_jBtnShwName2ActionPerformed

    private void jBtnShwName3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnShwName3ActionPerformed
        buildNameTable(VideoMemoryMap.NAME_TABLE_3_START);
    }//GEN-LAST:event_jBtnShwName3ActionPerformed

    private void jBtnShwAttr0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnShwAttr0ActionPerformed
        buildAttributeTable(VideoMemoryMap.ATTR_TABLE_0_START);
}//GEN-LAST:event_jBtnShwAttr0ActionPerformed

    private void jBtnShwAttr1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnShwAttr1ActionPerformed
        buildAttributeTable(VideoMemoryMap.ATTR_TABLE_1_START);
}//GEN-LAST:event_jBtnShwAttr1ActionPerformed

    private void jBtnShwAttr2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnShwAttr2ActionPerformed
        buildAttributeTable(VideoMemoryMap.ATTR_TABLE_2_START);
}//GEN-LAST:event_jBtnShwAttr2ActionPerformed

    private void jBtnShwAttr3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnShwAttr3ActionPerformed
        buildAttributeTable(VideoMemoryMap.ATTR_TABLE_3_START);
}//GEN-LAST:event_jBtnShwAttr3ActionPerformed

    private void jBtnShowTile0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnShowTile0ActionPerformed
        buildNameTableByTile(VideoMemoryMap.NAME_TABLE_0_START);
    }//GEN-LAST:event_jBtnShowTile0ActionPerformed

    private void jBtnShowTile1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnShowTile1ActionPerformed
        buildNameTableByTile(VideoMemoryMap.NAME_TABLE_1_START);
    }//GEN-LAST:event_jBtnShowTile1ActionPerformed

    private void jBtnShowTile2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnShowTile2ActionPerformed
        buildNameTableByTile(VideoMemoryMap.NAME_TABLE_2_START);
    }//GEN-LAST:event_jBtnShowTile2ActionPerformed

    private void jBtnShowTile3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnShowTile3ActionPerformed
        buildNameTableByTile(VideoMemoryMap.NAME_TABLE_3_START);
    }//GEN-LAST:event_jBtnShowTile3ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new NameTableWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnShowTile0;
    private javax.swing.JButton jBtnShowTile1;
    private javax.swing.JButton jBtnShowTile2;
    private javax.swing.JButton jBtnShowTile3;
    private javax.swing.JButton jBtnShwAttr0;
    private javax.swing.JButton jBtnShwAttr1;
    private javax.swing.JButton jBtnShwAttr2;
    private javax.swing.JButton jBtnShwAttr3;
    private javax.swing.JButton jBtnShwName0;
    private javax.swing.JButton jBtnShwName1;
    private javax.swing.JButton jBtnShwName2;
    private javax.swing.JButton jBtnShwName3;
    private javax.swing.JPanel jPnNameTable;
    // End of variables declaration//GEN-END:variables
}
