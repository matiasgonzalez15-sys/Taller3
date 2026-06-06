package Dominio;

public abstract class Hechizo {
	private String nombre;
	private String tipo;
	private int daño;
	private int puntuacion;

	public Hechizo(String nombre, String tipo, int daño) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.daño = daño;
		this.puntuacion = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public int getDaño() {
		return daño;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public abstract void calcularPuntuacion();

}
