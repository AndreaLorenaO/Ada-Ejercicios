package db.inicial.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import db.inicial.DAO.RegistrationDAO;
import db.inicial.model.Registration;

public class RegistrationController {

	public static void registrationSelection(Scanner sc, Connection connection, int professorOption)
			throws SQLException {
		switch (professorOption) {
		case 1:
			registrationEnrollment(sc, connection);
			break;
//		case 2:
//			registrationListByStudent(connection);
//			break;
//		case 3:
//			registrationListByEvaluation(sc, connection);
//			break;
//		case 4:
//			registrationUpdate(sc, connection);
//			break;
		}
	}

	public static void registrationEnrollment(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Please enter course id the student wishes to register for:");
		int courseId = sc.nextInt();
		System.out.println("Please enter student id:");
		int studentId = sc.nextInt();
		System.out.println("Please enter professor id:");
		int professorId = sc.nextInt();
		System.out.println("Please enter commision the student wishes to be in:");
		int commission = sc.nextInt();
		System.out.println("Please enter student first evaluation:");
		int evaluation1 = sc.nextInt();
		System.out.println("Please enter student second evaluation:");
		int evaluation2 = sc.nextInt();
		System.out.println("Please enter registration state:");
		int state = sc.nextInt();
		Registration registration = new Registration(courseId, studentId, professorId, commission, evaluation1,
				evaluation2, state);
		RegistrationDAO.insert(registration, connection);
		System.out.println("Registration successful");
	}

	public static void registrationListByStudent(Connection connection) throws SQLException {
		System.out.println("Registration list of students:");
		List<Registration> listStudents = RegistrationDAO.findAll(connection);
		System.out.println("ID - NAME - SCHEDULE - DURATION - START - END - PROFESSOR ID");
		for (Registration registration : listStudents) {
			System.out.println(registration.toString());
		}
	}
}
