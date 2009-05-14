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

import com.sun.opengl.util.FPSAnimator;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.swing.JFrame;
import jnesbr.video.jogl.GLListener;

/**
 * @author dreampeppers99
 */
public class ScreenJogl extends JFrame {

    public static void main(String[] args) {
        new ScreenJogl().setVisible(true);
    }

    public ScreenJogl() {
        super("JNesBR - Jogl Render");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        GLCapabilities setup = new GLCapabilities();
        GLCanvas canvas = new GLCanvas(setup);
        GLEventListener listener = new GLListener(canvas);
        canvas.addGLEventListener(listener);
        canvas.addKeyListener((KeyListener) listener);
        canvas.setSize(256, 240);
        getContentPane().add(canvas, BorderLayout.CENTER);
        setSize(258, 242);
        setResizable(false);
        center(this);
        FPSAnimator animator = new FPSAnimator(canvas, 60, true);
        animator.start();
    }

    private void center(Component comp) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = comp.getSize();

        if (frameSize.width > screenSize.width)frameSize.width = screenSize.width;
        if (frameSize.height > screenSize.height)frameSize.height = screenSize.height;

        comp.setLocation((screenSize.width-frameSize.width)>>1, (screenSize.height-frameSize.height)>>1);
    }
}