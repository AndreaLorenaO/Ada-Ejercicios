package ejercicios;

import java.util.Scanner;

public class Ejercicio2_3Lapices {

	private static final int PRECIO_MIN = 90;
	private static final int PRECIO_MAY = 85;
	private static final int CANT_LIM = 1000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese la cantidad de lapices");
		int lapices = sc.nextInt();
		int total = 0;
		// el int total se define fuera del if para que el programa lo pueda leer tanto
		// antes como despues del if
		if (lapices < CANT_LIM) {
			total = lapices * PRECIO_MIN;
		} else {
			total = lapices * PRECIO_MAY;
		}

		System.out.println("El total es: " + total);
		sc.close();

	}
}
