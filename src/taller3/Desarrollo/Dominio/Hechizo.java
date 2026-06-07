package Dominio;

public abstract class Hechizo {
	protected String nombre;
	protected String tipo;
	protected int daño;
	protected int puntuacion;
	
	public Hechizo(String nombre, String tipo, int daño) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.daño = daño;
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
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setDaño(int daño) {
		this.daño = daño;
	}

	public abstract void calcularPuntuacion();
	
