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
package jnesbr.gui;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @author dreampeppers99
 */
public class Configuration extends javax.swing.JFrame {

    public Configuration() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTreeMenuConfiguration = new javax.swing.JTree();
        jPnGeneral = new javax.swing.JPanel();
        jTabConfiguration = new javax.swing.JTabbedPane();
        jPnGeneralTab = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jBtnMetal = new javax.swing.JButton();
        jBtnMotif = new javax.swing.JButton();
        jBtnWindows = new javax.swing.JButton();
        jBtnNimbus = new javax.swing.JButton();
        jBtnWindowsClassic = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPnJoystickTab = new javax.swing.JPanel();
        jTxtKeyUp = new javax.swing.JTextField();
        jTxtKeyUp1 = new javax.swing.JTextField();
        jTxtKeyUp2 = new javax.swing.JTextField();
        jTxtKeyUp3 = new javax.swing.JTextField();
        jTxtKeyUp4 = new javax.swing.JTextField();
        jTxtKeyUp5 = new javax.swing.JTextField();
        jTxtKeyUp6 = new javax.swing.JTextField();
        jTxtKeyUp7 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPnVideoTab = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configuration");
        setLocationByPlatform(true);
        setResizable(false);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("JNesBR");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("General");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Joystick");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Video");
        treeNode1.add(treeNode2);
        jTreeMenuConfiguration.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTreeMenuConfiguration.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTreeMenuConfigurationMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTreeMenuConfiguration);

        jPnGeneral.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jnesbr/gui/resources/metallookandfeel.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jnesbr/gui/resources/motiflookandfeel.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jnesbr/gui/resources/nimbuslookandfeel.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jnesbr/gui/resources/windowclassiclookandfeel.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jnesbr/gui/resources/windowlookandfeel.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel6.setText("Change look and feel");

        jBtnMetal.setText("Apply");
        jBtnMetal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnMetalActionPerformed(evt);
            }
        });

        jBtnMotif.setText("Apply");

        jBtnWindows.setText("Apply");

        jBtnNimbus.setText("Apply");
        jBtnNimbus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNimbusActionPerformed(evt);
            }
        });

        jBtnWindowsClassic.setText("Appy");

        jLabel7.setText("Rom folder");

        jButton1.setText("...");

        javax.swing.GroupLayout jPnGeneralTabLayout = new javax.swing.GroupLayout(jPnGeneralTab);
        jPnGeneralTab.setLayout(jPnGeneralTabLayout);
        jPnGeneralTabLayout.setHorizontalGroup(
            jPnGeneralTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnGeneralTabLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel6)
                .addContainerGap(164, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnGeneralTabLayout.createSequentialGroup()
                .addGroup(jPnGeneralTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnGeneralTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPnGeneralTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                            .addGroup(jPnGeneralTabLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addGap(7, 7, 7)))
                        .addGroup(jPnGeneralTabLayout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(15, 15, 15)))
                    .addGroup(jPnGeneralTabLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(7, 7, 7)))
                .addGap(68, 68, 68)
                .addGroup(jPnGeneralTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnGeneralTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jBtnNimbus)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnGeneralTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtnWindows)
                            .addComponent(jBtnMotif)))
                    .addComponent(jBtnWindowsClassic)
                    .addComponent(jBtnMetal))
                .addContainerGap(130, Short.MAX_VALUE))
            .addGroup(jPnGeneralTabLayout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
        );
        jPnGeneralTabLayout.setVerticalGroup(
            jPnGeneralTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnGeneralTabLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPnGeneralTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnGeneralTabLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPnGeneralTabLayout.createSequentialGroup()
                        .addComponent(jBtnMetal)
                        .addGap(17, 17, 17)
                        .addComponent(jBtnMotif)
                        .addGap(20, 20, 20)
                        .addComponent(jBtnWindows)
                        .addGap(20, 20, 20)
                        .addComponent(jBtnNimbus)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnWindowsClassic)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPnGeneralTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        jTabConfiguration.addTab("General", new javax.swing.ImageIcon(getClass().getResource("/jnesbr/gui/resources/general.png")), jPnGeneralTab); // NOI18N

        jTxtKeyUp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxtKeyUp.setText("Key Up");

        jTxtKeyUp1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxtKeyUp1.setText("Key Up");

        jTxtKeyUp2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxtKeyUp2.setText("Key Up");

        jTxtKeyUp3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxtKeyUp3.setText("Key Up");

        jTxtKeyUp4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxtKeyUp4.setText("Key Up");

        jTxtKeyUp5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxtKeyUp5.setText("Key Up");

        jTxtKeyUp6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxtKeyUp6.setText("Key Up");

        jTxtKeyUp7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxtKeyUp7.setText("Key Up");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jnesbr/gui/resources/up.png"))); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jnesbr/gui/resources/down.png"))); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jnesbr/gui/resources/left.png"))); // NOI18N

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jnesbr/gui/resources/right.png"))); // NOI18N

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jnesbr/gui/resources/button_b.png"))); // NOI18N

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jnesbr/gui/resources/button_a.png"))); // NOI18N

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jnesbr/gui/resources/select_button.png"))); // NOI18N

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jnesbr/gui/resources/start_button.png"))); // NOI18N

        javax.swing.GroupLayout jPnJoystickTabLayout = new javax.swing.GroupLayout(jPnJoystickTab);
        jPnJoystickTab.setLayout(jPnJoystickTabLayout);
        jPnJoystickTabLayout.setHorizontalGroup(
            jPnJoystickTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnJoystickTabLayout.createSequentialGroup()
                .addGroup(jPnJoystickTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnJoystickTabLayout.createSequentialGroup()
                        .addComponent(jTxtKeyUp3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPnJoystickTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPnJoystickTabLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                                .addGroup(jPnJoystickTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jTxtKeyUp4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40))
                            .addGroup(jPnJoystickTabLayout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(jTxtKeyUp2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                    .addGroup(jPnJoystickTabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPnJoystickTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPnJoystickTabLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel8))
                            .addGroup(jPnJoystickTabLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPnJoystickTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPnJoystickTabLayout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel9))
                                    .addComponent(jTxtKeyUp1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPnJoystickTabLayout.createSequentialGroup()
                                        .addComponent(jTxtKeyUp, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel11)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPnJoystickTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnJoystickTabLayout.createSequentialGroup()
                        .addComponent(jTxtKeyUp6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtKeyUp7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTxtKeyUp5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPnJoystickTabLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel12)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel13))
                    .addComponent(jLabel15))
                .addGap(21, 21, 21))
        );
        jPnJoystickTabLayout.setVerticalGroup(
            jPnJoystickTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnJoystickTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnJoystickTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPnJoystickTabLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(1, 1, 1)
                        .addComponent(jTxtKeyUp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGroup(jPnJoystickTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnJoystickTabLayout.createSequentialGroup()
                        .addGroup(jPnJoystickTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPnJoystickTabLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPnJoystickTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTxtKeyUp6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTxtKeyUp7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPnJoystickTabLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtKeyUp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPnJoystickTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel14))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPnJoystickTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtKeyUp5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtKeyUp4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPnJoystickTabLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtKeyUp3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtKeyUp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(214, Short.MAX_VALUE))
        );

        jTabConfiguration.addTab("Joystick", new javax.swing.ImageIcon(getClass().getResource("/jnesbr/gui/resources/joystickicon.png")), jPnJoystickTab); // NOI18N

        javax.swing.GroupLayout jPnVideoTabLayout = new javax.swing.GroupLayout(jPnVideoTab);
        jPnVideoTab.setLayout(jPnVideoTabLayout);
        jPnVideoTabLayout.setHorizontalGroup(
            jPnVideoTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 464, Short.MAX_VALUE)
        );
        jPnVideoTabLayout.setVerticalGroup(
            jPnVideoTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 418, Short.MAX_VALUE)
        );

        jTabConfiguration.addTab("Video", new javax.swing.ImageIcon(getClass().getResource("/jnesbr/gui/resources/video.png")), jPnVideoTab); // NOI18N

        javax.swing.GroupLayout jPnGeneralLayout = new javax.swing.GroupLayout(jPnGeneral);
        jPnGeneral.setLayout(jPnGeneralLayout);
        jPnGeneralLayout.setHorizontalGroup(
            jPnGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabConfiguration, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
        );
        jPnGeneralLayout.setVerticalGroup(
            jPnGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabConfiguration, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPnGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                    .addComponent(jPnGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTreeMenuConfigurationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTreeMenuConfigurationMouseClicked
        try {
            JTree j = (JTree) evt.getSource();
            String selected = j.getSelectionPath().getPath()[1].toString();

            if (selected.equals("General")){
                jTabConfiguration.setSelectedIndex(0);
            }
            if (selected.equals("Joystick")){
                jTabConfiguration.setSelectedIndex(1);
            }
            if (selected.equals("Video")){
                jTabConfiguration.setSelectedIndex(2);
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jTreeMenuConfigurationMouseClicked

    private void jBtnNimbusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNimbusActionPerformed
        apply("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
}//GEN-LAST:event_jBtnNimbusActionPerformed

    private void apply(String classe){
         try {
            UIManager.setLookAndFeel(classe);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jBtnMetalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnMetalActionPerformed
        apply("javax.swing.plaf.metal.MetalLookAndFeel");
}//GEN-LAST:event_jBtnMetalActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Configuration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnMetal;
    private javax.swing.JButton jBtnMotif;
    private javax.swing.JButton jBtnNimbus;
    private javax.swing.JButton jBtnWindows;
    private javax.swing.JButton jBtnWindowsClassic;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPnGeneral;
    private javax.swing.JPanel jPnGeneralTab;
    private javax.swing.JPanel jPnJoystickTab;
    private javax.swing.JPanel jPnVideoTab;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabConfiguration;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTree jTreeMenuConfiguration;
    private javax.swing.JTextField jTxtKeyUp;
    private javax.swing.JTextField jTxtKeyUp1;
    private javax.swing.JTextField jTxtKeyUp2;
    private javax.swing.JTextField jTxtKeyUp3;
    private javax.swing.JTextField jTxtKeyUp4;
    private javax.swing.JTextField jTxtKeyUp5;
    private javax.swing.JTextField jTxtKeyUp6;
    private javax.swing.JTextField jTxtKeyUp7;
    // End of variables declaration//GEN-END:variables

}
