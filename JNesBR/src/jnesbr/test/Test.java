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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author dreampeppers99
 */
public class Test {

    public static void main(String[] args) {
        int[] temp = new int[16];
        String tmp = "1000000000010011";
        temp[15]=1;
        temp[1]=1;
        temp[0]=1;
        temp[4]=1;
        System.out.println(assemble(temp));
        System.out.println(Integer.parseInt(tmp, 2));
    }

    private static final int assemble(final int[] temp) {
        return (temp[15] << 15) | (temp[14] << 14) | (temp[13] << 13) | (temp[12] << 12) | (temp[11] << 11) | (temp[10] << 10) | (temp[9] << 9) | (temp[8] << 8) | (temp[7] << 7) | (temp[6] << 6) | (temp[5] << 5) | (temp[4] << 4) | (temp[3] << 3) | (temp[2] << 2) | (temp[1] << 1) | (temp[0]);
    }

    public void test(){
     Properties pp = new Properties();
        try {
            pp.loadFromXML(new FileInputStream(new File("arquivo.xml")));
            System.out.println(pp);
            System.out.println(pp.keys());
            System.out.println(pp.values());
            System.out.println(pp.propertyNames());
            System.out.println(pp.elements());
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
