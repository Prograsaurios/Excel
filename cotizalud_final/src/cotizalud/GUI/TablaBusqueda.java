/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizalud.GUI;

import cotizalud.Datos.Reporte;
import cotizalud.Contexto.Medicamento;
import cotizalud.Datos.DB;
import cotizalud.GUI.util.*;
import java.awt.Component;
import java.awt.Font;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.edisoncor.gui.util.WindowDragger;

/**
 *
 * @author diegosaurio
 */
public class TablaBusqueda extends JFrame {
    DefaultTableModel seleccionados;
    Font titulo = new Font("Consolas", Font.PLAIN, 10);

    /**
     * Creates new form Probando
     */
    public TablaBusqueda() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Cotizalud");
        seleccionados = loadSeleccionados();
        tabla.setFont(titulo);
       
    }

    public DefaultTableModel loadMedicamentos(String region, String medicamento, String farmacia) {

        try {
            Medicamento busca = new Medicamento(region, medicamento, farmacia);
            Object[] arreglo = new Object[10];
            ResultSet rs = busca.resp("MEDS");
            DefaultTableModel dtm = new Tabla_Medicamentos();

            dtm.addColumn("ID");
            dtm.addColumn("MEDICAMENTO");
            dtm.addColumn("DOSIS");
            dtm.addColumn("PRESENTACIÓN");
            dtm.addColumn("MARCA");
            dtm.addColumn("FARMACÍA");
            dtm.addColumn("PRECIO");
            dtm.addColumn("DIRECCIÓN");
            dtm.addColumn("COMUNA");
            dtm.addColumn("REGIÓN");

            while (rs.next()) {
                arreglo[0] = rs.getInt("id");
                arreglo[1] = rs.getString("medicamento");
                arreglo[2] = rs.getString("dosis");
                arreglo[3] = rs.getString("presentación");
                arreglo[4] = rs.getString("marca");
                arreglo[5] = rs.getString("farmacía");
                arreglo[6] = rs.getInt("precio");
                arreglo[7] = rs.getString("dirección");
                arreglo[8] = rs.getString("comuna");
                arreglo[9] = rs.getString("región");
                dtm.addRow(arreglo);
            }

            busca.getDb().desconectar();
            return dtm;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public DefaultTableModel loadSeleccionados() {
        DefaultTableModel dtm = new Tabla_Seleccionados();
        dtm.addColumn("MEDICAMENTO");
        dtm.addColumn("DOSIS");
        dtm.addColumn("PRESENTACIÓN");
        dtm.addColumn("MARCA");
        dtm.addColumn("FARMACÍA");
        dtm.addColumn("PRECIO");
        dtm.addColumn("DIRECCIÓN");
        dtm.addColumn("COMUNA");
        dtm.addColumn("REGIÓN");
        dtm.addColumn("CANTIDAD");
        dtm.addColumn("PRECIO TOTAL");
        tabla1
                .setDefaultRenderer(Object.class,
                        new DefaultTableCellRenderer() {
                    @Override
                    public Component getTableCellRendererComponent(JTable table, Object value,
                            boolean isSelected, boolean hasFocus, int row, int column) {

                        if (value instanceof JButton) {
                            JButton btn = (JButton) value;
                            if (isSelected) {
                                btn.setForeground(table.getSelectionForeground());
                                btn.setBackground(table.getSelectionBackground());
                            } else {
                                btn.setForeground(table.getForeground());
                                btn.setBackground(UIManager.getColor("Button.background"));
                            }
                            return btn;
                        }

                        if (value instanceof JCheckBox) {
                            JCheckBox ch = (JCheckBox) value;

                            return ch;
                        }
                        if (value instanceof JSpinner) {
                            JSpinner sp = (JSpinner) value;
                            return sp;
                        }

                        return super.getTableCellRendererComponent(table, value, isSelected,
                                hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
                    }
                });
        dtm.addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent e) {

                if (e.getColumn() == dtm.findColumn("CANTIDAD")) {
                    int cantidad = (Integer) dtm.getValueAt(e.getFirstRow(), dtm.findColumn("CANTIDAD"));
                    int precio = (Integer) dtm.getValueAt(e.getFirstRow(), dtm.findColumn("PRECIO"));
                    int total = cantidad * precio;
                    //System.out.println(total);
                    dtm.setValueAt(total, e.getFirstRow(), dtm.findColumn("PRECIO TOTAL"));

                }
                int num = 0;
                for (int i = 0; i < dtm.getRowCount(); i++) {
                    num = num + (Integer) dtm.getValueAt(i, dtm.findColumn("PRECIO TOTAL"));
                }
                Total.setText(Integer.toString(num));

            }
        });

        return dtm;
    }

    public void consultarProductos() {
        String region = (String) cRegiones.getSelectedItem();
        String medicamento = campoMedicamento.getText();
        String farmacia = (String) cFarmacias.getSelectedItem();
        tabla.setModel(loadMedicamentos(region, medicamento, farmacia));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        filler9 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        btnBuscar = new javax.swing.JButton();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jPanel1 = new javax.swing.JPanel();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(8, 0), new java.awt.Dimension(8, 0), new java.awt.Dimension(8, 32767));
        tRegion = new javax.swing.JLabel();
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(8, 0), new java.awt.Dimension(8, 0), new java.awt.Dimension(8, 32767));
        cRegiones = new javax.swing.JComboBox<>();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(16, 0), new java.awt.Dimension(16, 0), new java.awt.Dimension(16, 32767));
        tMedicamento = new javax.swing.JLabel();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(8, 0), new java.awt.Dimension(8, 0), new java.awt.Dimension(8, 32767));
        campoMedicamento = new javax.swing.JTextField();
        filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(16, 0), new java.awt.Dimension(16, 0), new java.awt.Dimension(16, 32767));
        tFarmacia = new javax.swing.JLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(8, 0), new java.awt.Dimension(8, 0), new java.awt.Dimension(8, 32767));
        cFarmacias = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Total = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        FormListener formListener = new FormListener();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 255, 51));
        setMinimumSize(new java.awt.Dimension(780, 450));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1000, 700));

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));

        jTabbedPane1.setBackground(new java.awt.Color(0, 153, 153));

        jScrollPane1.setBackground(new java.awt.Color(0, 204, 204));

        tabla.setAutoCreateRowSorter(true);
        tabla.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Medicamento", "Dosis", "Presentacion", "Marca", "Farmacia", "Precio", "Direccion", "Comuna", "Region"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setMaximumSize(new java.awt.Dimension(214, 16));
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setHeaderValue("Codigo");
            tabla.getColumnModel().getColumn(1).setHeaderValue("Medicamento");
            tabla.getColumnModel().getColumn(2).setHeaderValue("Dosis");
            tabla.getColumnModel().getColumn(3).setHeaderValue("Presentacion");
            tabla.getColumnModel().getColumn(4).setHeaderValue("Marca");
            tabla.getColumnModel().getColumn(5).setHeaderValue("Farmacia");
            tabla.getColumnModel().getColumn(6).setHeaderValue("Precio");
            tabla.getColumnModel().getColumn(7).setHeaderValue("Direccion");
            tabla.getColumnModel().getColumn(8).setHeaderValue("Comuna");
            tabla.getColumnModel().getColumn(9).setHeaderValue("Region");
        }

        jTabbedPane1.addTab("Medicamentos", jScrollPane1);

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));

        tabla1.setAutoCreateRowSorter(true);
        tabla1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicamento", "Dosis", "Presentacion", "Marca", "Farmacia", "Precio", "Direccion", "Comuna", "Region", "Cantidad", "Precio Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla1.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tabla1);

        jTabbedPane1.addTab("Seleccionados", jScrollPane3);

        btnSalir.setText("Salir");
        btnSalir.setFocusable(false);
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(formListener);

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel3.setName(""); // NOI18N
        jPanel3.setOpaque(false);

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setMinimumSize(new java.awt.Dimension(65, 23));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));
        jPanel2.add(filler9);

        btnBuscar.setText("Buscar");
        btnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscar.setRequestFocusEnabled(false);
        btnBuscar.addActionListener(formListener);
        jPanel2.add(btnBuscar);
        jPanel2.add(filler3);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));
        jPanel1.add(filler4);

        tRegion.setText("Region");
        jPanel1.add(tRegion);
        jPanel1.add(filler7);

        cRegiones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Arica", "Tarapacá", "Antofagasta", "Atacama", "Coquimbo", "Valparaíso", "Metropolitana", "O'higgins", "Maule", "Bio-bío", "Araucanía", "Los Ríos", "Los Lagos", "Aysén", "Magallanes" }));
        jPanel1.add(cRegiones);
        jPanel1.add(filler1);

        tMedicamento.setText("Remedio");
        jPanel1.add(tMedicamento);
        jPanel1.add(filler6);

        campoMedicamento.setMinimumSize(new java.awt.Dimension(120, 20));
        campoMedicamento.setPreferredSize(new java.awt.Dimension(120, 20));
        campoMedicamento.addKeyListener(formListener);
        jPanel1.add(campoMedicamento);
        jPanel1.add(filler8);

        tFarmacia.setText("Farmacia");
        jPanel1.add(tFarmacia);
        jPanel1.add(filler2);

        cFarmacias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cruz Verde", "Ahumada", "Salcobrand", "Dr.Simi" }));
        cFarmacias.setMinimumSize(new java.awt.Dimension(100, 20));
        cFarmacias.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel1.add(cFarmacias);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(47, Short.MAX_VALUE)))
        );

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(formListener);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(formListener);

        btnActualizar.setText("Actualizar Base de Datos");
        btnActualizar.addActionListener(formListener);

        btnReporte.setText("Hacer Reporte");
        btnReporte.addActionListener(formListener);

        jLabel1.setText("Total Medicamentos Selecionados: $");

        Total.setText("0");

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\cotiZalud\\cotizalud_final\\icon.gif")); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(btnReporte)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addComponent(jTabbedPane1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnActualizar))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(77, 77, 77)))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAgregar)
                        .addComponent(btnEliminar)
                        .addComponent(btnReporte)
                        .addComponent(jLabel1)
                        .addComponent(Total)))
                .addContainerGap())
        );

        btnSalir.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener, java.awt.event.KeyListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == btnSalir) {
                TablaBusqueda.this.btnSalirActionPerformed(evt);
            }
            else if (evt.getSource() == btnBuscar) {
                TablaBusqueda.this.btnBuscarActionPerformed(evt);
            }
            else if (evt.getSource() == btnAgregar) {
                TablaBusqueda.this.btnAgregarActionPerformed(evt);
            }
            else if (evt.getSource() == btnEliminar) {
                TablaBusqueda.this.btnEliminarActionPerformed(evt);
            }
            else if (evt.getSource() == btnActualizar) {
                TablaBusqueda.this.btnActualizarActionPerformed(evt);
            }
            else if (evt.getSource() == btnReporte) {
                TablaBusqueda.this.btnReporteActionPerformed(evt);
            }
        }

        public void keyPressed(java.awt.event.KeyEvent evt) {
        }

        public void keyReleased(java.awt.event.KeyEvent evt) {
        }

        public void keyTyped(java.awt.event.KeyEvent evt) {
            if (evt.getSource() == campoMedicamento) {
                TablaBusqueda.this.campoMedicamentoKeyTyped(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void campoMedicamentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoMedicamentoKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_campoMedicamentoKeyTyped

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        consultarProductos();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        int num = tabla.getSelectedRow();
        if (num == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un elemento de Medicamentos", "Atención", JOptionPane.WARNING_MESSAGE);
        } else {
            TableModel model = tabla.getModel();
            Object[] obj = new Object[11];
            for (int i = 0; i < 9; i++) {
                obj[i] = (model.getValueAt(num, i + 1));
            }
            obj[9] = 1;
            obj[10] = (Integer) obj[5] * (Integer) obj[9]; //Hacer que se actualize respecto al de arriba
            seleccionados.addRow(obj);
            tabla1.setModel(seleccionados);
            tabla1.getColumn("CANTIDAD").setCellEditor(new SpinnerEditor()); //Intentar mover fuera de este método
            tabla1.getColumn("PRECIO TOTAL").setCellRenderer(new Total());
        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int num = tabla1.getSelectedRow();
        if (num == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un elemento de Seleccionados", "Atención", JOptionPane.WARNING_MESSAGE);
        } else {
            seleccionados.removeRow(num);
            tabla1.setModel(seleccionados);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
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
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        // TODO add your handling code here:
         Reporte.utilJTableToPdf(tabla1, new File("pdfJTables.pdf"), "(Código Xules)");
         JOptionPane.showMessageDialog(null, "El reporte ha sido creado.", "CotiZalud Informa:", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_btnReporteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Total;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cFarmacias;
    private javax.swing.JComboBox<String> cRegiones;
    private javax.swing.JTextField campoMedicamento;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.Box.Filler filler8;
    private javax.swing.Box.Filler filler9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel tFarmacia;
    private javax.swing.JLabel tMedicamento;
    private javax.swing.JLabel tRegion;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tabla1;
    // End of variables declaration//GEN-END:variables
}
