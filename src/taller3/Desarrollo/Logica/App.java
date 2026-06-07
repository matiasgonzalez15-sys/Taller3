package Logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Dominio.Agua;
import Dominio.Fuego;
import Dominio.Hechizo;
import Dominio.Mago;
import Dominio.Planta;
import Dominio.Tierra;

public class App {

	private static Sistema sistema = new SistemaImpl();
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception {
		leerHechizos();
		leerMagos();
		menuPrincipal();

	}

	private static void leerHechizos() throws Exception {
		File arch = new File("Hechizos.txt");
		Scanner lector = new Scanner(arch);
		while (lector.hasNext()) {
			String linea = lector.nextLine();
			String[] partes = linea.split(";");
			sistema.crearHechizo(partes);
		}

	}

	private static void leerMagos() throws Exception {
		File arch = new File("Magos.txt");
		Scanner lector = new Scanner(arch);
		while (lector.hasNext()) {
			String linea = lector.nextLine();
			String[] partes = linea.split(";");
			String nombre = partes[0];
			String hechizos = partes[1];
			sistema.crearMago(nombre, hechizos);

		}

	}

	private static void menuPrincipal() throws Exception {
		System.out.println();
		int opcion = -1;
		while (opcion != 3) {
			System.out.println("Que menú desea elegir?");
			System.out.println("1) Menú del administrador.");
			System.out.println("2) Menú del analista.");
			System.out.println("3) Salir.");
			System.out.print("Ingrese opcion: ");
			try {
				opcion = Integer.valueOf(sc.nextLine());
			} catch (Exception e) {
				System.out.println("Opcion no valida, " + e.getMessage());
			}
			if (opcion > 3 || opcion < 1) {
				System.out.println("Opcion invalida");
			} else {

				switch (opcion) {
				case 1:
					menuAdministrador();
					break;
				case 2:
					menuAnalista();
					break;
				}
			}
		}
		System.out.println();
	}

	private static void menuAnalista() throws Exception {
		int opcion = -1;
		while (opcion != 7) {
			System.out.println();
			System.out.println("1. Top 10 Mejores Hechizos");
			System.out.println("2. Top 3 Mejores Magos");
			System.out.println("3. Mostrar todos los Hechizos");
			System.out.println("4. Mostrar todos los magos");
			System.out.println("5. Mostrar todos los Hechizos junto a su puntuacion");
			System.out.println("6. Mostrar todos los magos junto a su puntuacion");
			System.out.println("7. Salir");
			System.out.println("Ingrese opcion: ");
			try {
				opcion = Integer.valueOf(sc.nextLine());
			} catch (Exception e) {
				System.out.println("Opcion no valida, " + e.getMessage());
			}
			if (opcion < 1 || opcion > 7) {
				System.out.println("Opcion incorrecta");
			}
			switch (opcion) {
			case 1:
				sistema.mostrarDiezHechizos();
				break;
			case 2:
				sistema.mostrarTresMagos();
				break;
			case 3:
				sistema.mostrarHechizos();
				break;
			case 4:
				sistema.mostrarMagos();
				break;
			case 5:
				sistema.mostrarHechizosPuntuacion();
				break;
			case 6:
				sistema.mostrarMagosPuntuacion();
				break;
			}
		}
	

	}

	private static void menuAdministrador() throws Exception {
		int opcion = -1;
		while (opcion != 7) {
			System.out.println();
			System.out.println("1. Agregar Mago");
			System.out.println("2. Modificar Mago");
			System.out.println("3. Eliminar Mago");
			System.out.println("4. Agregar Hechizo");
			System.out.println("5. Modificar Hechizo");
			System.out.println("6. Eliminar Hechizo");
			System.out.println("7. Salir");
			System.out.println("Ingrese opcion: ");
			try {
				opcion = Integer.valueOf(sc.nextLine());
			} catch (Exception e) {
				System.out.println("Opcion no valida, " + e.getMessage());
			}
			if (opcion < 1 || opcion > 7) {
				System.out.println("Opcion incorrecta");
			}
			switch (opcion) {
			case 1:
				agregarMago();
				break;
			case 2:
				modificarMago();
				break;
			case 3:
				eliminarMago();
				break;
			case 4:
				agregarHechizo();
				break;
			case 5:
				modificarHechizo();
				break;
			case 6:
				eliminarHechizo();
				break;
			}
		}

	}

