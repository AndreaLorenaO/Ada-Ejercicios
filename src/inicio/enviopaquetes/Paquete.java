package inicio.enviopaquetes;

public class Paquete {

	private static float ZONA_1 = 11;
	private static float ZONA_2 = 10;
	private static float ZONA_3 = 12;
	private static float ZONA_4 = 24;
	private static float ZONA_5 = 27;

	private float peso;
	private int zona;
	private boolean enviable;

	public Paquete() {
	}

	public Paquete(float peso, int zona) {
		this.peso = peso;
		this.zona = zona;
		this.enviable = peso < 5000;
	}

	public boolean isEnviable() {
		return enviable;
	}

	public void setEnviable(boolean enviable) {
		this.enviable = enviable;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		if (peso < 5000) {
			enviable = true;
		} else {
			enviable = false;
		}
		this.peso = peso;
	}

	public int getZona() {
		return zona;
	}

	public void setZona(int zona) {
		this.zona = zona;
	}

	public float calcularPrecio() {
		float costoEnvio = 0;
		switch (zona) {
		case 1:
			costoEnvio = peso * ZONA_1;
			break;
		case 2:
			costoEnvio = peso * ZONA_2;
			break;
		case 3:
			costoEnvio = peso * ZONA_3;
			break;
		case 4:
			costoEnvio = peso * ZONA_4;
			break;
		case 5:
			costoEnvio = peso * ZONA_5;
			break;
		}
		return costoEnvio;
	}
}
