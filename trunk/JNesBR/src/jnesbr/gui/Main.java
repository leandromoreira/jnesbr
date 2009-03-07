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

import jnesbr.gui.debugger.MemoryView;
import jnesbr.gui.debugger.RomHeader;
import jnesbr.gui.debugger.Debugger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import jnesbr.core.Emulator;
import jnesbr.core.MetaInformation;
import jnesbr.gui.debugger.MemoryVideoView;
import jnesbr.gui.debugger.PPUStateViewer;
import jnesbr.gui.debugger.PatternTableViewer;

/**
 * @author dreampeppers99
 */
public class Main extends javax.swing.JFrame {

    private Emulator emulator;

    public Main() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMnuMain = new javax.swing.JMenuBar();
        jMnuFile = new javax.swing.JMenu();
        jMnuLoad = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        jMnuExit = new javax.swing.JMenuItem();
        jMnuConfig = new javax.swing.JMenu();
        jMnuConfigGeneral = new javax.swing.JMenuItem();
        jMnuJoystick = new javax.swing.JMenuItem();
        jMnuDebugger = new javax.swing.JMenu();
        jMnuShowHeader = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JSeparator();
        jMnuMemoryView = new javax.swing.JMenuItem();
        jMnuVideoMemoryView = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JSeparator();
        jMnuPatternTableViewer = new javax.swing.JMenuItem();
        jMnuPPUState = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        JmnuDebbugerShow = new javax.swing.JMenuItem();
        jMnuAbout = new javax.swing.JMenu();
        jmnuAboutMe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JNesBR - an(other) NES emulator.");
        setLocationByPlatform(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jnesbr/gui/resources/run.PNG"))); // NOI18N
        jButton1.setMnemonic('r');
        jButton1.setText("Run");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jnesbr/gui/resources/stop.PNG"))); // NOI18N
        jButton2.setMnemonic('s');
        jButton2.setText("Stop");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton2);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jnesbr/gui/resources/firstscreen.PNG"))); // NOI18N

        jMnuFile.setText("File");

