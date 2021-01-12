package db.inicial.menu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import db.inicial.controller.RegistrationController;
import db.inicial.io.IOBuffered;

public class MenuRegistration {

	public static int printMenuRegistration(Scanner sc, Connection connection) throws SQLException {
		System.out.println();
		IOBuffered.lecturaPrintMenuRegistration();
		return sc.nextInt();
	}

	public static void registrationSelection(Scanner sc, Connection connection, int registrationMenuOption)
			throws SQLException {
		switch (registrationMenuOption) {
		case 1:
			RegistrationController.registrationEnrollment(sc, connection);
			break;
		case 2:
			RegistrationController.registrationListByStudent(connection);
			break;
//		case 3:
//			RegistrationController.registrationListByEvaluation(sc, connection);
//			break;
//		case 4:
//			RegistrationController.registrationUpdate(sc, connection);
//			break;
		}
	}

}
