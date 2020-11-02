package inicio.periodico;

import java.util.Scanner;

import inicio.periodico.entidades.NotaEscrita;
import inicio.periodico.entidades.NotaVideo;
import inicio.periodico.entidades.Publicidad;

//Existen publicaciones que pueden ser notas (escritas o videos) y publicidad.
//El portal puede tener 10 publicaciones online.
//Las publicidades se cobran en funcion del tamaño que ocupan en la pantalla.
//Las notas tiene autor, seccion, etc
//Descubrir las clases y atributos que necesitamos para modelar nuestro sistema
//Conocer el total facturado en la publicacion del portal

public class AppPeriodico {

	private static final int TOTAL_PUBLICACIONES = 3;

	public static void main(String[] args) {
		// No se suele usar Object de esta forma
		// Object es la superclase de todos, no tiene superclase
		Scanner sc = new Scanner(System.in);
		Object publicaciones[] = new Object[TOTAL_PUBLICACIONES];
		int totalRecaudado = 0;
		System.out.println("Bienvenido!");
		solicitarPublicaciones(sc, publicaciones, totalRecaudado);
		System.out.println();
		listarPublicaciones(publicaciones);
	}

	private static void solicitarPublicaciones(Scanner sc, Object[] publicaciones, int totalRecaudado) {
		for (int i = 0; i < TOTAL_PUBLICACIONES; i++) {
			int tipo = solicitarTipo("publicacion: 1.Nota, 2.Publicidad", sc);
			if (tipo == 1) {
				System.out.println("Has elegido Nota como tipo de publicacion");
				int subTipo = solicitarTipo("Nota que desea publicar: 1.Nota escrita, 2.Nota video", sc);
				if (subTipo == 1) {
					System.out.println("Has elegido Nota escrita como tipo de publicacion");
					System.out.println("Ingrese tamano (area) de la nota escrita");
					int tamano = sc.nextInt();
					System.out.println("Ingrese el genero de la nota escrita");
					String genero = sc.next();
					System.out.println("Ingrese nombre completo del autor de la nota escrita");
					String autor = sc.next();
					NotaEscrita notaEsc = new NotaEscrita(tamano, genero, autor);
					publicaciones[i] = notaEsc;
				} else {
					System.out.println("Has elegido Nota video como tipo de publicacion");
					System.out.println("Ingrese tamano (area) de la nota video");
					int tamano = sc.nextInt();
					System.out.println("Ingrese el genero de la nota video");
					String genero = sc.next();
					System.out.println("Ingrese nombre completo del periodista de la nota video");
					String periodista = sc.next();
					NotaVideo notaVideo = new NotaVideo(tamano, genero, periodista);
					publicaciones[i] = notaVideo;
				}
			} else {
				System.out.println("Has elegido Publicidad como tipo de publicacion");
				System.out.println("Ingrese tamano de la publicacion: 1.Chico, 2.Mediano, 3.Grande");
				int tamano = sc.nextInt();
				System.out.println("Ingrese nombre de la marca");
				String marca = sc.next();
				Publicidad publicidad = new Publicidad(tamano, marca);
				publicidad.isTieneImagen();
				if (publicidad.tieneImagen) {
					publicidad.getPrecioImagen();
					publicaciones[i] = publicidad;
				} else {
					publicidad.getPrecioImagen();
					publicaciones[i] = publicidad;
				}
			}
		}

		// Falta calcular el costo total de las publicidades
		System.out.println("El total de recaudado por publicidades es: " + totalRecaudado);
	}

	private static int solicitarTipo(String mensaje, Scanner sc) {
		System.out.println("Elija el tipo de " + mensaje);
		return sc.nextInt();
	}

	private static void listarPublicaciones(Object[] publicaciones) {
		for (int i = 0; i < TOTAL_PUBLICACIONES; i++) {
			System.out.println("Las publicaciones son: " + publicaciones[i]);
		}
		System.out.println();
	}
}
