package inicio.periodico.entidades;

public abstract class Nota extends Publicacion {

	public String genero;

	public Nota(int ancho, int alto, String genero) {
		super(ancho, alto);
		this.genero = genero;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
