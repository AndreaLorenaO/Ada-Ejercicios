package inicio;

public class AppInicio {

	/**
	 * Metodo que inicia la aplicacion
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		Bicicleta bici = new Bicicleta();

		System.out.println("Velocidad actual: " + bici.getVelocidad());
		bici.acelerar(10);
		System.out.println("Velocidad actual: " + bici.getVelocidad());
		bici.frenar(20);
		System.out.println("Velocidad actual: " + bici.getVelocidad());
		bici.frenar(3);
		System.out.println("Velocidad actual: " + bici.getVelocidad());
		bici.detener();
		System.out.println("Velocidad actual: " + bici.getVelocidad());
		bici.frenar(4);
		System.out.println("Velocidad actual: " + bici.getVelocidad());
		bici.detener();
		System.out.println("Velocidad actual: " + bici.getVelocidad());

	}

}
