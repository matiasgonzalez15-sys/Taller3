package taller3;

public class Roca extends Hechizo {
	private int mejoraDefensa;

	public Roca(String nombre, String tipo, int daño, int mejoraDefensa) {
		super(nombre, tipo, daño);
		this.mejoraDefensa = mejoraDefensa;
	}

	public int getMejoraDefensa() {
		return mejoraDefensa;
	}

	@Override
	public void calcularPuntuacion() {
		this.puntuacion = (this.daño * this.mejoraDefensa) / 2 ;
	}
	

}
