/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizalud.GUI;

import java.awt.BorderLayout;
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
    private JPanel izq;
    private JPanel center;
    private JPanel der;
    
    public GUI_Botones() {
        super(new BorderLayout());
        initComponents();
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JButton getBtnReporte() {
        return btnReporte;
    }

    public void setBtnReporte(JButton btnReporte) {
        this.btnReporte = btnReporte;
    }

    public JButton getBtnSalir() {
        return btnSalir;
    }

    public void setBtnSalir(JButton btnSalir) {
        this.btnSalir = btnSalir;
    }

    public void initComponents() {
        btnAgregar=new JButton("Agregar");
        btnEliminar=new JButton("Eliminar");
        btnReporte=new JButton("Hacer Reporte");
        btnSalir=new JButton("Salir");
        izq=new JPanel();
        center=new JPanel();
        der=new JPanel();
        
        izq.add(btnAgregar);
        izq.add(btnEliminar);
        izq.add(btnReporte);
        der.add(btnSalir);
        this.add(izq,BorderLayout.WEST);
        this.add(der,BorderLayout.EAST);
        btnAgregar.addActionListener(this);
        btnEliminar.addActionListener(this);
        btnReporte.addActionListener(this);
        btnSalir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==getBtnAgregar()){}
        if (ae.getSource()==getBtnEliminar()){}
        if (ae.getSource()==getBtnReporte()){}
        if (ae.getSource()==getBtnSalir()){}


    }
    
}
