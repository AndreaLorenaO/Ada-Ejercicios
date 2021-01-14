package db.inicial.controller;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import db.inicial.DAO.RegistrationDAO;
import db.inicial.io.IOBuffered;
import db.inicial.model.Registration;

public class RegistrationController {

	public static void registrationEnrollment(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Please enter course id the student wishes to register for:");
		int courseId = sc.nextInt();
		System.out.println("Please enter student id:");
		int studentId = sc.nextInt();
		System.out.println("Please enter professor id:");
		int professorId = sc.nextInt();
		System.out.println("Please enter commision the student wishes to be in:");
		int commission = sc.nextInt();
		System.out.println("Please enter registration state:");
		int state = sc.nextInt();
		Registration registration = new Registration(courseId, studentId, professorId, commission, state);
		RegistrationDAO.insert(registration, connection);
		System.out.println("Registration successful");
		System.out.println();
		IOBuffered.prinRegistrationCard(connection, registration, sc);
	}

	public static void registrationListByStudent(Connection connection) throws SQLException {
		System.out.println("Registration list of students:");
		List<Registration> listStudents = RegistrationDAO.findAll(connection);
		System.out.println("ID - COURSE_ID - STUDENT_ID - PROFESSOR_ID - COMMISSION - STATE");
		for (Registration registration : listStudents) {
			System.out.println(registration.toString());
		}
	}

	public static void registrationListByEvaluation(Scanner sc, Connection connection) {

	}

	public static void registrationUpdateState(Scanner sc, Connection connection) {

	}

	public static void printRegistrationCard(Scanner sc) {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/db/inicial/io/logs"))) {

		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}

}
