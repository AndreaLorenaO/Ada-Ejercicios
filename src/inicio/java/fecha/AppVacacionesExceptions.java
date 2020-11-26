package inicio.java.fecha;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AppVacacionesExceptions {

	private static final int CANT_EMPLEADOS = 3;

	public static void main(String[] args) {
		Date[] fechaVacaciones = new Date[CANT_EMPLEADOS];
		String[] fechaVac = new String[CANT_EMPLEADOS];
		Scanner sc = new Scanner(System.in);
		ingresarFechasVacaciones(fechaVacaciones, fechaVac, sc);
	}

	private static void ingresarFechasVacaciones(Date[] fechaVacaciones, String[] fechaVac, Scanner sc) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < CANT_EMPLEADOS; i++) {
			System.out.println("Ingrese la fecha (YYYY-MM-DD) de inicio de las vacaciones del empleado " + (i + 1));
			fechaVac[i] = sc.next();
			try {
				fechaVacaciones[i] = sdf.parse(fechaVac[i]);
				System.out.println("Vacaciones OK");
			} catch (ParseException parseException) {
//				parseException.printStackTrace();
				System.out.println("Error al ingresar fecha: " + parseException.getMessage());
				System.out.println("Fin de excepcion");
				// Java va a crear un objeto ParseException al no usar throws ParseException
				// Class Throwable de la cual nacen las clases Error y Exception
				// throws Exception lanza la excepcion pero no la capta, por ello se implementa
				// try and catch
				// no se rompe el codigo pero pasa directo a pedir fecha para el empleado 2
			} catch (NullPointerException parseException) {
				System.out.println("Error al ingresar fecha");
				System.out.println("Fin de excepcion");
			} catch (Exception parseException) {
				System.out.println("Error al ingresar fecha: " + parseException.getMessage());
				System.out.println("Fin de excepcion");
				// Exception va a "atajar" todos los tipos de excepciones
				// Agrupa todas las excepciones en una
				// Siempre se lo escribe en el ultimo bloque
			}
		}

		for (int i = 0; i < CANT_EMPLEADOS; i++) {
			System.out.println("Las vacaciones del empleado " + (i + 1) + " inician: " + fechaVac[i]);
		}

		System.out.println();
		int pos = compararFechas(fechaVacaciones);
		System.out.println("El primer empleado en salir de vaciones es: " + (pos + 1));
	}

	private static int compararFechas(Date[] fechaVacaciones) {
		Date min = null;
		int pos = 0;
		for (int i = 0; i < CANT_EMPLEADOS; i++) {
			if (min == null || min.after(fechaVacaciones[i])) {
				min = fechaVacaciones[i];
				pos = i;
			}
		}
		return pos;
	}
}