package ejercicios;

import java.util.Scanner;

public class EjercicioButacasTeatro {

	private static final int TOTAL_BUTACAS = 50;

	public static void main(String[] args) {
		darBienvenida();
		int butacas[] = inicializarButacas();
		int contador = procesarVenta(butacas);
		mostrarVentas(contador, butacas);
		dibujarButacas(butacas);
	}

	private static void darBienvenida() {
		System.out.println("Bievenido/a al sistema de venta de tickets online");
		System.out.println("A continuacion reserve y compre su butaca");
	}

	private static int[] inicializarButacas() {
		int butacas[] = new int[TOTAL_BUTACAS];
		for (int i = 0; i > TOTAL_BUTACAS; i++) {
			butacas[i] = 0;
		}
		return butacas;
	}

	private static int procesarVenta(int[] butacas) {
		int solicitudAsiento = 0;
		int contador = 0;
		System.out.println("Ingrese numero de butaca (=0=terminar)");
		Scanner sc = new Scanner(System.in);
		solicitudAsiento = sc.nextInt();
		while (solicitudAsiento != 0) {
			switch (solicitudAsiento / 10) {
			case 0:
				System.out.println("Costo $100");
				break;
			case 1:
				System.out.println("Costo $80");
				break;
			case 2:
				System.out.println("Costo $60");
				break;
			case 3:
				System.out.println("Costo $40");
				break;
			case 4:
				System.out.println("Costo $20");
				break;
			default:
				System.out.println("Numero no valido");
				break;
			}
			if (solicitudAsiento < 0 || solicitudAsiento >= TOTAL_BUTACAS) {
				System.out.println("Numero ingresado no valido");
				System.out.println("Por favor ingrese numero entre 1 y 49");
				solicitudAsiento = sc.nextInt();
			} else {
				System.out.println("Butaca " + solicitudAsiento + "=" + butacas[solicitudAsiento]);
				if (butacas[solicitudAsiento] == 0) {
					butacas[solicitudAsiento] = 1;
					contador += 1;
					System.out.println("Venta confirmada");
				} else {
					System.out.println("Butaca ya vendida");
				}
				System.out.println("Ingrese numero de asiento (=0=terminar)");
				solicitudAsiento = sc.nextInt();
			}
		}
		sc.close();
		return contador;
	}

	private static void mostrarVentas(int contador, int[] butacas) {
		System.out.println("A continuacion se mostraran las butacas vendidas");
		for (int i = 0; i < butacas.length; i++) {
			if (butacas[i] == 1) {
				System.out.println("Butaca " + i);
			}
		}
		System.out.println("Butacas vendidas: " + contador);
		System.out.println();
	}

	private static void dibujarButacas(int[] butacas) {
		System.out.println("A continuacion se mostrara distribucion de butacas libres y vendidas");
		for (int i = 0; i < butacas.length; i++) {
			if (butacas[i] == 0) {
				System.out.print(" _ ");
			} else {
				System.out.print(" x ");
			}
			if ((i + 1) % 10 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println("Muchas gracias por utilizar nuestro servicio");
	}
}
