package db.inicial.menu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import db.inicial.controller.StudentController;

public class MenuStudent {

	public static int printMenuStudent(Scanner sc, Connection connection) throws SQLException {
		System.out.println();
		System.out.println("Student menu");
		MenuOptions.printSubMenu();
		return sc.nextInt();
	}

	public static void studentSelection(Scanner sc, Connection connection, int studentMenuOption) throws SQLException {
		switch (studentMenuOption) {
		case 1:
			StudentController.studentEnrollment(sc, connection);
			break;
		case 2:
			StudentController.studentList(connection);
			break;
//		case 3:
//			StudentController.studentDisenrollment(sc, connection);
//			break;
		case 3:
			StudentController.studentUpdate(sc, connection);
			break;
		case 4:
			StudentController.findStudent(sc, connection);
			break;
		}
	}

}
