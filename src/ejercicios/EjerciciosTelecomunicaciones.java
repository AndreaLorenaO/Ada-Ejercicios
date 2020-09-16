package ejercicios;

import java.util.Scanner;

public class EjerciciosTelecomunicaciones {

	private static final int COSTO_TELEF = 1000;
	private static final int COSTO_BANDA = 1500;
	private static final int COSTO_TV = 2000;

	public static void main(String[] args) {
		int servicios[] = inicializarServicios();
		procesarVenta(servicios);
	}

	private static int[] inicializarServicios() {
		int servicios[] = new int[3];
		for (int i = 0; i > servicios.length; i++) {
			servicios[i] = 0;
		}
		return servicios;
	}

	private static int procesarVenta(int[] servicios) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Bienvenido al sistema online de servicio de comunicaciones");
		System.out.println("Por favor, ingrese numero de cliente (0=terminar)");
		int cliente = sc.nextInt();
		while (cliente != 0) {
			if (cliente > 0) {
				System.out.println(
						"Por favor ingrese el numero de servicio que desea contratar (1=telefonia, 2=banda ancha, 3=television)");
				int servicio = sc.nextInt();
				if (0 < servicio && servicio <= 3) {
					servicios[servicio - 1] = servicios[servicio - 1] + 1;
					System.out.println("Por favor, ingrese numero de cliente");
					cliente = sc.nextInt();
				} else {
					System.out.println("Numero ingresado no valido");
				}
			} else {
				System.out.println("Numero ingresado no valido");
				System.out.println("Por favor, ingrese numero de cliente (0=terminar)");
				cliente = sc.nextInt();
			}
		}
		int totalRecaudado = 0;
		totalRecaudado = (servicios[0] * COSTO_TELEF) + (servicios[1] * COSTO_BANDA) + (servicios[2] * COSTO_TV);
		System.out.println("El total recaudado es: " + totalRecaudado);
		for (int i = 0; i < servicios.length; i++) {
			System.out.println("La cantidad de servicios " + (i + 1) + " vendidos es " + servicios[i]);
		}
		sc.close();
		return totalRecaudado;
	}
}