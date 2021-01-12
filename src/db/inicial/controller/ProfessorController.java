package db.inicial.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import db.inicial.DAO.ProfessorDAO;
import db.inicial.io.Util;
import db.inicial.model.Professor;

public class ProfessorController {

	public static void professorSelection(Scanner sc, Connection connection, int professorOption) throws SQLException {
		switch (professorOption) {
		case 1:
			professorEnrollment(sc, connection);
			break;
		case 2:
			professorList(connection);
			break;
		case 3:
			professorDisenrollment(sc, connection);
			break;
		case 4:
			professorUpdate(sc, connection);
			break;
		case 5:
			findProfessor(sc, connection);
			break;
		}
	}

	public static void professorEnrollment(Scanner sc, Connection connection) throws SQLException {
		sc.nextLine();
		System.out.println("Enter professor name you wish to add:");
		String professorName = sc.nextLine();
		Util.validarlongitud(sc, professorName);
		System.out.println("Enter professor lastname:");
		String professorLastname = sc.nextLine();
		Util.validarlongitud(sc, professorLastname);
		System.out.println("Enter professor e-mail:");
		String professorEmail = sc.next();
		Util.validarlongitud(sc, professorEmail);
		System.out.println("Enter professor cellphone:");
		String professorCellphone = sc.next();
		Professor professor = new Professor(professorName, professorLastname, professorEmail, professorCellphone);
		ProfessorDAO.insert(professor, connection);
		System.out.println("Enrollment successful");
	}

	public static void professorList(Connection connection) throws SQLException {
		System.out.println("List of professors:");
		List<Professor> professorsList = ProfessorDAO.findAll(connection);
		System.out.println("ID - NAME - LASTNAME - EMAIL - CELLPHONE");
		for (Professor professor : professorsList) {
			System.out.println(professor.getId() + " - " + professor.getName() + " - " + professor.getLastname() + " - "
					+ professor.getEmail() + " - " + professor.getCellphone());
		}
	}

	public static void professorDisenrollment(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Enter professor Id you wish to disenroll:");
		int professorId = sc.nextInt();
		Professor professorDelete = ProfessorDAO.findById(professorId, connection);
		if (professorDelete == null) {
			System.err.println("The professor was not found");
		} else {
			int modified = ProfessorDAO.delete(professorId, connection);
			if (modified == 1) {
				System.out.println("Successful disenrollment of the professor");
			} else {
				System.err.println("Disenrollment could not be accomplished");
			}
		}
	}

	public static void professorUpdate(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Enter professor Id you wish to update:");
		int professorId = sc.nextInt();
		Professor professorModified = ProfessorDAO.findById(professorId, connection);
		if (professorModified == null) {
			System.err.println("The professor was not found");
		} else {
			System.out.println(
					"You wish to update: " + professorModified.getName() + " " + professorModified.getLastname());
			System.out.println("Enter option to update: 1.Name; 2.Lastname. 0.Exit");
			int optionName = sc.nextInt();
			if (optionName == 1) {
				System.out.println("Please enter new name");
				sc.nextLine();
				String newName = sc.nextLine();
				int updated = ProfessorDAO.updateProfessorName(professorId, newName, connection);
				if (updated == 1) {
					System.out.println("Successful update");
				} else {
					System.err.println("Professor update error: " + updated);
				}
			} else {
				System.out.println("Please enter new lastname");
				String newLastname = sc.next();
				int updated = ProfessorDAO.updateProfessorLastname(professorId, newLastname, connection);
				if (updated == 1) {
					System.out.println("Successful update");
				} else {
					System.err.println("Professor update error: " + updated);
				}
			}
		}
	}

	public static void findProfessor(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Enter professor lastname you wish to find:");
		String professorLastname = sc.next();
		List<Professor> list = ProfessorDAO.findByName(professorLastname, connection);
		System.out.println();
		list.forEach(professor -> System.out
				.println(professor.getId() + " - " + professor.getName() + " - " + professor.getLastname()));
	}

}
