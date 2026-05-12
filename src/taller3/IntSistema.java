package taller3;

public interface IntSistema {
	void crearMago(String nombre, String hechizos) throws Exception;
	void crearHechizo(String[] partes) throws Exception;
	void agregarMago() throws Exception;
	void modificarMago() throws Exception;
	void eliminarMago() throws Exception;
	void agregarHechizo() throws Exception;
	void modificarHechizo() throws Exception;
	void eliminarHechizo() throws Exception;
	void mostrarDiezHechizos() throws Exception;
	void mostrarTresMagos() throws Exception;
	void mostrarHechizos() throws Exception;
	void mostrarMagos() throws Exception;
	

}
