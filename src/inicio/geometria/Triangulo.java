package inicio.geometria;

public class Triangulo extends FiguraGeometrica implements Perimetrable {

	private int cantLados;

	public int getCantLados() {
		return cantLados;
	}

	public void setCantLados(int cantLados) {
		this.cantLados = cantLados;
	}

	public Triangulo() {

	}

	public double obtenerPerimetro() {
		return cantLados * getLado();
	}

}
