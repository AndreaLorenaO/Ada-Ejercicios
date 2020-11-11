package inicio.periodico.entidades;

public class NotaEscrita extends Nota {

	private String autor;
	private String texto;
	protected int cantPalabras;

	public NotaEscrita(int ancho, int alto, String genero, String autor) {
		super(ancho, alto, genero);
		this.autor = autor;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getCantPalabras() {
		return cantPalabras;
	}

	public void setCantPalabras(int cantPalabras) {
		this.cantPalabras = cantPalabras;
	}

	public String toString() {
		return "Tipo Nota Escrita; Tamano: " + ancho * alto + ";" + " Genero: " + genero + ";" + " Autor: " + autor;
	}

}
