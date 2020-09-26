package ejercicios;

import java.util.Scanner;

public class EjercicioTateti {

	private static int FILAS = 3;
	private static int COLS = 3;

	public static void main(String[] args) {
		char[][] tablero = new char[FILAS][COLS];
		// X un jugador
		// O otro jugador
		boolean ganador = false;
		int contador = 0;
		int turno = 1;
		System.out.println("JUEGO TA-TE-TI");
		imprimirTablero(tablero);
		while (!ganador && contador < 9) {
			contador++;
			turno = contador % 2; // hace que sea turno del jugador 1 y luego 2, y luego 1 y 2 de nuevo
			jugarFicha(turno, tablero);
		}
	}

	private static void jugarFicha(int turno, char[][] tablero) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Jugador" + (turno + 1) + "ingrese fila");
		int fila = sc.nextInt();
		System.out.println("Ingrese columna");
		int columna = sc.nextInt();
		if (tablero[fila][columna] == 'X' || tablero[fila][columna] == 'O') {
			System.out.println("Opps! Lugar ya ocupado, elegi otro lugar!");
		} else {
			if (turno == 0) {
				tablero[fila][columna] = 'X';
			} else {
				tablero[fila][columna] = 'O';
			}
		}
		sc.close();
		imprimirTablero(tablero);
	}

	private static void imprimirTablero(char[][] tablero) {
		System.out.println("[");
		for (int fila = 0; fila < FILAS; FILAS++) {
			for (int col = 0; col < COLS; COLS++) {
				System.out.print(" " + tablero[fila][col] + " ");
			}
			System.out.println("]");
		}

	}
}
