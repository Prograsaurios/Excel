package cotizalud.cotiZalud;

public class Medicamento {
	private String nombre;
	private String marca;
	private String dosis;
	private double precio;
	public Medicamento(String nombre, String dosis, String marca, double precio) {
		super();
		this.nombre = nombre;
		this.marca = marca;
		this.dosis = dosis;
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public String getMarca() {
		return marca;
	}

	public String getDosis() {
		return dosis;
	}

	public double getPrecio() {
		return precio;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setDosis(String dosis) {
		this.dosis = dosis;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String toString() {
		String arreglo=(getNombre()+" "+getDosis()+" "+getMarca()+" $"+getPrecio());
		return arreglo;

	}
}