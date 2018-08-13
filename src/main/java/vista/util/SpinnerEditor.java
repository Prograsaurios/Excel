package vista.util;

import javax.swing.*;
import java.awt.*;

/**
 * @author (extraido de
 *https : / / stackoverflow.com / questions / 1882400 / is - there - a -
 * convenient - way - to - use - a - spinner - as - an - editor - in - a - swing - jtable)
 */
public class SpinnerEditor extends DefaultCellEditor {

    private final JSpinner spinner;

    /**
     *
     */
    public SpinnerEditor() {
        super(new JTextField());
        spinner = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        spinner.setBorder(null);
    }

    /**
     * @param table
     * @param value
     * @param isSelected
     * @param row
     * @param column
     * @return
     */
    @Override
    public Component getTableCellEditorComponent(
            JTable table, Object value, boolean isSelected, int row, int column) {
        spinner.setValue(value);
        return spinner;
    }

    /**
     * @return
     */
    @Override
    public Object getCellEditorValue() {
        return spinner.getValue();
    }
}
