/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizalud.GUI;

import cotizalud.Datos.Reporte;
import cotizalud.GUI.util.SpinnerEditor;
import cotizalud.GUI.util.Total;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author raguileoam
 */
public class GUI_Main extends JFrame implements ActionListener, KeyListener {

    private GUI_Medicamentos gMeds;
    private GUI_Seleccionados gSelects;
    private GUI_Busqueda gBusqueda;
    private JScrollPane spMeds;
    private JScrollPane spSelects;
    private GUI_Botones gBotones;
    private JTabbedPane tablas;

    public GUI_Main() {
        super();
        initWindow();
        initComponents();
        addEvents();
    }

    public void initComponents() {
        gMeds = new GUI_Medicamentos();
        gSelects = new GUI_Seleccionados();
        gBusqueda = new GUI_Busqueda();
        this.add(gBusqueda, BorderLayout.NORTH);
        spMeds = new JScrollPane();
        spMeds.setViewportView(gMeds);
        spSelects = new JScrollPane();
        spSelects.setViewportView(gSelects);
        tablas = new JTabbedPane();
        tablas.addTab("Medicamentos", spMeds);
        tablas.addTab("Seleccionados", spSelects);
        this.add(tablas);
        gBotones = new GUI_Botones();
        this.add(gBotones, BorderLayout.SOUTH);

    }

    public void addEvents() {
        gBusqueda.getBuscar().addActionListener(this);
        gBusqueda.getActualizar().addActionListener(this);
        gBusqueda.getTfMedicamento().addKeyListener(this);
        gBotones.getBtnAgregar().addActionListener(this);
        gBotones.getBtnEliminar().addActionListener(this);
        gBotones.getBtnReporte().addActionListener(this);
        gBotones.getBtnSalir().addActionListener(this);
    }

    public void initWindow() {
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
        if (ae.getSource() == gBusqueda.getBuscar()) {
            System.out.print("Buscando...");
            System.out.println(gBusqueda.getTfMedicamento().getText());
            DefaultTableModel tm = gMeds.loadMedicamentos((String) gBusqueda.getcRegiones().getSelectedItem(), gBusqueda.getTfMedicamento().getText(), (String) gBusqueda.getcFarmacias().getSelectedItem());
            gMeds.setModel(tm);
        }
        if (ae.getSource() == gBusqueda.getActualizar()) {
            System.out.print("Actualizando...");
            
            gBusqueda.actualizar();

        }
        if (ae.getSource() == gBotones.getBtnAgregar()) {
            int num = gMeds.getSelectedRow();
            if (num == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione un elemento de Medicamentos", "Atención", JOptionPane.WARNING_MESSAGE);
            } else {

                Object[] obj = new Object[11];
                for (int i = 0; i < 9; i++) {
                    obj[i] = (gMeds.getValueAt(num, i + 1)); //Para futuro, si se accede al valor del modelo y se ordena, la tabla no manda data actualizados
                }
                obj[9] = 1;
                obj[10] = (Integer) obj[5] * (Integer) obj[9]; //Hacer que se actualize respecto al de arriba
                gSelects.getDtm().addRow(obj);
                gSelects.setModel(gSelects.getDtm());
                gSelects.getColumn("CANTIDAD").setCellEditor(new SpinnerEditor()); //Intentar mover fuera de este método
                gSelects.getColumn("PRECIO TOTAL").setCellRenderer(new Total());
            }

        }
        if (ae.getSource() == gBotones.getBtnEliminar()) {
            int num = gSelects.getSelectedRow();
            if (num == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione un elemento de Seleccionados", "Atención", JOptionPane.WARNING_MESSAGE);
            } else {
                gSelects.getDtm().removeRow(num);
                gSelects.setModel(gSelects.getDtm());
            }
        }
        if (ae.getSource() == gBotones.getBtnReporte()) {
            Reporte.utilJTableToPdf(gSelects, new File("pdfJTables.pdf"), "(Código Xules)");
            JOptionPane.showMessageDialog(null, "El reporte ha sido creado.", "CotiZalud Informa:", JOptionPane.INFORMATION_MESSAGE);

        }
        if (ae.getSource() == gBotones.getBtnSalir()) {
            dispose();
        }
    }

    @Override
    public void keyTyped(KeyEvent evt) {
        if (evt.getSource() == gBusqueda.getTfMedicamento()) {    
            char c = evt.getKeyChar();
            if (Character.isLowerCase(c)) {
                String cad = ("" + c).toUpperCase();
                c = cad.charAt(0);
                evt.setKeyChar(c);
            }
             Pattern patron = Pattern.compile("[^A-Z]"); //si el patron es diferente a A-Z
             Matcher encaja = patron.matcher(String.valueOf(c));
             if(encaja.find()){
                 evt.setKeyChar((char)0); //https://stackoverflow.com/questions/18410234/how-does-one-represent-the-empty-char
             }
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

}
