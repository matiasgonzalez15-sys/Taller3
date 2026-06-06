package Logica;


public interface Sistema {

	void crearMago(String nombre, String listaHechizos) throws Exception;
	void crearHechizo(String[] partes) throws Exception;
	void mostrarDiezHechizos();
    void mostrarTresMagos();
    void mostrarHechizos();
    void mostrarMagos();
    void mostrarHechizosConPuntuacion();
    void mostrarMagosConPuntuacion();
}
