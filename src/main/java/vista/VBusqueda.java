package vista;

import datos.DB;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class VBusqueda extends JPanel {

    private JComboBox<String> cFarmacias;
    private JComboBox<String> cRegiones;
    private JTextField tfMedicamento;
    private final JLabel lMedicamento;
    private final JLabel lRegion;
    private final JLabel lFarmacia;
    private final JPanel pCentro;
    private JButton buscar;
    private final JPanel pSur;
    private final JPanel pNorte;
    private JButton actualizar;

    /**
     *
     */
    public VBusqueda() {
        super(new BorderLayout());
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

    /**
     * @return
     */
    public JButton getBuscar() {
        return buscar;
    }

    /**
     * @return
     */
    public JButton getActualizar() {
        return actualizar;
    }

    private void addComponents() {

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
     * @return
     */
    public JComboBox<String> getcFarmacias() {
        return cFarmacias;
    }

    /**
     * @return
     */
    public JComboBox<String> getcRegiones() {
        return cRegiones;
    }

    /**
     * @return
     */
    public JTextField getTfMedicamento() {
        return tfMedicamento;
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
