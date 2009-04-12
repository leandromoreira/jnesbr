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

import jnesbr.util.JNesUtil;
import jnesbr.video.PPUAddress;
import jnesbr.video.PPUControll;
import jnesbr.video.PPUData;
import jnesbr.video.PPUMask;
import jnesbr.video.PPUStatus;
import jnesbr.video.Ppu2C02;

/**
 * @author Dreampeppers99
 */
public class PPUStateViewer extends javax.swing.JFrame {

    public PPUStateViewer() {
        initComponents();
    }

    private void cleanPPUAddress() {
        jTxtFirst2006Address.setText("");
        jTxtFirst2006Value1.setText("");
        jTxtFirst2006Value2.setText("");
    }

    private void cleanPPUControll() {
        jChkExecuteNMIonVblank.setSelected(false);
        jChkSpriteSize8x8.setSelected(false);
        jChkSpriteSize8x16.setSelected(false);
        jChkSpritePatternTable0000.setSelected(false);
        jChkSpritePatternTable1000.setSelected(false);
        jChkBackgroundPatternTable0000.setSelected(false);
        jChkBackgroundPatternTable1000.setSelected(false);
        jChkBaseNametable2000.setSelected(false);
        jChkBaseNametable2400.setSelected(false);
        jChkBaseNametable2800.setSelected(false);
        jChkBaseNametable2C00.setSelected(false);
    }

    private void cleanPPUData() {
        jTxtPPUData.setText("");
    }

    private void cleanPPUMask() {
        jChkBackgroundRenderingEnable.setSelected(false);
        jChkClipBackground.setSelected(false);
        jChkClipSprite.setSelected(false);
        jChkColor.setSelected(false);
        jChkDisplayBackground.setSelected(false);
        jChkDisplaySprite.setSelected(false);
        jChkIntensifyBlues.setSelected(false);
        jChkIntensifyGreens.setSelected(false);
        jChkIntensifyReds.setSelected(false);
        jChkMonochromo.setSelected(false);
        jChkSpriteRenderingEnable.setSelected(false);
    }

    private void cleanPPUStatus() {
        jChkIsVB.setSelected(false);
        jChkSprite0.setSelected(false);
        jChkHasSpriteOverFlow.setSelected(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPnMain = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPnPPUControll = new javax.swing.JPanel();
        jChkExecuteNMIonVblank = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jChkSpriteSize8x8 = new javax.swing.JCheckBox();
        jChkSpriteSize8x16 = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jChkBackgroundPatternTable0000 = new javax.swing.JCheckBox();
        jChkBackgroundPatternTable1000 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jChkSpritePatternTable0000 = new javax.swing.JCheckBox();
        jChkSpritePatternTable1000 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jChkBaseNametable2000 = new javax.swing.JCheckBox();
        jChkBaseNametable2800 = new javax.swing.JCheckBox();
        jChkBaseNametable2400 = new javax.swing.JCheckBox();
        jChkBaseNametable2C00 = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jChkIntensifyBlues = new javax.swing.JCheckBox();
        jChkIntensifyGreens = new javax.swing.JCheckBox();
        jChkIntensifyReds = new javax.swing.JCheckBox();
        jChkSpriteRenderingEnable = new javax.swing.JCheckBox();
        jChkBackgroundRenderingEnable = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jChkClipSprite = new javax.swing.JCheckBox();
        jChkDisplaySprite = new javax.swing.JCheckBox();
        jChkDisplayBackground = new javax.swing.JCheckBox();
        jChkClipBackground = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jChkColor = new javax.swing.JCheckBox();
        jChkMonochromo = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jChkIsVB = new javax.swing.JCheckBox();
        jChkSprite0 = new javax.swing.JCheckBox();
        jChkHasSpriteOverFlow = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTxtFirst2006Value1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTxtFirst2006Value2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTxtFirst2006Address = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jTxtPPUData = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jBtnRefreshPPUState = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PPU state viewer");
        setLocationByPlatform(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        jPnMain.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jPnMainPropertyChange(evt);
            }
        });

        jChkExecuteNMIonVblank.setFont(new java.awt.Font("Tahoma", 1, 11));
        jChkExecuteNMIonVblank.setText("Execute NMI on VBlank");
        jChkExecuteNMIonVblank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChkExecuteNMIonVblankActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setText("Sprite size");

        jChkSpriteSize8x8.setText("8x8");

        jChkSpriteSize8x16.setText("8x16");
        jChkSpriteSize8x16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChkSpriteSize8x16ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setText("Background Pattern Table");

        jChkBackgroundPatternTable0000.setText("$0000");

