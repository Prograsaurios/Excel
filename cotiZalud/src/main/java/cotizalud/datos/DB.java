/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//TRUNCATE TABLE `medicamentos` vacia tabla 
//DROP TABLE `medicamentos` borra tabla
//DROP DATABASE `myjavaapp1` borra base de datos
package cotizalud.datos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mysql.cj.jdbc.Driver;
import org.apache.poi.ss.usermodel.Row;
/**
 *
 * @author Usuario
 */
public class DB { //mySQL DataBase
    private static Connection conn;
    private static final String bd="?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String driver =("com.mysql.cj.jdbc.Driver");
    private static final String user="root";
    private static final String password="root";
    private static final String url="jdbc:mysql://localhost:3306/"+bd;
    
    public DB() {
        conn = null;
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, user, password);;
            
        } catch ( ClassNotFoundException|SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (conn != null) {
            System.out.print("Conectado");
        }
    }

    public Connection getConn() {
        return conn;
    }

    public void desconectar() throws SQLException {
        conn.close();//por si acaso lo de arriba no funciona
    }
    
    public void crearDatabase(String database){
        try {
            Statement sent=conn.createStatement();
            String crear= "create database "+database+";";
            String usar="use "+database+",";
            sent.execute(crear);
            sent.execute(usar);
            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    public void crearTabla(String tabla) throws SQLException {
        Statement sent = conn.createStatement();
        String query = String.format("CREATE TABLE `cotiZalud`.`%s` ( `id` INT NOT NULL AUTO_INCREMENT , `medicamento` TEXT NOT NULL , `dosis` TEXT NOT NULL , `presentación` TEXT NOT NULL ,`marca` TEXT NOT NULL, `farmacia` TEXT NOT NULL , `precio` INT NOT NULL , `direccion` TEXT NOT NULL,`comuna` TEXT NOT NULL ,`region` TEXT NOT NULL, PRIMARY KEY (`id`)) ENGINE = InnoDB;",tabla);
        sent.execute(query);

    }
    
    public void insertar(String tabla,String med, String dosis, String presentacion, String marca,String farmacia, int precio, String direccion,String comuna,String region){
        try {
            Statement ins=conn.createStatement();
            String query1 = String.format("INSERT INTO `cotiZalud`.`%s` (`id`, `medicamento`, `dosis`, `presentación`, `marca`,`farmacia`, `precio`, `direccion`,`comuna`,`region`) VALUES (NULL, '%s', '%s', '%s', '%s','%s', '%d', '%s','%s','%s');",tabla,med,dosis,presentacion,marca,farmacia,precio,direccion,comuna,region);
            ins.executeUpdate(query1);
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void importarExcel(){
        Excel ex=new Excel();
        for (Row row:ex.getSheet1()){
            if(row.getRowNum()!=0){
            insertar("medicamentos",row.getCell(1).getStringCellValue() , row.getCell(2).getStringCellValue(), row.getCell(3).getStringCellValue(), row.getCell(4).getStringCellValue(), row.getCell(5).getStringCellValue(), (int)row.getCell(6).getNumericCellValue(), row.getCell(7).getStringCellValue(), row.getCell(8).getStringCellValue(), row.getCell(9).getStringCellValue());
        }
        }
    
    }
    public void ver(){
    Statement s;
        try {
            s = conn.createStatement();
            String query2 = "select * from `cotiZalud`.`medicamentos1`";
            ResultSet r = s.executeQuery(query2);
            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }


}
