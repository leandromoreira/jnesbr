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
import java.util.Random;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;

/**
 * @author dreampeppers99
 */
public class GLListener implements GLEventListener, KeyListener {

    private GLCanvas canvas;
    public static int width = 256,  height = 240;

    public GLListener(GLCanvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(0, width, height, 0, 0, 1);
        gl.glDisable(GL.GL_DEPTH_TEST);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
        gl.glTranslatef(0.375f, 0.375f, 0f);
        gl.glClearColor(.3f, .3f, .3f, 0.f);
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        int x = 0, y = 0;

        for (x = 0; x < 256; x++) {
            for (y = 0; y < 240; y++) {
                gl.glColor3f((float) Math.random(), (float) Math.random(), (float) Math.random());
                gl.glBegin(GL.GL_POINT);
                gl.glVertex2i(x, y);
                gl.glEnd();
            }
        }

        gl.glColor3f((float) Math.random(), (float) Math.random(), (float) Math.random());
        gl.glBegin(GL.GL_TRIANGLES);
            gl.glVertex2f(0.035f, 0.50f);
            gl.glVertex2f(0.045f, 0.40f);
            gl.glVertex2f(0.055f, 0.30f);
        gl.glEnd();
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        drawable.getGL().glViewport(0, 0, width, height);
        drawable.getGL().glMatrixMode(GL.GL_MODELVIEW);
        drawable.getGL().glLoadIdentity();
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
