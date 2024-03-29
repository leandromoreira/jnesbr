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
package jnesbr.core;

/**
 * @author dreampeppers99
 */
public class IntegerRange implements Range<Integer,Integer,Integer> {
    private int max, min;
    public void setRange(Integer maximun, Integer minimun) {
        max = maximun;
        min = minimun;
    }

    public boolean isInside(Integer value) {
        return (value >= min && value <= max);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final IntegerRange other = (IntegerRange) obj;
        if (this.max != other.max) {
            return false;
        }
        if (this.min != other.min) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + this.max;
        hash = 73 * hash + this.min;
        return hash;
    }

}
