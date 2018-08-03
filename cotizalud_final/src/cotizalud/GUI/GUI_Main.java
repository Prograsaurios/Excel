/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizalud.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

/**
 *
 * @author raguileoam
 */
public class GUI_Main extends JFrame implements ActionListener{
    private GUI_Medicamentos gMeds;
    private GUI_Seleccionados gSelects;
    private GUI_Busqueda gBusqueda;
    private JScrollPane spMeds; 
    private JScrollPane spSelects;
    private GUI_Botones gBotones;
    private JTabbedPane tablas;
    

    public GUI_Main(){
        super();
        initWindow();
        initComponents();
        

    }
    public void initComponents(){
        gMeds=new GUI_Medicamentos();
        gSelects=new GUI_Seleccionados();
        gBusqueda=new  GUI_Busqueda();
        this.add(gBusqueda,BorderLayout.NORTH);
        spMeds = new JScrollPane();
        spMeds.setViewportView(gMeds);
        spSelects = new JScrollPane();
        spSelects.setViewportView(gSelects);
        tablas=new JTabbedPane();
        tablas.addTab("Medicamentos", spMeds);
        tablas.addTab("Seleccionados", spSelects);
        this.add(tablas);
        gBotones=new GUI_Botones();
        this.add(gBotones,BorderLayout.SOUTH);
       
    
    }
    public void initWindow(){
        //this.setLocationRelativeTo(null);
        this.setTitle("Cotizalud");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBackground(Color.yellow);
        setSize(800, 600);
        //setUndecorated(true);
        setLayout(new BorderLayout());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
    
}
