package taller3;

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

	public void agregarHechizo(Hechizo h) {
		hechizos.add(h);
		
	}

	public void calcularPuntuacion() {
		int contador = 0;
		for(Hechizo h : hechizos) {
			contador += h.getPuntuacion();
		}
		this.puntuacion = contador;
		
	}

	
	
	

}
