package taller3;

public class Planta extends Hechizo {
	private int duracionStun;
	private int cantPlantas;
	
	public Planta(String nombre, String tipo, int daño, int duracionStun, int cantPlantas) {
		super(nombre, tipo, daño);
		this.duracionStun = duracionStun;
		this.cantPlantas = cantPlantas;
	}

	public int getDuracionStun() {
		return duracionStun;
	}

	public int getCantPlantas() {
		return cantPlantas;
	}

	@Override
	public void calcularPuntuacion() {
		this.puntuacion = this.daño + (this.duracionStun * this.cantPlantas);
		
	}
	
	

}
