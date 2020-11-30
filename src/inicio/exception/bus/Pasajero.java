package inicio.exception.bus;

public class Pasajero {

	private String dni;
	private int cantPasajesPasajero;

	public Pasajero(String dni, int cantPasajesPasajero) {
		this.dni = dni;
		this.cantPasajesPasajero = cantPasajesPasajero;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getCantPasajes() {
		return cantPasajesPasajero;
	}

	public void setCantPasajes(int cantPasajesPasajero) {
		this.cantPasajesPasajero = cantPasajesPasajero;
	}

	public String toString() {
		return "Pasajero DNI: " + dni + " ; cantidad de pasajes vendidos: " + cantPasajesPasajero;
	}

}
