/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizalud.Main;

import cotizalud.Datos.DB;
import cotizalud.GUI.Login;
import cotizalud.GUI.TablaBusqueda;

/**
 * Clase principal
 * @author Prograsaurios
 */
public class Main {

    /**
     * Metodo principal que usa en el proyecto
     * @param args argumentos
     */
    public static void main(String[] args) throws Exception{
    // Login b=new Login();
     //b.setVisible(true);
     //DB d=new DB();
     //d.loadData();
     TablaBusqueda t=new TablaBusqueda();
     t.setVisible(true);

    }

}
