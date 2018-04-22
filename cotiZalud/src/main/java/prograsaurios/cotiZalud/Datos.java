package prograsaurios.cotiZalud;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class Datos {
	InputStream inp;
	HSSFWorkbook wb;
	Sheet sheet1; // se elije la hoja del excel wb
	ArrayList<Row> lista = new ArrayList<Row>();

	public Datos() {
		setDatos();
	}

	public void setDatos() {
		try {
			inp = new FileInputStream("medicamentos1.xls");
			wb = new HSSFWorkbook(new POIFSFileSystem(inp));
			sheet1 = wb.getSheetAt(0); // se elije la hoja del excel wb
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void busca_fila(String tipo, String palabra) {
		int index = 0;
		for (Cell cell : sheet1.getRow(0)) {
			if (cell.toString().equals(tipo)) {
				index = cell.getColumnIndex();
				break;
				}
			}
		lista.add(sheet1.getRow(0));
		
		for (Row row : sheet1) {
			if (row.getCell(index).toString().equals(palabra)) {
				lista.add(row);
			}
		}
	}	
	
	public void restriccion(String palabra,String tipo){
		int index = 0;
		for (Cell cell : lista.get(0)) {
			if (cell.toString().equals(tipo)) {
				index = cell.getColumnIndex();
				break;
			}
		}
		lista.add(sheet1.getRow(0));
		for (Row row : lista) {
			if (row.getCell(index).toString().equals(palabra)) {
				lista.add(row);
			}
		}
		
	}
}