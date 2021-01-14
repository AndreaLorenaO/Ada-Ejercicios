package db.inicial.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import db.inicial.DAO.StudentDAO;
import db.inicial.io.Util;
import db.inicial.model.Student;

public class StudentController {

	public static void studentEnrollment(Scanner sc, Connection connection) throws SQLException {
		sc.nextLine();
		System.out.println("Enter student name you wish to enroll:");
		String studentName = sc.nextLine();
		Util.validarlongitud(sc, studentName);
		System.out.println("Enter student lastname:");
		String studentLastname = sc.nextLine();
		Util.validarlongitud(sc, studentLastname);
		System.out.println("Enter student e-mail:");
		String studentEmail = sc.next();
		Util.validarlongitud(sc, studentEmail);
		System.out.println("Enter student cellphone:");
		String studentCellphone = sc.next();
		sc.nextLine();
		System.out.println("Enter student faculty:");
		String studentFaculty = sc.nextLine();
		Student student = new Student(studentName, studentLastname, studentEmail, studentCellphone, studentFaculty);
		StudentDAO.insert(student, connection);
		System.out.println("Enrollment successful");
	}

	public static void studentList(Connection connection) throws SQLException {
		System.out.println("List of courses:");
		List<Student> listOfStudents = StudentDAO.findAll(connection);
		System.out.println("ID - NAME - LASTNAME - EMAIL - CELLPHONE - FACULTY");
		for (Student student : listOfStudents) {
			System.out.println(student.getId() + " - " + student.getName() + " - " + student.getLastname() + " - "
					+ student.getEmail() + " - " + student.getCellphone() + " - " + student.getFaculty());
		}
	}

//	public static void studentDisenrollment(Scanner sc, Connection connection) throws SQLException {
//		System.out.println("Enter student Id you wish to disenroll:");
//		int studentId = sc.nextInt();
//		Student studentDelete = StudentDAO.findById(studentId, connection);
//		if (studentDelete == null) {
//			System.err.println("The student was not found");
//		} else {
//			int modified = StudentDAO.delete(studentId, connection);
//			if (modified == 1) {
//				System.out.println("Successful disenrollment");
//			} else {
//				System.err.println("Disenrollment could not be accomplished");
//			}
//		}
//	}

	public static void studentUpdate(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Enter student Id you wish to update:");
		int studentId = sc.nextInt();
		Student studentModified = StudentDAO.findById(studentId, connection);
		if (studentModified == null) {
			System.err.println("The student was not found");
		} else {
			System.out
					.println("You wish to update: " + studentModified.getName() + " " + studentModified.getLastname());
			System.out.println("Enter option to update: 1.Name; 2.Lastname. 0.Exit");
			int optionName = sc.nextInt();
			if (optionName == 1) {
				System.out.println("Please enter new name");
				String newName = sc.next();
				int updated = StudentDAO.updateStudentName(studentId, newName, connection);
				if (updated == 1) {
					System.out.println("Successful update");
				} else {
					System.err.println("Student update error: " + updated);
				}
			} else {
				System.out.println("Please enter new lastname");
				String newLastname = sc.next();
				int updated = StudentDAO.updateStudentLastname(studentId, newLastname, connection);
				if (updated == 1) {
					System.out.println("Successful update");
				} else {
					System.err.println("Student update error: " + updated);
				}
			}
		}

	}

	public static void findStudent(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Enter student lastname you wish to find:");
		String studentLastname = sc.next();
		List<Student> list = StudentDAO.findByName(studentLastname, connection);
		System.out.println();
		list.forEach(student -> System.out
				.println(student.getId() + " - " + student.getName() + " - " + student.getLastname()));
	}

}
