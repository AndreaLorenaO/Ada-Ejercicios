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
		Butaca butaca;
		while (posicion != 99) {
			butaca = new Butaca(); // siempre inicializar asi para poder usar luego
			butaca.mostrarPrecio();
			butaca.setPosicion(posicion);
			if (butacas[posicion].isOcupado()) {
				System.out.println("Butaca no disponible, la butaca ya se ha vendido");
			} else {
				butaca.setOcupado(true);
				butacas[posicion] = butaca;
				System.out.println("Butaca confirmada");
			}
		}

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

}
