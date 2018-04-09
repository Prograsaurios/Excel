package prograsaurios.cotiZalud;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellReference;

public class Buscador {
	public static void buscador(String tipo,String palabra) {
		try {
		    InputStream inp = new FileInputStream("medicamentos1.xls");
			HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(inp));
			Sheet sheet1 = wb.getSheetAt(0); //se elije la hoja del excel wb
			//palabra=palabra.toUpperCase(); //Mayusculiza(?) la palabra
			for (Row row : sheet1) {
				for (Cell cell : row) {
					if(row.getCell(1).getStringCellValue().equals(palabra) ) { //por farmacia o medicamento
						filtro(tipo,row,cell);
					}
					else if(row.getCell(5).getStringCellValue().equals(palabra) ) { //por farmacia o medicamento
						filtro(tipo,row,cell);
					}
					}
				}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	public static String[] medicamentos(Row row,Cell cell) {
		String nombre=row.getCell(1).getStringCellValue();
		String marca=row.getCell(4).getStringCellValue();
		String presentacion=row.getCell(3).getStringCellValue();
		double numprecio=row.getCell(6).getNumericCellValue();
		String precio=Double.toString(numprecio);
		String[] arregloMedicamento= {nombre,marca,presentacion,precio}; //nombre,marca,presentacion,precio
		for(String dato:arregloMedicamento) {
			System.out.print(dato +"\t");
		}
		System.out.println("");
		return arregloMedicamento;

	}
	
	public static String[] farmacia(Row row,Cell cell) {
		String farmacia=row.getCell(5).getStringCellValue();
		String comuna=row.getCell(9).getStringCellValue();
		String direccion=row.getCell(7).getStringCellValue();
		String[] arregloFarmacia= {farmacia,comuna,direccion};
		for (String dato:arregloFarmacia) {
			System.out.print(dato + "\t");
		}
		System.out.println("");
		return arregloFarmacia;
	}
	public static void filtro(String tipo, Row row, Cell cell) {
		if (tipo.equals("farmacia")) {
			farmacia(row, cell); //datos de objeto farmacia(hacer)
			}
		else if(tipo.equals("medicamento")){
			medicamentos(row, cell); //datos de objeto medicamento(hacer)
			}
		}
	}