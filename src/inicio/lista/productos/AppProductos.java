package inicio.lista.productos;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* Se venden productos por la web de la empresa
 * Se dispone de 100 productos con codigo numerico
 * Codigo de producto secuencial desde 1 a 100
 * Precio que oscila entre 5 y 20 pesos
 * Vender 10 productos al azar con una cantidad determinada
 * Calcule la venta total 
 */

public class AppProductos {

	private final static int PRODUCTOS_DISPONIBLES = 100;
	private final static int TOTAL_VENTAS = 10;
	private final static int PRECIO_MAX = 20;
	private final static int PRECIO_MIN = 5;
	private static final int PRECIO_RANGO = PRECIO_MAX - PRECIO_MIN;
	private static final int STOCK_PRODUCTO = 9;

	public static void main(String[] args) {

		Random randomCodigo = new Random();
		Random randomPrecio = new Random();
		List<Producto> productosDisponibles = new ArrayList<Producto>();
		Producto producto;
		for (int i = 0; i < PRODUCTOS_DISPONIBLES; i++) {
			int codigo = randomCodigo.nextInt(PRODUCTOS_DISPONIBLES);
			double precio = getRandomNumberPrecio(PRECIO_MIN, PRECIO_RANGO);
			producto = new Producto(codigo, precio);
			productosDisponibles.add(producto);
		}
		System.out.println("Los productos disponibles son:");
		productosDisponibles.forEach(x -> System.out.println(x));

		List<Venta> productosVendidos = new ArrayList<Venta>();
		Random randomProductos = new Random();
		Random randomCantProd = new Random();
		Venta venta;
		double totalPrecio = 0;
		int cantidadVendida;
		for (int i = 0; i < TOTAL_VENTAS; i++) {
			int ventaProducto = randomProductos.nextInt(productosDisponibles.size());
			Producto productoVendido = productosDisponibles.remove(ventaProducto);
			cantidadVendida = 1 + randomCantProd.nextInt(STOCK_PRODUCTO);
			venta = new Venta(productoVendido, cantidadVendida);
			totalPrecio += productoVendido.getPrecio() * cantidadVendida;
			productosVendidos.add(venta);
		}
		DecimalFormat formatoDosDecimales = new DecimalFormat("#.00");
		System.out.println();
		System.out.println("Las ventas del dia son:");
		productosVendidos.forEach(x -> System.out.println(x));
		System.out.println("La recaudacion total del dia es: " + formatoDosDecimales.format(totalPrecio));
	}

	private static double getRandomNumberPrecio(int precioMin, int precioRango) {
		Random randomPrecio = new Random();
		double precio = PRECIO_MIN + PRECIO_RANGO * randomPrecio.nextDouble();
		return Math.round(precio * 100.0) / 100.0;
//		Random randomPrecio = new Random();
//		return randomPrecio.nextInt(20 - 5) + 5;
	}

//	public int getRandomNumber(int min, int max) {
//	    return (int) ((Math.random() * (max - min)) + min);
//	}

}
