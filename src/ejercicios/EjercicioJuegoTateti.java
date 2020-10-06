package ejercicios;

import java.util.Scanner;

public class EjercicioJuegoTateti {

	private static final int FILAS = 3;
	private static final int COLS = 3;

	public static void main(String[] args) {
		char[][] tablero = new char[FILAS][COLS];
		darBienvenida();
		mostrarTablero(tablero);
		boolean ganador = false;
		int contador = 0;
		int turno = 0;
		while (!ganador && turno < 9) {
			contador++;
			turno++;
			iniciarJugada(turno, tablero);
			mostrarTablero(tablero);
			ganador = validarHayganador(tablero);
			if (ganador) {
				if (turno == 1 || turno == 3 || turno == 5 || turno == 7 || turno == 9) {
					System.out.println("Felicidades Jugador 1");
				} else {
					System.out.println("Felicidades Jugador 2");
				}
				System.out.println("GANASTE!");
			}
		}
		if (!ganador && turno == 9) {
			System.out.println("Que pena, ha sido un empate");
		}
	}

	private static void darBienvenida() {
		System.out.println("Es hora de jugar!!!");
		System.out.println();
		System.out.println("Esto es estrategia, esto es TA-TE-TI!!!");
		System.out.println();
	}

	private static void mostrarTablero(char[][] tablero) {
		for (int filas = 0; filas < FILAS; filas++) {
			for (int columnas = 0; columnas < COLS; columnas++) {
				System.out.print("[" + tablero[filas][columnas] + "]");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void iniciarJugada(int turno, char[][] tablero) {
		Scanner sc = new Scanner(System.in);
		if (turno == 1 || turno == 3 || turno == 5 || turno == 7 || turno == 9) {
			System.out.println("Turno del Jugador 1");
		} else {
			System.out.println("Turno del Jugador 2");
		}
		System.out.println("ELegi una posicion en alguna fila");
		int fila = sc.nextInt();
		System.out.println("ELegi una posicion en alguna columna");
		int columna = sc.nextInt();
		validarRangosmatriz(fila, columna);
		validarCasilleroelegido(turno, fila, columna, tablero);
	}

	private static boolean validarHayganador(char[][] tablero) {
		boolean cond1 = tablero[0][0] == tablero[0][1] && tablero[0][0] == tablero[0][2]
				&& (tablero[0][0] == 'X' || tablero[0][0] == 'O');
		boolean cond2 = tablero[1][0] == tablero[1][1] && tablero[1][0] == tablero[1][2]
				&& (tablero[1][0] == 'X' || tablero[1][0] == 'O');
		boolean cond3 = tablero[2][0] == tablero[2][1] && tablero[2][0] == tablero[2][2]
				&& (tablero[2][0] == 'X' || tablero[2][0] == 'O');
		boolean cond4 = tablero[0][0] == tablero[1][0] && tablero[0][0] == tablero[2][0]
				&& (tablero[0][0] == 'X' || tablero[0][0] == 'O');
		boolean cond5 = tablero[0][1] == tablero[1][1] && tablero[0][1] == tablero[2][1]
				&& (tablero[0][1] == 'X' || tablero[0][1] == 'O');
		boolean cond6 = tablero[0][2] == tablero[1][2] && tablero[0][2] == tablero[2][2]
				&& (tablero[0][2] == 'X' || tablero[0][2] == 'O');
		boolean cond7 = tablero[0][0] == tablero[1][1] && tablero[0][0] == tablero[2][2]
				&& (tablero[0][0] == 'X' || tablero[0][0] == 'O');
		boolean cond8 = tablero[0][2] == tablero[1][1] && tablero[0][2] == tablero[2][0]
				&& (tablero[0][2] == 'X' || tablero[0][2] == 'O');
		return cond1 || cond2 || cond3 || cond4 || cond5 || cond6 || cond7 || cond8;
	}

	private static int validarRangosmatriz(int fila, int columna) {
		Scanner sc = new Scanner(System.in);
		while (fila < 0 || fila > 2) {
			System.out.println("Posicion invalida, elige otra fila");
			fila = sc.nextInt();
		}
		while (columna < 0 || columna > 2) {
			System.out.println("Posicion invalida, elige otra columna");
			columna = sc.nextInt();
		}
		return fila | columna;
	}

	private static char[][] validarCasilleroelegido(int turno, int fila, int columna, char[][] tablero) {
		Scanner sc = new Scanner(System.in);
		while (tablero[fila][columna] == 'X' || tablero[fila][columna] == 'O') {
			System.out.println("Posicion ya jugada");
			System.out.println("ELegi una posicion en alguna fila");
			fila = sc.nextInt();
			System.out.println("ELegi una posicion en alguna columna");
			columna = sc.nextInt();
			validarRangosmatriz(fila, columna);
		}
		if (turno == 1 || turno == 3 || turno == 5 || turno == 7 || turno == 9) {
			tablero[fila][columna] = 'X';
		} else {
			tablero[fila][columna] = 'O';
		}
		return tablero;
	}
}