package inicio;

public class Bicicleta {

	private int velocidad;
	private String color;

	/**
	 * Suma el valor dado a la velocidad actual y devuelve una nueva velocidad
	 * 
	 * @param aceleracion
	 * @return
	 */

	public int acelerar(int aceleracion) {
		setVelocidad(velocidad + aceleracion);
		return velocidad;
	}

	/**
	 * Disminuye la velocidad en valor dado siempre y cuando ese valor no sea mayor
	 * que la velocidad actual Devuelve la velocidad actualizada Devuelve velocidad
	 * final luego de x cantidad de frenado
	 * 
	 * @param menosVelocidad
	 * @return
	 */

	public int frenar(int menosVelocidad) {
		if (velocidad - menosVelocidad >= 0) {
			setVelocidad(velocidad - menosVelocidad);
		} else {
			System.out.println("La velocidad actual no se puede frenar con " + menosVelocidad);
		}
		return velocidad;
	}

	/**
	 * Pone la velocidad en cero siempre y cuando la velocidad actual sea menor a 5
	 * Porque no se puede frenar de golpe Void porque siempre va a devolver valor
	 * cero, no devuelve nada
	 */

	public void detener() {
		if (velocidad < 5) {
			setVelocidad(0);
		} else {
			System.out.println("No se puede frenar a esa velocidad");
		}
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getVelocidad() {
		return velocidad;
	}

	private void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

}