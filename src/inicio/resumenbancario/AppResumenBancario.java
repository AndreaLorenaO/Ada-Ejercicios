package inicio.resumenbancario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AppResumenBancario {

	private static final int MOVIM_BANCARIOS = 5;

	// Resumen bancario del cliente tiene los ultimos 5 movimientos
	// Los movimientos tienen fecha e importe y pueden ser retiros o depositos
	// Se pide ingresar los movimientos y luego listarlos de mayor a menor de
	// acuerdo a las fechas dadas

	public static void main(String[] args) throws ParseException {
		MovimientosBancarios[] movimientos = new MovimientosBancarios[MOVIM_BANCARIOS];
		Scanner sc = new Scanner(System.in);
		String fechaMovBanc = null;
		float importe = 0;
		int tipoMovBancario = 0;
		ingresoDatos(movimientos, sc, fechaMovBanc, importe, tipoMovBancario);
		fechasEnOrden(movimientos);

	}

	private static void ingresoDatos(MovimientosBancarios[] movimientos, Scanner sc, String fechaMovBanc, float importe,
			int tipoMovBancario) throws ParseException {
		for (int i = 0; i < movimientos.length; i++) {
			System.out.println("Ingrese fecha (DD-MM-YYYY) del movimiento bancario " + (i + 1));
			fechaMovBanc = sc.next();
			System.out.println("Ingrese importe del movimiento bancario " + (i + 1));
			importe = sc.nextFloat();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Date fecha = sdf.parse(fechaMovBanc);
			System.out.println("Ingrese tipo del movimiento bancario " + (i + 1) + ": 1-Retiro; 2-Deposito");
			tipoMovBancario = sc.nextInt();
			if (tipoMovBancario == 1) {
				Retiro retiro = new Retiro(importe, fecha);
				movimientos[i] = retiro;
			} else {
				Deposito deposito = new Deposito(importe, fecha);
				movimientos[i] = deposito;
			}
		}

	}

	private static void fechasEnOrden(MovimientosBancarios[] movimientos) {
		for (int j = 0; j < movimientos.length; j++) {
			System.out.println(movimientos[j]);
		}
		System.out.println();
		MovimientosBancarios aux = null;
		System.out.println("A continuacion se listan los movimientos bancarios en orden de acuerdo a las fechas");
		for (int i = 0; i < movimientos.length - 1; i++) {
			for (int j = 0; j < movimientos.length - 1; j++) {
				if (movimientos[j].getFecha().getTime() > (movimientos[j + 1].getFecha().getTime())) {
					aux = movimientos[j + 1];
					movimientos[j + 1] = movimientos[j];
					movimientos[j] = aux;
				}

			}
		}
		for (int i = 0; i < movimientos.length; i++) {
			System.out.println(movimientos[i]);
		}

	}

}
