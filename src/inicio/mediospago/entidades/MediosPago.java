package inicio.mediospago.entidades;

public class MediosPago {

	public static int CODIGO_PAGO_EFECTIVO = 1;
	public static int CODIGO_PAGO_TARJETA = 2;
	public static int CODIGO_PAGO_CHEQUE = 3;
	protected float importe;
	private int id;
	private String moneda; // ARS - USD - EUR - ETC

	public MediosPago(float importe, String moneda) {
		this.importe = importe;
		this.moneda = moneda;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

}
