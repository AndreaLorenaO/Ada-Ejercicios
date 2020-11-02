package inicio.geometria;

public class Cuadrado extends FiguraGeometrica implements Perimetrable {

	private int cantLados;

	public int getCantLados() {
		return cantLados;
	}

	public void setCantLados(int cantLados) {
		this.cantLados = cantLados;
	}

	public Cuadrado() {

	}

	@Override
	public double obtenerPerimetro() {
		return cantLados * getLado();
	}

}