        jChkBackgroundPatternTable1000.setText("$1000");
        jChkBackgroundPatternTable1000.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChkBackgroundPatternTable1000ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setText("Sprite Pattern Table");

        jChkSpritePatternTable0000.setText("$0000");

        jChkSpritePatternTable1000.setText("$1000");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel4.setText("Base nametable address");

        jChkBaseNametable2000.setText("$2000");

        jChkBaseNametable2800.setText("$2800");

        jChkBaseNametable2400.setText("$2400");
        jChkBaseNametable2400.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChkBaseNametable2400ActionPerformed(evt);
            }
        });

        jChkBaseNametable2C00.setText("$2C00");
        jChkBaseNametable2C00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChkBaseNametable2C00ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPnPPUControllLayout = new javax.swing.GroupLayout(jPnPPUControll);
        jPnPPUControll.setLayout(jPnPPUControllLayout);
        jPnPPUControllLayout.setHorizontalGroup(
            jPnPPUControllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnPPUControllLayout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addGroup(jPnPPUControllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnPPUControllLayout.createSequentialGroup()
                        .addGroup(jPnPPUControllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jChkBaseNametable2800)
                            .addComponent(jChkBaseNametable2000))
                        .addGap(18, 18, 18)
                        .addGroup(jPnPPUControllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jChkBaseNametable2C00)
                            .addComponent(jChkBaseNametable2400)))
                    .addComponent(jChkExecuteNMIonVblank)
                    .addComponent(jLabel4))
                .addContainerGap(184, Short.MAX_VALUE))
            .addGroup(jPnPPUControllLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPnPPUControllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPnPPUControllLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPnPPUControllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jChkSpriteSize8x16)
                            .addComponent(jChkSpriteSize8x8))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addGroup(jPnPPUControllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnPPUControllLayout.createSequentialGroup()
                        .addGroup(jPnPPUControllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jChkSpritePatternTable0000)
                            .addComponent(jChkSpritePatternTable1000))
                        .addGap(86, 86, 86))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnPPUControllLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(55, 55, 55)))
                .addGroup(jPnPPUControllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnPPUControllLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(jPnPPUControllLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPnPPUControllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jChkBackgroundPatternTable1000)
                            .addComponent(jChkBackgroundPatternTable0000))))
                .addGap(29, 29, 29))
        );
        jPnPPUControllLayout.setVerticalGroup(
            jPnPPUControllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnPPUControllLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPnPPUControllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnPPUControllLayout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jChkSpriteSize8x8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jChkSpriteSize8x16))
                    .addGroup(jPnPPUControllLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jChkExecuteNMIonVblank)
                        .addGap(63, 63, 63)
                        .addGroup(jPnPPUControllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPnPPUControllLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jChkBackgroundPatternTable0000)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jChkBackgroundPatternTable1000))
                            .addGroup(jPnPPUControllLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jChkSpritePatternTable0000)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jChkSpritePatternTable1000)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addGroup(jPnPPUControllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPnPPUControllLayout.createSequentialGroup()
                                        .addComponent(jChkBaseNametable2000)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jChkBaseNametable2800))
                                    .addGroup(jPnPPUControllLayout.createSequentialGroup()
                                        .addComponent(jChkBaseNametable2400)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jChkBaseNametable2C00)))))))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("PPU Controll $2000", jPnPPUControll);

        jChkIntensifyBlues.setFont(new java.awt.Font("Tahoma", 1, 11));
        jChkIntensifyBlues.setForeground(new java.awt.Color(0, 0, 255));
        jChkIntensifyBlues.setText("Intesify Blues");

        jChkIntensifyGreens.setFont(new java.awt.Font("Tahoma", 1, 11));
        jChkIntensifyGreens.setForeground(new java.awt.Color(0, 102, 0));
        jChkIntensifyGreens.setText("Intesify Greens");

        jChkIntensifyReds.setFont(new java.awt.Font("Tahoma", 1, 11));
        jChkIntensifyReds.setForeground(new java.awt.Color(255, 51, 51));
        jChkIntensifyReds.setText("Intesify Reds");

        jChkSpriteRenderingEnable.setText("Sprite Rendering Enable");
        jChkSpriteRenderingEnable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChkSpriteRenderingEnableActionPerformed(evt);
            }
        });

        jChkBackgroundRenderingEnable.setText("Background Rendering Enable");
        jChkBackgroundRenderingEnable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChkBackgroundRenderingEnableActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel5.setText("Enable sprite in leftmost 8 pixels of screen");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel6.setText("Enable background in leftmost 8 pixels of screen");

        jChkClipSprite.setText("Clip");
        jChkClipSprite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChkClipSpriteActionPerformed(evt);
            }
        });

        jChkDisplaySprite.setText("Display");
        jChkDisplaySprite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChkDisplaySpriteActionPerformed(evt);
            }
        });

        jChkDisplayBackground.setText("Display");
        jChkDisplayBackground.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChkDisplayBackgroundActionPerformed(evt);
            }
        });

        jChkClipBackground.setText("Clip");
        jChkClipBackground.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChkClipBackgroundActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel7.setText("Monochromo mode");

        jChkColor.setText("Color");

        jChkMonochromo.setText("Monochromo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addComponent(jChkSpriteRenderingEnable)
                .addGap(68, 68, 68)
                .addComponent(jChkBackgroundRenderingEnable)
                .addGap(98, 98, 98))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jChkIntensifyBlues)
                .addGap(83, 83, 83)
                .addComponent(jChkIntensifyGreens)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(jChkIntensifyReds)
                .addGap(44, 44, 44))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jChkDisplaySprite)
                    .addComponent(jChkClipSprite))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jChkDisplayBackground)
                    .addComponent(jChkClipBackground))
                .addGap(116, 116, 116))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(jLabel7)
                .addContainerGap(229, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jChkMonochromo)
                    .addComponent(jChkColor))
                .addContainerGap(225, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jChkIntensifyBlues)
                    .addComponent(jChkIntensifyGreens)
                    .addComponent(jChkIntensifyReds))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jChkBackgroundRenderingEnable)
                    .addComponent(jChkSpriteRenderingEnable))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jChkClipSprite)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jChkDisplaySprite))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jChkClipBackground)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jChkDisplayBackground)))
                .addGap(43, 43, 43)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jChkColor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jChkMonochromo)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("PPU Mask $2001", jPanel2);

        jChkIsVB.setFont(new java.awt.Font("Tahoma", 1, 11));
        jChkIsVB.setText("Is in the VBlank?");
        jChkIsVB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChkIsVBActionPerformed(evt);
            }
        });

        jChkSprite0.setFont(new java.awt.Font("Tahoma", 1, 11));
        jChkSprite0.setText("Sprite 0 hit is seted?");
        jChkSprite0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChkSprite0ActionPerformed(evt);
            }
        });

        jChkHasSpriteOverFlow.setFont(new java.awt.Font("Tahoma", 1, 11));
        jChkHasSpriteOverFlow.setText("Has some sprite overflow?");
        jChkHasSpriteOverFlow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChkHasSpriteOverFlowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(195, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jChkSprite0)
                        .addGap(199, 199, 199))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jChkIsVB)
                        .addGap(207, 207, 207))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jChkHasSpriteOverFlow)
                        .addGap(179, 179, 179))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jChkIsVB)
                .addGap(54, 54, 54)
                .addComponent(jChkSprite0)
                .addGap(65, 65, 65)
                .addComponent(jChkHasSpriteOverFlow)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("PPU Status $2002", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 549, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 376, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("OAM Address $2003", jPanel5);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 549, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 376, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("OAM Data $2004", jPanel6);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 549, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 376, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("PPU Scroll $2005", jPanel7);

        jLabel8.setText("First Value");

        jLabel9.setText("Second Value");

        jLabel10.setText("Complete Address");

        jTxtFirst2006Address.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtFirst2006Address, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtFirst2006Value1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtFirst2006Value2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addGap(99, 99, 99))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(154, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTxtFirst2006Value2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jTxtFirst2006Value1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTxtFirst2006Address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(149, 149, 149))
        );

        jTabbedPane1.addTab("PPU Address $2006", jPanel8);

        jTxtPPUData.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel11.setText("Data to be written");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTxtPPUData, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(240, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtPPUData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(263, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("PPU Data $2007", jPanel9);

        jBtnRefreshPPUState.setText("Refresh");
        jBtnRefreshPPUState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRefreshPPUStateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPnMainLayout = new javax.swing.GroupLayout(jPnMain);
        jPnMain.setLayout(jPnMainLayout);
        jPnMainLayout.setHorizontalGroup(
            jPnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnMainLayout.createSequentialGroup()
                .addGroup(jPnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnMainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPnMainLayout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(jBtnRefreshPPUState)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPnMainLayout.setVerticalGroup(
            jPnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnRefreshPPUState)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPnMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPnMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jChkExecuteNMIonVblankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChkExecuteNMIonVblankActionPerformed
}//GEN-LAST:event_jChkExecuteNMIonVblankActionPerformed

    private void jChkSpriteSize8x16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChkSpriteSize8x16ActionPerformed
}//GEN-LAST:event_jChkSpriteSize8x16ActionPerformed

    private void jChkBaseNametable2400ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChkBaseNametable2400ActionPerformed
}//GEN-LAST:event_jChkBaseNametable2400ActionPerformed

    private void jChkBaseNametable2C00ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChkBaseNametable2C00ActionPerformed
}//GEN-LAST:event_jChkBaseNametable2C00ActionPerformed

    private void jChkBackgroundPatternTable1000ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChkBackgroundPatternTable1000ActionPerformed
}//GEN-LAST:event_jChkBackgroundPatternTable1000ActionPerformed

    private void jBtnRefreshPPUStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRefreshPPUStateActionPerformed
        cleanAll();
        refreshAll();
    }//GEN-LAST:event_jBtnRefreshPPUStateActionPerformed

    private void jPnMainPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jPnMainPropertyChange
    }//GEN-LAST:event_jPnMainPropertyChange

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jBtnRefreshPPUStateActionPerformed(null);
    }//GEN-LAST:event_formWindowOpened

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
    }//GEN-LAST:event_formKeyReleased

    private void jChkIsVBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChkIsVBActionPerformed
}//GEN-LAST:event_jChkIsVBActionPerformed

    private void jChkSprite0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChkSprite0ActionPerformed
}//GEN-LAST:event_jChkSprite0ActionPerformed

    private void jChkHasSpriteOverFlowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChkHasSpriteOverFlowActionPerformed
}//GEN-LAST:event_jChkHasSpriteOverFlowActionPerformed

    private void jChkSpriteRenderingEnableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChkSpriteRenderingEnableActionPerformed
}//GEN-LAST:event_jChkSpriteRenderingEnableActionPerformed

    private void jChkBackgroundRenderingEnableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChkBackgroundRenderingEnableActionPerformed
}//GEN-LAST:event_jChkBackgroundRenderingEnableActionPerformed

    private void jChkClipSpriteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChkClipSpriteActionPerformed
}//GEN-LAST:event_jChkClipSpriteActionPerformed

    private void jChkDisplaySpriteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChkDisplaySpriteActionPerformed
}//GEN-LAST:event_jChkDisplaySpriteActionPerformed

    private void jChkDisplayBackgroundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChkDisplayBackgroundActionPerformed
}//GEN-LAST:event_jChkDisplayBackgroundActionPerformed

    private void jChkClipBackgroundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChkClipBackgroundActionPerformed
}//GEN-LAST:event_jChkClipBackgroundActionPerformed
    private void cleanAll() {
        cleanPPUControll();
        cleanPPUStatus();
        cleanPPUMask();
        cleanPPUAddress();
        cleanPPUData();
    }

    private void refreshAll() {
        Ppu2C02 ppu = Ppu2C02.getInstance();
        PPUControll ppuControll = ppu.ppuControl;
        PPUStatus ppuStatus = ppu.ppuStatus;
        PPUMask ppuMask = ppu.ppuMask;
        PPUAddress ppuAddress = ppu.pPUAddress;
        PPUData pPUData = ppu.pPUData;
        refreshPPUControll(ppuControll);
        refreshPPUStatus(ppuStatus);
        refreshPPUMask(ppuMask);
        refreshPPUAddress(ppuAddress);
        refreshPPUData(pPUData);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PPUStateViewer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnRefreshPPUState;
    private javax.swing.JCheckBox jChkBackgroundPatternTable0000;
    private javax.swing.JCheckBox jChkBackgroundPatternTable1000;
    private javax.swing.JCheckBox jChkBackgroundRenderingEnable;
    private javax.swing.JCheckBox jChkBaseNametable2000;
    private javax.swing.JCheckBox jChkBaseNametable2400;
    private javax.swing.JCheckBox jChkBaseNametable2800;
    private javax.swing.JCheckBox jChkBaseNametable2C00;
    private javax.swing.JCheckBox jChkClipBackground;
    private javax.swing.JCheckBox jChkClipSprite;
    private javax.swing.JCheckBox jChkColor;
    private javax.swing.JCheckBox jChkDisplayBackground;
    private javax.swing.JCheckBox jChkDisplaySprite;
    private javax.swing.JCheckBox jChkExecuteNMIonVblank;
    private javax.swing.JCheckBox jChkHasSpriteOverFlow;
    private javax.swing.JCheckBox jChkIntensifyBlues;
    private javax.swing.JCheckBox jChkIntensifyGreens;
    private javax.swing.JCheckBox jChkIntensifyReds;
    private javax.swing.JCheckBox jChkIsVB;
    private javax.swing.JCheckBox jChkMonochromo;
    private javax.swing.JCheckBox jChkSprite0;
    private javax.swing.JCheckBox jChkSpritePatternTable0000;
    private javax.swing.JCheckBox jChkSpritePatternTable1000;
    private javax.swing.JCheckBox jChkSpriteRenderingEnable;
    private javax.swing.JCheckBox jChkSpriteSize8x16;
    private javax.swing.JCheckBox jChkSpriteSize8x8;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPnMain;
    private javax.swing.JPanel jPnPPUControll;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTxtFirst2006Address;
    private javax.swing.JTextField jTxtFirst2006Value1;
    private javax.swing.JTextField jTxtFirst2006Value2;
    private javax.swing.JTextField jTxtPPUData;
    // End of variables declaration//GEN-END:variables

    private void refreshPPUAddress(PPUAddress ppuAddress) {
        jTxtFirst2006Address.setText(JNesUtil.giveMeHexaStringFormattedWith2Space(ppuAddress.completeAddress));
        jTxtFirst2006Value1.setText(JNesUtil.giveMeHexaStringFormattedWith2Space(ppuAddress.firstData));
        jTxtFirst2006Value2.setText(JNesUtil.giveMeHexaStringFormattedWith2Space(ppuAddress.secondData));
    }
    // End of variables declaration

    private void refreshPPUControll(PPUControll ppuControll) {
        if (ppuControll.executeNMIOnVBlank == 1) {
            jChkExecuteNMIonVblank.setSelected(true);
        }
        if (ppuControll.spriteSize == 0) {
            jChkSpriteSize8x8.setSelected(true);
        } else {
            jChkSpriteSize8x16.setSelected(true);
        }
        if (ppuControll.patternTableAddress8x8Sprites == 0) {
            jChkSpritePatternTable0000.setSelected(true);
        } else {
            jChkSpritePatternTable1000.setSelected(true);
        }
        if (ppuControll.patternTableAddressBackground == 0) {
            jChkBackgroundPatternTable0000.setSelected(true);
        } else {
            jChkBackgroundPatternTable1000.setSelected(true);
        }
        switch (ppuControll.nameTableAddress) {
            case 0:
                jChkBaseNametable2000.setSelected(true);
                break;
            case 1:
                jChkBaseNametable2400.setSelected(true);
                break;
            case 2:
                jChkBaseNametable2800.setSelected(true);
                break;
            case 3:
                jChkBaseNametable2C00.setSelected(true);
                break;
        }
    }

    private void refreshPPUData(PPUData pPUData) {
        jTxtPPUData.setText(JNesUtil.giveMeHexaStringFormattedWith2Space(pPUData.data));
    }

    private void refreshPPUMask(PPUMask ppuMask) {
        if (ppuMask.intensifyBlues == 1) {
            jChkIntensifyBlues.setSelected(true);
        }
        if (ppuMask.intensifyGreens == 1) {
            jChkIntensifyGreens.setSelected(true);
        }
        if (ppuMask.intensifyReds == 1) {
            jChkIntensifyReds.setSelected(true);
        }
        if (ppuMask.backgroundRenderingEnable == 1) {
            jChkBackgroundRenderingEnable.setSelected(true);
        }
        if (ppuMask.spriteRenderingEnable == 1) {
            jChkSpriteRenderingEnable.setSelected(true);
        }

        if (ppuMask.enableSpriteInLeftmost == PPUMask.CLIP) {
            jChkClipSprite.setSelected(true);
            jChkDisplaySprite.setSelected(false);
        } else {
            jChkClipSprite.setSelected(false);
            jChkDisplaySprite.setSelected(true);
        }
        if (ppuMask.enableBackgroundInLeftmost == PPUMask.CLIP) {
            jChkClipBackground.setSelected(true);
            jChkDisplayBackground.setSelected(false);
        } else {
            jChkClipBackground.setSelected(false);
            jChkDisplayBackground.setSelected(true);
        }
        if (ppuMask.grayscale == PPUMask.NORMAL) {
            jChkColor.setSelected(true);
            jChkMonochromo.setSelected(false);
        } else {
            jChkColor.setSelected(false);
            jChkMonochromo.setSelected(true);
        }
    }

    private void refreshPPUStatus(PPUStatus ppuStatus) {
        if (ppuStatus.verticalBlankStarted == PPUStatus.InVBlank) {
            jChkIsVB.setSelected(true);
        }
        if (ppuStatus.sprite0Hit == 1) {
            jChkSprite0.setSelected(true);
        }
        if (ppuStatus.moreThan8ObjectsOnScanLine == 1) {
            jChkHasSpriteOverFlow.setSelected(true);
        }
    }
}
