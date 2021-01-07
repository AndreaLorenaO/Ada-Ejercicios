package db.inicial.controller;

import java.sql.Connection;
import java.sql.SQLException;
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
		System.out.println("Please enter student id to start registration");
		int studentId = sc.nextInt();
		System.out.println("Please enter course id the student wishes to register for:");
		int courseId = sc.nextInt();
//		Course course = CursoDAO.findById(courseId, connection);
//		System.out.println("You wish to register the student in: " + course.getName());

//		Professor professor = ProfessorDAO.findProfessorByCourse(courseId, connection);

		System.out.println("Please enter commision you would like to register: 1 or 2");
		int comission = sc.nextInt();
		Registration registration = new Registration(courseId, studentId, comission);
		RegistrationDAO.insert(registration, connection);
		System.out.println("Registration successful");
	}

}
