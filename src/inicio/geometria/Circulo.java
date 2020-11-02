package inicio.geometria;

public class Circulo extends FiguraGeometrica implements Perimetrable {

	public Circulo() {

	}

	public double obtenerPerimetro() {
		System.out.println("Calcular perimetro circulo");
		return getLado() * Math.PI * 2;
	}

}
