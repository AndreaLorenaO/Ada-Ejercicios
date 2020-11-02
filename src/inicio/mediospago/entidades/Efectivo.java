package inicio.mediospago.entidades;

public class Efectivo extends MediosPago {

	public Efectivo(float importe, String moneda) {
		super(importe, moneda);

	}

	@Override
	public boolean validar() {
		return true;

	}

}
