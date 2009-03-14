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

import java.util.Iterator;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import jnesbr.core.Emulator;
import jnesbr.debugger.AssemblerLine;
import jnesbr.debugger.Debugger;
import jnesbr.processor.Cpu2A03;
import jnesbr.processor.memory.Memory;
import jnesbr.util.JNesUtil;
import jnesbr.util.JTableHelper;

/**
 * @author dreampeppers99
 */
public class DebuggerWindow extends javax.swing.JFrame {

    public DebuggerWindow() {
        initComponents();
    }

    private void configJTable() {
        jTableDebugger.setModel(new DefaultTableModel(new String[]{"", "Address", "Code"}, 0x7FFF));
        jTableDebugger.getColumnModel().getColumn(0).setMaxWidth(5);
        jTableDebugger.getColumnModel().getColumn(0).setResizable(false);
        jTableDebugger.getColumnModel().getColumn(1).setResizable(false);
        jTableDebugger.getColumnModel().getColumn(2).setResizable(false);
        jTableDebugger.getColumnModel().getColumn(1).setMaxWidth(60);
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
        jBtnNStep = new javax.swing.JButton();
        jTxtNStep = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jBtnText = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDebugger = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTxtAddress0 = new javax.swing.JTextField();
        jTxtAddress1 = new javax.swing.JTextField();
        jTxtAddress2 = new javax.swing.JTextField();
        jTxtValue1 = new javax.swing.JTextField();
        jTxtValue0 = new javax.swing.JTextField();
        jTxtValue2 = new javax.swing.JTextField();
        jBtnRefreshMemoryWacth = new javax.swing.JButton();
        jBtnAddBreakpoint = new javax.swing.JButton();
        jBtnDeleteBreakpoint = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jTxtValue1Bin = new javax.swing.JTextField();
        jTxtValue0Bin = new javax.swing.JTextField();
        jTxtValue2Bin = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Debugger");
        setLocationByPlatform(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
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
                .addContainerGap(210, Short.MAX_VALUE))
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

        jBtnStep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jnesbr/gui/resources/step.png"))); // NOI18N
        jBtnStep.setMnemonic('s');
        jBtnStep.setText("Step(F6)");
        jBtnStep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnStepActionPerformed(evt);
            }
        });

        jBtnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jnesbr/gui/resources/pause.png"))); // NOI18N
        jBtnPause.setText("Pause");
        jBtnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPauseActionPerformed(evt);
            }
        });

        jBtnRun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jnesbr/gui/resources/run.PNG"))); // NOI18N
        jBtnRun.setText("Run(F5)");
        jBtnRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRunActionPerformed(evt);
            }
        });

        jBtnStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jnesbr/gui/resources/stop.PNG"))); // NOI18N
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

        jBtnNStep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jnesbr/gui/resources/step.png"))); // NOI18N
        jBtnNStep.setText("N Step");
        jBtnNStep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNStepActionPerformed(evt);
            }
        });

        jTxtNStep.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxtNStep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtNStepActionPerformed(evt);
            }
        });

        jLabel7.setText("N Steps");

        jBtnText.setText("Clear");
        jBtnText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnTextActionPerformed(evt);
            }
        });

        jTableDebugger.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "", "Address", "Code"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableDebugger.setFocusable(false);
        jTableDebugger.setSelectionBackground(new java.awt.Color(204, 255, 204));
        jTableDebugger.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableDebugger.setShowHorizontalLines(false);
        jTableDebugger.setShowVerticalLines(false);
        jScrollPane1.setViewportView(jTableDebugger);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel8.setText("Memory Instant Watch");

        jLabel9.setText("Hex. Address");

        jLabel10.setText("Hex. Value");

        jTxtAddress0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxtAddress0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtAddress0ActionPerformed(evt);
            }
        });

        jTxtAddress1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxtAddress1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtAddress1ActionPerformed(evt);
            }
        });

        jTxtAddress2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxtAddress2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtAddress2ActionPerformed(evt);
            }
        });

        jTxtValue1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxtValue1.setFocusable(false);
        jTxtValue1.setRequestFocusEnabled(false);
        jTxtValue1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtValue1ActionPerformed(evt);
            }
        });

        jTxtValue0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxtValue0.setFocusable(false);
        jTxtValue0.setRequestFocusEnabled(false);
        jTxtValue0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtValue0ActionPerformed(evt);
            }
        });

        jTxtValue2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxtValue2.setFocusable(false);
        jTxtValue2.setRequestFocusEnabled(false);
        jTxtValue2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtValue2ActionPerformed(evt);
            }
        });

        jBtnRefreshMemoryWacth.setText("Refresh");
        jBtnRefreshMemoryWacth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRefreshMemoryWacthActionPerformed(evt);
            }
        });

        jBtnAddBreakpoint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jnesbr/gui/resources/addbreakpoint.png"))); // NOI18N
        jBtnAddBreakpoint.setText("Add Breakpoint");
        jBtnAddBreakpoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAddBreakpointActionPerformed(evt);
            }
        });

        jBtnDeleteBreakpoint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jnesbr/gui/resources/deletebreakpoint.png"))); // NOI18N
        jBtnDeleteBreakpoint.setText("Delete Breakpoint");
        jBtnDeleteBreakpoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDeleteBreakpointActionPerformed(evt);
            }
        });

        jLabel11.setText("Bin. Value");

        jTxtValue1Bin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxtValue1Bin.setFocusable(false);
        jTxtValue1Bin.setRequestFocusEnabled(false);
        jTxtValue1Bin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtValue1BinActionPerformed(evt);
            }
        });

        jTxtValue0Bin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxtValue0Bin.setFocusable(false);
        jTxtValue0Bin.setRequestFocusEnabled(false);
        jTxtValue0Bin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtValue0BinActionPerformed(evt);
            }
        });

        jTxtValue2Bin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxtValue2Bin.setFocusable(false);
        jTxtValue2Bin.setRequestFocusEnabled(false);
        jTxtValue2Bin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtValue2BinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPnRegisters, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBtnRun)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnStop)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnPause)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnStep)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtNStep, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnNStep))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(jLabel9))
                                            .addComponent(jTxtAddress1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                                            .addComponent(jTxtAddress0, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTxtAddress2, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel10)
                                            .addComponent(jTxtValue1)
                                            .addComponent(jTxtValue0, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                            .addComponent(jTxtValue2))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jTxtValue1Bin)
                                                    .addComponent(jTxtValue0Bin, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                                    .addComponent(jTxtValue2Bin, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(71, 71, 71)
                                                .addComponent(jLabel11))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(112, 112, 112)
                                        .addComponent(jLabel8)))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(jBtnRefreshMemoryWacth)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jBtnText)
                        .addGap(115, 115, 115))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnAddBreakpoint)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnDeleteBreakpoint)
                        .addContainerGap(337, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPnRegisters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBtnRun)
                            .addComponent(jBtnStop)
                            .addComponent(jBtnPause)
                            .addComponent(jBtnStep)
                            .addComponent(jLabel7)
                            .addComponent(jTxtNStep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnNStep))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBtnAddBreakpoint)
                            .addComponent(jBtnDeleteBreakpoint, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addComponent(jBtnText)
                        .addGap(217, 217, 217)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTxtAddress0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTxtAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTxtAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTxtValue0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTxtValue1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTxtValue2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTxtValue0Bin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtValue1Bin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtValue2Bin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnRefreshMemoryWacth))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(206, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnStepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnStepActionPerformed
        Emulator.getInstance().stepDebugger();
        sb.append(Emulator.getInstance().actualLine() + "\n");
        //jTxtLog.setText(jTxtLog.getText() + Emulator.getInstance().actualLine() + "\n");
        jTxtLog.setText(sb.toString());
        updateScreen();
        moveCursor(Emulator.getInstance().getCpu().programCounter);
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
        configJTable();
        updateScreen();
        updateMainCode();
        int realAddress = JNesUtil.get16BitLittleEndian(Memory.getMemory().read(Cpu2A03.InterruptRESET), Memory.getMemory().read(Cpu2A03.InterruptRESET + 1));
        moveCursor(realAddress);
    }//GEN-LAST:event_formWindowOpened

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        System.out.println(evt);
    }//GEN-LAST:event_formKeyTyped

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        System.out.println(evt);
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        // TODO add your handling code here:
        System.out.println(evt);
    }//GEN-LAST:event_formKeyReleased

    private void jBtnNStepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNStepActionPerformed
        int numberOfSteps = Integer.valueOf(jTxtNStep.getText());
        for (int i = 0; i < numberOfSteps; i++) {
            Emulator.getInstance().stepDebugger();
            sb.append(Emulator.getInstance().actualLine() + "\n");
        }
        jTxtLog.setText(sb.toString());
        updateScreen();
}//GEN-LAST:event_jBtnNStepActionPerformed

    private void jTxtNStepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtNStepActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTxtNStepActionPerformed
    private StringBuilder sb = new StringBuilder();
    private void jBtnTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnTextActionPerformed
        sb = null;
        sb = new StringBuilder();
        jTxtLog.setText(sb.toString());
}//GEN-LAST:event_jBtnTextActionPerformed

    private void jTxtAddress0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtAddress0ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTxtAddress0ActionPerformed

    private void jTxtAddress1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtAddress1ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTxtAddress1ActionPerformed

    private void jTxtAddress2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtAddress2ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTxtAddress2ActionPerformed

    private void jTxtValue1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtValue1ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTxtValue1ActionPerformed

    private void jTxtValue0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtValue0ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTxtValue0ActionPerformed

    private void jTxtValue2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtValue2ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTxtValue2ActionPerformed

    private void jBtnRefreshMemoryWacthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRefreshMemoryWacthActionPerformed
        updateMemoryWatch();
}//GEN-LAST:event_jBtnRefreshMemoryWacthActionPerformed

    private void jBtnAddBreakpointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAddBreakpointActionPerformed
        try {
            int rowIndex = jTableDebugger.getSelectedRow();
            jTableDebugger.setValueAt(Debugger.DEBUGGER_CHR, rowIndex, 0);
        //int addressInstruction = Integer.valueOf(jTableDebugger.getValueAt(rowIndex, 1).toString());
        //Debugger.add(new Breakpoint(addressInstruction));
        } catch (Exception e) {
        }
}//GEN-LAST:event_jBtnAddBreakpointActionPerformed

    private void jBtnDeleteBreakpointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDeleteBreakpointActionPerformed
        try {
            int rowIndex = jTableDebugger.getSelectedRow();
            jTableDebugger.setValueAt("", rowIndex, 0);
        //int addressInstruction = Integer.valueOf(jTableDebugger.getValueAt(rowIndex, 1).toString());
        //Debugger.remove(new Breakpoint(addressInstruction));
        } catch (Exception e) {
        }
}//GEN-LAST:event_jBtnDeleteBreakpointActionPerformed

    private void jTxtValue1BinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtValue1BinActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTxtValue1BinActionPerformed

    private void jTxtValue0BinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtValue0BinActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTxtValue0BinActionPerformed

    private void jTxtValue2BinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtValue2BinActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTxtValue2BinActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new DebuggerWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAddBreakpoint;
    private javax.swing.JButton jBtnDeleteBreakpoint;
    private javax.swing.JButton jBtnNStep;
    private javax.swing.JButton jBtnPause;
    private javax.swing.JButton jBtnRefreshMemoryWacth;
    private javax.swing.JButton jBtnRun;
    private javax.swing.JButton jBtnStep;
    private javax.swing.JButton jBtnStop;
    private javax.swing.JButton jBtnText;
    private javax.swing.JCheckBox jChkB;
    private javax.swing.JCheckBox jChkC;
    private javax.swing.JCheckBox jChkD;
    private javax.swing.JCheckBox jChkI;
    private javax.swing.JCheckBox jChkS;
    private javax.swing.JCheckBox jChkU;
    private javax.swing.JCheckBox jChkV;
    private javax.swing.JCheckBox jChkZ;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPnRegisters;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableDebugger;
    private javax.swing.JTextField jTxtAccumulator;
    private javax.swing.JTextField jTxtAddress0;
    private javax.swing.JTextField jTxtAddress1;
    private javax.swing.JTextField jTxtAddress2;
    private javax.swing.JTextArea jTxtLog;
    private javax.swing.JTextField jTxtNStep;
    private javax.swing.JTextField jTxtPC;
    private javax.swing.JTextField jTxtS;
    private javax.swing.JTextField jTxtSP;
    private javax.swing.JTextField jTxtValue0;
    private javax.swing.JTextField jTxtValue0Bin;
    private javax.swing.JTextField jTxtValue1;
    private javax.swing.JTextField jTxtValue1Bin;
    private javax.swing.JTextField jTxtValue2;
    private javax.swing.JTextField jTxtValue2Bin;
    private javax.swing.JTextField jTxtXIndex;
    private javax.swing.JTextField jTxtYIndex;
    // End of variables declaration//GEN-END:variables

    private void moveCursor(int row) {
        int rowNumber = jTableDebugger.getRowCount();
        for (int i = 0; i < rowNumber; i++) {
            if (jTableDebugger.getValueAt(i, 1).toString().toUpperCase().equals(Integer.toHexString(row).toUpperCase())){
                row = i;
                break;
            }
        }

        jTableDebugger.setRowSelectionInterval(row, row);
        JTableHelper.scrollToCenter(jTableDebugger, row, 2);
    }

    private void updateMainCode() {
        List<AssemblerLine> assembler = Debugger.disassembler();
        fillTable(assembler);
    }

    private void fillTable(List<AssemblerLine> assembler) {
        int row = 0, addressColunm = 1, codeColunm = 2;
        for (Iterator<AssemblerLine> it = assembler.iterator(); it.hasNext();) {
            AssemblerLine assemblerLine = it.next();
            jTableDebugger.setValueAt(Integer.toHexString(assemblerLine.pc).toUpperCase(), row, addressColunm);
            jTableDebugger.setValueAt(assemblerLine.code.toUpperCase(), row, codeColunm);
            row++;
        }
    }

    private void updateMemoryWatch() {
        updateWatcher(jTxtAddress0, jTxtValue0, jTxtValue0Bin);
        updateWatcher(jTxtAddress1, jTxtValue1, jTxtValue1Bin);
        updateWatcher(jTxtAddress2, jTxtValue2, jTxtValue2Bin);
    }

    public void updateWatcher(JTextComponent jtxt, JTextComponent jtxtHexa, JTextComponent jtxtBin) {
        try {
            if (!jtxt.getText().equals("")) {
                int address = Integer.parseInt(jtxt.getText(), 16);
                if (address >= 0x0000 & address <= 0xFFFF) {
                    jtxtHexa.setText("0x" + JNesUtil.fillIfNeedsWith(2, "0", Integer.toHexString(Emulator.getInstance().getMemory().read(address)).toUpperCase()));
                    jtxtBin.setText(JNesUtil.fillIfNeedsWith(8, "0", Integer.toBinaryString(Emulator.getInstance().getMemory().read(address)).toUpperCase()));
                }
            }
        } catch (Exception ex) {
        }
    }

    private void updateScreen() {
        Emulator emu = Emulator.getInstance();
        jTxtAccumulator.setText(Integer.toHexString(emu.getCpu().accumulator).toUpperCase());
        jTxtPC.setText(Integer.toHexString(emu.getCpu().programCounter).toUpperCase());
        jTxtXIndex.setText(Integer.toHexString(emu.getCpu().registerX).toUpperCase());
        jTxtYIndex.setText(Integer.toHexString(emu.getCpu().registerY).toUpperCase());
        jTxtS.setText(Integer.toHexString(emu.getCpu().processorStatus()).toUpperCase());
        jTxtSP.setText(Integer.toHexString(emu.getCpu().stackPointer).toUpperCase());
        jChkB.setSelected(emu.getCpu().flagBreak != 0);
        jChkC.setSelected(emu.getCpu().flagCarry != 0);
        jChkD.setSelected(emu.getCpu().flagDecimalMode != 0);
        jChkI.setSelected(emu.getCpu().flagIRQ != 0);
        jChkS.setSelected(emu.getCpu().flagSign != 0);
        jChkU.setSelected(emu.getCpu().flagNotUsed != 0);
        jChkV.setSelected(emu.getCpu().flagOverflow != 0);
        jChkZ.setSelected(emu.getCpu().flagZero != 0);
        updateMemoryWatch();
    }
}
