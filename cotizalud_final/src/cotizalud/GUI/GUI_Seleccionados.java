/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizalud.GUI;

import cotizalud.GUI.util.Tabla_Seleccionados;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raguileoam
 */
public class GUI_Seleccionados extends JTable implements TableModelListener{

    private JLabel total;
    private DefaultTableModel dtm;

    public JLabel getTotal() {
        return total;
    }

    public void setTotal(JLabel total) {
        this.total = total;
    }

    public DefaultTableModel getDtm() {
        return dtm;
    }

    public void setDtm(DefaultTableModel dtm) {
        this.dtm = dtm;
    }
    private TableModelListener dtl;

    public GUI_Seleccionados() {
        super();
        total = new JLabel("0");
        dtm = new Tabla_Seleccionados();
        dtm = loadSeleccionados();
        dtm.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
        if (e.getColumn() == dtm.findColumn("CANTIDAD")) {
            int cantidad = (Integer) getValueAt(e.getFirstRow(), dtm.findColumn("CANTIDAD"));
            int precio = (Integer) getValueAt(e.getFirstRow(), dtm.findColumn("PRECIO"));
            int total = cantidad * precio;
            //System.out.println(total);
            setValueAt(total, e.getFirstRow(), dtm.findColumn("PRECIO TOTAL"));

        }
        int num = 0;
        for (int i = 0; i < getRowCount(); i++) {
            num = num + (Integer) getValueAt(i, dtm.findColumn("PRECIO TOTAL"));
        }
        total.setText(Integer.toString(num));            }
        });

    }

    public DefaultTableModel loadSeleccionados() {
        dtm.addColumn("MEDICAMENTO");
        dtm.addColumn("DOSIS");
        dtm.addColumn("PRESENTACIÓN");
        dtm.addColumn("MARCA");
        dtm.addColumn("FARMACÍA");
        dtm.addColumn("PRECIO");
        dtm.addColumn("DIRECCIÓN");
        dtm.addColumn("COMUNA");
        dtm.addColumn("REGIÓN");
        dtm.addColumn("CANTIDAD");
        dtm.addColumn("PRECIO TOTAL");
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {

                if (value instanceof JButton) {
                    JButton btn = (JButton) value;
                    if (isSelected) {
                        btn.setForeground(table.getSelectionForeground());
                        btn.setBackground(table.getSelectionBackground());
                    } else {
                        btn.setForeground(table.getForeground());
                        btn.setBackground(UIManager.getColor("Button.background"));
                    }
                    return btn;
                }

                if (value instanceof JCheckBox) {
                    JCheckBox ch = (JCheckBox) value;

                    return ch;
                }
                if (value instanceof JSpinner) {
                    JSpinner sp = (JSpinner) value;
                    return sp;
                }

                return super.getTableCellRendererComponent(table, value, isSelected,
                        hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
            }
        });
        dtm.addTableModelListener(this);

        return dtm;
    }
    


}
