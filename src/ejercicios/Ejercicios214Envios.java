package ejercicios;

import java.util.Scanner;

public class Ejercicios214Envios {

	private static final int PES0_MAX = 5000;
	private static final int ZONA_1 = 11;
	private static final int ZONA_2 = 10;
	private static final int ZONA_3 = 12;
	private static final int ZONA_4 = 24;
	private static final int ZONA_5 = 27;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese peso del envio");
		int peso = sc.nextInt();

		if (peso > 0 && peso <= PES0_MAX) {
			System.out.println("Ingrese zona a la que desea enviar el paquete (1, 2, 3, 4, 5)");
			int zona = sc.nextInt();
			int costoEnvio = 0;
			switch (zona) {
			case 1:
				costoEnvio = peso * ZONA_1;
				break;
			case 2:
				costoEnvio = peso * ZONA_2;
				break;
			case 3:
				costoEnvio = peso * ZONA_3;
				break;
			case 4:
				costoEnvio = peso * ZONA_4;
				break;
			case 5:
				costoEnvio = peso * ZONA_5;
				break;
			}

			System.out.println("El costo del envio sera de: " + costoEnvio);

		} else {
			System.out.println("No se puede realizar el envio");
			sc.close();
		}

	}
}
