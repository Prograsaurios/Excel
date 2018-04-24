package prograsaurios.cotiZalud;

import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class App {
	public static void main(String[] args) {
		Controlador control=new Controlador();
		control.mostrar_lista();
		control.elegir_medicamento();
		control.verCliente();
		}
	
	}