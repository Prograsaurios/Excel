package vista.util;

import javax.swing.table.DefaultTableModel;

public class TablaSeleccionados extends DefaultTableModel {

    private static final String[] row = {"Medicamento", "Dosis", "Presentación", "Marca",
            "Farmacia", "Precio", "Dirección", "Comuna",
            "Región", "Cantidad", "Precio total"};

    private static final boolean[] canEdit = new boolean[]{
            false, false, false, false, false, false, false, false, false, true, false
    };

    /**
     *
     */
    public TablaSeleccionados() {
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
        Class respuesta;

        switch (column) {
            case 0:
                respuesta = Integer.class;
                break;
            case 6:
                respuesta = Integer.class;
                break;
            case 9:
                respuesta = Integer.class;
                break;
            case 10:
                respuesta = Integer.class;
                break;
            default:
                respuesta = String.class;
        }
        return respuesta;
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
