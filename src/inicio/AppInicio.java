package inicio;

import Bicicleta.bicicleta;

/**
 * JAVADOC: es una forma standar de escribir documentacion para clase o metodo
 * 
 * @author lore_
 *
 */

/* para comentarios de varias lineas */

//metodo publico de nombre main con parametros
//los parametros van entre parantesis
//main es el unico metodo ejecutable
public class AppInicio {
	/**
	 * Metodo que inicia la aplicacion
	 * 
	 * @param args
	 */
	public static void main(String[] args) { // esto es la firma del metodo, en este caso del metodo main

		Bicicleta bic = new bicicleta();
		bic.acelerar(10);
	}
}

//javac es el archivo que compila y esta dentro de program files/java/jdk