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
package jnesbr.test;

import java.util.Arrays;
import jnesbr.video.Frame;

/**
 * @author dreampeppers99
 */
public class Test {

    public static void main(String[] args) {
        Frame frm = Frame.getInstance();
        frm.setPixel(new float[]{0.5f,0.3f,0.0f}, 0, 0);
        frm.setPixel(new float[]{0.7f,0.0f,0.53f}, 0, 239);
        frm.setPixel(new float[]{0.53f,0.53f,0.53f}, 255, 1);

        System.out.println("x=0, y=0 color is="+Arrays.toString(frm.getRGBFrame()[0][0]));
        System.out.println("x=0, y=255 color is="+Arrays.toString(frm.getRGBFrame()[0][239]));
        System.out.println("x=239, y=1 color is="+Arrays.toString(frm.getRGBFrame()[255][1]));
    }
}
