package Dominio;

public class Fuego extends Hechizo {
	private int duracionQuemadura;

	public Fuego(String nombre, String tipo, int daño, int duracionQuemadura) {
		super(nombre, tipo, daño);
		this.duracionQuemadura = duracionQuemadura;
	}

	public int getDuracionQuemadura() {
		return duracionQuemadura;
	}

	@Override // Calcula la puntuacion de los atributos del fuego
	public void calcularPuntuacion() {
		this.puntuacion = duracionQuemadura * this.daño;;
		
	}

	public void setDuracionQuemadura(int duracionQuemadura) {
		this.duracionQuemadura = duracionQuemadura;
	}
	
	
