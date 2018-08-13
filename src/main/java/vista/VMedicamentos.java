/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import contexto.Medicamento;
import vista.util.TablaMedicamentos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author raguileoam
 */
class VMedicamentos extends JTable {

    /**
     *
     */
    public VMedicamentos() {
        super();
        this.setAutoCreateRowSorter(true);
        this.getTableHeader().setReorderingAllowed(false);
        this.setModel(new TablaMedicamentos());

    }

    /**
     * @param region
     * @param medicamento
     * @param farmacia
     * @return
     */
    public DefaultTableModel loadMedicamentos(String region, String medicamento, String farmacia) {
        try {
            Medicamento med = new Medicamento(region, medicamento, farmacia);
            ResultSet rs = med.resp("MEDS");
            DefaultTableModel dtm = new TablaMedicamentos();

            while (rs.next()) {
                med.setCodigo(rs.getInt("id"));
                med.setNombre(rs.getString("medicamento"));
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
