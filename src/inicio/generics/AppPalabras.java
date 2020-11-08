package inicio.generics;

import java.util.Map;
import java.util.TreeMap;

//Buscar en internet un texto (parrafo)
//Investigar metod split en String (java api String en google)
//metodo split de String separa un string en un array de string dado un caracter
//Guardamos en una variable el texto seleccionado, lo separamos mediante el metod split
//en un array de palabras
//Generar un mapa que contenga la palabra y la cantidad de veces que se repitio esa palabra
//en el texto

//Opcional: obtener la palabra de mayor repeticion

public class AppPalabras {

	public static void main(String[] args) {
		String texto = "In computer science, an abstract data type (ADT) is a mathematical model for a certain class of data structures that have similar behavior; or for certain data types of one or more programming languages that have similar semantics. An abstract data type is defined indirectly, only by the operations that may be performed on it and by mathematical constraints on the effects (and possibly cost) of those operations";
		@SuppressWarnings("unused")
		String[] arrayOfStrings = texto.split("\\s+|(?=[,.])");
		AlfabeticaDescendente alfabeticaDescendente = new AlfabeticaDescendente();
		Map<String, Integer> palabras = new TreeMap<String, Integer>(alfabeticaDescendente);
		for (int i = 0; i < arrayOfStrings.length; i++) {
			if (palabras.get(arrayOfStrings[i]) == null) {
				palabras.put(arrayOfStrings[i], 1);
			} else {
				Integer total = palabras.get(arrayOfStrings[i]);
				palabras.put(arrayOfStrings[i], ++total);
			}
		}
//		System.out.println(palabras);
		palabras.forEach((k, v) -> {
			System.out.println((k + ":" + v));
		});

	}

}
