package ejercicios;

import java.util.Scanner;

public class EjerciciosCiudadesyParadas2 {

	public static void main(String[] args) {
		mostrarTitulo();
		procesar();
	}

	private static int[] procesar() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Ingrese cantidad de estaciones intermedias: ");
		int totalEstaciones = sc.nextInt();
		float acumuladorKm = 0f;
		int ciudades[] = new int[totalEstaciones];
		for (int i = 0; i < ciudades.length; i++) {
			System.out.print("Ingrese km a estacion " + (i + 1) + ": ");
			ciudades[i] = sc.nextInt();
			acumuladorKm += ciudades[i];
//				acumuladorKm = acumuladorKm + ciudades[i];
		}
		System.out.println("La distancia promedio entre ciudades es: " + acumuladorKm / totalEstaciones);
		sc.close();

		System.out.print(" * ");

		for (int j = 0; j < ciudades.length; j++) {
			dibujarTrayecto(ciudades[j]);
			// esta es una funcion para agrupar todo: que dibuje linea por cada estacion por
			// cada vez dentro del bucle
		}
		return ciudades;
	}

	private static void mostrarTitulo() {
		System.out.println("Sistema de estaciones en ruta");
		System.out.println();
	}

	private static void dibujarTrayecto(int distancia) {
		// distancia es el parametro para que funcione el metodo dibujarTrayecto
		// este metodo es privado y sera llamado por el publico las veces que itere
		// por cada estacion (bucle), se imprime la cant de lineas segun km
		for (int i = 0; i < distancia; i++) {
			System.out.print("-");
		}
		// se imprime un *
		System.out.print(" * ");

	}

}
