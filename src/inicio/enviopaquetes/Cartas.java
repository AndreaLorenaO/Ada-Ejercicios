package inicio.enviopaquetes;

public class Cartas extends Envios {

	private static final int CARTAS_MAX = 50;

	private int cantidadCartas;

	public int getCantidad() {
		return cantidadCartas;
	}

	public void setCantidad(int cantidad) {
		this.cantidadCartas = cantidad;
	}

	public Cartas(int cantidad) {
		this.cantidadCartas = cantidad;
		enviable = cantidad < CARTAS_MAX && cantidad > 0;
		precioBase = cantidad;
	}

}
