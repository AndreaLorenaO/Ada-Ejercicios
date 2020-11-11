package inicio.periodico.entidades;

import java.util.Scanner;

public class Publicidad extends Publicacion implements Facturable {

	public boolean tieneImagen;
	protected final static int PRECIO_IMAGEN = 1000;
	private static final int VALOR_PIXEL = 100;
	protected int precioImagen;
	protected int costoTotal;
	protected String marca;

	public Publicidad(int ancho, int alto, String marca) {
		super(ancho, alto);
		this.marca = marca;
	}

	public boolean isTieneImagen() {
		System.out.println("Desea agregar una imagen? (S / N)");
		Scanner sc = new Scanner(System.in);
		if (sc.next().equalsIgnoreCase("s")) {
			return tieneImagen = true;
		}
		return tieneImagen;
	}

	public void setTieneImagen(boolean tieneImagen) {
		this.tieneImagen = tieneImagen;
	}

	public int getPrecioImagen() {
		if (tieneImagen == true) {
			precioImagen = PRECIO_IMAGEN;
		} else {
			precioImagen = 0;
		}
		return precioImagen;
	}

	public void setPrecioImagen(int precioImagen) {
		this.precioImagen = precioImagen;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(int costoTotal) {
		this.costoTotal = costoTotal;
	}

	public String toString() {
		return "Tipo Publicidad; Tamano: " + ancho * alto + ";" + " Marca: " + marca;
	}

	@Override
	public double facturacion(int alto, int ancho) {
		return alto * ancho * VALOR_PIXEL + precioImagen;
	}
}
