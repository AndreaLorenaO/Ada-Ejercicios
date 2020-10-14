package inicio.enviopaquetes;

public class Paquetes extends Envios {

	private static final int PESO_MAXIMO = 5000;
	private float peso;

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public Paquetes(float peso) {
		this.peso = peso;
		enviable = peso < PESO_MAXIMO && peso > 0;
		precioBase = peso;
	}

}
