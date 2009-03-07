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

import jnesbr.debugger.MemoryViewerBuilder;
import jnesbr.video.memory.VideoMemoryMap;

/**
 * @author dreampeppers99
 */
public class MemoryVideoView extends javax.swing.JFrame {

    public MemoryVideoView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTMemory = new javax.swing.JTable();
        jBtnGo = new javax.swing.JButton();
        jCboMap = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Memory Video Viewer");
        setLocationByPlatform(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTMemory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTMemory.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(jTMemory);

        jBtnGo.setText("Refresh");
        jBtnGo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGoActionPerformed(evt);
            }
        });

        jCboMap.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pattern Table 0 (4K) (256 Tiles)", "Pattern Table 1 (4K) (256 Tiles)", "Name Table 0 and Attribute Table 0 (1K) (32x30 BG Map)", "Name Table 1 and Attribute Table 1 (1K) (32x30 BG Map)", "Name Table 2 and Attribute Table 2 (1K) (32x30 BG Map)", "Name Table 3 and Attribute Table 3 (1K) (32x30 BG Map)", "Mirror of 2000h-2EFFh", "Background and Sprite Palettes (25 entries used)", "Mirrors of 3F00h-3F1Fh" }));
        jCboMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCboMapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jCboMap, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnGo))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnGo)
                    .addComponent(jCboMap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnGoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGoActionPerformed
        String userChoose = jCboMap.getSelectedItem().toString();

        if (userChoose.equals("Pattern Table 0 (4K) (256 Tiles)")){
            jTMemory.setModel(MemoryViewerBuilder.getMemoryVideoModel(jTMemory , VideoMemoryMap.PATTERN_TABLE_0_START,VideoMemoryMap.PATTERN_TABLE_0_END));
            return;
        }
        if (userChoose.equals("Pattern Table 1 (4K) (256 Tiles)")){
            jTMemory.setModel(MemoryViewerBuilder.getMemoryVideoModel(jTMemory,VideoMemoryMap.PATTERN_TABLE_1_START,VideoMemoryMap.PATTERN_TABLE_1_END));
            return;
        }
        if (userChoose.equals("Name Table 0 and Attribute Table 0 (1K) (32x30 BG Map)")){
            jTMemory.setModel(MemoryViewerBuilder.getMemoryVideoModel(jTMemory,VideoMemoryMap.NAME_TABLE_0_START,VideoMemoryMap.NAME_TABLE_0_END));
            return;
        }
        if (userChoose.equals("Name Table 1 and Attribute Table 1 (1K) (32x30 BG Map)")){
            jTMemory.setModel(MemoryViewerBuilder.getMemoryVideoModel(jTMemory,VideoMemoryMap.NAME_TABLE_1_START,VideoMemoryMap.NAME_TABLE_1_END));
            return;
        }
        if (userChoose.equals("Name Table 2 and Attribute Table 2 (1K) (32x30 BG Map)")){
            jTMemory.setModel(MemoryViewerBuilder.getMemoryVideoModel(jTMemory,VideoMemoryMap.NAME_TABLE_2_START,VideoMemoryMap.NAME_TABLE_2_END));
            return;
        }

        if (userChoose.equals("Name Table 3 and Attribute Table 3 (1K) (32x30 BG Map)")){
            jTMemory.setModel(MemoryViewerBuilder.getMemoryVideoModel(jTMemory,VideoMemoryMap.NAME_TABLE_3_START,VideoMemoryMap.NAME_TABLE_3_END));
            return;
        }
        if (userChoose.equals("Mirror of 2000h-2EFFh")){
            jTMemory.setModel(MemoryViewerBuilder.getMemoryVideoModel(jTMemory,VideoMemoryMap.MIRROR0_START,VideoMemoryMap.MIRROR0_END));
            return;
        }
        if (userChoose.equals("Background and Sprite Palettes (25 entries used)")){
            jTMemory.setModel(MemoryViewerBuilder.getMemoryVideoModel(jTMemory,VideoMemoryMap.BG_SPR_PALLETE_START,VideoMemoryMap.BG_SPR_PALLETE_END));
            return;
        }

        if (userChoose.equals("Mirrors of 3F00h-3F1Fh")){
            jTMemory.setModel(MemoryViewerBuilder.getMemoryVideoModel(jTMemory,VideoMemoryMap.MIRROR1_START,VideoMemoryMap.MIRROR1_END));
            return;
        }
}//GEN-LAST:event_jBtnGoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jTMemory.setModel(MemoryViewerBuilder.getMemoryVideoModel(jTMemory,VideoMemoryMap.PATTERN_TABLE_0_START,VideoMemoryMap.PATTERN_TABLE_1_END));
    }//GEN-LAST:event_formWindowOpened

    private void jCboMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCboMapActionPerformed
    }//GEN-LAST:event_jCboMapActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MemoryView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnGo;
    private javax.swing.JComboBox jCboMap;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTMemory;
    // End of variables declaration//GEN-END:variables
}
