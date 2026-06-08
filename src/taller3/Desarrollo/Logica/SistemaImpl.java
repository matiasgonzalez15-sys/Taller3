package Logica;


import java.util.LinkedList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import Dominio.*;

public class SistemaImpl implements Sistema {
	
	private List<Mago> magos;
	private List<Hechizo> hechizos;
	
	public SistemaImpl() {
		this.magos = new LinkedList<Mago>();
		this.hechizos = new LinkedList<Hechizo>();
		
	}
	/* Segun los datos enviados desde el App de Magos.txt, se crea el mago o no.
	Si es que se puede crear, le agrega los hechizos correspondientes si es que existe. Donde finalmente
	se le agrega a la lista de magos. Si es que hay algun dato no valido, se manda Exception*/
	@Override 
	public void crearMago(String nombre, String listaHechizos) throws Exception {

		if (nombre == null || nombre.isEmpty()) {
			throw new Exception("Nombre invalido");
		}
		Mago m = new Mago(nombre);
		String[] partes = listaHechizos.split("\\|");
		for (int i = 0; i < partes.length; i++) {
			Hechizo h = buscarHechizo(partes[i]);
			if (h != null) {
				m.agregarHechizo(h);
			}
		}
		m.calcularPuntuacion();
		magos.add(m);

	}
	// Segun el nombre de un hechizo, se busca en la lista, retornando el hechizo si es que existe o retornando null si no existe
	private Hechizo buscarHechizo(String hechizo) {
		for (Hechizo h : hechizos) {
			if (h.getNombre().equalsIgnoreCase(hechizo)) {
				return h;
			}
		}
		return null;
	}
	/*
	Segun los datos enviados desde App de Hechizos.txt, se procesan los datos para crear un hechizo de distintos tipos
	y guardarlo en su lista. Si lo enviado esta vacio, se manda excepcion como dato invalido
	*/
	@Override
	public void crearHechizo(String[] partes) throws Exception {
		if (partes.length == 0) {
			throw new Exception("Datos invalidos");
		}
		String nombre = partes[0];
		String tipo = partes[1];
		int daño = Integer.valueOf(partes[2]);
		if (daño < 0) {
			throw new Exception("El daño no puede ser negativo.");
		}
		Hechizo h = null;

		if (tipo.equals("Agua")) {
			String[] partes2 = partes[3].split(",");
			int cantHeal = Integer.valueOf(partes2[0]);
			int presionAgua = Integer.valueOf(partes2[1]);
			h = new Agua(nombre, tipo, daño, cantHeal, presionAgua);
		} else if (tipo.equals("Tierra")) {
			int mejoraDefensa = Integer.valueOf(partes[3]);
			h = new Roca(nombre, tipo, daño, mejoraDefensa);

		} else if (tipo.equals("Fuego")) {
			int duracionQuemadura = Integer.valueOf(partes[3]);
			h = new Fuego(nombre, tipo, daño, duracionQuemadura);

		} else if (tipo.equals("Planta")) {
			String[] partes2 = partes[3].split(",");
			int duracionStun = Integer.valueOf(partes2[0]);
			int cantPlantas = Integer.valueOf(partes2[1]);
			h = new Planta(nombre, tipo, daño, duracionStun, cantPlantas);
		} else {
			throw new Exception("Tipo invalido");
		}

		if (h != null) {
			h.calcularPuntuacion();
			hechizos.add(h);
		}

	}
	/* Segun los datos que ingreso el usuario, procesa los datos para poder crear
	el mago que el usuario quiera y se le agregan los hechizos
	si es que existen que el usuario ingreso, donde finalmente se le calcula
	la puntuacion. De caso contrario, manda excepcion.
	*/
	
	@Override
	public void agregarMago(String nombre, String listaHechizos) throws Exception {
		if (nombre == null || nombre.equals("")) {
			throw new Exception("Datos invalidos");
		}
		Mago m = new Mago(nombre);
		String[] partes = listaHechizos.split(";");
		for (int i = 0; i < partes.length; i++) {
			Hechizo h = existeHechizo(partes[i]);
			if (h != null) {
				m.agregarHechizo(h);
			}

		}
		m.calcularPuntuacion();
		magos.add(m);
		System.out.println(m.getNombre() + " ha sido creado");
		guardarMagos();
	}

