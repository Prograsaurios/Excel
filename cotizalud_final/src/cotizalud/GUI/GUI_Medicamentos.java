/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizalud.GUI;

import cotizalud.Contexto.Buscador;
import cotizalud.GUI.util.Tabla_Medicamentos;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raguileoam
 */
public class GUI_Medicamentos extends JTable{
    
    public GUI_Medicamentos(){
    super();
    this.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Medicamento", "Dosis", "Presentacion", "Marca", "Farmacia", "Precio", "Direccion", "Comuna", "Region"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
    this.setAutoCreateRowSorter(true);    
    this.getTableHeader().setReorderingAllowed(false);
    this.setModel(loadMedicamentos("", "", ""));
     

    
    }
    
    
    public DefaultTableModel loadMedicamentos(String region, String medicamento, String farmacia) {
        try {
            Buscador busca = new Buscador(region, medicamento, farmacia);
            Object[] arreglo = new Object[10];
            ResultSet rs = busca.resp("MEDS");
            DefaultTableModel dtm = new Tabla_Medicamentos();

            dtm.addColumn("ID");
            dtm.addColumn("MEDICAMENTO");
            dtm.addColumn("DOSIS");
            dtm.addColumn("PRESENTACIÓN");
            dtm.addColumn("MARCA");
            dtm.addColumn("FARMACÍA");
            dtm.addColumn("PRECIO");
            dtm.addColumn("DIRECCIÓN");
            dtm.addColumn("COMUNA");
            dtm.addColumn("REGIÓN");
          
            while (rs.next()) {
                arreglo[0] = rs.getInt("id");
                arreglo[1] = rs.getString("medicamento");
                arreglo[2] = rs.getString("dosis");
                arreglo[3] = rs.getString("presentación");
                arreglo[4] = rs.getString("marca");
                arreglo[5] = rs.getString("farmacía");
                arreglo[6] = rs.getInt("precio");
                arreglo[7] = rs.getString("dirección");
                arreglo[8] = rs.getString("comuna");
                arreglo[9] = rs.getString("región");
                dtm.addRow(arreglo);
            }
            busca.getDb().desconectar();
            return dtm;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
}