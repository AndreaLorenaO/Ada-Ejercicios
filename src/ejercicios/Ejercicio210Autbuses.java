package ejercicios;

import java.util.Scanner;

public class Ejercicio210Autbuses {

	private static final int MINIMO_PERSONAS = 20;
	private static final int COSTO_A = 2;
	private static final float COSTO_B = 2.5f;
	// f (float) o d (double) al final de un numero primitivo para que tome el valor
	private static final int COSTO_C = 3;
	private static final String BUS_A = "A";
	private static final String BUS_B = "B";
	private static final String BUS_C = "C";

	public static void main(String[] args) {
		// tres costos diferentes por km
		// para cada autobus
		// minimo de 20 personas
		// cantidad de km para saber el costo total
		// determinar costo total y costo total por persona

		// solicitar cantidad de personas
		Scanner sc = new Scanner(System.in);
		// con este objeto sc ya puedo leer todas las variables que pida
		System.out.println("Ingrese cantidad de personas");
		int personas = sc.nextInt();

		// solicitar la cant de km
		System.out.println("Ingrese cantidad de km");
		int km = sc.nextInt();

		// solicitar tipo de autobuses
		System.out.println("Ingrese tipo de autobus (A, B, C)");
		String tipo = sc.next();

		System.out.println("Ingreso: " + personas);
		System.out.println("Ingreso: " + km);
		System.out.println("Ingreso: " + tipo);

		int totalPersonas = MINIMO_PERSONAS;
		// calcular el costo
		if (personas > MINIMO_PERSONAS) {
			totalPersonas = personas;
		}
		int costoTotal = totalPersonas * km;
		float totalGrupal = 0;

		switch (tipo.toUpperCase()) {
		case BUS_A:
			totalGrupal = costoTotal * COSTO_A;
			break;
		case BUS_B:
			totalGrupal = costoTotal * COSTO_B;
			break;
		case BUS_C:
			totalGrupal = costoTotal * COSTO_C;
			break;
		}

		System.out.println("El total grupal es: " + totalGrupal);
		sc.close();

	}

}
