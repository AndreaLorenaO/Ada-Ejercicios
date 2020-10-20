package inicio.periodico.entidades;

public abstract class Nota extends Publicacion {

	private String genero;

	public Nota(int tamano, String genero) {
		super(tamano);
		this.genero = genero;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
