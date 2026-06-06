package Logica;


import java.util.LinkedList;
import java.util.List;
import Dominio.*;

public class SistemaImpl implements Sistema {
	
	private List<Hechizo> hechizos;
	private List<Mago> magos;
	
	public SistemaImpl() {
		hechizos = new LinkedList<>();
		magos = new LinkedList<>();
		
	}
	
	@Override
	public void crearHechizo(String[] partes) throws Exception {
	    if (partes.length == 0) {
	        throw new Exception("Datos invalidos");
	    }
	    String nombre = partes[0];
	    String tipo = partes[1];
	    int daño = Integer.parseInt(partes[2]);
	    Hechizo h = null;

	    if (tipo.equalsIgnoreCase("Fuego")) {
	        int duracionQuemadura = Integer.parseInt(partes[3]);
	        h = new Fuego(nombre, tipo, daño, duracionQuemadura);
	    } else if (tipo.equalsIgnoreCase("Tierra")) {
	        int mejoraDefensa = Integer.parseInt(partes[3]);
	        h = new Tierra(nombre, tipo, daño, mejoraDefensa);
	    } else if (tipo.equalsIgnoreCase("Planta")) {
	        String[] partes2 = partes[3].split(",");
	        int duracionStun = Integer.parseInt(partes2[0]);
	        int cantPlantas = Integer.parseInt(partes2[1]);
	        h = new Planta(nombre, tipo, daño, duracionStun, cantPlantas);
	    } else if (tipo.equalsIgnoreCase("Agua")) {
	        String[] partes2 = partes[3].split(",");
	        int cantidadHeal = Integer.parseInt(partes2[0]);
	        int presionDelAgua = Integer.parseInt(partes2[1]);
	        h = new Agua(nombre, tipo, daño, cantidadHeal, presionDelAgua);
	    } else {
	        System.out.println("No existe el tipo");
	    }

	    if (h != null) {
	        h.calcularPuntuacion();
	        hechizos.add(h);
	    }
	}
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

    private Hechizo buscarHechizo(String nombre) {
        for (Hechizo h : hechizos) {
            if (h.getNombre().equals(nombre)) {
                return h;
            }
        }
        return null;
    }

	@Override
	public void mostrarDiezHechizos() {
		List<Hechizo> ordenados = new LinkedList<>(hechizos);
		
		for (int i = 0; i < ordenados.size() -1 ; i++) {
			for (int j = i + 1; j < ordenados.size(); j++) {
				 if (ordenados.get(j).getPuntuacion() > ordenados.get(i).getPuntuacion()) {
		                Hechizo temp = ordenados.get(i);
		                ordenados.set(i, ordenados.get(j));
		                ordenados.set(j, temp);
		            }
			}
		}
		
		System.out.println("    TOP 10 MEJORES HECHIZOS");
        int limite = 10;
        if (ordenados.size() < 10) {
            limite = ordenados.size();
        }
        for (int i = 0; i < limite; i++) {
            System.out.println((i+1) + ". " + ordenados.get(i).getNombre());
        }
	}

	@Override
	public void mostrarTresMagos() {
		
		 List<Mago> ordenados = new LinkedList<>(magos);
		   for (int i = 0; i < ordenados.size() - 1; i++) {
		       for (int j = i + 1; j < ordenados.size(); j++) {
		           if (ordenados.get(j).getPuntuacion() > ordenados.get(i).getPuntuacion()) {
		               Mago temp = ordenados.get(i);
		               ordenados.set(i, ordenados.get(j));
		               ordenados.set(j, temp);
		            }
		        }
		    }
		  System.out.println("    TOP 3 MEJORES MAGOS");
		  int limite = 3;
	        if (ordenados.size() < 3) {
	            limite = ordenados.size();
	        }
	        for (int i = 0; i < limite; i++) {
	            System.out.println((i+1) + ". " + ordenados.get(i).getNombre());
	        }
		   
	}

	@Override
	public void mostrarHechizos() {
		 System.out.println("    TODOS LOS HECHIZOS");
	     for (Hechizo h : hechizos) {
	    	 System.out.println("- " + h.getNombre() + " [" + h.getTipo() + "]");
	        }
		
	}

	@Override
	public void mostrarMagos() {
		System.out.println("    TODOS LOS MAGOS");
		for (Mago m : magos) {
			System.out.println("- "+ m.getNombre());
			
		}
	}

	@Override
	public void mostrarHechizosConPuntuacion() {
		System.out.println("    HECHIZOS CON PUNTUACION");
        for (Hechizo h : hechizos) {
            System.out.println("- " + h.getNombre() + " | Puntuacion: " + h.getPuntuacion());
        }
		
	}

	@Override
	public void mostrarMagosConPuntuacion() {
		System.out.println("    MAGOS CON PUNTUACION");
        for (Mago m : magos) {
            System.out.println("- " + m.getNombre() + " | Puntuacion: " + m.getPuntuacion());
        }
		
	}
	

}
