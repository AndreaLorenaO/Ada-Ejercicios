package inicio.exception.bus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/* App de venta de pasajes en bus
 * Capacidad de asientos 10 por covid
 * Solicitar la venta de pasajes con los sgtes campos:
 * DNI pasajero, cant de pasajes por pasajero
 * Existe un solo viaje por dia y las ventas son para ese dia
 * En caso de no haber mas asientos disponibles que 1-informe al usuario; 2-lance una excepcion e intente reservar 
 * el siguiente dia
 */

public class AppBus {

	private static final String PATRON_FECHA = "dd-MM-yyyy";
	public static int TOTAL_ASIENTOS = 5;

	public static void main(String[] args) {

		Map<Date, List<Pasajero>> agendaVentaBus = new HashMap<Date, List<Pasajero>>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Bienvenido al sistema online de venta de pasajes de bus");
		System.out.println();
		System.out.println("Por favor ingrese fecha (DD-MM-YYYY) que desea viajar. 0 = terminar.");
		String fecha = sc.next();
		SimpleDateFormat sdf = new SimpleDateFormat(PATRON_FECHA);
		Date fechaVenta = null;
		String dni;
		int cantPasajes;
		while (!fecha.equals("0")) {
			try {
				fechaVenta = sdf.parse(fecha);
				System.out.println("Fecha registrada exitosamente");
			} catch (ParseException e1) {
				System.out.println("Error al ingresar la fecha");
			}

			System.out.println("Ingrese DNI del pasajero:");
			dni = sc.next();
			System.out.println("Ingrese cantidad de pasajes que desea adquirir para la fecha: " + fecha);
			cantPasajes = sc.nextInt();

			try {
				validarVentaPasajes(dni, cantPasajes, fechaVenta, agendaVentaBus);
			} catch (SinPasajesDisponiblesException e) {
				System.out.println(e.getMessage());
				System.out.println("Se propone realizar una fecha para el siguiente dia disponible");
			} finally {
				System.out.println();
			}

			System.out.println("Por favor ingrese fecha (DD-MM-YYYY) que desea viajar. 0 = terminar.");
			fecha = sc.next();
		}

		System.out.println("A continuacion se presenta las reservas por dia: ");
		agendaVentaBus.forEach((k, v) -> {
			System.out.println((sdf.format(k) + ":"));
			for (Pasajero item : v) {
				System.out.println(item);
			}
		});

	}

	private static void validarVentaPasajes(String dni, int cantPasajes, Date fechaVenta,
			Map<Date, List<Pasajero>> agendaVentaBus) throws SinPasajesDisponiblesException {

//		List<Pasajero> bus = agendaVentaBus.get(fechaVenta) == null ? new ArrayList<Pasajero>()
//				: agendaVentaBus.get(fechaVenta);
		List<Pasajero> bus = agendaVentaBus.get(fechaVenta);
		if (bus == null) {
			bus = new ArrayList<Pasajero>();
		}

		if (bus.size() + cantPasajes > TOTAL_ASIENTOS) {
			throw new SinPasajesDisponiblesException(
					String.format("Solo se dispone de %s asientos", TOTAL_ASIENTOS - bus.size()));
		} else {
			for (int i = 0; i < cantPasajes; i++) {
				bus.add(new Pasajero(dni, cantPasajes));
			}
			agendaVentaBus.put(fechaVenta, bus);
			System.out.println("Venta exitosa");
		}
	}

}
