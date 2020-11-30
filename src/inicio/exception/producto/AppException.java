package inicio.exception.producto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/* Generar una lista con 3 productos (codigo, nombre y stock)
 * pedir al usuario codigo del producto
 * buscar el codigo en la lista de productos
 * pedir al usuario la cantidad de ese producto
 * descontar stock en caso de que tenga suficiente 
 * sino lanzar excepcion
 */

public class AppException {

	public static void main(String[] args) {

		List<Producto> productos = iniciarProductos();
		Scanner sc = new Scanner(System.in);
		System.out.println("Sistema de pedidos");
		System.out.println();
		System.out.println("Ingrese codigo de producto");
		int codigo = sc.nextInt();
		System.out.println("Ingrese cantidad de producto");
		int cantidad = sc.nextInt();
//		Optional<Producto> producto = buscarProducto(productos, codigo);
		Producto producto = buscarProducto(productos, codigo);
		try {
			validarStock(producto, cantidad);
			imprimirFactura(producto, cantidad);
		} catch (SinStockException e) {
			System.out.println("No hay stock de este producto");
		} catch (ProductoNoEncontradoException e) {
			System.out.println("Producto no encontrado");
		} catch (InputMismatchException e) {
			System.out.println("Valor incorrecto");
		} catch (Exception e) {
			System.out.println("Excepcion general en procesamiento");
		} finally {
			System.out.println("Bloque final");
		}

	}

	private static List<Producto> iniciarProductos() {
		List<Producto> productos = new ArrayList<Producto>();
		productos.add(new Producto(1, "Notebook", 10));
		productos.add(new Producto(2, "Mouse", 5));
		productos.add(new Producto(3, "Monitor", 6));
		return productos;
	}

//	private static Optional<Producto> buscarProducto(List<Producto> productos, int codigo) {
//		return productos.stream().filter(p -> p.getId() == codigo).findAny();
//	}

	private static Producto buscarProducto(List<Producto> productos, int codigo) {
		boolean encontrado = false;
		Producto prod = null;
		int i = 0;
		while (!encontrado && i < productos.size()) {
			if (productos.get(i).getCodigo() == codigo) {
				encontrado = true;
				prod = productos.get(i);
			}
			i++;
		}
		return prod;
	}

	private static void validarStock(Producto producto, int cantidad)
			throws SinStockException, ProductoNoEncontradoException {
		if (producto != null) {
			if (producto.getStock() >= cantidad) {
				producto.setStock(producto.getStock() - cantidad);
			} else {
				throw new SinStockException("No hay stock de este producto");
			}
		} else {
			throw new ProductoNoEncontradoException();
		}
	}

	private static void imprimirFactura(Producto producto, int cantidad) {
		System.out.println("Factura del producto codigo " + producto.getCodigo() + " " + producto.getNombre());
		System.out.println("Cantidad vendida " + cantidad);

	}

}
