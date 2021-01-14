package db.inicial.menu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import db.inicial.controller.ProfessorController;

public class MenuProfessor {

	public static int printMenuProfessor(Scanner sc, Connection connection) throws SQLException {
		System.out.println();
		System.out.println("Professor menu");
		MenuOptions.printSubMenu();
		return sc.nextInt();
	}

	public static void professorSelection(Scanner sc, Connection connection, int professorOption) throws SQLException {
		switch (professorOption) {
		case 1:
			ProfessorController.professorEnrollment(sc, connection);
			break;
		case 2:
			ProfessorController.professorList(connection);
			break;
//		case 3:
//			ProfessorController.professorDisenrollment(sc, connection);
//			break;
		case 3:
			ProfessorController.professorUpdate(sc, connection);
			break;
		case 4:
			ProfessorController.findProfessor(sc, connection);
			break;
		}
	}

}
