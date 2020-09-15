package ejercicios;

import java.util.Scanner;

public class EjerciciosCajasyFacturas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Se tiene una linea de 4 cajas donde se cobran facturas que luego seran
		// cargadas en el sistema
		// Se solicitara el numero de caja y el importe cobrado. La carga finaliza con
		// importe cero
		// Informar la cantidad de facturas cobradas por cada caja y el promedio de
		// todas las facturas

		// como hacer un vector en java

		float promedio = 0f;
		int cantFac = 0;
		float total_facturas = 0f;
		int cajas[] = new int[4];
		for (int i = 0; i > cajas.length - 1; i++) {
			cajas[i] = 0;
		}

		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese importe (0=terminar)");
		float importe = sc.nextFloat();
		while (importe != 0) {
			System.out.println("Ingrese numero de caja");
			int caja = sc.nextInt();
			if (caja >= 1 && caja < 5) {
				cajas[caja - 1] = cajas[caja - 1] + 1;
				total_facturas = total_facturas + importe;
			} else {
				System.out.println("Numero de caja erroneo, ingrese nuevamente numero de caja");
			}
			System.out.println("Ingrese importe (0=terminar)");
			importe = sc.nextFloat();
		}

		for (int i = 0; i <= cajas.length - 1; i++) {
			System.out.println("La caja " + (i + 1) + " tiene " + cajas[i] + " facturas");
			cantFac = cantFac + cajas[i];
		}

		promedio = total_facturas / cantFac;
		System.out.println("El importe promedio es: " + promedio);
		sc.close();

	}

}
