package inicio.enviopaquetes;

import java.util.Scanner;

public class AppEnvios {

	public static void main(String[] args) {
		Envios.Bienvenida();
		Scanner sc = new Scanner(System.in);
		int opcion = sc.nextInt();
		while (opcion != 0) {
			switch (opcion) {
			case 1:
				envioPaquete();
				break;
			case 2:
				envioCarta();
				break;
			case 3:
				envioDinero();
				break;
			}
			System.out.println("Elija opcion 1-paquetes, opcion 2-cartas, opcion 3-dinero, 0=terminar");
			opcion = sc.nextInt();
		}
		System.out.println();
		System.out.println("Muchas gracias por utilizar nuestro servicio");
	}

	private static int solicitudZona() {
		System.out.println("Ingrese zona a la que desea realizar el envio");
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

	private static float solicitarFloat(String mensaje) {
		Scanner sc = new Scanner(System.in);
		System.out.println(mensaje);
		return sc.nextFloat();
	}

	private static int solicitarInt(String mensaje) {
		Scanner sc = new Scanner(System.in);
		System.out.println(mensaje);
		return sc.nextInt();
	}

	private static void envioPaquete() {
		float pesoEnvio = solicitarFloat("Ingrese peso del envio");
		if (pesoEnvio != 0) {
			Paquetes paq = new Paquetes(pesoEnvio);
			if (paq.isEnviable()) {
				int zona = solicitudZona();
				paq.setZona(zona);
				float precioTotal = paq.calcularPrecio();
				System.out.println("El valor total del envio es: " + precioTotal);
			} else {
				System.out.println("El peso del paquete excede lo permitido para enviar");
				System.out.println();
			}
		}
	}

	private static void envioCarta() {
		int cantEnvio = solicitarInt("Ingrese cantidad de cartas a enviar");
		Cartas car = new Cartas(cantEnvio);
		if (car.isEnviable()) {
			int zona = solicitudZona();
			car.setZona(zona);
			float precioTotal = car.calcularPrecio();
			System.out.println("El valor total del envio es: " + precioTotal);
		} else {
			System.out.println("La cantidad de cartas excede lo permitido para enviar");
			System.out.println();
		}
	}

	private static void envioDinero() {
		float cantDinero = solicitarFloat("Ingrese cantidad de dinero a enviar");
		Dinero din = new Dinero(cantDinero);
		if (din.isEnviable()) {
			int zona = solicitudZona();
			din.setZona(zona);
			float precioTotal = din.calcularPrecio();
			System.out.println("El valor total del envio es: " + precioTotal);
		} else {
			System.out.println("La cantidad de cartas excede lo permitido para enviar");
			System.out.println();
		}
	}
}
