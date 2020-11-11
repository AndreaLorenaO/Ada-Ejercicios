package inicio.periodico.entidades;

public abstract class Publicacion {

	protected int ancho;
	protected int alto;

	public Publicacion(int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

}
