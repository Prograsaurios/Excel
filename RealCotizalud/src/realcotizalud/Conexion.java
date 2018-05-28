/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realcotizalud;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author diegosaurio
 */
public class Conexion {
 


   private final String user="root";
   private final String password="";
   private final String url= "jdbc:mysql://localhost/cotizalud";
   Connection con;

   public void abrir_conexion(){
       try{
       Class.forName("com.mysql.jdbc.Driver");
       con = (Connection) DriverManager.getConnection(url, user, password);
    }catch (ClassNotFoundException | SQLException e){
           System.out.println(e);
        
   }
}
   public void cerrar_conexion(){
       try{
           if(con!=null){
               con.close();
           }
       }catch(Exception e){
           System.out.println(e);
       }
   }
}
