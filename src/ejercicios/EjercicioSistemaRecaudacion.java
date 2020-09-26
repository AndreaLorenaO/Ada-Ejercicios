package ejercicios;

import java.util.Scanner;

public class EjercicioSistemaRecaudacion {

	private static final int MAX_OPCIONES = 4;
	private static final int DIAS = 5;
	private static float[] recaudacion = new float[DIAS];
	private static String[] nombreDia = new String[DIAS];

	public static void main(String[] args) {
		cargarDias();
		int opcion = menuOpciones();
		while (opcion != 0) {
			// aca ya no necesito validar pues la validacion esta en el metodo menuOpciones
			switch (opcion) {
			case 1:
				agregarRecaudacion();
				break;
			case 2:
				listarRecaudacion();
				break;
			case 3:
				modificarRecaudacion();
				break;
			}
			opcion = menuOpciones();
		}
	}

	private static void cargarDias() {
		nombreDia[0] = "Lunes";
		nombreDia[1] = "Martes";
		nombreDia[2] = "Miercoles";
		nombreDia[3] = "Jueves";
		nombreDia[4] = "Viernes";
	}

	private static int menuOpciones() {
		System.out.println("Bienvenido al sistema online de recaudacion");
		System.out.println("-------------------------------------------");
		System.out.println("Por favor elija la opcion de su preferencia en el menu");
		System.out.println("1.Agregar, 2.Listar, 3.Modificar, 4.Salir");
		Scanner sc = new Scanner(System.in);
		int opcion = sc.nextInt();
		if (opcion < 0 || opcion > MAX_OPCIONES) {
			System.out.println("Opcion invalida. Por favor ingrese una opcion entre 1 y 4");
		}
		sc.close();
		return opcion;
	}

	private static void agregarRecaudacion() {
		Scanner sc = new Scanner(System.in);
		for (int dia = 0; dia < DIAS; dia++) {
			System.out.println("Ingrese el monto recaudado para dia " + nombreDia[dia] + ": ");
			recaudacion[dia] = sc.nextFloat();
			System.out.println();
		}
		System.out.println("Registro semanal exitoso");
		System.out.println();
		sc.close();
	}

	private static void listarRecaudacion() {
		for (int i = 0; i < DIAS; i++) {
			System.out.println("Los montos ingresados para el dia " + nombreDia[i] + recaudacion[i]);
		}
		System.out.println();
	}

	private static void modificarRecaudacion() {
		System.out.println("Ingrese numero de dia a mofiicar");
		System.out.println("1.Lunes | 2.Martes | 3.Miercoles | 4.Jueves | 5.Viernes");
		Scanner sc = new Scanner(System.in);
		int dia = sc.nextInt();
		System.out.println("El monto actual del " + dia + " es " + recaudacion[dia]);
		System.out.println();
		System.out.println("Ingrese el nuevo monto");
		float nuevaRecaudacion = sc.nextFloat();
		recaudacion[dia] = nuevaRecaudacion;
		System.out.println();
		System.out.println("Recaudacion modificada exitosamente");
		System.out.println();
		sc.close();
	}

}
