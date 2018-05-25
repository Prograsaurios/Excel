/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizalud.datos;

import java.sql.SQLException;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author Usuario
 */
public class Main {
    public static void main(String[] args) throws SQLException{
        DB co = new DB();
<<<<<<< HEAD
        co.usarDatabase("cotizalud");
        co.crearTabla("cotizalud","medicamentos");
=======
        //co.crearTabla("medicamentos");
>>>>>>> 3461cda15eddd7f62fc91a0285360d68b85d1e7a
        co.importarExcel();
        co.desconectar();
    }
}
