package Dominio;

public class Fuego extends Hechizo {
	private int duracionQuemadura;
	
	public Fuego(String nombre, String tipo, int daño, int duracionQuemadura) {
		super(nombre, tipo, daño);
		// TODO Auto-generated constructor stub
		this.duracionQuemadura = duracionQuemadura;
		
	}

	public int getDuracionQuemadura() {
		return duracionQuemadura;
	}

	@Override
	public void calcularPuntuacion() {
		setPuntuacion(getDaño() * duracionQuemadura);
		
	}

	

}
