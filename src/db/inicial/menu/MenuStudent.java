package db.inicial.menu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import db.inicial.controller.StudentController;

public class MenuStudent {

	public static int printMenuStudent(Scanner sc, Connection connection) throws SQLException {
		System.out.println();
		System.out.println("Student menu");
		System.out.println("----");
		System.out.println("1.Enrollment");
		System.out.println("2.List");
		System.out.println("3.Update");
		System.out.println("4.Search student");
		System.out.println("0.Exit");
		System.out.println();
		System.out.println("Please enter option:");
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
		case 3:
			StudentController.studentDisenrollment(sc, connection);
			break;
		case 4:
			StudentController.studentUpdate(sc, connection);
			break;
		case 5:
			StudentController.findStudent(sc, connection);
			break;
		}
	}

}
