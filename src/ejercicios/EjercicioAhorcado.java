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
		return palabra;
	}

	private static int adivinar(String palabra) {
		int aciertos = 0;
		int errores = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese una letra");
		String letra = sc.nextLine();
		boolean[] resultado = new boolean[palabra.length()];
		while (aciertos < palabra.length() && errores != MAX_ERRORES) {
			int posicion = palabra.indexOf(letra); // por ahora palabras sin letras repetidas
			if (posicion != -1) {
				resultado[posicion] = posicion != -1;
				aciertos++;
			} else {
				errores++;
			}
			for (int i = 0; i < palabra.length(); i++) {
				if (resultado[i]) {
					System.out.print(" " + palabra.charAt(i) + " ");
				} else {
					System.out.print(" _ ");
				}
			}
			System.out.println();
			System.out.println("Cuidado... ya vas acumulando un total de errores: " + errores);
			System.out.println("Ingrese una letra");
			letra = sc.nextLine();
		}
		if (errores == MAX_ERRORES) {
			System.out.println("Buuuu... intenta la proxima");
		} else {
			System.out.println("Parece que tenemos un ganador");
		}
		return errores;
	}

	private static void mostrarPuntos(int intentosFallidos) {
		int puntaje = MAX_PALABRA - intentosFallidos;
		System.out.println("El puntaje obtenido es: " + puntaje);
	}

}
