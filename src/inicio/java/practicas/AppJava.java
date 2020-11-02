package inicio.java.practicas;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import inicio.mediospago.entidades.TarjetaCredito;

public class AppJava {

	public static void main(String[] args) throws ParseException {

		// 1-Sacar turno en el banco
		// 2-Imprimir pantala
		// 3-Mostrar siguiente turno

		String numeroTurno = "123";
		System.out.println("Numero original: " + numeroTurno);
		// primero se converte el valor String a numerico
		// se usa la clase Integer para convertir a valores
		Integer numeroTurnoInteger = Integer.parseInt(numeroTurno);
		// el valor String es ahora un objeto de la clase Integer
		// este es el metodo mas correcto y ordenarlo de hacerlo
		numeroTurnoInteger++;
		// el objeto recien creado se puede usar como contador sin pasarlo a int
		Integer doble = numeroTurnoInteger + numeroTurnoInteger;
		// se pueden sumar dos objetos de la misma clase sin pasarlos a int
		int numeroTurnoInt = numeroTurnoInteger.intValue();
		// Integer encapsula el valor como int (primitivo)
		numeroTurnoInt++;
		String siguienteNumero = String.valueOf(numeroTurnoInt);
		// con String.valueOf convierto nuevamente la variable en String
		// valueOf me permite pasar a String valores primitivos, no lo puedo usar con
		// objetos
		System.out.println("Siguiente numero: " + siguienteNumero);
		System.out.println("Numero doble es: " + doble);
		//

		System.out.println("Numero original: " + numeroTurno);
		Double numeroTurnoDouble = Double.parseDouble(numeroTurno);
		numeroTurnoDouble++;
		double numeroTurnoDoublePrimitivo = numeroTurnoDouble.doubleValue();
		numeroTurnoDoublePrimitivo++;
		String siguienteNumeroDouble = String.valueOf(numeroTurnoDoublePrimitivo);
		System.out.println("Siguiente numero: " + siguienteNumeroDouble);
		//

		String turnoDos = "123";
		BigInteger bigInteger = new BigInteger(turnoDos);
		bigInteger.add(new BigInteger(numeroTurno));
		System.out.println(bigInteger.add(new BigInteger(numeroTurno)));
		// no se pueden sumar dos objetos de la misma clase BigInteger

		Object object = new Object();
		// la clase object no tiene atributos pues no tiene atributo comun a otras
		// clases
		// la clase object tiene metodos comunes a todas las otras clases
		System.out.println("Metodo equals: " + numeroTurno.equals(turnoDos));
		System.out.println("Metodo == : " + (numeroTurno == turnoDos));
		System.out.println(doble.compareTo(numeroTurnoInteger));
		System.out.println(siguienteNumero.getClass());
		System.out.println(doble.getClass());
		System.out.println(object.getClass().getSuperclass());
		System.out.println(numeroTurno.getClass().getSuperclass());
		// hashCode es el numero que le asigna JAVA internamente a cada variable
		System.out.println(numeroTurno.hashCode());
		System.out.println(doble.hashCode());
		System.out.println(siguienteNumero.hashCode());
		//

		TarjetaCredito tarjeta = new TarjetaCredito(100, "ARS", "54367801");
		System.out.println(tarjeta);
		System.out.println(tarjeta.toString());
		// usando el metodo .toString JAVA hara lo mismo que sin el metodo
		// por ello re-escribo el metodo toString en la subclase TarjetaCredito
		// System.out.println(String.format("Tarjeta: %s NumeroTurno %s ",
		// tarjeta.toString(), numeroTurno));
		//

		Date ahora = new Date();
		System.out.println(ahora);
		System.out.println(ahora.getTime());
		// getTime da la hora en milisegundos de la fecha
		// para convetir del objeto Date a String con el formato deseado por uno
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
		String ahoraFormateado = simpleDate.format(ahora);
		System.out.println(ahoraFormateado);
		// para convertir de String a objeto Date
		Date fechaPasada = simpleDate.parse(ahoraFormateado);
		System.out.println(fechaPasada);

		if (fechaPasada.after(ahora)) {
			System.out.println("Estas en el pasado, que has hecho?!");
		} else {
			System.out.println("Bien! Estas en el presente");
		}

		// Calendar calendar = new Calendar();
		// Es privado por lo que no se puede instanciar un nuevo calendario
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, 1);
		// configuro un objeto calendar con la fecha que yo desee
		calendar.setTime(fechaPasada);
		calendar.add(Calendar.DATE, -1);
		String calendarFormatted = simpleDate.format(calendar.getTime());
		System.out.println(calendarFormatted);
	}

}
