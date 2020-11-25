package inicio.juego.ajedrez;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import inicio.juego.ajedrez.pieces.Alfil;
import inicio.juego.ajedrez.pieces.Caballo;
import inicio.juego.ajedrez.pieces.Peon;
import inicio.juego.ajedrez.pieces.Reina;
import inicio.juego.ajedrez.pieces.Rey;
import inicio.juego.ajedrez.pieces.Torre;

public class AppAjedrez {

	public static void main(String[] args) {

		Map<Fichas, List<Posiciones>> ajedrez = new HashMap<Fichas, List<Posiciones>>();
		Peon peonBlanco1 = new Peon(Figura.PEON, Color.BLANCA, 1);
		Peon peonBlanco2 = new Peon(Figura.PEON, Color.BLANCA, 2);
		Peon peonBlanco3 = new Peon(Figura.PEON, Color.BLANCA, 3);
		Peon peonBlanco4 = new Peon(Figura.PEON, Color.BLANCA, 4);
		Peon peonBlanco5 = new Peon(Figura.PEON, Color.BLANCA, 5);
		Peon peonBlanco6 = new Peon(Figura.PEON, Color.BLANCA, 6);
		Peon peonBlanco7 = new Peon(Figura.PEON, Color.BLANCA, 7);
		Peon peonBlanco8 = new Peon(Figura.PEON, Color.BLANCA, 8);
		Peon peonNegro1 = new Peon(Figura.PEON, Color.NEGRA, 1);
		Peon peonNegro2 = new Peon(Figura.PEON, Color.NEGRA, 2);
		Peon peonNegro3 = new Peon(Figura.PEON, Color.NEGRA, 3);
		Peon peonNegro4 = new Peon(Figura.PEON, Color.NEGRA, 4);
		Peon peonNegro5 = new Peon(Figura.PEON, Color.NEGRA, 5);
		Peon peonNegro6 = new Peon(Figura.PEON, Color.NEGRA, 6);
		Peon peonNegro7 = new Peon(Figura.PEON, Color.NEGRA, 7);
		Peon peonNegro8 = new Peon(Figura.PEON, Color.NEGRA, 8);
		Torre torreBlanca1 = new Torre(Figura.TORRE, Color.BLANCA, 1);
		Torre torreBlanca2 = new Torre(Figura.TORRE, Color.BLANCA, 2);
		Torre torreNegra1 = new Torre(Figura.TORRE, Color.NEGRA, 1);
		Torre torreNegra2 = new Torre(Figura.TORRE, Color.NEGRA, 2);
		Caballo caballoBlanco1 = new Caballo(Figura.CABALLO, Color.BLANCA, 1);
		Caballo caballoBlanco2 = new Caballo(Figura.CABALLO, Color.BLANCA, 2);
		Caballo caballoNegro1 = new Caballo(Figura.CABALLO, Color.NEGRA, 1);
		Caballo caballoNegro2 = new Caballo(Figura.CABALLO, Color.NEGRA, 2);
		Alfil alfilBlanco1 = new Alfil(Figura.ALFIL, Color.BLANCA, 1);
		Alfil alfilBlanco2 = new Alfil(Figura.ALFIL, Color.BLANCA, 2);
		Alfil alfilNegro1 = new Alfil(Figura.ALFIL, Color.NEGRA, 1);
		Alfil alfilNegro2 = new Alfil(Figura.ALFIL, Color.NEGRA, 2);
		Reina reinaBlanca = new Reina(Figura.REINA, Color.BLANCA, 1);
		Reina reinaNegra = new Reina(Figura.REINA, Color.NEGRA, 1);
		Rey reyBlanco = new Rey(Figura.REY, Color.BLANCA, 1);
		Rey reyNegro = new Rey(Figura.REY, Color.NEGRA, 1);

		List<Posiciones> lista = new ArrayList<Posiciones>();
		System.out.println(ajedrez.size());
		lista.add(new Posiciones(0, 1));
		ajedrez.put(torreBlanca1, lista);
		ajedrez.put(torreBlanca2, lista);
		ajedrez.put(torreNegra1, lista);
		ajedrez.put(torreNegra2, lista);
		lista.add(new Posiciones(2, 3));
		ajedrez.put(torreBlanca1, lista);
		System.out.println(ajedrez.size());

		Posiciones[][] tablero = new Posiciones[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				tablero[i][j] = new Posiciones(i, j);
			}
		}

		Posiciones posicion = tablero[6][7]; // asignacion
		Fichas ficha = posicion.getFicha(); // da la ficha que existe en esa posicion
//		Fichas ficha = tablero[6][7].getFicha();
		Posiciones destino = tablero[5][7]; // asignacion
		if (ficha.validateMove(posicion, destino)) {
			ficha.move(posicion, destino);
		} else {
			System.out.println("No se pude mover ficha a destino elegido");
		}

	}

}
