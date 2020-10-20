package inicio.mediospago.entidades;

public class Cheque extends MediosPago {

	private String numeroCheque;
	private String librador;
	private String banco;

	public Cheque(float importe, String moneda, String numeroCheque) {
		super(importe, moneda);
		this.numeroCheque = numeroCheque;
	}

	public String getNumeroCheque() {
		return numeroCheque;
	}

	public void setNumeroCheque(String numeroCheque) {
		this.numeroCheque = numeroCheque;
	}

	public String getLibrador() {
		return librador;
	}

	public void setLibrador(String librador) {
		this.librador = librador;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

}
