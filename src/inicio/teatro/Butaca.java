package inicio.teatro;

public class Butaca {

	private int posicion;
	private boolean ocupado;

	public Butaca() {
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	public static Butaca crear() {
		Butaca but = new Butaca();
		return but;

	}

}
