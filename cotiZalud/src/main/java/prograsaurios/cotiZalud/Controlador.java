package prograsaurios.cotiZalud;

import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class Controlador {
	private Cliente cliente;
	private Scanner sc;
	private Datos datos;

	public Controlador() {
		cliente = new Cliente("Prograsaurio", 10000.0);
		sc = new Scanner(System.in);
		datos = new Datos();
		ingreso_datos();
	}
	public void ingreso_datos() {
		String tipo;
		String palabra;
		System.out.println("Escriba tipo:\nmedicamento \nfarmacia");
		tipo = sc.nextLine();
		System.out.println("Escriba su busqueda");
		palabra = sc.nextLine();
		datos.busca_fila(tipo, palabra);
		mostrar_lista();
		elegir_medicamento();
	}
	
	public void mostrar_lista() {
		for (Row row : datos.lista) {
			for (Cell cell : row) {
				System.out.print(cell.toString() + "\t | \t");
				}
			System.out.println(" ");
			}
		}
	
	public void elegir_medicamento() {
		System.out.println("Eliga medicamento (codigo)"); 
		int codigo = sc.nextInt();//
		for (Row row : datos.lista) {
			if (row.getCell(0).getNumericCellValue()==codigo) {
				String nombre = row.getCell(1).getStringCellValue();
				String dosis = row.getCell(2).getStringCellValue();
				String marca = row.getCell(4).getStringCellValue();
				double precio = row.getCell(6).getNumericCellValue();
				Medicamento medicamento = new Medicamento(nombre, dosis, marca, precio);
				cliente.addMedicamentos(medicamento);
				System.out.println(cliente.getMedicamentos());
				break;
			}
		}
		mas_medicamento();
		
	}
	public void mas_medicamento() {
		System.out.println("Desea otro medicamento? 1)Si 2)No");
		int op=sc.nextInt();
		switch(op) {
		case 1:
			ingreso_datos();
			break;
		case 2:
			System.out.println("Finalizado");
			break;
		default:
			System.out.println("Entrada incorrecta");
			mas_medicamento();
			break;
		}
	}
	
	public void verCliente(){
		System.out.println(cliente.toString());
	}
}
