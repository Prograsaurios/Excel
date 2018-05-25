/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizalud.datos;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import cotizalud.cotiZalud.Medicamento;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
public class Excel {
	private InputStream inp;
	private HSSFWorkbook wb;

    public InputStream getInp() {
        return inp;
    }

    public void setInp(InputStream inp) {
        this.inp = inp;
    }

    public HSSFWorkbook getWb() {
        return wb;
    }

    public void setWb(HSSFWorkbook wb) {
        this.wb = wb;
    }

    public Sheet getSheet1() {
        return sheet1;
    }

    public void setSheet1(Sheet sheet1) {
        this.sheet1 = sheet1;
    }
	private Sheet sheet1; // se elije la hoja del excel wb
	private ArrayList<Row> lista = new ArrayList<Row>();

	public Excel() {
		setDatos("medicamentos1.xls",0);
	}

	public void setDatos(String excel,int hoja) {
		try {
			inp = new FileInputStream(excel);
			wb = new HSSFWorkbook(new POIFSFileSystem(inp));
			sheet1 = wb.getSheetAt(hoja); // se elije la hoja del excel wb
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


        public void toMySQL(){
            for (Row row : sheet1) { 
                
            }
        }
     
           
	public ArrayList<Row> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Row> lista) {
		this.lista = lista;
	}
}
