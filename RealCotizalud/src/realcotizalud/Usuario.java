/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realcotizalud;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;

public class Usuario extends Conexion{
    
    
    int id;
    String usuario;
    String password;
    int permiso;


    public Usuario(){
    
    }
    
    
    public Usuario(int id, String u, String p, int per) {
        this.id = id;
        usuario = u;
        password = p;
        permiso=per;
    }

    public void alta() {
        try {
            this.abrir_conexion();
            Statement st = (Statement) con.createStatement();
            st.executeUpdate("INSERT INTO usuario VALUES (null,'" + this.usuario + "','" + this.password + "'," + this.permiso + ")");//insertar tabla usuario y valores sgtes
            this.cerrar_conexion();
            System.out.println("Usuario insertado");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean validarUsuario(String u, String p) {
        try {
            boolean bandera = false;
            this.abrir_conexion();
            Statement st = (Statement) con.createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM usuario WHERE nombre='" + u + "' AND password='" + p + "'");
            if (resultado.next()) {
                if (u.equals(resultado.getString("nombre")) && p.equals(resultado.getString("password"))) {
                    this.cerrar_conexion();
                    return true;
                }
            }
            this.cerrar_conexion();
            return false;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPermiso() {
        return permiso;
    }

    public void setPermiso(int permiso) {
        this.permiso = permiso;
    }

    
}
