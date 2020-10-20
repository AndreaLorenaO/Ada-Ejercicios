package inicio.periodico.entidades;

public abstract class Publicacion {

	protected int tamano;

	public Publicacion(int tamano) {
		this.tamano = tamano;
	}

	public int getTamano() {
		return tamano;
	}

	public void setTamano(int tamano) {
		this.tamano = tamano;
	}

}