	private Hechizo existeHechizo(String nameHechizo) {
		for (Hechizo h : hechizos) {
			if (h.getNombre().equalsIgnoreCase(nameHechizo)) {
				return h;
			}
		}
		return null;
	}
	/* Segun los datos que mando el usuario desde App, se modifica el NOMBRE del mago
	ingresado por el usuario. De caso contrario se manda excepcion.
	*/
	@Override
	public void modificarMago(String nombre, String nombreNuevo) throws Exception {
		if (nombre == null || nombre.equals("")) {
			System.out.println("Datos invalidos");
		}
		else {

			Mago m = buscarMago(nombre);
			if (m == null) {
				System.out.println("No existe un mago con ese nombre");
			} else {
				// cambiar nombre
				if (nombreNuevo == null || nombreNuevo.equals("")) {
					System.out.println("Nombre nuevo es invalido");
				} else {
					m.setNombre(nombreNuevo);
	
				}
	
			}
		}	
		guardarMagos();

	}
	// Se valida el tipo del hechizo, retornando true o false
	private boolean validarTipo(String tipoNuevo) {
		if (tipoNuevo == null) {
			return false;
		} else if (!tipoNuevo.equals("fuego") && !tipoNuevo.equals("tierra") && !tipoNuevo.equals("planta")
				&& !tipoNuevo.equals("agua")) {
			return false;
		}
		return true;
	}
	// Se busca al mago por su nombre, retornandolo si es que lo encuentra o retornando null si es que no.
	private Mago buscarMago(String nombre) {
		for (Mago m : magos) {
			if (m.getNombre().equalsIgnoreCase(nombre)) {
				return m;
			}
		}
		return null;
	}
	// Elimina el mago que el usuario ingreso de la lista de los magos. Si ingreso algo no valido, se manda excepcion.
	@Override
	public void eliminarMago(String nombre) throws Exception {
		if (nombre == null || nombre.equals("")) {
			System.out.println("Nombre invalido.");
		} else {
			Mago m = buscarMago(nombre);
			if (m != null) {
				magos.remove(m);
				System.out.println(m.getNombre() + " ha sido eliminado.");
			} else {
				System.out.println("No existe un mago con ese nombre.");
			}
		}
		guardarMagos();
	}
	/*
	Segun los datos que envio el usuario desde App, se crea un hechizo con sus distintos
	atributos, si es que logra crear, se agrega a la lista de los hechizos. Caso contrario, manda
	excepcion.
	*/
	@Override
	public void agregarHechizo(String hechizo) throws Exception {
		if (hechizo == null || hechizo.isEmpty()) {
			throw new Exception("Datos invalidos");
		}
		String[] partes = hechizo.split(",");
		String nombre = partes[0];
		String tipo = partes[1];
		int daño = Integer.valueOf(partes[2]);
		if (daño < 0) {
			throw new Exception("El daño no puede ser negativo.");
		}
		if (nombre == null || nombre.isEmpty()) {
			throw new Exception("Nombre no valido");
		}
		Hechizo h = null;
		try {
			if (tipo.equalsIgnoreCase("agua")) {
				int cantHeal = Integer.valueOf(partes[3]);
				int presionAgua = Integer.valueOf(partes[4]);
				h = new Agua(nombre, tipo, daño, cantHeal, presionAgua);

			} else if (tipo.equalsIgnoreCase("tierra")) {
				int mejoraDefensa = Integer.valueOf(partes[3]);
				h = new Roca(nombre, tipo, daño, mejoraDefensa);

			} else if (tipo.equalsIgnoreCase("fuego")) {
				int duracionQuemadura = Integer.valueOf(partes[3]);
				h = new Fuego(nombre, tipo, daño, duracionQuemadura);

			} else if (tipo.equalsIgnoreCase("planta")) {
				int duracionStun = Integer.valueOf(partes[3]);
				int cantPlantas = Integer.valueOf(partes[4]);
				h = new Planta(nombre, tipo, daño, duracionStun, cantPlantas);
			} else {
				throw new Exception("Tipo invalido.");

			}
			if (h != null) {
				System.out.println("Se ha agregado " + h.getNombre() + " a la lista de los hechizos!!");
				hechizos.add(h);
				h.calcularPuntuacion();
			}

		} catch (Exception e) {
			System.out.println("Datos invalidos " + e.getMessage());
		}
		guardarHechizos();

	}

