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
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import jnesbr.core.Emulator;
import jnesbr.util.JNesUtil;

/**
 * @author dreampeppers99
 */
public class PatternTableViewer extends javax.swing.JFrame {

    private static Map<Integer, Color> colors = new HashMap<Integer, Color>();


    static {
        colors.put(0, Color.WHITE);
        colors.put(1, Color.RED);
        colors.put(2, Color.GREEN);
        colors.put(3, Color.BLUE);
    }

    public PatternTableViewer() {
        initComponents();
    }

    /*  private void buildPatternTable(Map<Integer, int[][]> actualPatternTable) {
    Graphics scr = jPnPatternTables.getGraphics();
    int indexX = 0;
    int indexY = 0;
    for (int z = 0; z < 512; z++) {
    int[][] tile = actualPatternTable.get(z);
    int theLastX = indexX;
    for (byte row = 0; row < 8; row++) {
    indexX = theLastX;
    for (byte collumn = 7; collumn >= 0; collumn--, indexX++) {
    scr.setColor(colors.get(tile[row][collumn]));
    scr.fillRect(indexX * 2, indexY + row * 2, 2, 2);
    }
    }
    indexX = theLastX;
    indexX += 9;
    if (z != 0) {
    if (z % 38 == 0) {
    indexX = 0;
    indexY += 9 * 2;
    }
    }
    if (z == 254) {
    indexY += 9 * 2 * 4;
    }
    }
    }
     */
    private void buildPatternTable(Map<Integer, int[][]> actualPatternTable) {
        int rectangleSize = 16, pixelSize = 2;
        int initialX = 5, initialY = 5;
        int x = initialX, y = initialY;
        Graphics grp = jPnPatternTables.getGraphics();
        int count = 0, tileIndex = 0;

        for (int row = 0; row < 16; row++) {
            for (int col = 0; col < 32; col++) {
                grp.setColor(Color.WHITE);
                grp.drawRect(x, y, rectangleSize, rectangleSize);
                grp.setColor(Color.WHITE);
                grp.fillRect(x, y, rectangleSize, rectangleSize);
                int[][] tile = actualPatternTable.get(tileIndex++);
                int theLastY = y;
                for (byte rowPosition = 0; rowPosition < 8; rowPosition++) {
                    int theLastX = x;
                    for (byte collumn = 7; collumn >= 0; collumn--, theLastX++) {
                        grp.setColor(colors.get(tile[rowPosition][collumn]));
                        grp.fillRect(theLastX++, theLastY, pixelSize, pixelSize);
                    }
                    theLastY += pixelSize;
                }
                grp.setColor(Color.WHITE);
                grp.drawString(JNesUtil.giveMeHexaStringFormattedWith2Space(count++), x + 1, y + rectangleSize * 2 - 2);

                count = (count > 0xFF) ? 0 : count;
                x += rectangleSize + 2;
            }
            x = initialX;
            y += rectangleSize * 2 + 1;
        }
        grp.setColor(Color.RED);
        grp.drawLine(0, 268, 587, 268);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPnPatternTables = new javax.swing.JPanel();
        jBtnShowPT = new javax.swing.JButton();
        jBtnShowNext = new javax.swing.JButton();
        jBtnRefresh = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLblPage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Table Pattern Viewer");
        setLocationByPlatform(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPnPatternTables.setBackground(new java.awt.Color(102, 102, 102));
        jPnPatternTables.setPreferredSize(new java.awt.Dimension(587, 538));

        javax.swing.GroupLayout jPnPatternTablesLayout = new javax.swing.GroupLayout(jPnPatternTables);
        jPnPatternTables.setLayout(jPnPatternTablesLayout);
        jPnPatternTablesLayout.setHorizontalGroup(
            jPnPatternTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 587, Short.MAX_VALUE)
        );
        jPnPatternTablesLayout.setVerticalGroup(
            jPnPatternTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 538, Short.MAX_VALUE)
        );

        jBtnShowPT.setText("Show Pattern Table In Memory & Refresh");
        jBtnShowPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnShowPTActionPerformed(evt);
            }
        });

        jBtnShowNext.setText(">> Show Next Table on ROM File");
        jBtnShowNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnShowNextActionPerformed(evt);
            }
        });

        jBtnRefresh.setText("Refresh Pattern on ROM");
        jBtnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRefreshActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setText("PATTERN");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("TABLE 0");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel3.setText("TABLE 1");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel4.setText("PATTERN");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLblPage.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLblPage.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLblPage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPnPatternTables, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLblPage, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jBtnShowPT)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jBtnShowNext)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jBtnRefresh))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(234, 234, 234)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPnPatternTables, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLblPage, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBtnShowPT)
                            .addComponent(jBtnShowNext)
                            .addComponent(jBtnRefresh))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    }//GEN-LAST:event_formWindowOpened

    private void jBtnShowPTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnShowPTActionPerformed
        Map<Integer, int[][]> actualPatternTable = Emulator.getInstance().getPPU().getPatternTable();
        buildPatternTable(actualPatternTable);
}//GEN-LAST:event_jBtnShowPTActionPerformed
    private int actualChrPage = 0;
    private int actualChrPageNumber = 0;
    private String status;
    private Map<Integer, int[][]> patternTable;
    private void jBtnShowNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnShowNextActionPerformed
        jLblPage.setText("");
        if (Emulator.getInstance().rom().CHR_ROMPageCount8K == 0) {
            jLblPage.setText("There no video memory bank on rom file.");
            return;
        }
        int addressInitial = (actualChrPage == 0) ? 0 : actualChrPage * 8 * 1024;
        patternTable = Emulator.getInstance().getPPU().getPatternTable(
                Arrays.copyOfRange(Emulator.getInstance().rom().chr_rom, addressInitial,
                (addressInitial + 8 * 1024)));
        actualChrPage++;
        if (actualChrPage >= Emulator.getInstance().rom().CHR_ROMPageCount8K * 8 * 1024) {
            actualChrPage = 0;
        }
        if (Emulator.getInstance().rom().CHR_ROMPageCount8K == 1) {
            actualChrPage = 0;
        }

        actualChrPageNumber++;
        status = "Page " + actualChrPageNumber + " from " + Emulator.getInstance().rom().CHR_ROMPageCount8K;
        if (actualChrPageNumber == Emulator.getInstance().rom().CHR_ROMPageCount8K) {
            actualChrPage = 0;
            actualChrPageNumber = 0;
        }
        buildPatternTable(patternTable);
        jLblPage.setText(status);
}//GEN-LAST:event_jBtnShowNextActionPerformed

    private void jBtnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRefreshActionPerformed
        jLblPage.setText("");
        if (patternTable == null) {
            jBtnShowNextActionPerformed(null);
            return;
        }
        buildPatternTable(patternTable);
        jLblPage.setText(status);
    }//GEN-LAST:event_jBtnRefreshActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PatternTableViewer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnRefresh;
    private javax.swing.JButton jBtnShowNext;
    private javax.swing.JButton jBtnShowPT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLblPage;
    private javax.swing.JPanel jPnPatternTables;
    // End of variables declaration//GEN-END:variables
}
