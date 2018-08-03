/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizalud.GUI;

import cotizalud.Contexto.Medicamento;
import cotizalud.Datos.DB;
import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author raguileoam
 */
public class GUI_Busqueda extends JPanel implements ActionListener{
    private JComboBox<String> cFarmacias;
    private JComboBox<String> cRegiones;
    private JTextField tfMedicamento;
    private JLabel lMedicamento;
    private JLabel lRegion;
    private JLabel lFarmacia;
    private JLabel logo;
    private JPanel pCentro;
    private JButton buscar;
    private JPanel pSur;
    private JPanel pNorte;
    private JButton actualizar;

    public GUI_Busqueda() {
        super(new BorderLayout());
        initPanel();
        this.pCentro=new JPanel();
        this.cFarmacias = new JComboBox<>(new String[] { "Cruz Verde", "Ahumada", "Salcobrand"});
        this.cRegiones = new JComboBox<>(new String[] { "Arica", "Tarapacá", "Antofagasta", "Atacama", "Coquimbo", "Valparaíso", "Metropolitana", "O'higgins", "Maule", "Bio-bío", "Araucanía", "Los Ríos", "Los Lagos", "Aysén", "Magallanes" });
        this.tfMedicamento = new JTextField(20);
        this.lMedicamento = new JLabel("Medicamento");
        this.lFarmacia = new JLabel("Farmacia");
        this.lRegion = new JLabel("Región");
        this.buscar=new JButton("Buscar");
        this.pSur=new JPanel();
        
        this.actualizar=new JButton("Actualizar Base de Datos");
        this.pNorte=new JPanel(new BorderLayout());
        addComponents();

        
    }
    void initPanel(){
    
    }
    void addComponents(){
        
    pCentro.add(lFarmacia);
    pCentro.add(cFarmacias);
    pCentro.add(lMedicamento);
    pCentro.add(tfMedicamento);
    pCentro.add(lRegion);
    pCentro.add(cRegiones);
    this.add(pCentro,BorderLayout.CENTER);
    
    pSur.add(buscar);
    buscar.addActionListener(this);
    this.add(pSur,BorderLayout.SOUTH);
    
    pNorte.add(actualizar,BorderLayout.EAST);
    actualizar.addActionListener(this);
  
    this.add(pNorte,BorderLayout.NORTH);    
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==buscar){
            System.out.print("Buscando...");
            consultarProductos();
        }
        if(ae.getSource()==actualizar){
            System.out.print("Actualizando...");
            actualizar();

        }
    }
    
      public void consultarProductos() {
        String region = (String) cRegiones.getSelectedItem();
        String medicamento = tfMedicamento.getText();
        String farmacia = (String) cFarmacias.getSelectedItem();
        //setModel(loadMedicamentos(region, medicamento, farmacia));
    }
      
    public void actualizar(){
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
