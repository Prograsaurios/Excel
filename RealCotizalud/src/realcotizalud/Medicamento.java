/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realcotizalud;

import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Medicamento extends Conexion{
    
    private int codigo;
    private String medicamento;
    private String dosis;
    private String presentacion;
    private String marca;
    private String farmacia;
    private int precio;
    private String direccion;
    private String comuna;
    private String region;
    public Medicamento(){
    }
    public Medicamento(int codigo, String medicamento, String dosis, String presentacion, String marca, String farmacia, int precio, String direccion, String comuna, String region) {
        this.codigo = codigo;
        this.medicamento = medicamento;
        this.dosis = dosis;
        this.presentacion = presentacion;
        this.marca = marca;
        this.farmacia = farmacia;
        this.precio = precio;
        this.direccion = direccion;
        this.comuna = comuna;
        this.region = region;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(String farmacia) {
        this.farmacia = farmacia;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    
    public DefaultTableModel buscar(String region, String medicamento, String farmacia){
    try{
     DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Codigo");
            dtm.addColumn("Medicamentos");
            dtm.addColumn("Dosis");
            dtm.addColumn("Presentacion");
            dtm.addColumn("Marca");
            dtm.addColumn("Farmacia");
            dtm.addColumn("Precio");
            dtm.addColumn("Direccion");
            dtm.addColumn("Comuna");
            dtm.addColumn("Region");
            this.abrir_conexion();
            Statement st = (Statement) con.createStatement();
            String consulta = "SELECT * FROM datos WHERE 1=1 ";
            if(null != region && !"".endsWith(region)){
                consulta = consulta + " AND region like '%"+region.replace("'", "")+"%'";
            }
            if(null != medicamento && !"".endsWith(medicamento)){
                consulta = consulta + " AND medicamento = '"+medicamento+"'";
            }
            if(null != farmacia && !"".endsWith(farmacia)){
                consulta = consulta + " AND farmacia = '"+farmacia+"'";
            }
            ResultSet rs = st.executeQuery(consulta);
            String arreglo[] = new String[10];
            while (rs.next()) {
                arreglo[0] = rs.getString("codigo");
                arreglo[1] = rs.getString("medicamento");
                arreglo[2] = rs.getString("dosis");
                arreglo[3] = rs.getString("presentacion");
                arreglo[4] = rs.getString("marca");
                arreglo[5] = rs.getString("farmacia");
                arreglo[6] = rs.getString("precio");
                arreglo[7] = rs.getString("direccion");
                arreglo[8] = rs.getString("comuna");
                arreglo[9] = rs.getString("region");
                dtm.addRow(arreglo);
            }
            this.cerrar_conexion();
            return dtm;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
   
    
    
    
    /*
   public DefaultTableModel consulta() { //te retorna tabla
        try {
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Codigo");
            dtm.addColumn("Medicamentos");
            dtm.addColumn("Dosis");
            dtm.addColumn("Presentacion");
            dtm.addColumn("Marca");
            dtm.addColumn("Farmacia");
            dtm.addColumn("Precio");
            dtm.addColumn("Direccion");
            dtm.addColumn("Comuna");
            dtm.addColumn("Region");
            this.abrir_conexion();
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM datos;");
            String arreglo[] = new String[10];
            while (rs.next()) {
                arreglo[0] = rs.getString("codigo");
                arreglo[1] = rs.getString("medicamento");
                arreglo[2] = rs.getString("dosis");
                arreglo[3] = rs.getString("presentacion");
                arreglo[4] = rs.getString("marca");
                arreglo[5] = rs.getString("farmacia");
                arreglo[6] = rs.getString("precio");
                arreglo[7] = rs.getString("direccion");
                arreglo[8] = rs.getString("comuna");
                arreglo[9] = rs.getString("region");
                dtm.addRow(arreglo);
            }
            this.cerrar_conexion();
            return dtm;
    
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
    */
           
}
