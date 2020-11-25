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

public class AppNaipesLore {

	private final static int TOTAL_CARTAS_PALO = 13;
	private final static int TOTAL_CANT_PALOS = 4;
	private final static int TOTAL_MAZO = 52;

	public static void main(String[] args) {

		List<Naipe> mazoUno = new ArrayList<Naipe>();
		for (Palo palo : Palo.values()) {
			for (NumeroNaipe numero : NumeroNaipe.values()) {
				mazoUno.add(new Naipe(numero, palo));
			}
		}
		System.out.println(mazoUno);

		List<Naipe> mazoDos = new ArrayList<Naipe>();
		Random random = new Random(TOTAL_MAZO);
		while (!mazoUno.isEmpty()) {
			int naipeAleatorio = random.nextInt(mazoUno.size());
			Naipe naipe = mazoUno.remove(naipeAleatorio);
			mazoDos.add(naipe);
		}
		System.out.println(mazoDos);

		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese cantidad de jugadores");
		int cantJugadores = sc.nextInt();
		Map<String, List<Naipe>> mesa = new HashMap<String, List<Naipe>>();
		List<Naipe> mazoJugador;
		int i = 1;
		do {
			mazoJugador = new ArrayList<Naipe>();
			System.out.println("Jugador :" + i);
			int opcion;
			int totalPuntosJugador = 0;
			do {
				Naipe naipe = mazoDos.remove(0);
				System.out.println(naipe);
				totalPuntosJugador += naipe.getNumero().getValor();
				System.out.println("Desea otra carta? 1:Si; 2:No");
				opcion = sc.nextInt();
			} while (opcion == 1);
			mesa.put("Jugador' " + i, mazoJugador);
			cantJugadores--;
			i++;
		} while (cantJugadores > 0);

	}

}
