package db.inicial;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.inicial.DAO.AdminDB;
import db.inicial.menu.MenuCourse;
import db.inicial.menu.MenuOptions;
import db.inicial.menu.MenuProfessor;
import db.inicial.menu.MenuRegistration;
import db.inicial.menu.MenuStudent;

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
			System.out.println("Welcome to the Course online system");
			int optionMenu = MenuOptions.printMenuOptions(sc);
			while (optionMenu != 0) {
				switch (optionMenu) {
				case 1:
					course(sc, connection);
					break;
				case 2:
					student(sc, connection);
					break;
				case 3:
					professor(sc, connection);
					break;
				case 4:
					registration(sc, connection);
					break;
				}
				optionMenu = MenuOptions.printMenuOptions(sc);
			}
			connection.close();

		} catch (ClassNotFoundException e) {
			System.err.println("Driver Class loading error: " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("SQL execution error: " + e.getMessage());
		}
	}

	private static void course(Scanner sc, Connection connection) throws SQLException {
		int courseMenuOption = MenuCourse.printMenuCourse(sc, connection);
		while (courseMenuOption != 0) {
			MenuCourse.courseSelection(sc, connection, courseMenuOption);
			courseMenuOption = MenuCourse.printMenuCourse(sc, connection);
		}
	}

	private static void student(Scanner sc, Connection connection) throws SQLException {
		int studentMenuOption = MenuStudent.printMenuStudent(sc, connection);
		while (studentMenuOption != 0) {
			MenuStudent.studentSelection(sc, connection, studentMenuOption);
			studentMenuOption = MenuStudent.printMenuStudent(sc, connection);
		}
	}

	private static void professor(Scanner sc, Connection connection) throws SQLException {
		int professorMenuOption = MenuProfessor.printMenuProfessor(sc, connection);
		while (professorMenuOption != 0) {
			MenuProfessor.professorSelection(sc, connection, professorMenuOption);
			professorMenuOption = MenuProfessor.printMenuProfessor(sc, connection);
		}
	}

	private static void registration(Scanner sc, Connection connection) throws SQLException {
		int registrationMenuOption = MenuRegistration.printMenuRegistration(sc, connection);
		while (registrationMenuOption != 0) {
			MenuRegistration.registrationSelection(sc, connection, registrationMenuOption);
			registrationMenuOption = MenuRegistration.printMenuRegistration(sc, connection);
		}
	}

}
