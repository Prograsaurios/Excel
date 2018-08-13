package vista.util;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class Total extends DefaultTableCellRenderer {

    private static final int VALIDATION_COLUMN = 1;

    /**
     * @param table
     * @param value
     * @param isSelected
     * @param hasFocus
     * @param row
     * @param col
     * @return
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int col) {

        Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
                row, col);

        String s = table.getModel().getValueAt(row, VALIDATION_COLUMN).toString();

        if (s.equalsIgnoreCase("1")) {
            comp.setForeground(Color.red);
        } else {
            comp.setForeground(null);
        }

        return (comp);
    }
}
