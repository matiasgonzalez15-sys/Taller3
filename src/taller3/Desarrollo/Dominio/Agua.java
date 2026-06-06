package Dominio;

public class Agua extends Hechizo {
	
	private int cantidadHeal;
	private int presionDelAgua;
	
	public Agua(String nombre, String tipo, int daño,int cantidadHeal,int presionDelAgua ) {
		super(nombre, tipo, daño);
		// TODO Auto-generated constructor stub
		this.cantidadHeal = cantidadHeal;
		this.presionDelAgua = presionDelAgua;
		
	}

	public int getCantidadHeal() {
		return cantidadHeal;
	}

	public int getPresionDelAgua() {
		return presionDelAgua;
	}

	@Override
	public void calcularPuntuacion() {
		setPuntuacion((getDaño() + cantidadHeal + presionDelAgua)*2);
		
	}

}
