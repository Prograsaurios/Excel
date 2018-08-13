/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizalud.GUI;

import cotizalud.Contexto.Medicamento;
import cotizalud.GUI.util.Tabla_Medicamentos;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raguileoam
 */
public class GUI_Medicamentos extends JTable {

    /**
     *
     */
    public GUI_Medicamentos() {
        super();
        this.setAutoCreateRowSorter(true);
        this.getTableHeader().setReorderingAllowed(false);
        this.setModel(loadMedicamentos("", "", ""));
    }

    /**
     *
     * @param region
     * @param medicamento
     * @param farmacia
     * @return
     */
    public DefaultTableModel loadMedicamentos(String region, String medicamento, String farmacia) {
        try {
            Medicamento med = new Medicamento(region, medicamento, farmacia);
            ResultSet rs = med.resp("MEDS");
            DefaultTableModel dtm = new Tabla_Medicamentos();

            while (rs.next()) {
                med.setCodigo(rs.getInt("id"));
                med.setMedicamento(rs.getString("medicamento"));
                med.setDosis(rs.getString("dosis"));
                med.setPresentacion(rs.getString("presentación"));
                med.setMarca(rs.getString("marca"));
                med.setFarmacia(rs.getString("farmacía"));
                med.setPrecio(rs.getInt("precio"));
                med.setDireccion(rs.getString("dirección"));
                med.setComuna(rs.getString("comuna"));
                med.setRegion(rs.getString("región"));
                dtm.addRow(med.toArray());
            }
            med.getDb().desconectar();
            return dtm;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
}
