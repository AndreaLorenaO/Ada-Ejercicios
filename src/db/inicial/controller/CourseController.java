package db.inicial.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import db.inicial.DAO.CursoDAO;
import db.inicial.model.Course;

public class CourseController {

	public static void courseEnrollment(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Enter course name you wish to enroll:");
		String courseName = sc.next();
		sc.nextLine();
		System.out.println("Enter course schedule:");
		String courseSchedule = sc.nextLine();
		System.out.println("Enter course duration:");
		String courseDuration = sc.nextLine();
		System.out.println("Enter course start month:");
		String courseStart = sc.next();
		System.out.println("Enter course end month:");
		String courseEnd = sc.next();
		System.out.println("Enter professor id that would teach the course");
		int professorId = sc.nextInt();
//		Validar la existencia del profesor
		Course course = new Course(courseName, courseSchedule, courseDuration, courseStart, courseEnd, professorId);
		CursoDAO.insert(course, connection);
		System.out.println("Enrollment successful");
	}

	public static void courseList(Connection connection) throws SQLException {
		System.out.println("List of courses:");
		List<Course> listOfCourses = CursoDAO.findAll(connection);
		System.out.println("ID - NAME - SCHEDULE - DURATION - START - END - PROFESSOR ID");
		for (Course course : listOfCourses) {
			System.out.println(course.getId() + " - " + course.getName() + " - " + course.getSchedule() + " - "
					+ course.getDuration() + " - " + course.getStart() + " - " + course.getEnd() + " - "
					+ course.getProfessorId());
		}
	}

	public static void courseUpdate(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Enter course Id you wish to update:");
		int courseId = sc.nextInt();
		Course courseModified = CursoDAO.findById(courseId, connection);
		if (courseModified == null) {
			System.err.println("The course was not found");
		} else {
			System.out.println("You wish to update: " + courseModified.getName());
			System.out.println("Enter option to update: 1.Course name; 2.Course state. 0.Exit");
			int optionName = sc.nextInt();
			if (optionName == 1) {
				System.out.println("Please enter new name");
				String newName = sc.next();
				int updated = CursoDAO.updateCourseName(courseId, newName, connection);
				if (updated == 1) {
					System.out.println("Successful update");
				} else {
					System.err.println("Course update error: " + updated);
				}
			} else {
				System.out.println("Please enter option to update: 1.Active; 2.Inactive. 0.Exit");
				int optionState = sc.nextInt();
				if (optionState == 1) {
					int updated = CursoDAO.updateCourseState(courseId, optionState, connection);
					if (updated == 1) {
						System.out.println("Successful update");
					} else {
						System.err.println("Course update error: " + updated);
					}
				}
			}

		}
	}

	public static void findCourse(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Enter course name you wish to find:");
		String courseName = sc.next();
		List<Course> list = CursoDAO.findByName(courseName, connection);
		System.out.println();
		list.forEach(course -> course.toString());
	}

}
