package inicio.auto;
/*
 * Programar la clase auto que contenga:
 * Tiene 5 velocidades y para hacer un cambio 
 * debo tener la velocidad adecuada.
 * 0 -> cambio = 0
 * 1-20 -> numeroCambio = 1
 * 21-40 -> numeroCambio = 2
 * 41-60 -> numeroCambio = 3
 * 61-80 -> numeroCambio = 4
 * 81+ -> numeroCambio = 5
 * 
 * int numeroCambio
 * int velocidad
 * 
 * Programar getters y setters segun sea necesario
 * Y los metodos acelerar, frenar segun sea posible
 * validando las posibilidades y metodos 
 * subirCambio y bajarCambio
 * 
 * Proceso: subirCambio y luego acelerar validando
 * la velocidad
 * 
 * 
 */

public class AppAuto {

	public static void main(String[] args) {
		Auto a1 = new Auto();
		a1.subirCambio();
		a1.acelerar(18);
		a1.subirCambio();
		a1.acelerar(20);
		a1.subirCambio();
		a1.acelerar(20);
		a1.subirCambio();
		a1.acelerar(40);
		a1.frenar(58);
		a1.bajarCambio();
		a1.frenar(10);
		a1.bajarCambio();
		a1.frenar(15);
		a1.bajarCambio();
		a1.frenar(33);
	}

}
