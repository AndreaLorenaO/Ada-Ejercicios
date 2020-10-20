package inicio.mediospago;

import java.util.Scanner;

import inicio.mediospago.entidades.Cheque;
import inicio.mediospago.entidades.Efectivo;
import inicio.mediospago.entidades.TarjetaCredito;

public class AppMediosDePago {

	// Se desea registrar los pagos realizados por los clientes
	// Se reciben pagos en efectivo, cheque o tarjeta de credito
	// Se desea conocer el total pagado por los diferentes medios
	// Se ingresan los pagos hasta el ingreso de importe 0.

	public static void main(String[] args) {
		float totales[] = new float[3];
		Scanner sc = new Scanner(System.in);
		System.out.println("Bienvenidos al Medios de pago App");
		System.out.println();
		float importe = solicitarImporte();
		int medio;

		while (importe != 0) {
			medio = solicitarMedioPago();
			String moneda = solicitarMoneda();
			switch (medio) {
			case 1:
				Efectivo efectivo = new Efectivo(importe, moneda);
				totales[0] += efectivo.getImporte();
				break;
			case 2:
				String numero = solicitarTexto("numero de tarjeta", sc);
				TarjetaCredito tarjetaCredito = new TarjetaCredito(importe, moneda, numero);
				totales[1] += tarjetaCredito.getImporte();
				break;
			case 3:
				String numeroCheque = solicitarTexto("numero de cheque", sc);
				Cheque cheque = new Cheque(importe, moneda, numeroCheque);
				totales[2] += cheque.getImporte();
			}

			importe = solicitarImporte();
		}

	}

	private static float solicitarImporte() {
		return 0;
	}

	private static int solicitarMedioPago() {
		return 0;
	}

	private static String solicitarMoneda() {
		return null;
	}

	private static String solicitarTexto(String mensaje, Scanner sc) {
		System.out.println("Ingrese " + mensaje);
		return sc.next();
	}

}