	/* Segun el dato que se mando desde App, se elimina el hechizo de los magos que lo tengan
	y tambien se elimina de la lista de los hechizos si es que existe. Si se ingreso un dato no valido, 
	se manda excepcion.
	*/
	@Override
	public void eliminarHechizo(String nombre) throws Exception {
		if (nombre == null || nombre.equals("")) {
			System.out.println("Nombre invalido.");
		} else {
			Hechizo h = buscarHechizo(nombre);
			if (h != null) {
				buscarHechizoMagos(nombre);

				hechizos.remove(h);
				System.out.println(h.getNombre() + " ha sido eliminado");
			}
		}
		guardarHechizos();
		guardarMagos();

	}
	// Busca el hechizo a eliminar en los magos para eliminarlo de sus listas de cada uno.
	private void buscarHechizoMagos(String nombre) {
		for (Mago m : magos) {
			for (Hechizo h : m.getHechizos()) {
				if (h.getNombre().equals(nombre)) {
					m.eliminarHechizo(h);
					break;
				}

			}

		}

	}
	// muestra los 10 mejores hechizos con mayor puntuacion
	@Override
	public void mostrarDiezHechizos() {
	    List<Hechizo> ordenados = new LinkedList<>(hechizos);
	    for(int i = 0; i < ordenados.size() - 1; i++) {
	        for(int j = i + 1; j < ordenados.size(); j++) {
	            if(ordenados.get(j).getPuntuacion() > ordenados.get(i).getPuntuacion()) {
	                Hechizo temp = ordenados.get(i);
	                ordenados.set(i, ordenados.get(j));
	                ordenados.set(j, temp);
	            }
	        }
	    }
	    System.out.println("=== TOP 10 MEJORES HECHIZOS ===");
	    int limite = Math.min(10, ordenados.size());
	    for(int i = 0; i < limite; i++) {
	        System.out.println((i+1) + ". " + ordenados.get(i).getNombre() + " | Puntuacion: " + ordenados.get(i).getPuntuacion());
	    }

	}
	// muestra los 3 magos con mayor puntuacion
	@Override
	public void mostrarTresMagos() {
	    List<Mago> ordenados = new LinkedList<>(magos);
	    for(int i = 0; i < ordenados.size() - 1; i++) {
	        for(int j = i + 1; j < ordenados.size(); j++) {
	            if(ordenados.get(j).getPuntuacion() > ordenados.get(i).getPuntuacion()) {
	                Mago temp = ordenados.get(i);
	                ordenados.set(i, ordenados.get(j));
	                ordenados.set(j, temp);
	            }
	        }
	    }
	    System.out.println("=== TOP 3 MEJORES MAGOS ===");
	    int limite = Math.min(3, ordenados.size());
	    for(int i = 0; i < limite; i++) {
	        System.out.println((i+1) + ". " + ordenados.get(i).getNombre() + " | Puntuacion: " + ordenados.get(i).getPuntuacion());
	    }

	}
	// muestra todos los hechizos existentes
	@Override
	public void mostrarHechizos() {
	    System.out.println("=== TODOS LOS HECHIZOS ===");
	    for(Hechizo h : hechizos) {
	        System.out.println("- " + h.getNombre() + " [" + h.getTipo() + "]");
	    }

	}
	// muestra todos los magos existentes
	@Override
	public void mostrarMagos(){
		int c = 1;
		for (Mago m : magos) {
			System.out.println(c + ") " + m.getNombre());
			c++;
		}

	}
	// muestra todos los hechizos con su respectiva puntuacion
	@Override
	public void mostrarHechizosPuntuacion(){
	    System.out.println("=== HECHIZOS CON PUNTUACION ===");
	    for(Hechizo h : hechizos) {
	        System.out.println("- " + h.getNombre() + " | Puntuacion: " + h.getPuntuacion());
	    }

	}
	// muestra todos los magos con su respectiva puntuacion
	@Override
	public void mostrarMagosPuntuacion() {
	    System.out.println("=== MAGOS CON PUNTUACION ===");
	    for(Mago m : magos) {
	        System.out.println("- " + m.getNombre() + " | Puntuacion: " + m.getPuntuacion());
	    }

	}
	// se modifican los hechizos del mago a modificar que el usuario ingreso desde el App
	@Override
	public void modificarHechizoMago(String nombre, String listaHechizos) throws Exception {
		Mago m = buscarMago(nombre);
		if (m != null) {
			String[] partes = listaHechizos.split(";");
			boolean verificoHechizo = verificarHechizos(partes);
			if (verificoHechizo) {
				m.eliminarHechizos();
				for (int i = 0; i < partes.length; i++) {
					Hechizo h = existeHechizo(partes[i]);
					m.agregarHechizo(h);
					System.out.println("Se agrego " + h.getNombre() + " a " + m.getNombre());
				}
				m.calcularPuntuacion();
			} else {
				System.out.println("No existen esos hechizos");
			}
		}
		guardarMagos();

	}
	// se verifican si todos los hechizos que quieren poner el usuario en el mago a modificar existen
	private boolean verificarHechizos(String[] partes) {
		int c = 0;
		for (int i = 0; i < partes.length; i++) {
			String hechizo = partes[i];
			Hechizo h = existeHechizo(hechizo);
			if (h != null) {
				c += 1;
			}
		}

		if (c == partes.length) {
			return true;
		}
		return false;
	}
	// se modifica el nombre del hechizo
	@Override
	public void modificarHechizoNombre(String nombre, String nombreNuevo) throws Exception {
		if(nombre == null || nombre.equals("") || nombreNuevo == null || nombreNuevo.equals("") ) {
			System.out.println("Datos invalidos.");
		}
		else {
			Hechizo h = buscarHechizo(nombre);
			if(h!= null) {
				h.setNombre(nombreNuevo);
				System.out.println("Se ha cambiado el nombre del hechizo " + nombre + " a " + nombreNuevo);
				
			}
		}
		guardarHechizos();
		
	}
	// se modifica el daño del hechizo
	@Override
	public void modificarHechizoDaño(String nombre, int dañoNuevo) throws Exception {
		if(nombre == null || nombre.equals("") || dañoNuevo < 0 ) {
			System.out.println("Datos invalidos.");
		}
		else {
			Hechizo h = buscarHechizo(nombre);
			if(h!= null) {
				h.setDaño(dañoNuevo);
				System.out.println("Se ha cambiado el daño del hechizo " + nombre + " a " + dañoNuevo);
				
			}
		}
		guardarHechizos();
	}
	/* Se modifica el tipo del hechizo con sus respectivos atributos, quitando de la lista
	el hechizo a modificar y agregando un nuevo hechizo con su nuevo tipo y nuevos atributos,
	donde despues de ese proceso, en los magos que tengan el hechizo que se modifico, se le reemplaza
	en su lista por el hechizo nuevo
	*/
	@Override
	public void modificarHechizoTipo(String nombre, String tipoNuevo, int extra) throws Exception {
		if(nombre == null || nombre.equals("") || tipoNuevo == null || tipoNuevo.equals("") ) {
			System.out.println("Datos invalidos.");
		}
		else {
			Hechizo h = buscarHechizo(nombre);
			if (h!= null) {
				int indice = hechizos.indexOf(h);
				int daño = h.getDaño();
				Hechizo nuevo = null;
				if(tipoNuevo.equalsIgnoreCase("Tierra")) {
					nuevo = new Roca(nombre, tipoNuevo, daño, extra);
				}
				if(tipoNuevo.equalsIgnoreCase("Fuego")) {
					nuevo = new Fuego(nombre, tipoNuevo, daño, extra);
				}
				if(nuevo != null) {
					nuevo.calcularPuntuacion();
					hechizos.set(indice, nuevo);
					
				}
				for(Mago m: magos) {
					int indiceHechizo = m.getHechizos().indexOf(h);
					if(indiceHechizo != -1) {
						m.getHechizos().set(indiceHechizo, nuevo);
						m.calcularPuntuacion();
					}
				}
				
			}
		}
		guardarHechizos();
		guardarMagos();
		
		
	}
	/* Se modifica el tipo del hechizo con sus respectivos atributos, quitando de la lista
	el hechizo a modificar y agregando un nuevo hechizo con su nuevo tipo y nuevos atributos,
	donde despues de ese proceso, en los magos que tengan el hechizo que se modifico, se le reemplaza
	en su lista por el hechizo nuevo
	*/
	@Override
	public void modificarHechizoTipo(String nombre, String tipoNuevo, int extra, int extra2) throws Exception {
		if(nombre == null || nombre.equals("") || tipoNuevo == null || tipoNuevo.equals("") ) {
			System.out.println("Datos invalidos.");
		}
		else {
			Hechizo h = buscarHechizo(nombre);
			if (h!= null) {
				int indice = hechizos.indexOf(h);
				int daño = h.getDaño();
				Hechizo nuevo = null;
				if(tipoNuevo.equalsIgnoreCase("Agua")) {
					nuevo = new Agua(nombre, tipoNuevo, daño, extra, extra2);
				}
				if(tipoNuevo.equalsIgnoreCase("Planta")) {
					nuevo = new Planta(nombre, tipoNuevo, daño, extra, extra2);
				}
				
				if(nuevo != null) {
					nuevo.calcularPuntuacion();
					hechizos.set(indice, nuevo);
				}
				
				for(Mago m : magos) {
					int indiceHechizo = m.getHechizos().indexOf(h);
					if(indiceHechizo != -1) {
						m.getHechizos().set(indiceHechizo, nuevo);
						m.calcularPuntuacion();
					}
				}
			}
		}
		guardarHechizos();
		guardarMagos();
		
	}
	// Va modificando despues de cada actualizacion el archivo de magos.txt
	@Override
	public void guardarMagos() throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter("Magos.txt"));
		for(Mago m : magos) {
			String linea = m.getNombre() + ";";
			
			List<Hechizo> hechizosMago = m.getHechizos();
			for(int i = 0; i < hechizosMago.size(); i++) {
				if(i + 1 < hechizosMago.size()) {
					linea += hechizosMago.get(i).getNombre() + "|";
				}
				else {
					linea+= hechizosMago.get(i).getNombre();
				}
			}
			bw.write(linea);
			bw.newLine();
		}
		bw.close();
		
	}
	// se va modificando despues de cada actualizacion el archivo de hechizos.txg
	@Override
	public void guardarHechizos() throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter("Hechizos.txt"));
		for(Hechizo h : hechizos) {
			String linea = h.getNombre() + ";" + h.getTipo() + ";" + h.getDaño();
			if(h.getTipo().equalsIgnoreCase("Agua")) {
				Agua a = (Agua) h;
				linea += ";" +a.getCantidadHeal() + "," + a.getPresionAgua();
			}
			if(h.getTipo().equalsIgnoreCase("Tierra")) {
				Roca r = (Roca) h;
				linea += ";" +r.getMejoraDefensa();
			}
			if(h.getTipo().equalsIgnoreCase("Fuego")) {
				Fuego f = (Fuego) h;
				linea += ";" +f.getDuracionQuemadura();
			}
			if(h.getTipo().equalsIgnoreCase("Planta")) {
				Planta p = (Planta) h;
				linea += ";" +p.getDuracionStun() + "," + p.getCantPlantas();
			}
			bw.write(linea);
			bw.newLine();
		}
		bw.close();
		
	}
}
