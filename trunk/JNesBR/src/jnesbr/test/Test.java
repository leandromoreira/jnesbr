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
        int v = Integer.parseInt("0000010000001110", 2);
        int t = Integer.parseInt("0000000000010001", 2);
        int loopy_v_without_5_bits = v >> 5;
        int new_loopy_t = (loopy_v_without_5_bits << 5) | (t & 0x1F);
        //  v[0-4] = t[0-4] ;
        loopy_v_without_5_bits = (t >> 10) & 1;
        //getting the 11th bit ;
        new_loopy_t = ((new_loopy_t >> 11) << 11) | (loopy_v_without_5_bits << 10) | (new_loopy_t & 0x3FF);
        System.out.println(Integer.toBinaryString(new_loopy_t));
        System.out.println("10000010001");
    }

    public static void printTile(int[][] a) {
        System.out.println("");
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                System.out.print(a[x][y] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public void test() {
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
