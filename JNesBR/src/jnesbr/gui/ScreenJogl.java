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

    private GLCanvas canvas;
    public static void main(String[] args) {
        new ScreenJogl().setVisible(true);
    }
    public ScreenJogl() {
        GLCapabilities setup = new GLCapabilities();
        canvas = new GLCanvas(setup);
        GLEventListener listener = new GLListener(canvas);
        canvas.addGLEventListener(listener);
        canvas.addKeyListener((KeyListener) listener);
        canvas.setSize(799, 599);
        setSize(800, 600);
        setLocation(70, 70);
        add(canvas);
        Thread render = new Thread(new Runnable() {

            @Override
            @SuppressWarnings("empty-statement")
            public void run() {
                while (true) {
                    canvas.display();
                }
            }
        });

        render.start();
    }
}