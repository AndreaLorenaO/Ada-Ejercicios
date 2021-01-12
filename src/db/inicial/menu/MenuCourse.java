package db.inicial.menu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import db.inicial.controller.CourseController;

public class MenuCourse {

	public static int printMenuCourse(Scanner sc, Connection connection) {
		System.out.println();
		System.out.println("Course menu");
		MenuOptions.printPartMenu();
		return sc.nextInt();
	}

	public static void courseSelection(Scanner sc, Connection connection, int courseMenuOption) throws SQLException {
		switch (courseMenuOption) {
		case 1:
			CourseController.courseEnrollment(sc, connection);
			break;
		case 2:
			CourseController.courseList(connection);
			break;
		case 3:
			CourseController.courseUpdate(sc, connection);
			break;
		case 4:
			CourseController.findCourse(sc, connection);
		default:
			break;
		}
	}

}
