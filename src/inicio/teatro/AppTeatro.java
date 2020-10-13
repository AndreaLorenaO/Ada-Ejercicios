package inicio.teatro;

import java.util.Scanner;

//Se venden boletos de una funcion numerados del 0-49. Cada uno de esos boletos
//se corresponde con una butaca que tiene fila y columna.
//Solicitar que asiento elige la persona al  comprarlo y marcarlo (de alguna manera)
//Se ingresan valores de fila hasta que se ingrese fila 0
//Listar los asientos vendidos

public class AppTeatro {

	private static final int TOTAL_BUTACAS = 50;

	public static void main(String[] args) {
		Butaca[] butacas = new Butaca[50];
		for (int i = 0; i < TOTAL_BUTACAS; i++) {
			butacas[i] = new Butaca();
		}
		darBienvenida();
		int posicion = solicitarPosicion("posicion");
		while (posicion != 99) {
			mostrarPrecio(posicion);
			Butaca but = Butaca.crear();
			// but = new Butaca(); // siempre inicializar asi para poder usar luego
			but.setPosicion(posicion);
			validarPosicion(posicion);
			if (butacas[posicion].isOcupado()) {
				System.out.println("Butaca no disponible, la butaca ya se ha vendido");
			} else {
				but.setOcupado(true);
				butacas[posicion] = but;
				System.out.println("Butaca confirmada");
			}
			posicion = solicitarPosicion("posicion");
		}
		for (int j = 0; j < butacas.length; j++) {
			if (butacas[j].isOcupado()) {
				System.out.println("Butaca vendida numero " + butacas[j].getPosicion());
			}

		}
		System.out.println();
		System.out.println("Muchas gracias por utilizar nuestro servicio");
	}

	private static void darBienvenida() {
		System.out.println("Bievenido/a al sistema de venta de tickets online");
		System.out.println("A continuacion reserve y compre su butaca");
	}

	private static int solicitarPosicion(String x) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese numero de butaca (99=terminar)");
		return sc.nextInt();
	}

	private static void mostrarPrecio(int posicion) {
		switch (posicion / 10) {
		case 0:
			System.out.println("La butaca has seleccionado cuesta $100");
			break;
		case 1:
			System.out.println("La butaca has seleccionado cuesta $80");
			break;
		case 2:
			System.out.println("La butaca has seleccionado cuesta $60");
			break;
		case 3:
			System.out.println("La butaca has seleccionado cuesta $40");
			break;
		case 4:
			System.out.println("La butaca has seleccionado cuesta $20");
			break;
		default:
			System.out.println("Numero no valido");
			break;
		}
	}

	private static int validarPosicion(int posicion) {
		while (posicion < 0 || posicion >= TOTAL_BUTACAS) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Numero ingresado no valido");
			System.out.println("Por favor ingrese numero entre 1 y 49");
			posicion = sc.nextInt();
		}
		return posicion;
	}
}
