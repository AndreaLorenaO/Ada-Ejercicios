package inicio.periodico.entidades;

public class NotaVideo extends Nota {

	protected int duracionVideo;
	private String periodista;

	public NotaVideo(int tamano, String genero, String periodista) {
		super(tamano, genero);
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

}
