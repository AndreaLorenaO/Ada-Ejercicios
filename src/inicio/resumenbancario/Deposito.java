package inicio.resumenbancario;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Deposito extends MovimientosBancarios {

	public Deposito(float importe, Date fecha) {
		super(importe, fecha);
	}

	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return "Deposito. Fecha: " + sdf.format(fecha) + " Importe: " + importe;
	}

}
