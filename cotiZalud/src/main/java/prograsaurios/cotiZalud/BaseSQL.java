package prograsaurios.cotiZalud;
import com.mysql.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
//import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.*;

public class BaseSQL {
	
	public static void main(String[] args) throws Exception {

	    try {

	        Class forName = Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = null;
	        String BD_URL = "jdbc:mysql://localhost:3036/bd_name?useTimezone=true&serverTimezone=UTC";
	       con = DriverManager.getConnection(BD_URL, "root", "root");
	        con.setAutoCommit(false);
	        PreparedStatement pstm = null;
	        FileInputStream input = new FileInputStream("medicamentos1.xls");
	        POIFSFileSystem fs = new POIFSFileSystem(input);
	        Workbook workbook;
	        workbook = WorkbookFactory.create(fs);
	        Sheet sheet = workbook.getSheetAt(0);
	        Row row;
	        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
	            row = (Row) sheet.getRow(i);
	            int cod = (int)row.getCell(0).getNumericCellValue();
	            String med= row.getCell(1).getStringCellValue();

	            String dir = row.getCell(7).getStringCellValue();

	            int precio = (int)row.getCell(6).getNumericCellValue();

	            String sql = "INSERT INTO employee (name, address, contactNo, email) VALUES('" + cod + "','" + med + "'," + dir + ",'" + precio + "')";
	            pstm = (PreparedStatement) con.prepareStatement(sql);
	            pstm.execute();
	            System.out.println("Import rows " + i);
	        }
	        con.commit();
	        pstm.close();
	        con.close();
	        input.close();
	        System.out.println("Success import excel to mysql table");
	     } catch (IOException e) {
	    }
	}
}
