/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizalud.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author raguileoam
 */
public class GUI_Botones extends JPanel implements ActionListener{
    private JButton btnAgregar;
    private JButton btnEliminar;
    private JButton btnReporte;
    private JButton btnSalir;
    

    public GUI_Botones() {
        super();
        initComponents();
    }

    public void initComponents() {
        btnAgregar=new JButton("Agregar");
        btnEliminar=new JButton("Eliminar");
        btnReporte=new JButton("Hacer Reporte");
        btnSalir=new JButton("Salir");
        this.add(btnAgregar);
        this.add(btnEliminar);
        this.add(btnReporte);
        this.add(btnSalir);
        btnAgregar.addActionListener(this);
        btnEliminar.addActionListener(this);
        btnReporte.addActionListener(this);
        btnSalir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==btnAgregar){}
        if (ae.getSource()==btnEliminar){}
        if (ae.getSource()==btnReporte){}
        if (ae.getSource()==btnSalir){}


    }
    
}
