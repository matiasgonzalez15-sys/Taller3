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

	private static Sistema sys = new SistemaImpl();
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception {
		leerMagos();
		leerHechizos();
		menuPrincipal();
	}

	private static void leerHechizos() throws Exception {
		
		   Scanner lector = new Scanner(new File("Hechizos.txt"));

		   while (lector.hasNextLine()) {
		       String[] parts = lector.nextLine().split(";");
		       sys.crearHechizo(parts);
		    }

		    lector.close();
		}

	
	private static void leerMagos() throws Exception {
	    Scanner lector = new Scanner(new File("Magos.txt"));

	    while (lector.hasNextLine()) {
	        String[] parts = lector.nextLine().split(";");
	        String nombre = parts[0];
	        String listaHechizos = parts[1];
	        sys.crearMago(nombre, listaHechizos);
	    }

	    lector.close();
	}
	private static void menuPrincipal() {
		boolean correcta = true;
		int opcion = -1;
		while(correcta) {
			System.out.println("Que menú desea elegir?");
			System.out.println("1) Menú del administrador.");
			System.out.println("2) Menú del analista.");
			System.out.print("Ingrese opcion: ");
			try {
				opcion = Integer.valueOf(sc.nextLine());
			}catch(Exception e) {
				System.out.println("Opcion no valida, " + e.getMessage());
			}
			if(opcion > 2 || opcion < 1) {
				System.out.println("Opcion invalida");
			}
			else {
				correcta = false;
				switch(opcion) {
				case 1:
					menuAdministrador();
					break;
				case 2:
					menuAnalista();
					break;
				}
			}
		}
		
	}

	private static void menuAnalista() {
		String opcion = "";
		do {
			System.out.println("BIENVENIDO AL MENU ANALISTA...");
			System.out.println("1. Top 10 Mejores Hechizos");
			System.out.println("2. Top 3 Mejores Magos");
			System.out.println("3. Mostrar todos los Hechizos");
			System.out.println("4. Mostrar todos los magos");
			System.out.println("5. Mostrar todos los Hechizos junto a su puntuacion");
			System.out.println("6. Mostrar todos los magos junto a su puntuacion");
			System.out.println("0. Para salir");
			System.out.print("Ingrese una opcion: ");
			opcion = sc.nextLine();
			switch (opcion) {
			
			case "1" :
				sys.mostrarDiezHechizos();
				System.out.println();
				break;
			case "2" :
				sys.mostrarTresMagos();
				System.out.println();
				break;
			case "3" :
				sys.mostrarHechizos();
				System.out.println();
				break;
			case "4" :
				sys.mostrarMagos();
				System.out.println();
				break;
			case "5" :
				sys.mostrarHechizosConPuntuacion();
				System.out.println();
				break;
			case "6":
				sys.mostrarMagosConPuntuacion();
				System.out.println();
				break;
			case "0":
				System.out.println("Saliendo...");
				break;
			default:
				break;
			}
			
			
		} while (!opcion.equals("0"));
		
		
	}

	private static void menuAdministrador() {
		// TODO Auto-generated method stub
		
	}	
}
