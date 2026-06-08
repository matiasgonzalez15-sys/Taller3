package Dominio;

import java.util.LinkedList;
import java.util.List;

public class Mago {
	private String nombre;
	private int puntuacion;
	private List<Hechizo> hechizos;
	
	public Mago(String nombre) {
		this.nombre = nombre;
		this.hechizos = new LinkedList<Hechizo>();
		this.puntuacion = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public List<Hechizo> getHechizos() {
		return hechizos;
	}
	// Agrega hechizos a su lista
	public void agregarHechizo(Hechizo h) {
		hechizos.add(h);
		
	}
	// calcula la puntuacion total de la suma de las puntuaciones de sus hechizos
	public void calcularPuntuacion() {
		int contador = 0;
		for(Hechizo h : hechizos) {
			contador += h.getPuntuacion();
		}
		this.puntuacion = contador;
		
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	// muestra su lista de hechizos junto con su tipo
	public void mostrarHechizos() {
		System.out.println();
		System.out.println("=== HECHIZOS DEL MAGO ===");
		for(Hechizo h : hechizos) {
			System.out.println("- " + h.getNombre() +" || Tipo: " + h.getTipo());
		}
		
	}
	// elimina hechizos de su lista
	public void eliminarHechizo(Hechizo h) {
		hechizos.remove(h);
		System.out.println("Se elimino un hechizo a " + this.nombre);
	}
	// elimina su lista completa de sus hechizos
	public void eliminarHechizos() {
		hechizos.clear();
		
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	

	
	
	

}
