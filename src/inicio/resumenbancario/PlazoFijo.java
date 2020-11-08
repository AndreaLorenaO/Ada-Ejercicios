package inicio.resumenbancario;

import java.util.Date;

public class PlazoFijo extends MovimientosBancarios implements Precancelable {

	public PlazoFijo(float importe, Date fecha) {
		super(importe, fecha);
	}

	public void cancelar() {
		System.out.println("Motivo: tiempo de procesamiento de la solicitud");
		// System.out.println("Cancela plazo fijo por motivo: " + motivo);

	}

}
