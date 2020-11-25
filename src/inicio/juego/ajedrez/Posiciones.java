package inicio.juego.ajedrez;

public class Posiciones {

	private int x;
	private int y;
	private Color color;
	private Fichas ficha;

	public Posiciones(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Fichas getFicha() {
		return ficha;
	}

	public void setFicha(Fichas ficha) {
		this.ficha = ficha;
	}

}
