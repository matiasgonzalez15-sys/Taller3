# Taller3

Integrantes: Matias Gonzalez, Maximiliano Abd-El-Kader

Docentes: Alejandro Paolini, Cristian Rabi, Juan Nilo.

Ayudantes: Nicolás Rojas (Talleres), Catalina Galleguillos (Catedra), Martin Droguett (Catedra), Estefania Ulloa(Catedra).

Este proyecto consiste en el desarrollo de un sistema de gestión para un juego de magia, donde cada mago posee un repertorio de uno o más hechizos pertenecientes a distintos elementos: Fuego, Roca, Planta y Agua. El sistema fue desarrollado en Java aplicando los principios de Programación Orientada a Objetos, utilizando herencia para modelar los distintos tipos de hechizos a partir de una clase abstracta base, e interfaces para definir el contrato del sistema. La arquitectura separa el punto de entrada (Main) de la lógica de negocio (Sistema), siguiendo los lineamientos de diseño establecidos en el curso. Las colecciones de magos y hechizos son gestionadas mediante LinkedList, y toda la información es cargada al inicio desde archivos de texto (Magos.txt y Hechizos.txt), manteniéndose sincronizada con estos archivos ante cualquier modificación mediante BufferedWriter. El sistema cuenta con dos paneles: el panel Administrador, que permite agregar, modificar y eliminar tanto magos como hechizos, reflejando los cambios en los archivos correspondientes; y el panel Analista, que permite visualizar rankings de los mejores magos y hechizos según su puntuación, calculada con fórmulas específicas para cada tipo de elemento. Finalmente, se entregaron el Diagrama de Clases y el Modelo de Dominio en formato PDF como parte de los entregables del taller.
