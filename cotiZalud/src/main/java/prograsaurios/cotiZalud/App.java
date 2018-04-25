package prograsaurios.cotiZalud;

public class App {
	public static void main(String[] args) {
		Controlador controlador = new Controlador(new Cliente("Prograsaurio", 1000));
		Vista vista = new Vista(controlador);
		
		vista.mostrar_lista();
		vista.elegir_medicamento();
		vista.ver_cliente();
		}
	}
