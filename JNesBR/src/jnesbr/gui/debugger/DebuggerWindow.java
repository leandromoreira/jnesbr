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
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.JTextComponent;
import jnesbr.core.Emulator;
import jnesbr.debugger.AssemblerLine;
import jnesbr.debugger.Debugger;
import jnesbr.debugger.Disassembler;
import jnesbr.util.JNesUtil;
import jnesbr.util.JTableHelper;
import jnesbr.video.Ppu2C02;

/**
 * @author dreampeppers99
 */
public class DebuggerWindow extends javax.swing.JFrame {

    private boolean useJtableSystem = true;

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
        jTableDebugger.getColumnModel().getColumn(1).setCellRenderer(
                new TableCellRenderer() {

                    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                        Component renderer = new DefaultTableCellRenderer().getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                        renderer.setForeground(Color.getHSBColor(Color.RGBtoHSB(0x00, 0x00, 0x66, null)[0], Color.RGBtoHSB(0x00, 0x00, 0x66, null)[1], Color.RGBtoHSB(0x00, 0x00, 0x66, null)[2]));
                        return renderer;
                    }
                });
        //#FF7246
        jTableDebugger.getColumnModel().getColumn(0).setCellRenderer(
                new TableCellRenderer() {

                    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                        Component renderer = new DefaultTableCellRenderer().getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                        renderer.setForeground(Color.getHSBColor(Color.RGBtoHSB(0xFF, 0x72, 0x46, null)[0], Color.RGBtoHSB(0xFF, 0x72, 0x46, null)[1], Color.RGBtoHSB(0xFF, 0x72, 0x46, null)[2]));
                        return renderer;
                    }
                });
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
        jLblActualScanline = new javax.swing.JLabel();
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
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jBtnSaveSourceCode = new javax.swing.JButton();

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
        jPnRegisters.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPnRegistersKeyPressed(evt);
            }
        });

        jLabel1.setText("Accumulator");

        jTxtAccumulator.setBackground(new java.awt.Color(0, 0, 0));
        jTxtAccumulator.setForeground(new java.awt.Color(204, 255, 204));
        jTxtAccumulator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtAccumulatorActionPerformed(evt);
            }
        });
        jTxtAccumulator.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxtAccumulatorKeyPressed(evt);
            }
        });

        jLabel2.setText("X Index");

        jTxtXIndex.setBackground(new java.awt.Color(0, 0, 0));
        jTxtXIndex.setForeground(new java.awt.Color(204, 255, 204));
        jTxtXIndex.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxtXIndexKeyPressed(evt);
            }
        });

        jTxtYIndex.setBackground(new java.awt.Color(0, 0, 0));
        jTxtYIndex.setForeground(new java.awt.Color(204, 255, 204));
        jTxtYIndex.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxtYIndexKeyPressed(evt);
            }
        });

        jLabel3.setText("Y Index");

        jLabel4.setText("Status");

        jTxtS.setBackground(new java.awt.Color(0, 0, 0));
        jTxtS.setForeground(new java.awt.Color(204, 255, 204));
        jTxtS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxtSKeyPressed(evt);
            }
        });

        jLabel5.setText("Program Counter");

        jTxtPC.setBackground(new java.awt.Color(0, 0, 0));
        jTxtPC.setForeground(new java.awt.Color(204, 255, 204));
        jTxtPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtPCActionPerformed(evt);
            }
        });
        jTxtPC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxtPCKeyPressed(evt);
            }
        });

        jLabel6.setText("Stack Pointer");

        jTxtSP.setBackground(new java.awt.Color(0, 0, 0));
        jTxtSP.setForeground(new java.awt.Color(204, 255, 204));
        jTxtSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxtSPKeyPressed(evt);
            }
        });

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

        jLblActualScanline.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLblActualScanline.setForeground(new java.awt.Color(0, 0, 102));
        jLblActualScanline.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

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
                        .addComponent(jChkB)
                        .addGap(18, 18, 18)
                        .addComponent(jLblActualScanline, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(253, Short.MAX_VALUE))
        );
        jPnRegistersLayout.setVerticalGroup(
            jPnRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnRegistersLayout.createSequentialGroup()
                .addGroup(jPnRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jChkS)
                    .addComponent(jChkV)
                    .addComponent(jChkU)
                    .addComponent(jChkB)
                    .addComponent(jLblActualScanline))
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
        jBtnStep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBtnStepKeyPressed(evt);
            }
        });

        jBtnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jnesbr/gui/resources/pause.png"))); // NOI18N
        jBtnPause.setText("Pause");
        jBtnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPauseActionPerformed(evt);
            }
        });
        jBtnPause.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBtnPauseKeyPressed(evt);
            }
        });

        jBtnRun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jnesbr/gui/resources/run.PNG"))); // NOI18N
        jBtnRun.setText("Run(F5)");
        jBtnRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRunActionPerformed(evt);
            }
        });
        jBtnRun.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBtnRunKeyPressed(evt);
            }
        });

        jBtnStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jnesbr/gui/resources/stop.PNG"))); // NOI18N
        jBtnStop.setText("Stop");
        jBtnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnStopActionPerformed(evt);
            }
        });
        jBtnStop.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBtnStopKeyPressed(evt);
            }
        });

        jTxtLog.setBackground(new java.awt.Color(0, 0, 0));
        jTxtLog.setColumns(20);
        jTxtLog.setEditable(false);
        jTxtLog.setForeground(new java.awt.Color(204, 255, 204));
        jTxtLog.setRows(5);
        jTxtLog.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxtLogKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(jTxtLog);

        jBtnNStep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jnesbr/gui/resources/step.png"))); // NOI18N
        jBtnNStep.setText("N Step");
        jBtnNStep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNStepActionPerformed(evt);
            }
        });
        jBtnNStep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBtnNStepKeyPressed(evt);
            }
        });

        jTxtNStep.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxtNStep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtNStepActionPerformed(evt);
            }
        });
        jTxtNStep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxtNStepKeyPressed(evt);
            }
        });

        jLabel7.setText("Steps");

        jBtnText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jnesbr/gui/resources/cleartext.png"))); // NOI18N
        jBtnText.setText("Clear code");
        jBtnText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnTextActionPerformed(evt);
            }
        });
        jBtnText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBtnTextKeyPressed(evt);
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
        jTableDebugger.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableDebuggerKeyPressed(evt);
            }
        });
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
        jTxtAddress0.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxtAddress0KeyPressed(evt);
            }
        });

        jTxtAddress1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxtAddress1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtAddress1ActionPerformed(evt);
            }
        });
        jTxtAddress1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxtAddress1KeyPressed(evt);
            }
        });

        jTxtAddress2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxtAddress2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtAddress2ActionPerformed(evt);
            }
        });
        jTxtAddress2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxtAddress2KeyPressed(evt);
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
        jTxtValue1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxtValue1KeyPressed(evt);
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
        jTxtValue0.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxtValue0KeyPressed(evt);
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
        jTxtValue2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxtValue2KeyPressed(evt);
            }
        });

        jBtnRefreshMemoryWacth.setText("Refresh");
        jBtnRefreshMemoryWacth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRefreshMemoryWacthActionPerformed(evt);
            }
        });
        jBtnRefreshMemoryWacth.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBtnRefreshMemoryWacthKeyPressed(evt);
            }
        });

        jBtnAddBreakpoint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jnesbr/gui/resources/addbreakpoint.png"))); // NOI18N
        jBtnAddBreakpoint.setText("Add Breakpoint");
        jBtnAddBreakpoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAddBreakpointActionPerformed(evt);
            }
        });
        jBtnAddBreakpoint.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBtnAddBreakpointKeyPressed(evt);
            }
        });

        jBtnDeleteBreakpoint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jnesbr/gui/resources/deletebreakpoint.png"))); // NOI18N
        jBtnDeleteBreakpoint.setText("Delete Breakpoint");
        jBtnDeleteBreakpoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDeleteBreakpointActionPerformed(evt);
            }
        });
        jBtnDeleteBreakpoint.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBtnDeleteBreakpointKeyPressed(evt);
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
        jTxtValue1Bin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxtValue1BinKeyPressed(evt);
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
        jTxtValue0Bin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxtValue0BinKeyPressed(evt);
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
        jTxtValue2Bin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxtValue2BinKeyPressed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 102));
        jLabel12.setText("Regular Debug Output");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel13.setForeground(new java.awt.Color(0, 0, 102));
        jLabel13.setText("Console Debug Output");

        jBtnSaveSourceCode.setFont(new java.awt.Font("Tahoma", 1, 11));
        jBtnSaveSourceCode.setForeground(new java.awt.Color(0, 0, 102));
        jBtnSaveSourceCode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jnesbr/gui/resources/icon.PNG"))); // NOI18N
        jBtnSaveSourceCode.setText("Save Source Code");
        jBtnSaveSourceCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSaveSourceCodeActionPerformed(evt);
            }
        });
        jBtnSaveSourceCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBtnSaveSourceCodeKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPnRegisters, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jBtnRefreshMemoryWacth))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addComponent(jBtnAddBreakpoint, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnDeleteBreakpoint))
                            .addComponent(jLabel12)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                                .addComponent(jBtnSaveSourceCode)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnText)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPnRegisters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)))
                    .addComponent(jBtnText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(262, 262, 262)
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnSaveSourceCode, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void stepDebugger() {
        Emulator.getInstance().stepDebugger();
        if (useJtableSystem) {
            moveCursor(Emulator.getInstance().getCpu().programCounter);
        } else {
            sb.append(Emulator.getInstance().actualLine() + "\n");
            jTxtLog.setText(sb.toString());
        }
        updateScreen();
    }
    private void jBtnStepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnStepActionPerformed
        stepDebugger();
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
        moveCursor(Emulator.getInstance().getCpu().programCounter);
    }//GEN-LAST:event_formWindowOpened

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        System.out.println(evt);
    }//GEN-LAST:event_formKeyTyped

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        stepShortCut(evt);
}//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        System.out.println(evt);
    }//GEN-LAST:event_formKeyReleased

    private void jBtnNStepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNStepActionPerformed
        int numberOfSteps = Integer.valueOf(jTxtNStep.getText());
        if (useJtableSystem) {
            for (int i = 0; i < numberOfSteps; i++) {
                Emulator.getInstance().stepDebugger();
            }
            moveCursor(Emulator.getInstance().getCpu().programCounter);
        } else {
            for (int i = 0; i < numberOfSteps; i++) {
                Emulator.getInstance().stepDebugger();
                sb.append(Emulator.getInstance().actualLine() + "\n");
            }
            jTxtLog.setText(sb.toString());
        }
        updateScreen();
}//GEN-LAST:event_jBtnNStepActionPerformed

    private void jTxtNStepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtNStepActionPerformed
}//GEN-LAST:event_jTxtNStepActionPerformed
    private StringBuilder sb = new StringBuilder();
    private void jBtnTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnTextActionPerformed
        sb = null;
        sb = new StringBuilder();
        jTxtLog.setText(sb.toString());
}//GEN-LAST:event_jBtnTextActionPerformed

    private void jTxtAddress0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtAddress0ActionPerformed
}//GEN-LAST:event_jTxtAddress0ActionPerformed

    private void jTxtAddress1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtAddress1ActionPerformed
}//GEN-LAST:event_jTxtAddress1ActionPerformed

    private void jTxtAddress2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtAddress2ActionPerformed
}//GEN-LAST:event_jTxtAddress2ActionPerformed

    private void jTxtValue1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtValue1ActionPerformed
}//GEN-LAST:event_jTxtValue1ActionPerformed

    private void jTxtValue0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtValue0ActionPerformed
}//GEN-LAST:event_jTxtValue0ActionPerformed

    private void jTxtValue2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtValue2ActionPerformed
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
}//GEN-LAST:event_jTxtValue1BinActionPerformed

    private void jTxtValue0BinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtValue0BinActionPerformed
}//GEN-LAST:event_jTxtValue0BinActionPerformed

    private void jTxtValue2BinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtValue2BinActionPerformed
}//GEN-LAST:event_jTxtValue2BinActionPerformed

    private void jBtnStepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBtnStepKeyPressed
        stepShortCut(evt);
    }//GEN-LAST:event_jBtnStepKeyPressed

    private void jPnRegistersKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPnRegistersKeyPressed
        stepShortCut(evt);
    }//GEN-LAST:event_jPnRegistersKeyPressed

    private void jTableDebuggerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableDebuggerKeyPressed
        stepShortCut(evt);
    }//GEN-LAST:event_jTableDebuggerKeyPressed

    private void jTxtAccumulatorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtAccumulatorKeyPressed
        stepShortCut(evt);
    }//GEN-LAST:event_jTxtAccumulatorKeyPressed

    private void jTxtPCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtPCKeyPressed
        stepShortCut(evt);
    }//GEN-LAST:event_jTxtPCKeyPressed

    private void jTxtXIndexKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtXIndexKeyPressed
        stepShortCut(evt);
    }//GEN-LAST:event_jTxtXIndexKeyPressed

    private void jTxtSPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtSPKeyPressed
        stepShortCut(evt);
    }//GEN-LAST:event_jTxtSPKeyPressed

    private void jTxtYIndexKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtYIndexKeyPressed
        stepShortCut(evt);
    }//GEN-LAST:event_jTxtYIndexKeyPressed

    private void jTxtSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtSKeyPressed
        stepShortCut(evt);
    }//GEN-LAST:event_jTxtSKeyPressed

    private void jBtnRunKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBtnRunKeyPressed
        stepShortCut(evt);
    }//GEN-LAST:event_jBtnRunKeyPressed

    private void jBtnStopKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBtnStopKeyPressed
        stepShortCut(evt);
    }//GEN-LAST:event_jBtnStopKeyPressed

    private void jBtnPauseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBtnPauseKeyPressed
        stepShortCut(evt);
    }//GEN-LAST:event_jBtnPauseKeyPressed

    private void jTxtNStepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtNStepKeyPressed
        stepShortCut(evt);
    }//GEN-LAST:event_jTxtNStepKeyPressed

    private void jBtnNStepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBtnNStepKeyPressed
        stepShortCut(evt);
    }//GEN-LAST:event_jBtnNStepKeyPressed

    private void jBtnAddBreakpointKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBtnAddBreakpointKeyPressed
        stepShortCut(evt);
    }//GEN-LAST:event_jBtnAddBreakpointKeyPressed

    private void jBtnDeleteBreakpointKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBtnDeleteBreakpointKeyPressed
        stepShortCut(evt);
    }//GEN-LAST:event_jBtnDeleteBreakpointKeyPressed

    private void jBtnTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBtnTextKeyPressed
        stepShortCut(evt);
    }//GEN-LAST:event_jBtnTextKeyPressed

    private void jTxtLogKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtLogKeyPressed
        stepShortCut(evt);
    }//GEN-LAST:event_jTxtLogKeyPressed

    private void jTxtAddress0KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtAddress0KeyPressed
        stepShortCut(evt);
    }//GEN-LAST:event_jTxtAddress0KeyPressed

    private void jTxtValue0KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtValue0KeyPressed
        stepShortCut(evt);
    }//GEN-LAST:event_jTxtValue0KeyPressed

    private void jTxtValue0BinKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtValue0BinKeyPressed
        stepShortCut(evt);
    }//GEN-LAST:event_jTxtValue0BinKeyPressed

    private void jTxtAddress1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtAddress1KeyPressed
        stepShortCut(evt);
    }//GEN-LAST:event_jTxtAddress1KeyPressed

    private void jTxtValue1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtValue1KeyPressed
        stepShortCut(evt);
    }//GEN-LAST:event_jTxtValue1KeyPressed

    private void jTxtValue1BinKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtValue1BinKeyPressed
        stepShortCut(evt);
    }//GEN-LAST:event_jTxtValue1BinKeyPressed

    private void jTxtAddress2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtAddress2KeyPressed
        stepShortCut(evt);
    }//GEN-LAST:event_jTxtAddress2KeyPressed

    private void jTxtValue2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtValue2KeyPressed
        stepShortCut(evt);
    }//GEN-LAST:event_jTxtValue2KeyPressed

    private void jTxtValue2BinKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtValue2BinKeyPressed
        stepShortCut(evt);
    }//GEN-LAST:event_jTxtValue2BinKeyPressed

    private void jBtnRefreshMemoryWacthKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBtnRefreshMemoryWacthKeyPressed
        stepShortCut(evt);
    }//GEN-LAST:event_jBtnRefreshMemoryWacthKeyPressed

    private JFileChooser makeSaveDialog() {
        final JFileChooser fc = new JFileChooser();
        fc.setDialogType(JFileChooser.SAVE_DIALOG);
        fc.setDialogTitle("Save 6502 Asm");
        fc.setCurrentDirectory(new java.io.File("."));
        return fc;
    }

    private boolean userChooseSomething(int returnVal) {
        return returnVal == JFileChooser.APPROVE_OPTION;
    }

    private void jBtnSaveSourceCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSaveSourceCodeActionPerformed
        try {
            final JFileChooser fc = makeSaveDialog();
            int returnVal = fc.showSaveDialog(this);
            if (userChooseSomething(returnVal)) {
                File file = fc.getSelectedFile();
                FileWriter assemblerFile = null;
                try {
                    assemblerFile = new FileWriter(file);
                } catch (IOException ex) {
                    Logger.getLogger(DebuggerWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (file.exists()) {
                    file.delete();
                }
                try {
                    file.createNewFile();

                    int row = 0;
                    int colAddress = 1;
                    int colCode = 2;

                    String address = jTableDebugger.getValueAt(row, colAddress).toString();
                    while (address != null) {
                        String line = jTableDebugger.getValueAt(row, colAddress).toString() + ":" + jTableDebugger.getValueAt(row, colCode).toString();
                        assemblerFile.write(line + "\n");
                        row++;
                        if (jTableDebugger.getValueAt(row, colAddress) == null) {
                            address = null;
                        } else {
                            address = jTableDebugger.getValueAt(row, colAddress).toString();
                        }
                        if (address != null) {
                            if (address.equals("")) {
                                address = null;
                            }
                        }
                    }

                } catch (IOException ex) {
                    Logger.getLogger(DebuggerWindow.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    if (assemblerFile != null) {
                        try {
                            assemblerFile.close();
                        } catch (IOException ex) {
                            Logger.getLogger(DebuggerWindow.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex, "Error on Save 6502 ASM", JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_jBtnSaveSourceCodeActionPerformed

    private void jBtnSaveSourceCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBtnSaveSourceCodeKeyPressed
        stepShortCut(evt);
}//GEN-LAST:event_jBtnSaveSourceCodeKeyPressed

    public void stepShortCut(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_F6) {
            stepDebugger();
        }
    }

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
    private javax.swing.JButton jBtnSaveSourceCode;
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
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLblActualScanline;
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
        try {
            boolean findRowCursor = false;
            int rowNumber = jTableDebugger.getRowCount();
            for (int i = 0; i < rowNumber; i++) {
                if (jTableDebugger.getValueAt(i, 1).toString().toUpperCase().equals(Integer.toHexString(row).toUpperCase())) {
                    row = i;
                    findRowCursor = true;
                    break;
                }
            }
            if (findRowCursor) {
                useJtableSystem = true;
                jTableDebugger.setRowSelectionInterval(row, row);
                JTableHelper.scrollToCenter(jTableDebugger, row, 2);
            } else {
                JOptionPane.showMessageDialog(this, "Debugger system wasn't uncapable to find the actual line. [" + JNesUtil.giveMeHexaStringFormattedWith4Space(row) + "]\n " +
                        "Then the debug system will be the Console output.");
                useJtableSystem = false;
            }
        } catch (java.lang.NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "Debugger system wasn't uncapable to find the actual line. [" + JNesUtil.giveMeHexaStringFormattedWith4Space(row) + "]\n " +
                    "Then the debug system will be the Console output.");
            useJtableSystem = false;
        }
    }

    private void updateMainCode() {
        List<AssemblerLine> assembler = Disassembler.disassembler();
        fillTable(assembler);
    }

    private void fillTable(List<AssemblerLine> assembler) {
        int row = 0, addressColunm = 1, codeColunm = 2;
        for (Iterator<AssemblerLine> it = assembler.iterator(); it.hasNext();) {
            AssemblerLine assemblerLine = it.next();
            jTableDebugger.setValueAt(Integer.toHexString(assemblerLine.pc).toUpperCase(), row, addressColunm);
            jTableDebugger.setValueAt(assemblerLine.asm6502Code.toUpperCase(), row, codeColunm);
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
        jLblActualScanline.setText("Scanline #" + Ppu2C02.getInstance().actualScanline());
        updateMemoryWatch();
    }
}
