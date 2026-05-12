package taller3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	public static Sistema sistema = new Sistema();
	

	public static void main(String[] args) throws Exception {
		leerHechizos();
		leerMagos();
		menuPrincipal();

	}

	private static void leerHechizos() throws Exception {
		File arch = new File("Hechizos.txt");
		Scanner lector = new Scanner(arch);
		while(lector.hasNext()) {
			String linea = lector.nextLine();
			String[] partes = linea.split(";");
			sistema.crearHechizo(partes);
		}
		
		
	}

	private static void leerMagos() throws Exception {
		File arch = new File("Magos.txt");
		Scanner lector = new Scanner(arch);
		while(lector.hasNext()) {
			String linea = lector.nextLine();
			String[] partes = linea.split(";");
			String nombre = partes[0];
			String hechizos = partes[1];
			sistema.crearMago(nombre, hechizos);
			
		}
		
		
		
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
		// TODO Auto-generated method stub
		
	}

	private static void menuAdministrador() {
		// TODO Auto-generated method stub
		
	}

}
