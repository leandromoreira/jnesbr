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
package jnesbr.rom;

/**
 * @author dreampeppers99
 */
public class INesMapperUtil {

    private static String[] helpers = new String[0xFF];
    static{
        helpers[0]="No Mapper";
        helpers[1]="MMC1";
        helpers[2]="UNROM";
        helpers[3]="CNROM";
        helpers[4]="MMC3";
        helpers[5]="MMC5";
        helpers[6]="FFE";
        helpers[7]="AOROM";
        helpers[8]="FFE";
        helpers[9]="MMC2";
        helpers[10]="MMC4";
    }
    public static String getName(int code){
        if (code>=0xFF || code<0) throw new IllegalArgumentException("There is no mapped mappers for this code ["+code+"]");
        return (helpers[code]!=null?helpers[code]:"Not Found");
    }
}