	private static void modificarHechizo() {
		try {
			String nombreNuevo = "";
			System.out.println();
			System.out.print("Nombre del hechizo que deseas modificar: ");
			String nombre = sc.nextLine();
			
			System.out.print("Quieres cambiar el nombre?: ");
			String cambiarNombre = sc.nextLine().toLowerCase();
			boolean validarNombre = validarDatos(cambiarNombre);
			while(!validarNombre) {
				System.out.print("Quieres cambiar el nombre?: ");
				cambiarNombre = sc.nextLine();
				validarNombre = validarDatos(cambiarNombre);
				
			}
			
			System.out.print("Quieres cambiar el tipo?: ");
			String cambiarTipo = sc.nextLine().toLowerCase();
			boolean validarTipo = validarDatos(cambiarTipo);
			while(!validarTipo) {
				System.out.print("Quieres cambiar el tipo?: ");
				cambiarTipo = sc.nextLine();
				validarTipo = validarDatos(cambiarTipo);
				
			}
			
			System.out.print("Quieres cambiar el daño?: ");
			String cambiarDaño = sc.nextLine().toLowerCase();
			boolean validarDaño = validarDatos(cambiarDaño);
			while(!validarDaño) {
				System.out.print("Quieres cambiar el daño?: ");
				cambiarDaño = sc.nextLine().toLowerCase();
				validarDaño = validarDatos(cambiarDaño);
				
			}
			
			if(cambiarNombre.equals("si")) {
				System.out.print("Ingrese el nuevo nombre: ");
				nombreNuevo = sc.nextLine().toLowerCase();
				sistema.modificarHechizoNombre(nombre, nombreNuevo);
			}
			if(cambiarDaño.equals("si")) {
				System.out.print("Ingrese el nuevo daño: ");
				int dañoNuevo = Integer.valueOf(sc.nextLine());
				if(cambiarNombre.equals("si")) {
					sistema.modificarHechizoDaño(nombreNuevo, dañoNuevo);
				}
				else {
					sistema.modificarHechizoDaño(nombre, dañoNuevo);
				}
			}
			if(cambiarTipo.equals("si")) {
				System.out.print("Ingrese el nuevo tipo: ");
				String tipoNuevo = sc.nextLine();
				
				if (tipoNuevo.equalsIgnoreCase("Agua")) {
					System.out.print("Cantidad Heal: ");
					int cantHeal = Integer.valueOf(sc.nextLine());
					System.out.print("Presion del agua: ");
					int presionAgua = Integer.valueOf(sc.nextLine());
					comprobarNombre(nombre, nombreNuevo, cambiarNombre, tipoNuevo, cantHeal, presionAgua);
					
				
				} else if (tipoNuevo.equalsIgnoreCase("Tierra")) {
					System.out.print("Mejora Defensa: ");
					int mejoraDefensa = Integer.valueOf(sc.nextLine());
					comprobarNombre(nombre, nombreNuevo, cambiarNombre, tipoNuevo, mejoraDefensa);

					
				} else if (tipoNuevo.equalsIgnoreCase("Planta")) {
					System.out.print("Duracion stun: ");
					int duracionStun = Integer.valueOf(sc.nextLine());
					System.out.print("Cantidad de plantas: ");
					int cantPlantas = Integer.valueOf(sc.nextLine());
					comprobarNombre(nombre, nombreNuevo, cambiarNombre, tipoNuevo, duracionStun, cantPlantas);

				} else if (tipoNuevo.equalsIgnoreCase("Fuego")) {
					System.out.print("Duracion quemadura: ");
					int duracionQuemadura = Integer.valueOf(sc.nextLine());
					comprobarNombre(nombre, nombreNuevo, cambiarNombre, tipoNuevo, duracionQuemadura);
	

				}
				
				
			}
			
			
			
			
		}catch(Exception e) {
			System.out.println("No valido " + e.getMessage());
		}
		
		
		
		
		
	}

