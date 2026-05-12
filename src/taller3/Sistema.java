package taller3;

import java.util.LinkedList;
import java.util.List;

public class Sistema implements IntSistema {
	private List<Mago> magos;
	private List<Hechizo> hechizos;


	public Sistema() {
		this.magos = new LinkedList<Mago>();
		this.hechizos = new LinkedList<Hechizo>();
	
	}

	@Override
	public void crearMago(String nombre, String listaHechizos) throws Exception{ 
		
		if(nombre == null || nombre.isEmpty()) {
			throw new Exception("Nombre invalido");		
		}
		Mago m = new Mago(nombre);
		String[] partes = listaHechizos.split("\\|");
		for(int i = 0; i < partes.length; i++) {
			Hechizo h = buscarHechizo(partes[i]);
			if(h != null) {
				m.agregarHechizo(h);
			}
		}
		m.calcularPuntuacion();
		magos.add(m);
		
	}



	private Hechizo buscarHechizo(String hechizo) {
		for(Hechizo h : hechizos) {
			if(h.getNombre().equals(hechizo)) {
				return h;
			}
		}
		return null;
	}

	@Override
	public void crearHechizo(String[] partes)throws Exception {
		if(partes.length == 0) {
			throw new Exception("Datos invalidos");
		}
		String nombre = partes[0];
		String tipo = partes[1];
		int daño = Integer.valueOf(partes[2]);
		Hechizo h = null;
		
		if(tipo.equals("Agua")) {
			String[] partes2 = partes[3].split(",");
			int cantHeal = Integer.valueOf(partes2[0]);
			int presionAgua = Integer.valueOf(partes2[1]);
			h = new Agua(nombre, tipo, daño, cantHeal, presionAgua);
		}
		else if(tipo.equals("Tierra")) {
			int mejoraDefensa = Integer.valueOf(partes[3]);
			h = new Roca(nombre, tipo, daño, mejoraDefensa);
			
		}
		else if(tipo.equals("Fuego")) {
			int duracionQuemadura = Integer.valueOf(partes[3]);
			h = new Fuego(nombre, tipo, daño, duracionQuemadura);

		}
		else if(tipo.equals("Planta")) {
			String[] partes2 = partes[3].split(",");
			int duracionStun = Integer.valueOf(partes2[0]);
			int cantPlantas = Integer.valueOf(partes2[1]);
			h = new Planta(nombre, tipo, daño, duracionStun, cantPlantas);
		}
		else {
			System.out.println("No existe el tipo");
		}
		
		if(h != null) {
			h.calcularPuntuacion();
			hechizos.add(h);
		}

	}

	@Override
	public void agregarMago() throws Exception{
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarMago() throws Exception{
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarMago() throws Exception{
		// TODO Auto-generated method stub

	}

	@Override
	public void agregarHechizo() throws Exception{
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarHechizo() throws Exception{
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarHechizo() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void mostrarDiezHechizos()throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void mostrarTresMagos() throws Exception{
		// TODO Auto-generated method stub

	}

	@Override
	public void mostrarHechizos() throws Exception{
		// TODO Auto-generated method stub

	}

	@Override
	public void mostrarMagos() throws Exception{
		// TODO Auto-generated method stub

	}



}
