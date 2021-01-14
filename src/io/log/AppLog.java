package io.log;

import java.util.List;
import java.util.Scanner;

public class AppLog {

	public static void main(String[] args) {
		System.out.println("Menu inscripcion");
		Scanner sc = new Scanner(System.in);
		int opcion = solicitarOpcion(sc);
		while (opcion != 0) {
			switch (opcion) {
			case 1: {
				incripcion(sc);
				break;
			}
			case 2: {
				cancelacion(sc);
				break;
			}
			case 3: {
				listado();
				break;
			}
			}

			opcion = solicitarOpcion(sc);
		}

	}

	private static void listado() {
		System.out.println("Fecha   Hora    Alumno  Curso  Accion");
		List<String> lineasLog = FileUtil.lecturaArchivo("src/io/logs/logs.txt");
		lineasLog.forEach(System.out::println);
	}

	private static void cancelacion(Scanner sc) {
		System.out.println("Cancelación:");
		System.out.println("Ingrese codigo de alumn@:");
		int alumno = sc.nextInt();
		System.out.println("Ingrese codigo de curso:");
		int curso = sc.nextInt();
		// escribir en archivo
		LogInscripcion log = new LogInscripcion(alumno, curso, Accion.CANCELACION);
		FileUtil.escribir(log);

	}

	private static void incripcion(Scanner sc) {
		System.out.println("Incripcion:");
		System.out.println("Ingrese codigo de alumn@:");
		int alumno = sc.nextInt();
		System.out.println("Ingrese codigo de curso:");
		int curso = sc.nextInt();
		// escribir en archivo
		LogInscripcion log = new LogInscripcion(alumno, curso, Accion.INSCRIPCION);
		FileUtil.escribir(log);

	}

	private static int solicitarOpcion(Scanner sc) {
		System.out.println();
		System.out.println("1. Inscripcion");
		System.out.println("2. Cancelación");
		System.out.println("3. Listado");
		System.out.println("0. Salir");
		return sc.nextInt();
	}

}
