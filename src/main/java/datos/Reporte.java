/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author raguileoam, originally from
 * http://codigoxules.org/java-itext-pdf-creando-pdf-java-itext/
 */
public class Reporte {

    private static final Font categoryFont = new Font(Font.TIMES_ROMAN, 18, Font.BOLD);
    private static final Font subCategoryFont = new Font(Font.TIMES_ROMAN, 16, Font.BOLD);
    private static final Font small = new Font(Font.TIMES_ROMAN, 7, Font.BOLD);
    private static final String dia = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

    /**
     * @param jTable
     * @param pdfNewFile
     */
    public static void utilJTableToPdf(JTable jTable, File pdfNewFile) {
        try {
            // We create the document and set the file name.        
            // Creamos el documento e indicamos el nombre del fichero.
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(pdfNewFile));
            document.open();
            // We add metadata to PDF
            // Añadimos los metadatos del PDF
            document.addTitle("Medicamentos " + dia);
            document.addAuthor("cotiZalud");
            // First page (Primera página)
            Anchor anchor = new Anchor("Medicamentos " + dia, categoryFont);

            // Second parameter is the number of the chapter (El segundo parámetro es el número del capítulo).
            Paragraph subPara = new Paragraph("Cotizalud ", subCategoryFont);
            Paragraph v = new Paragraph(" ", subCategoryFont);
            // Create the table (Creamos la tabla)
            PdfPTable table = new PdfPTable(jTable.getColumnCount());
            table.calculateHeightsFast();
            // Now we fill the rows of the PdfPTable (Ahora llenamos las filas de PdfPTable)
            PdfPCell columnHeader;
            // Fill table columns header 
            // Rellenamos las cabeceras de las columnas de la tabla.                
            for (int column = 0; column < jTable.getColumnCount(); column++) {
                columnHeader = new PdfPCell(new Paragraph(jTable.getColumnName(column), small));
                table.addCell(columnHeader);
            }

            table.setHeaderRows(1);
            // Fill table rows (rellenamos las filas de la tabla).                
            for (int row = 0; row < jTable.getRowCount(); row++) {
                for (int column = 0; column < jTable.getColumnCount(); column++) {
                    table.addCell(new Paragraph(jTable.getValueAt(row, column).toString(), small));
                }
            }

            document.add(anchor);
            document.add(subPara);
            document.add(v);
            document.add(table);

            document.close();
        } catch (DocumentException documentException) {
            System.out.println("The file not exists (Se ha producido un error al generar un documento): "
                    + documentException);

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("No such file was found to generate the PDF (No se encontró el fichero para generar el pdf)"
                    + fileNotFoundException);
        }
    }
}
