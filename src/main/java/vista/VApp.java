package vista;

import datos.Reporte;
import vista.util.SpinnerEditor;
import vista.util.Total;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author raguileoam
 */
public class VApp extends JFrame implements ActionListener, KeyListener, TableModelListener {

    private VMedicamentos gMeds;
    private VSeleccionados gSelects;
    private VBusqueda gBusqueda;
    private VBotones gBotones;

    /**
     *
     */
    public VApp() {
        super();
        initWindow();
        initComponents();
        addEvents();
    }

    /**
     *
     */
    private void initComponents() {
        gMeds = new VMedicamentos();
        gSelects = new VSeleccionados();
        gBusqueda = new VBusqueda();
        this.add(gBusqueda, BorderLayout.NORTH);
        JScrollPane spMeds = new JScrollPane();
        spMeds.setViewportView(gMeds);
        JScrollPane spSelects = new JScrollPane();
        spSelects.setViewportView(gSelects);
        JTabbedPane tablas = new JTabbedPane();
        tablas.addTab("Medicamentos", spMeds);
        tablas.addTab("Seleccionados", spSelects);
        this.add(tablas);
        gBotones = new VBotones();
        this.add(gBotones, BorderLayout.SOUTH);

    }

    /**
     *
     */
    private void addEvents() {
        gBusqueda.getBuscar().addActionListener(this);
        gBusqueda.getActualizar().addActionListener(this);
        gBusqueda.getTfMedicamento().addKeyListener(this);
        gBotones.getBtnAgregar().addActionListener(this);
        gBotones.getBtnEliminar().addActionListener(this);
        gBotones.getBtnReporte().addActionListener(this);
        gBotones.getBtnSalir().addActionListener(this);
        gSelects.getDtm().addTableModelListener(this);
    }

    /**
     *
     */
    private void initWindow() {
        //this.setLocationRelativeTo(null);
        this.setTitle("Cotizalud");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBackground(Color.yellow);
        setSize(800, 600);
        //setUndecorated(true);
        setLayout(new BorderLayout());
    }

    /**
     * @param ae
     */
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
                gSelects.getColumn("Cantidad").setCellEditor(new SpinnerEditor()); //Intentar mover fuera de este método
                gSelects.getColumn("Precio total").setCellRenderer(new Total());
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
            Reporte.utilJTableToPdf(gSelects, new File("ReporteCotiZalud.pdf"));
            JOptionPane.showMessageDialog(null, "El reporte ha sido creado.", "CotiZalud Informa:", JOptionPane.INFORMATION_MESSAGE);

        }
        if (ae.getSource() == gBotones.getBtnSalir()) {
            dispose();
        }
    }

    /**
     * @param evt
     */
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
            if (encaja.find()) {
                evt.setKeyChar((char) 0); //https://stackoverflow.com/questions/18410234/how-does-one-represent-the-empty-char
            }
        }
    }

    /**
     * @param ke
     */

    public void keyPressed(KeyEvent ke) {

    }

    /**
     * @param ke
     */

    public void keyReleased(KeyEvent ke) {
    }

    /**
     * @param e
     */

    public void tableChanged(TableModelEvent e) {
        if (e.getSource() == gSelects.getDtm()) {
            if (e.getColumn() == gSelects.getDtm().findColumn("Cantidad")) {
                int cantidad = (Integer) gSelects.getValueAt(e.getFirstRow(), gSelects.getDtm().findColumn("Cantidad"));
                int precio = (Integer) gSelects.getValueAt(e.getFirstRow(), gSelects.getDtm().findColumn("Precio"));
                int total = cantidad * precio;
                gSelects.setValueAt(total, e.getFirstRow(), gSelects.getDtm().findColumn("Precio total"));

            }
            int num = 0;
            for (int i = 0; i < gSelects.getRowCount(); i++) {
                num = num + (Integer) gSelects.getValueAt(i, gSelects.getDtm().findColumn("Precio total"));
            }
            gBotones.getTotal().setText(Integer.toString(num));
        }
    }

}
