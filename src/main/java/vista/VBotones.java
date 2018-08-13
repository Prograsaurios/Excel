/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.*;
import java.awt.*;

/**
 * @author raguileoam
 */
class VBotones extends JPanel {

    private JButton btnAgregar;
    private JButton btnEliminar;
    private JButton btnReporte;
    private JButton btnSalir;
    private JPanel izq;
    private JLabel total;
    private JPanel der;

    /**
     *
     */
    public VBotones() {
        super(new BorderLayout());
        initComponents();
    }

    /**
     * @return
     */
    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    /**
     * @return
     */
    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    /**
     * @return
     */
    public JButton getBtnReporte() {
        return btnReporte;
    }

    /**
     * @return
     */
    public JButton getBtnSalir() {
        return btnSalir;
    }

    /**
     * @return
     */
    public JLabel getTotal() {
        return total;
    }

    /**
     *
     */
    private void initComponents() {
        btnAgregar = new JButton("Agregar");
        btnEliminar = new JButton("Eliminar");
        btnReporte = new JButton("Hacer Reporte");
        btnSalir = new JButton("Salir");
        izq = new JPanel();
        JLabel textTotal = new JLabel("Total medicamentos: $");
        total = new JLabel("0");
        der = new JPanel();

        izq.add(btnAgregar);
        izq.add(btnEliminar);
        izq.add(btnReporte);
        der.add(textTotal);
        der.add(total);
        der.add(btnSalir);
        this.add(izq, BorderLayout.WEST);
        this.add(der, BorderLayout.EAST);

    }

}
