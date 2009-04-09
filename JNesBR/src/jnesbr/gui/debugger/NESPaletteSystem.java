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
import jnesbr.util.JNesUtil;
import jnesbr.video.color.NesPalette;

/**
 *
 * @author Leandro
 */
public class NESPaletteSystem extends javax.swing.JFrame {

    /** Creates new form NESPaletteSystem */
    public NESPaletteSystem() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPnNesPalette = new javax.swing.JPanel();
        jBtnRefreshPalette = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("NES Palette");
        setLocationByPlatform(true);
        setResizable(false);

        jPnNesPalette.setBackground(new java.awt.Color(255, 255, 255));
        jPnNesPalette.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPnNesPaletteLayout = new javax.swing.GroupLayout(jPnNesPalette);
        jPnNesPalette.setLayout(jPnNesPaletteLayout);
        jPnNesPaletteLayout.setHorizontalGroup(
            jPnNesPaletteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 495, Short.MAX_VALUE)
        );
        jPnNesPaletteLayout.setVerticalGroup(
            jPnNesPaletteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 142, Short.MAX_VALUE)
        );

        jBtnRefreshPalette.setText("Refresh Palette");
        jBtnRefreshPalette.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRefreshPaletteActionPerformed(evt);
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
                        .addComponent(jPnNesPalette, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(jBtnRefreshPalette)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPnNesPalette, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnRefreshPalette)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnRefreshPaletteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRefreshPaletteActionPerformed
        Graphics graphics2D = jPnNesPalette.getGraphics();
        int rectangleSize = 30;
        int x = 3, y = 3;
        for (int i = 0; i < 64; i++) {
            graphics2D.setColor(Color.BLACK);
            graphics2D.drawRect(x, y, rectangleSize, rectangleSize);
            graphics2D.setColor(NesPalette.getColor(i));
            graphics2D.fillRect(x, y, rectangleSize, rectangleSize);

            String index = JNesUtil.giveMeHexaStringFormattedWith2Space(i);
            if (index.contains("D") || index.contains("E") || index.contains("F") || (Integer.valueOf(index,16)<=0x1C)) {
                graphics2D.setColor(Color.WHITE);
            } else {
                graphics2D.setColor(Color.BLACK);
            }
            graphics2D.drawString(index, x+7, y+18);

            if (i <= 15) {
                if (i == 15) {
                    x = 3;
                    y += 32;
                } else {
                    x += rectangleSize + 1;
                }
            } else if (i <= 31) {
                if (i == 31) {
                    x = 3;
                    y += 32;
                } else {
                    x += rectangleSize + 1;
                }

            } else if (i <= 47) {
                if (i == 47) {
                    x = 3;
                    y += 32;
                } else {
                    x += rectangleSize + 1;
                }
            } else {
                x += rectangleSize + 1;
            }
        }
    }//GEN-LAST:event_jBtnRefreshPaletteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new NESPaletteSystem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnRefreshPalette;
    private javax.swing.JPanel jPnNesPalette;
    // End of variables declaration//GEN-END:variables
}
