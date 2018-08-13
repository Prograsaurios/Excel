package vista.util;

import javax.swing.table.DefaultTableModel;

public class TablaMedicamentos extends DefaultTableModel {
    private static final String[] row = {"Codigo", "Medicamento", "Dosis", "Presentacion",
            "Marca", "Farmacia", "Precio", "Direccion",
            "Comuna", "Region"};

    private static final boolean[] canEdit = new boolean[]{
            false, false, false, false, false, false, false, false, false, false};

    /**
     *
     */
    public TablaMedicamentos() {
        super();
        setColumnIdentifiers(row);
    }

    /**
     * @param column
     * @return
     */
    @Override
    public Class
    getColumnClass(int column) {
        switch (column) {
            case 0:
                return Integer.class;

            case 6:
                return Integer.class;
            default:
                return String.class;
        }
    }

    /**
     * @param row
     * @param column
     * @return boolean
     */
    @Override
    public boolean isCellEditable(int row, int column) {
        return canEdit[column];
    }
}
