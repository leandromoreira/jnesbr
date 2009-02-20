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

import jnesbr.core.Emulator;

/**
 * @author dreampeppers99
 */
public class Debugger extends javax.swing.JFrame {

    public Debugger() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPnRegisters = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTxtAccumulator = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTxtXIndex = new javax.swing.JTextField();
        jTxtYIndex = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTxtS = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTxtPC = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTxtSP = new javax.swing.JTextField();
        jChkS = new javax.swing.JCheckBox();
        jChkV = new javax.swing.JCheckBox();
        jChkB = new javax.swing.JCheckBox();
        jChkU = new javax.swing.JCheckBox();
        jChkC = new javax.swing.JCheckBox();
        jChkZ = new javax.swing.JCheckBox();
        jChkI = new javax.swing.JCheckBox();
        jChkD = new javax.swing.JCheckBox();
        jBtnStep = new javax.swing.JButton();
        jBtnPause = new javax.swing.JButton();
        jBtnRun = new javax.swing.JButton();
        jBtnStop = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTxtLog = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Debugger");
        setLocationByPlatform(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPnRegisters.setBorder(javax.swing.BorderFactory.createTitledBorder("Registers"));

        jLabel1.setText("Accumulator");

        jTxtAccumulator.setBackground(new java.awt.Color(0, 0, 0));
        jTxtAccumulator.setForeground(new java.awt.Color(204, 255, 204));
        jTxtAccumulator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtAccumulatorActionPerformed(evt);
            }
        });

        jLabel2.setText("X Index");

        jTxtXIndex.setBackground(new java.awt.Color(0, 0, 0));
        jTxtXIndex.setForeground(new java.awt.Color(204, 255, 204));

        jTxtYIndex.setBackground(new java.awt.Color(0, 0, 0));
        jTxtYIndex.setForeground(new java.awt.Color(204, 255, 204));

        jLabel3.setText("Y Index");

        jLabel4.setText("Status");

        jTxtS.setBackground(new java.awt.Color(0, 0, 0));
        jTxtS.setForeground(new java.awt.Color(204, 255, 204));

        jLabel5.setText("Program Counter");

        jTxtPC.setBackground(new java.awt.Color(0, 0, 0));
        jTxtPC.setForeground(new java.awt.Color(204, 255, 204));
        jTxtPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtPCActionPerformed(evt);
            }
        });

        jLabel6.setText("Stack Pointer");

        jTxtSP.setBackground(new java.awt.Color(0, 0, 0));
        jTxtSP.setForeground(new java.awt.Color(204, 255, 204));

        jChkS.setText("S");
        jChkS.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jChkS.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jChkS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChkSActionPerformed(evt);
            }
        });

        jChkV.setText("V");
        jChkV.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jChkV.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jChkB.setText("B");
        jChkB.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jChkB.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jChkU.setText("U");
        jChkU.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jChkU.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jChkC.setText("C");
        jChkC.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jChkC.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jChkZ.setText("Z");
        jChkZ.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jChkZ.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jChkI.setText("I");
        jChkI.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jChkI.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jChkD.setText("D");
        jChkD.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jChkD.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout jPnRegistersLayout = new javax.swing.GroupLayout(jPnRegisters);
        jPnRegisters.setLayout(jPnRegistersLayout);
        jPnRegistersLayout.setHorizontalGroup(
            jPnRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnRegistersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPnRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTxtYIndex, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTxtXIndex)
                    .addComponent(jTxtAccumulator, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPnRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnRegistersLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPnRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnRegistersLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel4)
                        .addGap(46, 46, 46)))
                .addGroup(jPnRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTxtS, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTxtSP)
                    .addComponent(jTxtPC, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPnRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnRegistersLayout.createSequentialGroup()
                        .addComponent(jChkD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jChkI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jChkZ)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jChkC))
                    .addGroup(jPnRegistersLayout.createSequentialGroup()
                        .addComponent(jChkS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jChkV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jChkU)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jChkB)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPnRegistersLayout.setVerticalGroup(
            jPnRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnRegistersLayout.createSequentialGroup()
                .addGroup(jPnRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jChkS)
                    .addComponent(jChkV)
                    .addComponent(jChkU)
                    .addComponent(jChkB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPnRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jChkD)
                    .addComponent(jChkI)
                    .addComponent(jChkZ)
                    .addComponent(jChkC)))
            .addGroup(jPnRegistersLayout.createSequentialGroup()
                .addGroup(jPnRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTxtAccumulator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTxtPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPnRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTxtXIndex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTxtSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPnRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTxtYIndex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTxtS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jBtnStep.setMnemonic('s');
        jBtnStep.setText("Step");
        jBtnStep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnStepActionPerformed(evt);
            }
        });

        jBtnPause.setText("Pause");
        jBtnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPauseActionPerformed(evt);
            }
        });

        jBtnRun.setText("Run");
        jBtnRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRunActionPerformed(evt);
            }
        });

        jBtnStop.setText("Stop");
        jBtnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnStopActionPerformed(evt);
            }
        });

        jTxtLog.setBackground(new java.awt.Color(0, 0, 0));
        jTxtLog.setColumns(20);
        jTxtLog.setEditable(false);
        jTxtLog.setForeground(new java.awt.Color(204, 255, 204));
        jTxtLog.setRows(5);
        jScrollPane3.setViewportView(jTxtLog);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPnRegisters, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jBtnRun)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jBtnStop)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jBtnPause)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jBtnStep))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPnRegisters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnRun)
                    .addComponent(jBtnStop)
                    .addComponent(jBtnPause)
                    .addComponent(jBtnStep))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnStepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnStepActionPerformed
        Emulator.getInstance().stepDebugger();
        jTxtLog.setText(jTxtLog.getText() + Emulator.getInstance().actualLine() + "\n");
        updateScreen();
}//GEN-LAST:event_jBtnStepActionPerformed

    private void jTxtAccumulatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtAccumulatorActionPerformed
}//GEN-LAST:event_jTxtAccumulatorActionPerformed

    private void jBtnPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPauseActionPerformed
}//GEN-LAST:event_jBtnPauseActionPerformed

    private void jChkSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChkSActionPerformed
    }//GEN-LAST:event_jChkSActionPerformed

    private void jBtnRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRunActionPerformed
}//GEN-LAST:event_jBtnRunActionPerformed

    private void jBtnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnStopActionPerformed
}//GEN-LAST:event_jBtnStopActionPerformed

    private void jTxtPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtPCActionPerformed
    }//GEN-LAST:event_jTxtPCActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        updateScreen();
    }//GEN-LAST:event_formWindowOpened
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Debugger().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnPause;
    private javax.swing.JButton jBtnRun;
    private javax.swing.JButton jBtnStep;
    private javax.swing.JButton jBtnStop;
    private javax.swing.JCheckBox jChkB;
    private javax.swing.JCheckBox jChkC;
    private javax.swing.JCheckBox jChkD;
    private javax.swing.JCheckBox jChkI;
    private javax.swing.JCheckBox jChkS;
    private javax.swing.JCheckBox jChkU;
    private javax.swing.JCheckBox jChkV;
    private javax.swing.JCheckBox jChkZ;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPnRegisters;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTxtAccumulator;
    private javax.swing.JTextArea jTxtLog;
    private javax.swing.JTextField jTxtPC;
    private javax.swing.JTextField jTxtS;
    private javax.swing.JTextField jTxtSP;
    private javax.swing.JTextField jTxtXIndex;
    private javax.swing.JTextField jTxtYIndex;
    // End of variables declaration//GEN-END:variables

    private void updateScreen() {
        Emulator emu = Emulator.getInstance();
        jTxtAccumulator.setText(Integer.toHexString(emu.getCpu().accumulator).toUpperCase());
        jTxtPC.setText(Integer.toHexString(emu.getCpu().programCounter).toUpperCase());
        jTxtXIndex.setText(Integer.toHexString(emu.getCpu().registerX).toUpperCase());
        jTxtYIndex.setText(Integer.toHexString(emu.getCpu().registerY).toUpperCase());
        jTxtS.setText(Integer.toHexString(emu.getCpu().processorStatus).toUpperCase());
        jTxtSP.setText(Integer.toHexString(emu.getCpu().stackPointer).toUpperCase());
        jChkB.setSelected(emu.getCpu().flagBreak != 0);
        jChkC.setSelected(emu.getCpu().flagCarry != 0);
        jChkD.setSelected(emu.getCpu().flagDecimalMode != 0);
        jChkI.setSelected(emu.getCpu().flagIRQ != 0);
        jChkS.setSelected(emu.getCpu().flagSign != 0);
        jChkU.setSelected(emu.getCpu().flagNotUsed != 0);
        jChkV.setSelected(emu.getCpu().flagOverflow != 0);
        jChkZ.setSelected(emu.getCpu().flagZero != 0);
    }
}
