package inicio.collection;

public class CallCenter {

	private int cantVentas;
	private int cantReclamos;

	public CallCenter(int cantVentas, int cantReclamos) {
		this.cantVentas = cantVentas;
		this.cantReclamos = cantReclamos;
	}

	public float getCantVentas() {
		return cantVentas;
	}

	public void setCantVentas(int cantVentas) {
		this.cantVentas = cantVentas;
	}

	public int getCantReclamos() {
		return cantReclamos;
	}

	public void setCantReclamos(int cantReclamos) {
		this.cantReclamos = cantReclamos;
	}

	public String toString() {
		return "Cantidad de ventas: " + cantVentas + " : Cantidad de reclamos: " + cantReclamos;
	}

}
