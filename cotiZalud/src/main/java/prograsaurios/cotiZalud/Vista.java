package prograsaurios.cotiZalud;

import java.util.Scanner;

public class Vista {
	Controlador controlador;
	Scanner sc;

	public Vista(Controlador controlador) {
		this.controlador = controlador;
		sc = new Scanner(System.in); //Revisar si dejar como variable global
		this.ingreso_datos();
	}

	public void mostrar_lista() {
		System.out.println(this.controlador.generar_lista());
	}

	public void ingreso_datos() {
		String tipo;
		String consulta;
		System.out.println("Escriba tipo:\nMedicamento \nRegión \nFarmacia ");
		tipo = sc.nextLine();
		System.out.println("Escriba su búsqueda");
		consulta = sc.nextLine();
		this.controlador.busca_fila(tipo, consulta);
		this.mostrar_lista();
		this.elegir_medicamento();
	}

	public void elegir_medicamento() {
		System.out.println("Elija medicamento (código)"); 
		System.out.println(this.controlador.elegir_medicamento(sc.nextInt(), this));
	}

	public void mas_medicamento() {
		System.out.println("¿Desea otro medicamento? 1) Sí 2) No");
		int op = sc.nextInt();
		switch(op) {
		case 1:
			ingreso_datos();
			break;
		case 2:
			System.out.println("Finalizado.");
			break;
		default:
			System.out.println("Entrada incorrecta.");
			this.mas_medicamento();
			break;
		}
	}

	public void ver_cliente(){
		System.out.println(this.controlador.datos_cliente());
	}
}
