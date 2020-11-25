package inicio.juego.ajedrez;

public abstract class Fichas {

	private Color color;
	private int numero;
	private Figura figura;

	public abstract boolean validateMove(Posiciones origen, Posiciones dest);

	public abstract boolean move(Posiciones origen, Posiciones dest);

	public Fichas(Figura figura, Color color, int numero) {
		this.figura = figura;
		this.color = color;
		this.numero = numero;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Figura getFigura() {
		return figura;
	}

	public void setFigura(Figura figura) {
		this.figura = figura;
	}

	public String toString() {
		return "Ficha " + figura + "de color " + color + " con numero " + numero;

	}

}
