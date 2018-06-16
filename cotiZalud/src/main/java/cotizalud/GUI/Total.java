/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizalud.GUI;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author raguileoam
 */
public class Total extends DefaultTableCellRenderer{

    private static final int VALIDATION_COLUMN=1;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
        
     Component comp = super.getTableCellRendererComponent( table,  value, isSelected, hasFocus, row, col);
 
     String s =  table.getModel().getValueAt(row,VALIDATION_COLUMN).toString();
 
     if(s.equalsIgnoreCase("1")) 
     {
         comp.setForeground(Color.red);
     }
     else
     {
         comp.setForeground(null);
     }
 
     return( comp );
    }
}
