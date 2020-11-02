package inicio.resumenbancario;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Retiro extends MovimientosBancarios {

	public Retiro(float importe, Date fecha) {
		super(importe, fecha);
	}

	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return "Retiro. Fecha: " + sdf.format(fecha) + " Importe: " + importe;
	}

}
