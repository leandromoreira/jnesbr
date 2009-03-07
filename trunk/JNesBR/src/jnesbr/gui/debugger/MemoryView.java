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
import jnesbr.processor.memory.MemoryMap;

/**
 * @author dreampeppers99
 */
public class MemoryView extends javax.swing.JFrame {

    public MemoryView() {
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
        setTitle("Memory Viewer");
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

        jCboMap.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "LOWER BANK", "UPPER BANK", "ZERO PAGE", "STACK", "RAM", "MIRROR ZERO PAGE", "MIRROR STACK", "MIRROR RAM", "MIRROR 1 ZERO PAGE", "MIRROR 1 STACK", "MIRROR 1 RAM", "MIRROR 2 ZERO PAGE", "MIRROR 2 STACK", "MIRROR 2 RAM", "IO REGISTERS", "EXPANSION ROM", "SAVE RAM" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jCboMap, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        if (userChoose.equals("LOWER BANK")){
            jTMemory.setModel(MemoryViewerBuilder.getMemoryModel(jTMemory,MemoryMap.LOWER_BANK_START,MemoryMap.LOWER_BANK_END));
            return;
        }
        if (userChoose.equals("UPPER BANK")){
            jTMemory.setModel(MemoryViewerBuilder.getMemoryModel(jTMemory,MemoryMap.UPPER_BANK_START,MemoryMap.UPPER_BANK_END));
            return;
        }
        if (userChoose.equals("ZERO PAGE")){
            jTMemory.setModel(MemoryViewerBuilder.getMemoryModel(jTMemory,MemoryMap.ZERO_PAGE_START,MemoryMap.ZERO_PAGE_END));
            return;
        }
        if (userChoose.equals("STACK")){
            jTMemory.setModel(MemoryViewerBuilder.getMemoryModel(jTMemory,MemoryMap.STACK_START,MemoryMap.STACK_END));
            return;
        }
        if (userChoose.equals("RAM")){
            jTMemory.setModel(MemoryViewerBuilder.getMemoryModel(jTMemory,MemoryMap.RAM_0_START,MemoryMap.RAM_0_END));
            return;
        }

        if (userChoose.equals("MIRROR ZERO PAGE")){
            jTMemory.setModel(MemoryViewerBuilder.getMemoryModel(jTMemory,MemoryMap.MIRROR_0_ZERO_PAGE_START1,MemoryMap.MIRROR_0_ZERO_PAGE_END1));
            return;
        }
        if (userChoose.equals("MIRROR STACK")){
            jTMemory.setModel(MemoryViewerBuilder.getMemoryModel(jTMemory,MemoryMap.MIRROR_0_STACK_START1,MemoryMap.MIRROR_0_STACK_END1));
            return;
        }
        if (userChoose.equals("MIRROR RAM")){
            jTMemory.setModel(MemoryViewerBuilder.getMemoryModel(jTMemory,MemoryMap.MIRROR_0_RAM_0_START1,MemoryMap.MIRROR_0_RAM_0_END1));
            return;
        }

        if (userChoose.equals("MIRROR 1 ZERO PAGE")){
            jTMemory.setModel(MemoryViewerBuilder.getMemoryModel(jTMemory,MemoryMap.MIRROR_1_ZERO_PAGE_START1,MemoryMap.MIRROR_1_ZERO_PAGE_END1));
            return;
        }
        if (userChoose.equals("MIRROR 1 STACK")){
            jTMemory.setModel(MemoryViewerBuilder.getMemoryModel(jTMemory,MemoryMap.MIRROR_1_STACK_START1,MemoryMap.MIRROR_1_STACK_END1));
            return;
        }
        if (userChoose.equals("MIRROR 1 RAM")){
            jTMemory.setModel(MemoryViewerBuilder.getMemoryModel(jTMemory,MemoryMap.MIRROR_1_RAM_0_START1,MemoryMap.MIRROR_1_RAM_0_END1));
            return;
        }

        if (userChoose.equals("MIRROR 2 ZERO PAGE")){
            jTMemory.setModel(MemoryViewerBuilder.getMemoryModel(jTMemory,MemoryMap.MIRROR_2_ZERO_PAGE_START1,MemoryMap.MIRROR_2_ZERO_PAGE_END1));
            return;
        }
        if (userChoose.equals("MIRROR 2 STACK")){
            jTMemory.setModel(MemoryViewerBuilder.getMemoryModel(jTMemory,MemoryMap.MIRROR_2_STACK_START1,MemoryMap.MIRROR_2_STACK_END1));
            return;
        }
        if (userChoose.equals("MIRROR 2 RAM")){
            jTMemory.setModel(MemoryViewerBuilder.getMemoryModel(jTMemory,MemoryMap.MIRROR_2_RAM_0_START1,MemoryMap.MIRROR_2_RAM_0_END1));
            return;
        }
        if (userChoose.equals("IO REGISTERS")){
            jTMemory.setModel(MemoryViewerBuilder.getMemoryModel(jTMemory,MemoryMap.IO_REGISTERS_START,MemoryMap.IO_REGISTERS_END));
            return;
        }

        if (userChoose.equals("EXPANSION ROM")){
            jTMemory.setModel(MemoryViewerBuilder.getMemoryModel(jTMemory,MemoryMap.EXPANSION_ROM_START,MemoryMap.EXPANSION_ROM_END));
            return;
        }

        if (userChoose.equals("SAVE RAM")){
            jTMemory.setModel(MemoryViewerBuilder.getMemoryModel(jTMemory,MemoryMap.SAVE_RAM_START,MemoryMap.SAVE_RAM_END));
            return;
        }
}//GEN-LAST:event_jBtnGoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jTMemory.setModel(MemoryViewerBuilder.getMemoryModel(jTMemory,MemoryMap.LOWER_BANK_START,MemoryMap.LOWER_BANK_END));
    }//GEN-LAST:event_formWindowOpened

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
