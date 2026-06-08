package Dominio;

public class Roca extends Hechizo {
	private int mejoraDefensa;

	public Roca(String nombre, String tipo, int daño, int mejoraDefensa) {
		super(nombre, tipo, daño);
		this.mejoraDefensa = mejoraDefensa;
	}

	public int getMejoraDefensa() {
		return mejoraDefensa;
	}
	// calcula la puntuacion de sus atributos de roca
	@Override
	public void calcularPuntuacion() {
		this.puntuacion = (this.daño * this.mejoraDefensa) / 2 ;
	}

	public void setMejoraDefensa(int mejoraDefensa) {
		this.mejoraDefensa = mejoraDefensa;
	}
	

}
