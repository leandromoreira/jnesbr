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

import javax.swing.table.DefaultTableModel;
import jnesbr.util.JNesUtil;
import jnesbr.video.PPUControll;
import jnesbr.video.Ppu2C02;
import jnesbr.video.sprite.Sprite;
import jnesbr.video.sprite.SpriteRAM;

/**
 * @author dreampeppers99
 */
public class OAMWindow extends javax.swing.JFrame {

    public OAMWindow() {
        initComponents();
    }
    private int row = 0;

    private void add(String yCoordinate, String tileNumber, String attributes,String xCoordinate) {
        int colIndex = 0;
        jTableOAM.setValueAt(yCoordinate, row, colIndex++);
        jTableOAM.setValueAt(tileNumber, row, colIndex++);
        jTableOAM.setValueAt(attributes, row, colIndex++);
        jTableOAM.setValueAt(xCoordinate, row, colIndex++);
        row++;
    }

    private void fillOAMTable() {
        SpriteRAM sprRAM = SpriteRAM.getInstance();
        int oamIndex = 0;
        for (int i = 0 ; i < 64 ; i++ ){
            Sprite spr = SpriteRAM.getInstance().getSprite(i);
            String yCoordinate = "";
            String tileNumber = "";
            String attributes = "";
            String xCoordinate = "";
            
            yCoordinate = String.valueOf(spr.yCoordinate);
            if(Integer.valueOf(yCoordinate)>=0xEF && Integer.valueOf(yCoordinate)<=0xFF){
                yCoordinate += " hidden";
            }

            if (Ppu2C02.getInstance().ppuControl.spriteSize==PPUControll.SPRITE8x8){
                tileNumber = "| "+JNesUtil.giveMeHexaStringFormattedWith2Space(spr.tileNumer0);
                String address = (Ppu2C02.getInstance().ppuControl.patternTableAddressSprites == PPUControll.VRAM0x0000)?"0000" : "1000";
                tileNumber += " | Pattern="+address;
            }else{
                tileNumber = "| "+JNesUtil.giveMeHexaStringFormattedWith2Space(spr.tileNumer0);
                tileNumber += " | " + JNesUtil.giveMeHexaStringFormattedWith2Space(spr.tileNumer1);
                String address = ((spr.patternTable) == 0)?"0000" : "1000";
                tileNumber += " | Pattern="+address;
            }
            String verticalFlip = (spr.verticalFlip==0)?"Normal":"Mirror";
            String horizontalFlip = (spr.horizontalFlip==0)?"Normal":"Mirror";
            String backgroundPriority = (spr.backgroundPriority==0)?"Front":"Behind";
            String spritePalette = JNesUtil.giveMeBinaryStringFormattedWith2Space(spr.paletteUpperBitsColor);
            attributes = "Vertical flip="+verticalFlip
                    +", Horizontal flip="+horizontalFlip
                    +", Background prior="+backgroundPriority
                    +", Palette color="+spritePalette;

            xCoordinate = String.valueOf(spr.xCoordinate);
            add(yCoordinate, tileNumber, attributes, xCoordinate);
            oamIndex += 4;
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableOAM = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("OAM - Sprite RAM");
        setLocationByPlatform(true);
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTableOAM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Y Coordinate Minus 1", "Tile Number", "Attributes", "X Coordinate"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableOAM.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(jTableOAM);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 901, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jTableOAM.setModel(new DefaultTableModel(new String[]{"Y Coordinate", "Tile Number", "Attributes","X Coordinate"}, 64));
        jTableOAM.getColumnModel().getColumn(0).setResizable(false);
        jTableOAM.getColumnModel().getColumn(0).setMaxWidth(80);
        jTableOAM.getColumnModel().getColumn(1).setResizable(false);
        jTableOAM.getColumnModel().getColumn(1).setMaxWidth(200);
        jTableOAM.getColumnModel().getColumn(2).setResizable(false);
        jTableOAM.getColumnModel().getColumn(2).setMaxWidth(520);
        jTableOAM.getColumnModel().getColumn(3).setResizable(false);
        jTableOAM.getColumnModel().getColumn(3).setMaxWidth(80);
        fillOAMTable();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
    }//GEN-LAST:event_formWindowGainedFocus

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new OAMWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableOAM;
    // End of variables declaration//GEN-END:variables
}
