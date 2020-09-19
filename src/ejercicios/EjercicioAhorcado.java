package ejercicios;

import java.util.Scanner;

public class EjercicioAhorcado {

	private static final int MIN_PALABRA = 4;
	private static final int MAX_PALABRA = 10;
	private static final int MAX_ERRORES = 10;

	public static void main(String[] args) {
		String palabra = generarPalabra();
		int intentosFallidos = adivinar(palabra);
		mostrarPuntos(intentosFallidos);
	}

	private static String generarPalabra() {
		System.out.println("Empecemos a jugar!");
		System.out.println("Antes que nada la palabra tiene que tener un minimo de " + MIN_PALABRA + " letras");
		System.out.println("... Y un maximo de " + MAX_PALABRA + " letras");
		System.out.println("Ahora si! Ingresa la palabra secreta");
		Scanner sc = new Scanner(System.in);
		String palabra = sc.nextLine();
		while (palabra.length() < MIN_PALABRA || palabra.length() > MAX_PALABRA) {
			System.out.println("Oops, palabra invalida");
			System.out.println(
					"Recorda las reglas: minimo de " + MIN_PALABRA + " y un maximo de " + MAX_PALABRA + " letras");
			System.out.println("Por favor, ingresa otra palabra");
			palabra = sc.nextLine();
			// while (!espalabraValida(palabra)) {
			// private static boolean espalabraValida(String palabra) {
			// return (palabra.length() >= MIN_PALABRA && palabra.length() <= MAX_PALABRA);
			// }
		}
		return palabra.toUpperCase();
	}

	private static int adivinar(String palabra) {
		int contadorAciertos = 0;
		int contadorErrores = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingresa una letra");
		String letra = sc.nextLine();
		boolean[] letrasCorrectas = new boolean[palabra.length()];
		// con booleanos los lugares dentro del vector por defecto seran false
		// char[] vectorLetras = new char[palabra.length];
		// con char van los lugares dentro del vector arrancan vacios
		while (contadorAciertos < palabra.length() && contadorErrores != MAX_ERRORES) {
			int posicionLetra = palabra.indexOf(letra.toUpperCase()); // si la letra no existe devuelve -1
			if (posicionLetra != -1) {
				letrasCorrectas[posicionLetra] = true;
				contadorAciertos++;
			} else {
				contadorErrores++;
			}
			for (int i = 0; i < palabra.length(); i++) {
				if (letrasCorrectas[i]) {
					// la condicion no entra en la declaracion del if porque al ser boolenao ya
					// esta implicito
					System.out.print(" " + palabra.charAt(i) + " ");
				} else {
					System.out.print(" _ ");
				}
			}
			System.out.println();
			System.out.println("Parece que... ya vas acumulando un total de errores: " + contadorErrores);
			if (contadorAciertos < palabra.length() && contadorErrores != MAX_ERRORES) {
				System.out.println("Ingresa una letra");
				letra = sc.nextLine();
			}

		}
		if (contadorErrores == MAX_ERRORES) {
			System.out.println("Buuuu... intenta la proxima");
		} else {
			System.out.println("Parece que tenemos un ganador!!");
		}
		return contadorErrores;
	}

	private static void mostrarPuntos(int intentosFallidos) {
		int puntaje = MAX_PALABRA - intentosFallidos;
		System.out.println("El puntaje obtenido es: " + puntaje);
	}

}
