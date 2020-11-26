package inicio.lista.productos;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class AppProductosOptional {

	private static final int TOTAL_PROD = 100;
	private static final int TOTAL_VENDIDOS = 10;
	private static final double PRECIO_BASE = 5;
	private static final double RANGO_PRECIOS = 15;
	private static final int ENTERO_POR_DEFECTO = 100;

	public static void main(String[] args) {

		List<Producto> productos = new ArrayList<Producto>();

		for (int i = 0; i < TOTAL_PROD; i++) {
			productos.add(new Producto(i + 1, generarPrecio()));
		}

		Venta[] vendidos = new Venta[TOTAL_VENDIDOS];

		DecimalFormat formatoDosDecimales = new DecimalFormat("#.00");
		double total = 0;
		for (int j = 0; j < TOTAL_VENDIDOS; j++) {
			vendidos[j] = new Venta(productos.get(aleatorioEntero(Optional.empty())),
					1 + aleatorioEntero(Optional.of(10)));
			Producto itemProducto = vendidos[j].getProducto();
			int cantidad = vendidos[j].getCantidad();
			double precio = itemProducto.getPrecio();
			double totalLinea = precio * cantidad;
			System.out.println(itemProducto.getCodigo() + " --> " + precio + ": " + cantidad + " = "
					+ formatoDosDecimales.format(totalLinea));
			total += totalLinea;
		}
		System.out.println("Total venta " + formatoDosDecimales.format(total));
	}

	private static int aleatorioEntero(Optional<Integer> valorMaximo) {
		Random randomEntero = new Random();
		if (valorMaximo.isPresent()) {
			return randomEntero.nextInt(valorMaximo.get());
		} else {
			return randomEntero.nextInt(ENTERO_POR_DEFECTO);

		}
	}

	private static double generarPrecio() {
		Random randomPrecio = new Random();
		double precio = PRECIO_BASE + RANGO_PRECIOS * randomPrecio.nextDouble();
		return Math.round(precio * 100.0) / 100.0;
	}
}
