package Logica;


public interface Sistema {

	void crearMago(String nombre, String hechizos) throws Exception;
	void crearHechizo(String[] partes) throws Exception;
	void agregarMago(String nombre, String listaHechizos) throws Exception;
	void modificarMago(String nombre, String tipoNuevo) throws Exception;
	void eliminarMago(String nombre) throws Exception;
	void agregarHechizo(String hechizo) throws Exception;
	void modificarHechizoNombre(String nombre, String nombreNuevo) throws Exception;
	void modificarHechizoDaño(String nombre, int dañoNuevo) throws Exception;
	void modificarHechizoTipo(String nombre, String tipoNuevo, int extra) throws Exception;
	void modificarHechizoTipo(String nombre, String tipoNuevo, int extra, int extra2) throws Exception;
	void eliminarHechizo(String nombre) throws Exception;
	void mostrarDiezHechizos();
	void mostrarTresMagos();
	void mostrarHechizos();
	void mostrarMagos();
	void mostrarHechizosPuntuacion();
	void mostrarMagosPuntuacion();
	void modificarHechizoMago(String nombre, String listaHechizos) throws Exception;
	void guardarMagos() throws Exception;
	void guardarHechizos() throws Exception;
}
