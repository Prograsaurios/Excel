package prograsaurios.cotiZalud;
import java.util.Scanner;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc=new Scanner(System.in);
    	String tipo="";
    	System.out.println("Escriba tipo:\nmedicamento \nfarmacia" );
    	tipo=sc.nextLine();
    	System.out.println("Escriba su busqueda"); 
    	String palabra=sc.nextLine();
        Buscador.buscador(tipo,palabra);
        }
    }
