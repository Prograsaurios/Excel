/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizalud.Datos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import cotizalud.Contexto.Usuario;
import java.io.IOException;

/**
 * Clase que conecta base de Datos MySQL con el proyecto cotiZalud
 */
public class DB { 

    private static Connection conn;
    private String user;
    private String password;
    private String url ;

    /**
     * Construye la conexión entre el servidor con base de datos y el proyecto
     */
    public DB() {
        conn = null;
        url = "jdbc:mysql://localhost:3306/?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        user = "root";
        password = "root";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Retorna la conexión con MySQL
     * @return esta conexión (Connection)
     */
    public Connection getConn() {
        return conn;
    }

    /**
     * Cierra la conexión con el servidor
     * @throws SQLException Si hay una excepción en SQL
     */
    public void desconectar() throws SQLException {
        conn.close();
    }

    /**
     * Usa la base datos que se indica. Si no existe la crea.
     * @param database Nombre de la base de datos
     */
    public void usarDatabase(String database) {
        try {
            Statement sent = conn.createStatement();
            String crear = "CREATE DATABASE IF NOT EXISTS " + database + ";";
            String usar = "use " + database + ";";
            sent.execute(crear);
            sent.execute(usar);
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Crea una tabla en la base de datos si no existe
     *
     * @param database Nombre de la base de datos a usar
     * @param tabla Nombre de la tabla en la base de datos a usar
     * @throws SQLException
     */
    public void crearTabla(String database, String tabla) throws SQLException {
        Statement sent = conn.createStatement();
        String query = String.format("CREATE TABLE IF NOT EXISTS `%s`.`%s` ( `id` INT NOT NULL AUTO_INCREMENT , `medicamento` TEXT NOT NULL , `dosis` TEXT NOT NULL , `presentación` TEXT NOT NULL ,`marca` TEXT NOT NULL, `farmacia` TEXT NOT NULL , `precio` INT NOT NULL , `direccion` TEXT NOT NULL,`comuna` TEXT NOT NULL ,`region` TEXT NOT NULL, PRIMARY KEY (`id`)) ENGINE = InnoDB;", database, tabla);
        sent.execute(query);

    }

    /**
     * Importa archivo txt a MySQL
     * @param dirTxt directorio de archivo TXT
     * @param tabla
     * @throws java.sql.SQLException
     */
    public void impTxt(String dirTxt, String tabla) throws SQLException {
        Statement ins = conn.createStatement();
        String query1 = String.format("LOAD DATA INFILE '%s' INTO TABLE %s IGNORE 1 LINES;", dirTxt, tabla);
        ins.executeUpdate(query1);
    }

    /**
     * Usa clase Descarga, ConvertidorTXT y DB para llevar los datos a MYSQL
     * @throws IOException
     * @throws Exception
     */
    public void loadData() throws IOException, Exception {
        Descarga d = new Descarga();
        ConvertidorTXT a = new ConvertidorTXT("descargas/medicamentos.xls");
        usarDatabase("cotizalud");
        crearTabla("cotizalud", "medicamentos");
        impTxt("C:/Users/Usuario/Desktop/Eclipse/cotiZalud/cotiZalud/descargas/medicamentos.txt", "`cotizalud`.`medicamentos`");
        desconectar();
    }

    /**
     *
     * @param user
     * @param tabla
     * @return
     */
    public boolean validarUsuario(Usuario user,String tabla) {
        try {
            Statement st = (Statement) getConn().createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM "+tabla +" WHERE nombre='" + user.getNombre() + "' AND password='" + user.getPassword() + "'");
            if (resultado.next()) {
                if (user.getNombre().equals(resultado.getString("nombre")) && user.getPassword().equals(resultado.getString("password"))) {
                    desconectar();
                    return true;
                }
            }
            desconectar();
            return false;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    /**
     *
     * @param user
     * @param tabla
     */
    public void insertarUsuario(Usuario user,String tabla){
        try {
            Statement st = (Statement) getConn().createStatement();
            st.executeUpdate("INSERT INTO "+ tabla +" VALUES (null,'" + user.getNombre() + "','" + user.getPassword() + "'," + user.getPermiso() + ")");//insertar tabla usuario y valores sgtes
            desconectar();
            System.out.println("Usuario insertado");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
