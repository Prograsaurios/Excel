/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizalud.GUI;

import cotizalud.Datos.DB;
import java.awt.BorderLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author raguileoam
 */
public class GUI_Busqueda extends JPanel {

    private JComboBox<String> cFarmacias;
    private JComboBox<String> cRegiones;
    private JTextField tfMedicamento;
    private JLabel lMedicamento;
    private JLabel lRegion;
    private JLabel lFarmacia;
    private JPanel pCentro;
    private JButton buscar;
    private JPanel pSur;
    private JPanel pNorte;
    private JButton actualizar;

    /**
     *
     */
    public GUI_Busqueda() {
        super(new BorderLayout());
        initPanel();
        this.pCentro = new JPanel();
        this.cFarmacias = new JComboBox<>(new String[]{"Cruz Verde", "Ahumada", "Salcobrand"});
        this.cRegiones = new JComboBox<>(new String[]{"Arica", "Tarapacá", "Antofagasta", "Atacama", "Coquimbo", "Valparaíso", "Metropolitana", "O\'higgins", "Maule", "Bio-bío", "Araucanía", "Los Ríos", "Los Lagos", "Aysén", "Magallanes"});
        this.tfMedicamento = new JTextField(20);
        this.lMedicamento = new JLabel("Medicamento");
        this.lFarmacia = new JLabel("Farmacia");
        this.lRegion = new JLabel("Región");
        this.buscar = new JButton("Buscar");
        this.pSur = new JPanel();

        this.actualizar = new JButton("Actualizar Base de Datos");
        this.pNorte = new JPanel(new BorderLayout());
        addComponents();

    }

    void initPanel() {

    }

    /**
     *
     * @return
     */
    public JButton getBuscar() {
        return buscar;
    }

    /**
     *
     * @param buscar
     */
    public void setBuscar(JButton buscar) {
        this.buscar = buscar;
    }

    /**
     *
     * @return
     */
    public JButton getActualizar() {
        return actualizar;
    }

    /**
     *
     * @param actualizar
     */
    public void setActualizar(JButton actualizar) {
        this.actualizar = actualizar;
    }

    void addComponents() {

        pCentro.add(lFarmacia);
        pCentro.add(cFarmacias);
        pCentro.add(lMedicamento);
        pCentro.add(tfMedicamento);
        pCentro.add(lRegion);
        pCentro.add(cRegiones);
        this.add(pCentro, BorderLayout.CENTER);

        pSur.add(buscar);
        this.add(pSur, BorderLayout.SOUTH);

        pNorte.add(actualizar, BorderLayout.EAST);

        this.add(pNorte, BorderLayout.NORTH);
    }

    /**
     *
     * @return
     */
    public JComboBox<String> getcFarmacias() {
        return cFarmacias;
    }

    /**
     *
     * @param cFarmacias
     */
    public void setcFarmacias(JComboBox<String> cFarmacias) {
        this.cFarmacias = cFarmacias;
    }

    /**
     *
     * @return
     */
    public JComboBox<String> getcRegiones() {
        return cRegiones;
    }

    /**
     *
     * @param cRegiones
     */
    public void setcRegiones(JComboBox<String> cRegiones) {
        this.cRegiones = cRegiones;
    }

    /**
     *
     * @return
     */
    public JTextField getTfMedicamento() {
        return tfMedicamento;
    }

    /**
     *
     * @param tfMedicamento
     */
    public void setTfMedicamento(JTextField tfMedicamento) {
        this.tfMedicamento = tfMedicamento;
    }

    /**
     *
     */
    public void actualizar() {
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(null, "¿Desea actualizar la base de datos? Este proceso demora unos minutos.", "Cotizalud consulta:", JOptionPane.YES_NO_OPTION) == 0) {
            try {
                DB db = new DB();
                db.loadData();

            } catch (Exception ex) {
                Logger.getLogger(TablaBusqueda.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "La base de datos ha sido actualizada.", "CotiZalud Informa:", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "Error en la actualización.", "CotiZalud Informa:", JOptionPane.ERROR_MESSAGE);
        }
    }

}
