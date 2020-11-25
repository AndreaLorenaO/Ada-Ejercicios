package inicio.juego.naipes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/* Generar la baraja de naipes inglesas 
 * Repartir desordenamente los naipes (52) entre dos jugadores
 * Ver que naipe le toco a cada jugador
 *
 * Espada y trebol en negro
 * Corazon y rombo en rojo
 *
 */

public class AppNaipes {

//	public static final int TOTAL_PALOS = 4;
//	public static final int TOTAL_CARTAS_PALO = 13;

	public static void main(String[] args) {
		List<Naipe> mazo = new ArrayList<Naipe>();
//		for (int i = 0; i < TOTAL_PALOS; i++) {
//			for (int j = 0; j <TOTAL_CARTAS_PALO; j++) {
//				mazo.add(new Naipe(null, null));
//			}
//		}

		for (Palo palo : Palo.values()) {
			for (NumeroNaipe numero : NumeroNaipe.values()) {
				mazo.add(new Naipe(numero, palo));
			}
		}

//		Collections.shuffle(mazo);

		List<Naipe> mazoDos = new ArrayList<Naipe>();
		Random random = new Random(52);
		System.out.println(mazo);
		while (!mazo.isEmpty()) {
			int naipeAleatorio = random.nextInt(mazo.size());
			Naipe naipe = mazo.remove(naipeAleatorio);
			mazoDos.add(naipe);
		}

		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese cantidad de jugadores por favor");
		int jugadores = sc.nextInt();
		Map<String, List<Naipe>> mesa = new HashMap<String, List<Naipe>>();
		List<Naipe> cartasJugador;
		int i = 1;
		do {
			cartasJugador = new ArrayList<Naipe>();
			int opcion = 1;
			System.out.println("Esta jugando el Jugador: " + i);
			do {
				// repate la primera carta del mazoDos al jugador 1
				Naipe naipeJugador = mazoDos.remove(0);
				// agrega esa carta a la lista de carta del jugador 1
				cartasJugador.add(naipeJugador);
				System.out.println(naipeJugador);
				System.out.println("Desea otra carta? 1:Si, 2:No");
				opcion = sc.nextInt();

			} while (opcion == 1);
			mesa.put("Jugador " + i, cartasJugador);
			jugadores--;
			i++;

		} while (jugadores > 0);

	}

}
