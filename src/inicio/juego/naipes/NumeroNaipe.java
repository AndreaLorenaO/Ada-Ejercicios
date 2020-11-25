package inicio.juego.naipes;

public enum NumeroNaipe {
	AS(1), DOS(2), TRES(3), CUATRO(4), CINCO(5), SEIS(6), SIETE(7), OCHO(8), NUEVE(9), DIEZ(10), JACK(10), QUEEN(10),
	KING(10);

	public final int valor;

	private NumeroNaipe(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

}
