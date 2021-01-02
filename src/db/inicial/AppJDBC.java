package db.inicial;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import db.inicial.DAO.AdminDB;
import db.inicial.DAO.CursoDAO;
import db.inicial.model.Curso;

// Menu: 1.Curso, 2.Estudiantes, 3.Inscripciones
// Necesitamos alta, listado, modificaciones y baja de: 1.Curso y 2.Alumnos
// 

public class AppJDBC {

	public static void main(String[] args) {

		try {
			Connection connection = AdminDB.obtenerConexion(); // Objeto conexion listo para usar
//			Connection connection = AdminDB.obtenerConexion("com.mysql.cj.jdbc.Driver"); Asi seria para no hardcodear
//			System.out.println(AdminDB.obtenerConexion());
			Scanner sc = new Scanner(System.in);
			Statement stmt = connection.createStatement();
			System.out.println("Bienvenido al sistema online de Cursos");
			int opcion = menuOpciones(sc);
			while (opcion != 0) {
				switch (opcion) {
				case 1:
					menuCurso(sc, connection);
					break;
				case 2:
					menuAlumno(sc, connection);
					break;
				case 3:
					menuInscripcion(sc, connection);
					break;
				}
				opcion = menuOpciones(sc);
			}
			connection.close();

		} catch (ClassNotFoundException e) {
			System.err.println("Error en carga de Clase Driver: " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Error en la ejecucion SQL: " + e.getMessage());
		}
	}

	private static int menuOpciones(Scanner sc) {
		System.out.println();
		System.out.println("Menu");
		System.out.println("----");
		System.out.println("1.Curso; 2.Alumno; 3.Inscripcion; 0. Salir");
		System.out.println();
		System.out.println("Ingrese opcion: ");
		return sc.nextInt();
	}

	private static void menuCurso(Scanner sc, Connection connection) throws SQLException {
		System.out.println();
		System.out.println("Menu");
		System.out.println("----");
		System.out.println("1.Alta curso; 2.Listar curso; 3.Baja curso; 4.Modificar curso; 5.Buscar curso; 0. Salir");
		System.out.println();
		System.out.println("Ingrese opcion: ");
		int opcionCurso = sc.nextInt();
		switch (opcionCurso) {
		case 1:
			altaCurso(sc, connection);
			break;
		case 2:
			listaCurso(connection);
			break;
		case 3:
			bajaCurso(sc, connection);
			break;
		case 4:
			modificarCurso(sc, connection);
			break;
		case 5:
			buscarCurso(sc, connection);
		}
	}

	private static void altaCurso(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Ingrese nombre del curso: ");
		String nombreCurso = sc.next();
		Curso curso = new Curso(nombreCurso);
		CursoDAO.insert(curso, connection);
	}

	private static void listaCurso(Connection connection) throws SQLException {
		System.out.println("Lista de cursos:");
		List<Curso> listarCurso = CursoDAO.findAll(connection);
		for (Curso curso : listarCurso) {
			System.out.println(curso.getId() + " - " + curso.getName());
		}
	}

	private static void bajaCurso(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Ingrese ID del curso a eliminar: ");
		int idCurso = sc.nextInt();
		Curso cursoDelete = CursoDAO.findById(idCurso, connection);
		if (cursoDelete != null) {
			int modificadas = CursoDAO.delete(idCurso, connection);
			if (modificadas == 1) {
				System.out.println("Baja de curso realizada con exito");
			} else {
				System.err.println("No se realizo la baja");
			}
		} else {
			System.err.println("No se encontro el curso");
		}

	}

	@SuppressWarnings("unused")
	private static void modificarCurso(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Ingrese ID del curso a modificar: ");
		int idCurso = sc.nextInt();
		Curso cursoModificar = CursoDAO.findById(idCurso, connection);
		System.out.println(cursoModificar.getName());
		if (cursoModificar != null) {
			System.out.println("Ingrese nuevo nombre del curso");
			String nuevoNombre = sc.next();
			Curso curso = new Curso(nuevoNombre);
			curso.setId(idCurso);
			int updated = CursoDAO.updateCurso(curso, connection);
			if (updated == 1) {
				System.out.println("Modificacion realizada con exito");
			} else {
				System.err.println("Error en la modificacion del curso: " + updated);
			}
		} else {
			System.err.println("No se encontro el curso");
		}
	}

	private static void buscarCurso(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Ingrese nombre del Curso que desea buscar:");
		String nombreCurso = sc.next();
		List<Curso> lista = CursoDAO.findByName(nombreCurso, connection);
		System.out.println();
		lista.forEach(curso -> System.out.println(curso.getId() + " - " + curso.getName()));
	}

	private static void menuAlumno(Scanner sc, Connection connection) {
		System.out.println();
		System.out.println("Menu");
		System.out.println("----");
		System.out.println(
				"1.Alta alumno; 2.Listar alumno; 3.Baja alumno; 4.Modificar alumno; 5.Buscar alumno; 0. Salir");
		System.out.println();
		System.out.println("Ingrese opcion: ");
		int opcionAlumno = sc.nextInt();
		switch (opcionAlumno) {
		case 1:
			altaAlumno(sc, connection);
			break;
		case 2:
			listaAlumno(connection);
			break;
		case 3:
			bajaAlumno(sc, connection);
			break;
		case 4:
			modificarAlumno(sc, connection);
			break;
		case 5:
			encontrarAlumno(sc, connection);
			break;
		}
	}

	private static void altaAlumno(Scanner sc, Connection connection) {

	}

	private static void listaAlumno(Connection connection) {

	}

	private static void bajaAlumno(Scanner sc, Connection connection) {

	}

	private static void modificarAlumno(Scanner sc, Connection connection) {

	}

	private static void encontrarAlumno(Scanner sc, Connection connection) {

	}

	private static void menuInscripcion(Scanner sc, Connection connection) {

	}

}
