package prograsaurios.cotiZalud;

import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class Controlador {
	private Cliente cliente;
	private Datos datos;
	private Scanner sc;

	public Controlador(Cliente cliente) {
		this.datos = new Datos();
		this.cliente = cliente;
	}

	public String generar_lista() {
		String resultado = "";
		for (Row row : datos.getLista()) {
			for (Cell cell : row) {
				resultado = resultado + cell.toString() + "\t | \t";
			}
			resultado = resultado + "\n";
		}
		return resultado;
	}

	public void busca_fila(String tipo, String consulta) {
		this.datos.busca_fila(tipo, consulta);
	}

	public String elegir_medicamento(int codigo, Vista vista) {
		String resultado = "";
		for (Row row : datos.getLista()) {
			if (row.getCell(0).getNumericCellValue()==codigo) {
				String nombre = row.getCell(1).getStringCellValue();
				String dosis = row.getCell(2).getStringCellValue();
				String marca = row.getCell(4).getStringCellValue();
				double precio = row.getCell(6).getNumericCellValue();
				Medicamento medicamento = new Medicamento(nombre, dosis, marca, precio);
				cliente.addMedicamentos(medicamento);
				resultado = resultado + cliente.getMedicamentos();
			}
		}
		vista.mas_medicamento();
		return resultado;
	}

	public String datos_cliente() {
		return cliente.getNombre()+"\n"+cliente.getDinero()+"\n"+cliente.getMedicamentos()+"\n"+cliente.getPreciototal_medicamentos();
	}
}
