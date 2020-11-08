package inicio.resumenbancario;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class MovimientosBancarios {

	protected float importe;
	protected Date fecha;

	public MovimientosBancarios(float importe, Date fecha) {
		this.importe = importe;
		this.fecha = fecha;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return "Fecha del movimiento: " + sdf.format(fecha) + " importe: " + importe;
	}

}
