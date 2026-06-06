package Dominio;

public class Planta extends Hechizo {
	
	private int duracionStun;
	private int cantPlantas;
	
	public Planta(String nombre, String tipo, int daño, int duracionStun, int cantPlantas) {
		super(nombre, tipo, daño);
		this.duracionStun = duracionStun;
		this.cantPlantas = cantPlantas;
		
		// TODO Auto-generated constructor stub
	}

	public int getDuracionStun() {
		return duracionStun;
	}

	public int getCantPlantas() {
		return cantPlantas;
	}

	@Override
	public void calcularPuntuacion() {
		setPuntuacion(getDaño() + (duracionStun * cantPlantas));

	}

}
