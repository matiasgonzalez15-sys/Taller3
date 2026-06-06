package Dominio;

public class Tierra extends Hechizo {
	private int mejoraDefenza;
	
	public Tierra(String nombre, String tipo, int daño, int mejoraDefenza) {
		super(nombre, tipo, daño);
		this.mejoraDefenza = mejoraDefenza;
		// TODO Auto-generated constructor stub
	}

	public int getMejoraDefenza() {
		return mejoraDefenza;
	}

	@Override
	public void calcularPuntuacion() {
		setPuntuacion((getDaño() *mejoraDefenza)/2);
		
	}



}
