package inicio.map.agenda;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

//Se desea registrar una agenda con actividades por dia
//Las actividades ingresan por teclado con titulo de la actividad y fecha
//Una fecha puede tener varias actividades
//Al terminar el ingreso de actividades, mostrar las actividades por fecha

public class AppAgendaMap {

	public static void main(String[] args) throws ParseException {

//		FechaActividadesComparator fechaActividadesComparator = new FechaActividadesComparator();
		Map<Date, List<String>> agenda = new TreeMap<Date, List<String>>(new FechaActividadesComparator());
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date fechaActividad;
		System.out.println("Agenda virtual 2020");
		System.out.println();
		System.out.println("Por favor, ingrese fecha (yyyyMMdd). 0 = terminar");
		String fecha = sc.next();
		String actividad;
		while (!fecha.equals("0")) {
			fechaActividad = sdf.parse(fecha);
			System.out.println("Por favor ingrese la actividad de la fecha");
			actividad = sc.next();
			List<String> actividades = agenda.get(fechaActividad);
			if (actividades == null) {
				actividades = new ArrayList<String>();
			}
			actividades.add(actividad);
			agenda.put(fechaActividad, actividades);
			System.out.println("Actividad registrada exitosamente");
			System.out.println();
			System.out.println("Por favor, ingrese fecha (yyyyMMdd). 0 = terminar");
			fecha = sc.next();
		}
		agenda.forEach((k, v) -> {
			System.out.println((sdf.format(k) + ":"));
			for (String item : v) {
				System.out.println(item);
			}
		});

//		agenda.forEach((fechaAgenda, listaActividades) -> {
//			System.out.println((sdf.format(fechaAgenda) + ":"));
//			Collections.sort(listaActividades);
//			for (String item : listaActividades) {
//				System.out.println(item);
//			}
//		});

	}

}
