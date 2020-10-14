package inicio.enviopaquetes;

import java.util.Scanner;

public class Envios {

	private static float ZONA_1 = 11;
	private static float ZONA_2 = 10;
	private static float ZONA_3 = 12;
	private static float ZONA_4 = 24;
	private static float ZONA_5 = 27;

	protected int zona;
	protected boolean enviable;
	protected float precioBase;

	public int getZona() {
		return zona;
	}

	public void setZona(int zona) {
		this.zona = zona;
	}

	public boolean isEnviable() {
		return enviable;
	}

	public void setEnviable(boolean enviable) {
		this.enviable = enviable;
	}

	public float getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(float precioBase) {
		this.precioBase = precioBase;
	}

	public static void Bienvenida() {
		System.out.println("Bienvenido al sistema de envio");
		System.out.println();
		System.out.println("Elija opcion 1-paquetes, opcion 2-cartas, opcion 3-dinero, 0=terminar");
	}
	
	public static int solicitudZona() {
		System.out.println("Ingrese zona a la que desea realizar el envio");
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

	public float calcularPrecio() {
		float costoEnvio = 0;
		switch (zona) {
		case 1:
			costoEnvio = precioBase * ZONA_1;
			break;
		case 2:
			costoEnvio = precioBase * ZONA_2;
			break;
		case 3:
			costoEnvio = precioBase * ZONA_3;
			break;
		case 4:
			costoEnvio = precioBase * ZONA_4;
			break;
		case 5:
			costoEnvio = precioBase * ZONA_5;
			break;
		}
		return costoEnvio;
	}

}
