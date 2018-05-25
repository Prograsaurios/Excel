package cotizalud.cotiZalud;

import java.util.ArrayList;

public class Cliente {
	private String nombre;
	private double dinero;
	private ArrayList<Medicamento> medicamentos;
	private double preciototal_medicamentos;
	
	public Cliente(String nombre, double dinero) {
		this.nombre=nombre;
		this.dinero=dinero;
		this.medicamentos=new  ArrayList<Medicamento>();
	}
	
	public void addMedicamentos(Medicamento med) {
		this.medicamentos.add(med);
	}
	
	public void delMedicamentos(int indice) {
		this.medicamentos.remove(indice);
	}
	
	public String getMedicamentos() {
		return medicamentos.toString();
	}

	public String getNombre() {
		return nombre;
	}
	
	public double getDinero() {
		return dinero;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setDinero(int dinero) {
		this.dinero = dinero;
	}
	
	public double getPreciototal_medicamentos() {
		for(int index=0;index<medicamentos.size();index++) {
			preciototal_medicamentos+=+medicamentos.get(index).getPrecio();
		}
		return preciototal_medicamentos;
	}
}
