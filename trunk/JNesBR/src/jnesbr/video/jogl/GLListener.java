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
package jnesbr.video.jogl;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import jnesbr.video.Frame;

/**
 * @author dreampeppers99
 */
public class GLListener implements GLEventListener, KeyListener {

    private GLCanvas canvas;
    public static int width = 256,  height = 240;
    private Frame frame = Frame.getInstance();
    private static final int RED = 0 , GREEN = 1, BLUE = 2;
    private static final float PX_SIZE = 1.0f;

    public GLListener(GLCanvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        gl.glClearColor(.0f, .0f, .0f, 1.0f);
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(0.0, width, 0.0, height);
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glPointSize(PX_SIZE);
        
        float[][][] nesFrame = frame.getRGBFrame();
        
        gl.glBegin(GL.GL_POINTS);
        for (int x = 0; x < 256; x++) {
            for (int y = 0; y < 240; y++) {
                gl.glColor3f(nesFrame[x][y][RED], nesFrame[x][y][GREEN], nesFrame[x][y][BLUE]);
                gl.glVertex2i(x, y);
            }
        }
        gl.glEnd();
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }

    @Override
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 39) {
            System.out.println("39");
        }
        if (e.getKeyCode() == 37) {
            System.out.println("37");
        }
        if (e.getKeyCode() == 38) {
            System.out.println("38");
        }
        if (e.getKeyCode() == 40) {
            System.out.println("40");
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
