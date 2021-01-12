package io;

import java.util.List;

public class AppLecturaArchivo {

	public static void main(String[] args) {
		List<String> opciones = Util.lecturaArchivo("src/io/opciones.txt");
//		opciones.forEach(System.out::println);
		String encabezado = opciones.get(8);
		System.out.println();
		System.out.println(encabezado);
	}

//	String[] opciones = lecturaArchivo("opciones.txt");
//	Genera la clase Util
//	String[] opciones = Util.lecturaArchivo("opciones.txt");
//	Le paso la ruta, no el nombre del archivo solo
//	String[] opciones = Util.lecturaArchivo(""src/io/opciones.txt"");

}