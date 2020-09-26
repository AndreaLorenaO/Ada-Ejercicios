package ejercicios;

public class EjercicioPantalla {

	public static void main(String[] args) {
		int anchoCol = 60; // columnas
		int altoFila = 11; // filas
		// la fila tiene 60 caracteres
		// son 10 filas
		// la columna tiene 10 caracteres
		dibujarPantalla("Bienvenido/a al sistema online", anchoCol, altoFila, '#');
	}

	private static void dibujarPantalla(String string, int anchoCol, int altoFila, char c) {
		int textoFila = altoFila / 2;
		int textoInicio = (anchoCol / 2 - string.length() / 2); // posicion inicial del texto
		int textoFin = textoInicio + string.length(); // posicion del fin del texto
		for (int fila = 0; fila < altoFila; fila++) {
			for (int columna = 0; columna < anchoCol; columna++) {
				if (fila == 0 || fila == altoFila - 1) {
					System.out.print(c);
				} else {
					if (columna == 0 || columna == anchoCol - 1) {
						System.out.print(c);
					} else if (fila == textoFila && columna < textoInicio || columna > textoFin) {
						System.out.print(" ");
					} else if (fila == textoFila && columna > textoInicio && columna < textoFin) {
						System.out.print("");
					} else if (fila == textoFila && columna == textoInicio) {
						System.out.print(string);
					} else {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
	}

}
