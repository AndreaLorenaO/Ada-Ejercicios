package inicio.auto;

public class Auto {

	private int velocidad;
	private int cambio;

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getCambio() {
		return cambio;
	}

	public void setCambio(int cambio) {
		this.cambio = cambio;
	}

	public int acelerar(int masVelocidad) {
		int velocFutura = velocidad + masVelocidad;
		if ((velocFutura / 20) + 1 == cambio) {
			velocidad = velocFutura;
			System.out.println("Acelerar: Velocidad actualizada: " + velocidad);
		} else {
			System.out.println("No se puede acelerar a " + velocFutura + " con cambio " + cambio);
		}
		return velocidad;
	}

	public int frenar(int menosVelocidad) {
		int velocFutura = velocidad - menosVelocidad;
		if ((velocFutura / 20) + 1 == cambio) {
			velocidad = velocFutura;
			System.out.println("Frenar: Velocidad actualizada " + velocidad);
		} else {
			System.out.println("No se puede frenar a " + velocFutura + " con este cambio");
		}
		return velocidad;
	}

	public void subirCambio() {
		this.cambio++;
		System.out.println("Subiste un cambio. Ahora estas en cambio " + cambio);
	}

	public void bajarCambio() {
		this.cambio--;
		System.out.println("Bajaste un cambio. Ahora estas en cambio  " + cambio);
	}

}
