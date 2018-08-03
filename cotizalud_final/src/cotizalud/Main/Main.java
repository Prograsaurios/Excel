/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizalud.Main;

import cotizalud.GUI.GUI_Busqueda;
import cotizalud.GUI.GUI_Main;
import cotizalud.GUI.GUI_Medicamentos;
import cotizalud.GUI.TablaBusqueda;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 * Clase principal
 * @author Prograsaurios
 */
public class Main {

    /**
     * Metodo principal que usa en el proyecto
     * @param args argumentos
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception{
     //TablaBusqueda t=new TablaBusqueda();
     GUI_Main t=new GUI_Main();
     t.setVisible(true);


    }

}
