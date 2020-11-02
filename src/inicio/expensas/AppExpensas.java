package inicio.expensas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

// El pago de expensas se realiza del 1 al 10 de cada mes
// En caso de pagar con atraso se suma interes del 1% diario
// Solicitar fecha de pago y el importe
// Calcular el total a pagar

public class AppExpensas {

	public static void main(String[] args) throws ParseException {
		// Genero asi las variables para no pedir dato y leer con sc
		String diaDiez = "10-10-2020";
		String diaDePago = "25-10-2020";
		// Formateo las fechas string
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		// Parseo esas fechas del SimpleDateFormat a Date
		Date diaDePagoDate = sdf.parse(diaDePago);
		Date diaDiezDate = sdf.parse(diaDiez);
		// Genero los objetos calendarios
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		// Seteo las fechas ingresas que estan como objeto Date en objetos Calendarios
		cal1.setTime(diaDiezDate);
		cal2.setTime(diaDePagoDate);
		long diferencia = diasDiferencia(cal1, cal2);
		System.out.println(diferencia);
	}

	private static long diasDiferencia(Calendar cal1, Calendar cal2) {
		// Calendar calendar1 = Calendar.getInstance();
		// Calendar calendar2 = Calendar.getInstance();
		// long days = Duration.between(calendar1.toInstant(),
		// calendar2.toInstant()).toDays();
		return Duration.between(cal1.toInstant(), cal2.toInstant()).toDays();
	}

}
