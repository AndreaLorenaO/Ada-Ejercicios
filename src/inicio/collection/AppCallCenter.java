package inicio.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//se desea conocer para cada uno de los dias del mes, la cantidad de ventas y de reclamos
//por dia que realizaron al call center en el mes
//Listar la informacion generada

public class AppCallCenter {

	public static void main(String[] args) {

		List<CallCenter> callCenter = new ArrayList<CallCenter>();
		Random randomCantVentas = new Random();
		Random randomCantReclamos = new Random();
		CallCenter callCenter1;

		for (int i = 0; i < 30; i++) {
			// int cantVentas = randomCantVentas.nextInt(50);
			// int cantReclamos = randomCantReclamos.nextInt(15);
			// callCenter1 = new CallCenter(cantVentas, cantReclamos);
			// callCenter.add(callCenter1);
			callCenter1 = new CallCenter(randomCantVentas.nextInt(50), randomCantReclamos.nextInt(15));
			callCenter.add(callCenter1);
		}

		System.out.println("A continuacion se muestran las cantidades de ventas y reclamos por dia del mes:");
		callCenter.forEach(x -> System.out.println(x));
		System.out.println();
		System.out.println(callCenter.get(25));
	}

}