	private static void comprobarNombre(String nombre, String nombreNuevo, String cambiarNombre, String tipoNuevo, int extra) throws Exception {
		if(cambiarNombre.equals("si")) {
			sistema.modificarHechizoTipo(nombreNuevo, tipoNuevo, extra);
		}
		else {
			sistema.modificarHechizoTipo(nombre, tipoNuevo, extra);
		}
		
	}

	private static void comprobarNombre(String nombre, String nombreNuevo, String cambiarNombre, String tipoNuevo, int extra, int extra2) throws Exception {
		if(cambiarNombre.equals("si")) {
			sistema.modificarHechizoTipo(nombreNuevo, tipoNuevo, extra, extra2);
		}
		else {
			sistema.modificarHechizoTipo(nombre, tipoNuevo, extra, extra2);
		}
		
	}

	private static void agregarHechizo() throws Exception {
		try {
		System.out.println();
		String hechizo = "";
		System.out.print("Nombre del hechizo que quieres agregar: ");
		String nombre = sc.nextLine();
		System.out.print("De que tipo quieres que sea?: ");
		String tipo = sc.nextLine();
		System.out.println("Cuanto daño tendra?: ");
		String daño = sc.nextLine();
		String extras = itemsExtras(tipo);
		hechizo += nombre+","+tipo+","+ daño + "," + extras;
		sistema.agregarHechizo(hechizo);
		}catch(Exception e) {
			System.out.println("Datos invalidos --> "+ e.getMessage());
		}
		
		
		
	}

	private static void modificarMago() {
		try {
			String nombreNuevo = null;
			int cantHechizos = 0;
			System.out.println();
			System.out.print("Introduzca el nombre del mago a modificar: ");
			String nombre1 = sc.nextLine();
	
			System.out.print("Quieres cambiar el nombre? (si/no): ");
			String cambiarName = sc.nextLine().toLowerCase();
			boolean validarNombre = validarDatos(cambiarName);
			while(!validarNombre) {
				System.out.print("Quieres cambiar el nombre? (si/no): ");
				cambiarName = sc.nextLine().toLowerCase();
				validarNombre = validarDatos(cambiarName);
			}
	
			System.out.print("Quieres cambiar los hechizos (si/no): ");
			String cambiarHechizos = sc.nextLine().toLowerCase();
			boolean validarHechizo = validarDatos(cambiarHechizos);
			while(!validarHechizo) {
				System.out.print("Quieres cambiar los hechizos (si/no): ");
				cambiarHechizos = sc.nextLine().toLowerCase();
				validarHechizo = validarDatos(cambiarHechizos);
				
			}
			if (validarNombre) {
				if (cambiarName.equals("si")) {
					System.out.print("Ingrese el nuevo nombre del mago: ");
					nombreNuevo = sc.nextLine();
					sistema.modificarMago(nombre1, nombreNuevo);
				}
			}
	
			if (validarHechizo && !nombre1.equalsIgnoreCase("")) {
				if (cambiarHechizos.equals("si")) {
					System.out.print("Ingrese la cantidad de hechizos que quiere en el mago: ");
					cantHechizos = Integer.valueOf(sc.nextLine());
					while (cantHechizos < 1) {
						System.out.print("Error. Debe tener mas de 1 hechizo. Ingrese nuevamente: ");
						cantHechizos = Integer.valueOf(sc.nextLine());
					}
					String listaHechizos = "";
					for (int i = 0; i < cantHechizos; i++) {
						System.out.print("Ingrese el nombre del hechizo: ");
						String nombreHechizo = sc.nextLine();
	
						if (i + 1 < cantHechizos) {
							listaHechizos += nombreHechizo + ";";
						} else {
							listaHechizos += nombreHechizo;
						}
	
					}
					if (cambiarName.equals("si")) {
						sistema.modificarHechizoMago(nombreNuevo, listaHechizos);
					} else {
						sistema.modificarHechizoMago(nombre1, listaHechizos);
					}
	
				}
	
			}
		}catch(Exception e) {
			System.out.println("No valido --> " + e.getMessage());
		}
	}

