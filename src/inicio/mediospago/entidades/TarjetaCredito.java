package inicio.mediospago.entidades;

public class TarjetaCredito extends MediosPago {

	private String numero;
	private String vencimiento;
	private String titular;
	private int codigoSeguridad;
	private float recargoPorCiento; // por ejemplo 0.2
	private float importeRecargo;

	public TarjetaCredito(float importe, String moneda, String numero) {
		super(importe, moneda);
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getVencimiento() {
		return vencimiento;
	}

	public void setVencimiento(String vencimiento) {
		this.vencimiento = vencimiento;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public int getCodigoSeguridad() {
		return codigoSeguridad;
	}

	public void setCodigoSeguridad(int codigoSeguridad) {
		this.codigoSeguridad = codigoSeguridad;
	}

	public float getRecargoPorCiento() {
		return recargoPorCiento;
	}

	public void setRecargoPorCiento(float recargoPorCiento) {
		this.recargoPorCiento = recargoPorCiento;
	}

	public float getImporteRecargo() {
		return importeRecargo;
	}

	public void setImporteRecargo(float importeRecargo) {
		this.importeRecargo = importeRecargo;
	}

}
