package inicio.resumenbancario;

import java.util.Date;

public class PlazoFijo extends MovimientosBancarios implements Precancelable {

	public PlazoFijo(float importe, Date fecha) {
		super(importe, fecha);
	}

	public void cancelar(String motivo) {
		System.out.println("Cancela plazo fijo por motivo: " + motivo);

	}

}
