package inicio.java.fecha;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class AppVacaciones {

	private static final int CANT_EMPLEADOS = 3;

	public static void main(String[] args) throws ParseException {
		Date[] fechaVacaciones = new Date[CANT_EMPLEADOS];
		String[] fechaVac = new String[CANT_EMPLEADOS];
		Scanner sc = new Scanner(System.in);
		ingresarFechasVacaciones(fechaVacaciones, fechaVac, sc);
	}

	private static void ingresarFechasVacaciones(Date[] fechaVacaciones, String[] fechaVac, Scanner sc)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < CANT_EMPLEADOS; i++) {
			System.out.println("Ingrese la fecha (YYYY-MM-DD) de inicio de las vacaciones del empleado " + (i + 1));
			fechaVac[i] = sc.next();
			fechaVacaciones[i] = sdf.parse(fechaVac[i]);
			// Asi era la version con Tati
			// String fechaVacacionesString = sc.next();
			// fechaVacaciones[i] = fechaVacacionesDate.parse(fechaVacacionesString)
		}
		System.out.println();

		for (int i = 0; i < CANT_EMPLEADOS; i++) {
			System.out.println("Las vacaciones del empleado " + (i + 1) + " inician: " + fechaVac[i]);
			// System.out.println("Las vacaciones del empleado " + (i + 1) + " inician: " +
			// fechaVacaciones[i]);
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

	// Con la fecha de nacimiento ingresada, saber si la persona es mayor de edad o
	// no
	private boolean esMayorDeEdad(Date fechaNacimiento) {
		Calendar hoy = Calendar.getInstance();
		hoy.add(Calendar.YEAR, -18);
		return fechaNacimiento.before(hoy.getTime());
	}

}
