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
package jnesbr.gui.debugger;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 * @author dreampeppers99
 */
public class DebuggerDecoratorBuilder {

    private JTable jtable;

    public DebuggerDecoratorBuilder(JTable jTMemory) {
        jtable = jTMemory;
    }

    public TableModel getMemoryViewer() {
        
        jtable.setModel(new DefaultTableModel(0xFFFF, 17));
        TableColumn address = jtable.getColumnModel().getColumn(0);
        address.setWidth(25);
        address.setResizable(false);
        address.setHeaderValue("Address");
        short count = 1;

        while (count <= 16) {
            TableColumn col = jtable.getColumnModel().getColumn(count);
                        col.setWidth(3);
                        col.setResizable(false);
                        col.setHeaderValue(Integer.toHexString((count-1)).toUpperCase());
            count++;
        }
        return jtable.getModel();
    }
}