        jMnuLoad.setText("Load");
        jMnuLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuLoadActionPerformed(evt);
            }
        });
        jMnuFile.add(jMnuLoad);
        jMnuFile.add(jSeparator1);

        jMnuExit.setText("Exit");
        jMnuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuExitActionPerformed(evt);
            }
        });
        jMnuFile.add(jMnuExit);

        jMnuMain.add(jMnuFile);

        jMnuConfig.setText("Configuration");

        jMnuConfigGeneral.setText("General");
        jMnuConfig.add(jMnuConfigGeneral);

        jMnuJoystick.setText("Joystick");
        jMnuConfig.add(jMnuJoystick);

        jMnuMain.add(jMnuConfig);

        jMnuDebugger.setText("Debugger");

        jMnuShowHeader.setText("Rom Header");
        jMnuShowHeader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuShowHeaderActionPerformed(evt);
            }
        });
        jMnuDebugger.add(jMnuShowHeader);
        jMnuDebugger.add(jSeparator4);

        jMnuMemoryView.setText("Memory Viewer");
        jMnuMemoryView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuMemoryViewActionPerformed(evt);
            }
        });
        jMnuDebugger.add(jMnuMemoryView);

        jMnuVideoMemoryView.setText("Video Memory Viewer");
        jMnuVideoMemoryView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuVideoMemoryViewActionPerformed(evt);
            }
        });
        jMnuDebugger.add(jMnuVideoMemoryView);
        jMnuDebugger.add(jSeparator3);

        jMnuPatternTableViewer.setText("Pattern Table Viewer");
        jMnuPatternTableViewer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuPatternTableViewerActionPerformed(evt);
            }
        });
        jMnuDebugger.add(jMnuPatternTableViewer);

        jMnuPPUState.setText("Show PPU State");
        jMnuPPUState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuPPUStateActionPerformed(evt);
            }
        });
        jMnuDebugger.add(jMnuPPUState);
        jMnuDebugger.add(jSeparator2);

        JmnuDebbugerShow.setText("Show Debugger");
        JmnuDebbugerShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmnuDebbugerShowActionPerformed(evt);
            }
        });
        jMnuDebugger.add(JmnuDebbugerShow);

        jMnuMain.add(jMnuDebugger);

        jMnuAbout.setText("About");

        jmnuAboutMe.setText("Read");
        jmnuAboutMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnuAboutMeActionPerformed(evt);
            }
        });
        jMnuAbout.add(jmnuAboutMe);

        jMnuMain.add(jMnuAbout);

        setJMenuBar(jMnuMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabel1)
                .addContainerGap(111, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMnuLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuLoadActionPerformed
        final JFileChooser fc = makeJFileChooser();
        int returnVal = fc.showOpenDialog(this);

        if (userChooseSomething(returnVal)) {
            File file = fc.getSelectedFile();
            FileChannel fileChannel;
            ByteBuffer rom = null;
            try {
                fileChannel = new RandomAccessFile(file, "r").getChannel();
                try {
                    rom = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, (int) fileChannel.size());
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, "There was an error on reading the game!\n"+ex);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "File not found!\n"+ex);
            }

            emulator = Emulator.getInstance();
            emulator.load(rom);
        } else {
            return;
        }
    }//GEN-LAST:event_jMnuLoadActionPerformed

    private void jMnuShowHeaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuShowHeaderActionPerformed
        RomHeader romHeaderFrame = new RomHeader();
        romHeaderFrame.setVisible(true);
    }//GEN-LAST:event_jMnuShowHeaderActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMnuMemoryViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuMemoryViewActionPerformed
        MemoryView mv = new MemoryView();
        mv.setVisible(true);
    }//GEN-LAST:event_jMnuMemoryViewActionPerformed

    private void JmnuDebbugerShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmnuDebbugerShowActionPerformed
        Debugger cp = new Debugger();
        cp.setVisible(true);
    }//GEN-LAST:event_JmnuDebbugerShowActionPerformed

    private void jMnuVideoMemoryViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuVideoMemoryViewActionPerformed
        MemoryVideoView mvv = new MemoryVideoView();
        mvv.setVisible(true);
    }//GEN-LAST:event_jMnuVideoMemoryViewActionPerformed

    private void jMnuPatternTableViewerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuPatternTableViewerActionPerformed
        PatternTableViewer ptv = new PatternTableViewer();
        ptv.setVisible(true);
    }//GEN-LAST:event_jMnuPatternTableViewerActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //this is just to make tests..
        //TODO: REMOVE THIS AFTER GET RUNNING THE PONG GAME
        File file = new File("roms/pong_demo_nes/PONG.NES");
        FileChannel roChannel;
        ByteBuffer readbuffer = null;
        try {
            roChannel = new RandomAccessFile(file, "r").getChannel();
            try {
                readbuffer = roChannel.map(FileChannel.MapMode.READ_ONLY, 0, (int) roChannel.size());
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        emulator = Emulator.getInstance();
        emulator.load(readbuffer);
    }//GEN-LAST:event_formWindowOpened

    private void jmnuAboutMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnuAboutMeActionPerformed
        JOptionPane.showMessageDialog(this, "Site: code.google.com/p/jnesbr", MetaInformation.NAME, JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jmnuAboutMeActionPerformed

    private void jMnuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMnuExitActionPerformed

    private void jMnuPPUStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuPPUStateActionPerformed
        new PPUStateViewer().setVisible(true);
    }//GEN-LAST:event_jMnuPPUStateActionPerformed

    private boolean userChooseSomething(int returnVal) {
        return returnVal == JFileChooser.APPROVE_OPTION;
    }

    private JFileChooser makeJFileChooser() {
        final JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Open NES File");
        fc.setCurrentDirectory(new java.io.File("."));
        return fc;
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JmnuDebbugerShow;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMnuAbout;
    private javax.swing.JMenu jMnuConfig;
    private javax.swing.JMenuItem jMnuConfigGeneral;
    private javax.swing.JMenu jMnuDebugger;
    private javax.swing.JMenuItem jMnuExit;
    private javax.swing.JMenu jMnuFile;
    private javax.swing.JMenuItem jMnuJoystick;
    private javax.swing.JMenuItem jMnuLoad;
    private javax.swing.JMenuBar jMnuMain;
    private javax.swing.JMenuItem jMnuMemoryView;
    private javax.swing.JMenuItem jMnuPPUState;
    private javax.swing.JMenuItem jMnuPatternTableViewer;
    private javax.swing.JMenuItem jMnuShowHeader;
    private javax.swing.JMenuItem jMnuVideoMemoryView;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem jmnuAboutMe;
    // End of variables declaration//GEN-END:variables
}