	private static void eliminarHechizo() throws Exception {
		System.out.println();
		System.out.print("Ingrese el nombre del hechizo a eliminar: ");
		String nombre = sc.nextLine();
		sistema.eliminarHechizo(nombre);

	}

	private static void eliminarMago() throws Exception {
		System.out.println();
		System.out.print("Ingrese el nombre del mago a eliminar: ");
		String nombre = sc.nextLine();
		sistema.eliminarMago(nombre);

	}

	private static void agregarMago() throws Exception {
		try {
			int cantHechizos = 0;
			System.out.print("Ingrese el nombre del mago: ");
			String nombre = sc.nextLine();
			System.out.println("Cantidad de poderes que quieres que tenga: ");
			
			cantHechizos = Integer.valueOf(sc.nextLine());
	
			while (cantHechizos < 1) {
				System.out.println("Ingrese una cantidad correcta. Un mago debe tener al menos 1 hechizo: ");

				cantHechizos = Integer.valueOf(sc.nextLine());
			}
			String listaHechizos = "";
			for (int i = 0; i < cantHechizos; i++) {
				System.out.print("Ingrese el nombre del hechizo que le quiere agregar: ");
				String nombreHechizo = sc.nextLine().toLowerCase();
				if (i + 1 < cantHechizos) {
					listaHechizos += nombreHechizo + ";";
				} else {
					listaHechizos += nombreHechizo;
				}
	
			}
			sistema.agregarMago(nombre, listaHechizos);
		}catch(Exception e) {
			System.out.println("No valido " + e.getMessage());
		}
		

	}

	private static boolean validarDatos(String cambio) {
		if (!cambio.equals("si") && !cambio.equals("no")) {
			return false;
		}

		return true;
	}

	private static String itemsExtras(String tipo) {
		if (tipo != null) {
			if (tipo.equalsIgnoreCase("Agua")) {
				System.out.print("Cantidad Heal: ");
				String cantHeal = sc.nextLine();
				System.out.print("Presion del agua: ");
				String presionAgua = sc.nextLine();
				return cantHeal + "," + presionAgua;
				
			} else if (tipo.equalsIgnoreCase("Tierra")) {
				System.out.print("Mejora Defensa: ");
				String mejoraDefensa = sc.nextLine();
				return mejoraDefensa;
				
			} else if (tipo.equalsIgnoreCase("Planta")) {
				System.out.print("Duracion stun: ");
				String duracionStun = sc.nextLine();
				System.out.print("Cantidad de plantas: ");
				String cantPlantas = sc.nextLine();
				return duracionStun + "," + cantPlantas;

			} else if (tipo.equalsIgnoreCase("Fuego")) {
				System.out.print("Duracion quemadura: ");
				String duracionQuemadura = sc.nextLine();
				return duracionQuemadura;

			}

		}

		return null;
	}

	private static String validarTipo(String tipo) {
		if (tipo.equals("agua")) {
			return "Agua";
		} else if (tipo.equals("tierra")) {
			return "Tierra";
		} else if (tipo.equals("planta")) {
			return "Planta";
		} else if (tipo.equals("fuego")) {
			return "Fuego";
		}
		return null;
	}
