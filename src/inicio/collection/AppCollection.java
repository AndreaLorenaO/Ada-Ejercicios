package inicio.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import inicio.mediospago.entidades.TarjetaCredito;

public class AppCollection {

	public static void main(String[] args) {
		pruebaList();
		pruebaSet();
		pruebaListSolari();
		pruebaSetSolari();
	}

	private static void pruebaList() {
		List<String> lista = new ArrayList<String>();
		System.out.println("size: " + lista.size());
		lista.add("elemento1");
		lista.add("elemento1");
		System.out.println("size: " + lista.size());
		System.out.println(lista);
		lista.remove(0);
		System.out.println("size: " + lista.size());
		System.out.println(lista);

		List<String> lista2 = new ArrayList<String>();
		lista2.add("item2.1");
		lista2.add("item2.2");
		lista.addAll(lista2);
		System.out.println(lista);

		// Distintas formas de recorrer una lista, que puede ser con for o while
		System.out.println("Comiendo del bucle de un for clasico con indice");
		for (int i = 0; i < lista.size(); i++) {
			String item = lista.get(i);
			System.out.println(item);
		}

		System.out.println("Comiendo del bucle de un for clasico sin indice");
		for (String pos : lista) {
			System.out.println(pos);
		}

		// Es un for de programacion orientado a funciones
		System.out.println("Function lambda (arrow funtion)");
		lista.forEach(x -> System.out.println(x));

		//
		List<TarjetaCredito> tarjetas = new ArrayList<TarjetaCredito>();
		TarjetaCredito tarjeta1 = new TarjetaCredito(100, "ARS", "123123123");
		tarjetas.add(tarjeta1);
		System.out.println(tarjetas);
	}

	private static void pruebaSet() {
		Set<String> conj = new HashSet<String>();
		System.out.println("size: " + conj.size());
		conj.add("20-123123");
		conj.add("20-123124");
		System.out.println("size: " + conj.size());
		conj.add("20-123124");
		System.out.println("size: " + conj.size());

		System.out.println("Recorrer -posiciones- en un set con un iterator");
		Iterator<String> it = conj.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		System.out.println("Recorrer -posiciones- en un set con un foreach");
		conj.forEach(elem -> System.out.println(elem));

	}

	private static void pruebaListSolari() {
		List<Integer> conteoPetrogCalafate = new ArrayList<Integer>();
		System.out.println("Size of Calafate is: " + conteoPetrogCalafate.size());
		conteoPetrogCalafate.add(401);
		conteoPetrogCalafate.add(420);
		conteoPetrogCalafate.add(510);
		System.out.println("Size of Calafat is: " + conteoPetrogCalafate.size());
		List<Integer> conteoPetrogMalargue = new ArrayList<Integer>();
		conteoPetrogMalargue.add(430);
		conteoPetrogMalargue.add(415);
		System.out.println("Size of Malargue is: " + conteoPetrogMalargue.size());
		conteoPetrogCalafate.remove(2);
		conteoPetrogMalargue.remove(1);
		System.out.println("Size of Calafate is: " + conteoPetrogCalafate.size());
		System.out.println("Size of Malargue is: " + conteoPetrogMalargue.size());
		conteoPetrogCalafate.addAll(conteoPetrogMalargue);
		System.out.println(conteoPetrogCalafate);
	}

	private static void pruebaSetSolari() {
		Set<Integer> conteoPetrog = new HashSet<Integer>();
		System.out.println("Size of conteo petrog is: " + conteoPetrog.size());
		conteoPetrog.add(405);
		conteoPetrog.add(441);
		conteoPetrog.add(420);
		conteoPetrog.add(405);
		System.out.println("Size of conteo petrog is: " + conteoPetrog.size());
		conteoPetrog.remove(405);
		System.out.println("Size of conteo petrog is: " + conteoPetrog.size());
	}

}
