package inicio.periodico.entidades;

public class NotaVideo extends Nota {

	protected int duracionVideo;
	private String periodista;

	public NotaVideo(int ancho, int alto, String genero, String periodista) {
		super(ancho, alto, genero);
		this.periodista = periodista;
	}

	public int getDuracionVideo() {
		return duracionVideo;
	}

	public void setDuracionVideo(int duracionVideo) {
		this.duracionVideo = duracionVideo;
	}

	public String getPeriodista() {
		return periodista;
	}

	public void setPeriodista(String periodista) {
		this.periodista = periodista;
	}

	public String toString() {
		return "Tipo Nota Video; Tamano: " + ancho * alto + ";" + " Genero: " + genero + ";" + " Autor: " + periodista;
	}

}
