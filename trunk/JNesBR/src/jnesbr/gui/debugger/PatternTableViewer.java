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

        jBtnShowPT.setText("Show Pattern Table");
        jBtnShowPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnShowPTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPnPatternTables, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(jBtnShowPT)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPnPatternTables, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnShowPT)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    }//GEN-LAST:event_formWindowOpened

    private void jBtnShowPTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnShowPTActionPerformed
        Map<Integer, int[][]> patternTable = Emulator.getInstance().getPPU().getPatternTable();


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
            if (z==254){
                indexY += 9 * 2 * 4;
            }
        }
}//GEN-LAST:event_jBtnShowPTActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PatternTableViewer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnShowPT;
    private javax.swing.JPanel jPnPatternTables;
    // End of variables declaration//GEN-END:variables
}
