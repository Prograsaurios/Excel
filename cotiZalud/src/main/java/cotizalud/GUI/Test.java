/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizalud.GUI;
 import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
/**
 *
 * @author raguileoam
 */
public class Test {
   
//  w ww  .j  a va2  s  . c o m
  public static void main(String[] args) {
    JFrame f = new JFrame("Test");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JTable table = new JTable(new String[][] { { "One" }, { "Two" },
        { "Three" } }, new String[] { "Ordinal" });
    table.addRowSelectionInterval(1, 1);
    f.add(new JScrollPane(table));
    f.pack();
    f.setLocationRelativeTo(null);
    f.setVisible(true);

  }
}
