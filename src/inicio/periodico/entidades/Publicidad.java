package inicio.periodico.entidades;

import java.util.Scanner;

public class Publicidad extends Publicacion {

	public boolean tieneImagen;
	protected final static int PRECIO_IMAGEN = 1000;
	protected final static int PRECIO_TAMANOCHICO = 500;
	protected final static int PRECIO_TAMANOMEDIANO = 1000;
	protected final static int PRECIO_TAMANOGRANDE = 1500;
	protected int precioImagen;
	protected int costo;
	protected int costoTotal;
	protected String marca;

	public Publicidad(int tamano, String marca) {
		super(tamano);
		this.marca = marca;
	}

	public boolean isTieneImagen() {
		System.out.println("Desea agregar una imagen? (S / N)");
		Scanner sc = new Scanner(System.in);
		if (sc.next().equalsIgnoreCase("s")) {
			tieneImagen = true;
		}
		return tieneImagen;
	}

	public void setTieneImagen(boolean tieneImagen) {
		this.tieneImagen = tieneImagen;
	}

	public int getPrecioImagen() {
		if (tieneImagen = true) {
			precioImagen = PRECIO_IMAGEN;
		} else {
			precioImagen = 0;
		}
		return precioImagen;
	}

	public void setPrecioImagen(int precioImagen) {
		this.precioImagen = precioImagen;
	}

	public int getCosto() {
		switch (tamano) {
		case 1:
			costo = PRECIO_TAMANOCHICO;
			break;
		case 2:
			costo = PRECIO_TAMANOMEDIANO;
			break;
		case 3:
			costo = PRECIO_TAMANOGRANDE;
			break;
		}
		return costo;
	}

	public int setCosto() {
		costoTotal = precioImagen + costo;
		return costoTotal;
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

}
