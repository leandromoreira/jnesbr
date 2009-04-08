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
import java.awt.Font;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import jnesbr.core.Emulator;

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPnPatternTables = new javax.swing.JPanel();
        jBtnShowPT = new javax.swing.JButton();
        jBtnShowNext = new javax.swing.JButton();
        jBtnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Table Pattern Viewer");
        setLocationByPlatform(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPnPatternTables.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPnPatternTablesLayout = new javax.swing.GroupLayout(jPnPatternTables);
        jPnPatternTables.setLayout(jPnPatternTablesLayout);
        jPnPatternTablesLayout.setHorizontalGroup(
            jPnPatternTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 707, Short.MAX_VALUE)
        );
        jPnPatternTablesLayout.setVerticalGroup(
            jPnPatternTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 338, Short.MAX_VALUE)
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPnPatternTables, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnShowPT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnShowNext)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnRefresh)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPnPatternTables, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnShowPT)
                    .addComponent(jBtnShowNext)
                    .addComponent(jBtnRefresh))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    }//GEN-LAST:event_formWindowOpened

    private void jBtnShowPTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnShowPTActionPerformed
        Map<Integer, int[][]> actualPatternTable = Emulator.getInstance().getPPU().getPatternTable();


        Graphics scr = jPnPatternTables.getGraphics();
        int indexX = 0, indexY = 0;
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
}//GEN-LAST:event_jBtnShowPTActionPerformed
    private int actualChrPage = 0;
    private int actualChrPageNumber = 0;
    private String status;
    private Map<Integer, int[][]> patternTable;
    private void jBtnShowNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnShowNextActionPerformed

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

        Graphics scr = jPnPatternTables.getGraphics();
        int indexX = 0, indexY = 0;
        for (int z = 0; z < 512; z++) {
            int[][] tile = patternTable.get(z);
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
        scr.setColor(Color.WHITE);
        scr.draw3DRect(500, 330 - 20, 180, 30, true);
        scr.fill3DRect(500, 330 - 20, 180, 30, true);
        scr.setColor(Color.RED);
        scr.drawString(status, 500 + 30, 330);
}//GEN-LAST:event_jBtnShowNextActionPerformed

    private void jBtnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRefreshActionPerformed

        if (patternTable==null){
            jBtnShowNextActionPerformed(null);
        }
        Graphics scr = jPnPatternTables.getGraphics();
        int indexX = 0, indexY = 0;
        for (int z = 0; z < 512; z++) {
            int[][] tile = patternTable.get(z);
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
        scr.setColor(Color.WHITE);
        scr.draw3DRect(500, 330 - 20, 180, 30, true);
        scr.fill3DRect(500, 330 - 20, 180, 30, true);
        scr.setColor(Color.RED);
        scr.drawString(status, 500 + 30, 330);
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
    private javax.swing.JPanel jPnPatternTables;
    // End of variables declaration//GEN-END:variables
}