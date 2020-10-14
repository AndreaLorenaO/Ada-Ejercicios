package inicio.enviopaquetes;

public class Dinero extends Envios {

	private static final float DINERO_MAX = 1000000;

	private float montoDinero;

	public float getMontoDinero() {
		return montoDinero;
	}

	public void setMontoDinero(float montoDinero) {
		this.montoDinero = montoDinero;
	}

	public Dinero(float montoDinero) {
		this.montoDinero = montoDinero;
		enviable = montoDinero < DINERO_MAX && montoDinero > 0;
		precioBase = montoDinero;
	}

}
