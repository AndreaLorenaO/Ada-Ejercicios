package inicio.enviopaquetes;

import java.util.Scanner;

public class AppEnvios {

	public static void main(String[] args) {
		System.out.println("Bienvenido al sistema de envio");
		System.out.println();
		float pesoEnvio = solicitarPesoEnvio();
		int zona;
		while (pesoEnvio != 0) {
			zona = solicitudZona();
			Paquete paq = new Paquete(pesoEnvio, zona); // aca le paso al peso el pesoEnvio
			if (paq.isEnviable()) {
				float precioTotal = paq.calcularPrecio();
				System.out.println("El valor total del envio es: " + precioTotal);
			} else {
				System.out.println("El peso del paquete excede lo permitido para enviar");
			}
			pesoEnvio = solicitarPesoEnvio();
		}

	}

	private static int solicitudZona() {
		System.out.println("Ingrese zona a la que desea realizar el envio");
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

	private static float solicitarPesoEnvio() {
		System.out.println("Ingrese peso del envio (0 para finalizar)");
		Scanner sc = new Scanner(System.in);
		return sc.nextFloat();
	}

}
