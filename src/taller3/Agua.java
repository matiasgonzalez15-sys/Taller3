package taller3;

public class Agua extends Hechizo {
	private int cantidadHeal;
	private int presionAgua;
	
	public Agua(String nombre, String tipo, int daño, int cantidadHeal, int presionAgua) {
		super(nombre, tipo, daño);
		this.cantidadHeal = cantidadHeal;
		this.presionAgua = presionAgua;
	}

	public int getCantidadHeal() {
		return cantidadHeal;
	}

	public int getPresionAgua() {
		return presionAgua;
	}

	@Override
	public void calcularPuntuacion() {
		this.puntuacion = (this.daño + this.cantidadHeal + this.presionAgua)*2;
	}
	
	

}
