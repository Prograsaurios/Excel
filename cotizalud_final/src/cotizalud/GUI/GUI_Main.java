/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizalud.GUI;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 *
 * @author raguileoam
 */
public class GUI_Main extends JFrame{
    private GUI_Medicamentos gMeds;
    private GUI_Seleccionados gSelects;
    private GUI_Busqueda gBusqueda;
    private JScrollPane scrollPane;
    private GUI_Botones gBotones;
    

    public GUI_Main(){
        super();
        initWindow();
        initComponents();
        

    }
    public void initComponents(){
        gMeds=new GUI_Medicamentos();
      //  gSelects=new GUI_Seleccionados();
        gBusqueda=new  GUI_Busqueda();
        this.add(gBusqueda,BorderLayout.NORTH);
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(gMeds);
        this.add(scrollPane);
        gBotones=new GUI_Botones();
        this.add(gBotones,BorderLayout.SOUTH);
    
    }
    public void initWindow(){
        //this.setLocationRelativeTo(null);
        this.setTitle("Cotizalud");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        //setUndecorated(true);
        setLayout(new BorderLayout());
    }
  
    
}
