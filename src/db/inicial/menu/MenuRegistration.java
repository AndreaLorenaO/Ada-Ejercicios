package db.inicial.menu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import db.inicial.controller.RegistrationController;

public class MenuRegistration {

	public static int printMenuRegistration(Scanner sc, Connection connection) throws SQLException {
		System.out.println();
		System.out.println("Registration menu");
		System.out.println("----");
		System.out.println("1.Registration");
		System.out.println("2.List by students");
		System.out.println("3.List by evaluation");
		System.out.println("4.Cancellation of registration");
		System.out.println("0.Exit");
		System.out.println();
		System.out.println("Please enter option: ");
		return sc.nextInt();
	}

	public static void registrationSelection(Scanner sc, Connection connection, int registrationMenuOption)
			throws SQLException {
		switch (registrationMenuOption) {
		case 1:
			RegistrationController.registrationEnrollment(sc, connection);
			break;
//		case 2:
//			RegistrationController.registrationListByStudent(connection);
//			break;
//		case 3:
//			RegistrationController.registrationListByEvaluation(sc, connection);
//			break;
//		case 4:
//			RegistrationController.registrationUpdate(sc, connection);
//			break;
		}
	}

}
