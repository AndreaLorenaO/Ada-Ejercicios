package db.inicial;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import db.inicial.DAO.AdminDB;
import db.inicial.DAO.CursoDAO;
import db.inicial.DAO.ProfessorDAO;
import db.inicial.DAO.RegistrationDAO;
import db.inicial.DAO.StudentDAO;
import db.inicial.model.Course;
import db.inicial.model.Professor;
import db.inicial.model.Registration;
import db.inicial.model.Student;

// Menu: 1.Curso, 2.Estudiantes, 3.Inscripciones
// Necesitamos alta, listado, modificaciones y baja de: 1.Curso y 2.Alumnos
// 

public class AppJDBC {

	public static void main(String[] args) {

		try {
			Connection connection = AdminDB.obtenerConexion(); // Objeto conexion listo para usar
//			Connection connection = AdminDB.obtenerConexion("com.mysql.cj.jdbc.Driver"); Asi seria para no hardcodear
//			System.out.println(AdminDB.obtenerConexion());
			Scanner sc = new Scanner(System.in);
			@SuppressWarnings("unused")
			Statement stmt = connection.createStatement();
			System.out.println("Welcome to the Course online system");
			int option = menuOptions(sc);
			while (option != 0) {
				switch (option) {
				case 1:
					menuCourse(sc, connection);
					break;
				case 2:
					menuStudent(sc, connection);
					break;
				case 3:
					menuProfessor(sc, connection);
					break;
				case 4:
					menuRegistration(sc, connection);
					break;
				}
				option = menuOptions(sc);
			}
			connection.close();

		} catch (ClassNotFoundException e) {
			System.err.println("Driver Class loading error: " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("SQL execution error: " + e.getMessage());
		}
	}

	private static int menuOptions(Scanner sc) {
		System.out.println();
		System.out.println("Menu");
		System.out.println("----");
		System.out.println("1.Course; 2.Student; 3.Professor; 4.Registration; 0.Exit");
		System.out.println();
		System.out.println("Please enter option: ");
		return sc.nextInt();
	}

	private static void menuCourse(Scanner sc, Connection connection) throws SQLException {
		System.out.println();
		System.out.println("Menu");
		System.out.println("----");
		System.out.println(
				"1.Course enrollment; 2.Course list; 3.Course disenrollment; 4.Course update; 5.Find course; 0. Exit");
		System.out.println();
		System.out.println("Please enter option: ");
		int courseOption = sc.nextInt();
		switch (courseOption) {
		case 1:
			courseEnrollment(sc, connection);
			break;
		case 2:
			courseList(connection);
			break;
		case 3:
			courseDisenrollment(sc, connection);
			break;
		case 4:
			courseUpdate(sc, connection);
			break;
		case 5:
			findCourse(sc, connection);
		}
	}

	private static void courseEnrollment(Scanner sc, Connection connection) throws SQLException {
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
		Course course = new Course(courseName, courseSchedule, courseDuration, courseStart, courseEnd, professorId);
		CursoDAO.insert(course, connection);
		System.out.println("Enrollment successful");
	}

	private static void courseList(Connection connection) throws SQLException {
		System.out.println("List of courses:");
		List<Course> listOfCourses = CursoDAO.findAll(connection);
		System.out.println("ID - NAME - SCHEDULE - DURATION - START - END - PROFESSOR ID");
		for (Course course : listOfCourses) {
			System.out.println(course.getId() + " - " + course.getName() + " - " + course.getSchedule() + " - "
					+ course.getDuration() + " - " + course.getStart() + " - " + course.getEnd() + " - "
					+ course.getProfessorId());
		}
	}

	private static void courseDisenrollment(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Enter course Id you wish to disenroll:");
		int courseId = sc.nextInt();
		Course courseDelete = CursoDAO.findById(courseId, connection);
		if (courseDelete != null) {
			int modified = CursoDAO.delete(courseId, connection);
			if (modified == 1) {
				System.out.println("Successful disenrollment of the course");
			} else {
				System.err.println("Disenrollment could not be accomplished");
			}
		} else {
			System.err.println("The course was not found");
		}
	}

	private static void courseUpdate(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Enter course Id you wish to update:");
		int courseId = sc.nextInt();
		Course courseModified = CursoDAO.findById(courseId, connection);
		if (courseModified != null) {
			System.out.println("You wish to update: " + courseModified.getName());
			System.out.println("Please enter field you wish to update: Name; Schedule; Duration; Start; End. 0.Exit");
			String field = sc.next();
			System.out.println("Please enter field new value you have selected:");
			sc.nextLine();
			String newValue = sc.nextLine();
			int updated = CursoDAO.updateCourse(courseId, field, newValue, connection);
			if (updated == 1) {
				System.out.println("Successful update");
			} else {
				System.err.println("Course update error: " + updated);
			}
		} else {
			System.err.println("The course was not found");
		}
	}

	private static void findCourse(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Enter course name you wish to find:");
		String courseName = sc.next();
		List<Course> list = CursoDAO.findByName(courseName, connection);
		System.out.println();
		list.forEach(course -> System.out.println(course.getId() + " - " + course.getName()));
	}

	private static void menuStudent(Scanner sc, Connection connection) throws SQLException {
		System.out.println();
		System.out.println("Menu");
		System.out.println("----");
		System.out.println(
				"1.Student enrollment; 2.Student list; 3.Student disenrollment; 4.Student update; 5.Find student; 0. Exit");
		System.out.println();
		System.out.println("Please enter option:");
		int studentOption = sc.nextInt();
		switch (studentOption) {
		case 1:
			studentEnrollment(sc, connection);
			break;
		case 2:
			studentList(connection);
			break;
		case 3:
			studentDisenrollment(sc, connection);
			break;
		case 4:
			studentUpdate(sc, connection);
			break;
		case 5:
			findStudent(sc, connection);
			break;
		}
	}

	private static void studentEnrollment(Scanner sc, Connection connection) throws SQLException {
		sc.nextLine();
		System.out.println("Enter student name you wish to enroll:");
		String studentName = sc.nextLine();
		System.out.println("Enter student lastname:");
		String studentLastname = sc.nextLine();
		System.out.println("Enter student e-mail:");
		String studentEmail = sc.next();
		System.out.println("Enter student cellphone:");
		String studentCellphone = sc.next();
		sc.nextLine();
		System.out.println("Enter sudent faculty:");
		String studentFaculty = sc.nextLine();
		Student student = new Student(studentName, studentLastname, studentEmail, studentCellphone, studentFaculty);
		StudentDAO.insert(student, connection);
		System.out.println("Enrollment successful");
	}

	private static void studentList(Connection connection) throws SQLException {
		System.out.println("List of courses:");
		List<Student> listOfStudents = StudentDAO.findAll(connection);
		System.out.println("ID - NAME - LASTNAME - EMAIL - CELLPHONE - FACULTY");
		for (Student student : listOfStudents) {
			System.out.println(student.getId() + " - " + student.getName() + " - " + student.getLastname() + " - "
					+ student.getEmail() + " - " + student.getCellphone() + " - " + student.getFaculty());
		}
	}

	private static void studentDisenrollment(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Enter student Id you wish to disenroll:");
		int studentId = sc.nextInt();
		Student studentDelete = StudentDAO.findById(studentId, connection);
		if (studentDelete != null) {
			int modified = StudentDAO.delete(studentId, connection);
			if (modified == 1) {
				System.out.println("Successful disenrollment of the student");
			} else {
				System.err.println("Disenrollment could not be accomplished");
			}
		} else {
			System.err.println("The student was not found");
		}
	}

	private static void studentUpdate(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Enter student Id you wish to update:");
		int studentId = sc.nextInt();
		Student studentModified = StudentDAO.findById(studentId, connection);
		if (studentModified != null) {
			System.out
					.println("You wish to update: " + studentModified.getName() + " " + studentModified.getLastname());
			System.out.println(
					"Please enter field you wish to update: Name; Lastname; Email; Cellphone; Faculty. 0.Exit");
			String field = sc.next();
			System.out.println("Please enter field new value you have selected:");
			sc.nextLine();
			String newValue = sc.nextLine();
			int updated = StudentDAO.updateStudent(studentId, field, newValue, connection);
			if (updated == 1) {
				System.out.println("Successful update");
			} else {
				System.err.println("Student update error: " + updated);
			}
		} else {
			System.err.println("The student was not found");
		}
	}

	private static void findStudent(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Enter student lastname you wish to find:");
		String studentLastname = sc.next();
		List<Student> list = StudentDAO.findByName(studentLastname, connection);
		System.out.println();
		list.forEach(student -> System.out
				.println(student.getId() + " - " + student.getName() + " - " + student.getLastname()));
	}

	private static void menuProfessor(Scanner sc, Connection connection) throws SQLException {
		System.out.println();
		System.out.println("Menu");
		System.out.println("----");
		System.out.println(
				"1.Professor enrollment; 2.Professor list; 3.Professor disenrollment; 4.Professor update; 5.Find Professor; 0. Exit");
		System.out.println();
		System.out.println("Please enter option: ");
		int studentOption = sc.nextInt();
		switch (studentOption) {
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

	private static void professorEnrollment(Scanner sc, Connection connection) throws SQLException {
		sc.nextLine();
		System.out.println("Enter professor name you wish to add:");
		String professorName = sc.nextLine();
		System.out.println("Enter professor lastname:");
		String professorLastname = sc.nextLine();
		System.out.println("Enter professor e-mail:");
		String professorEmail = sc.next();
		System.out.println("Enter professor cellphone:");
		String professorCellphone = sc.next();
		Professor professor = new Professor(professorName, professorLastname, professorEmail, professorCellphone);
		ProfessorDAO.insert(professor, connection);
		System.out.println("Enrollment successful");
	}

	private static void professorList(Connection connection) throws SQLException {
		System.out.println("List of professors:");
		List<Professor> professorsList = ProfessorDAO.findAll(connection);
		System.out.println("ID - NAME - LASTNAME - EMAIL - CELLPHONE");
		for (Professor professor : professorsList) {
			System.out.println(professor.getId() + " - " + professor.getName() + " - " + professor.getLastname() + " - "
					+ professor.getEmail() + " - " + professor.getCellphone());
		}
	}

	private static void professorDisenrollment(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Enter professor Id you wish to disenroll:");
		int professorId = sc.nextInt();
		Professor professorDelete = ProfessorDAO.findById(professorId, connection);
		if (professorDelete != null) {
			int modified = ProfessorDAO.delete(professorId, connection);
			if (modified == 1) {
				System.out.println("Successful disenrollment of the professor");
			} else {
				System.err.println("Disenrollment could not be accomplished");
			}
		} else {
			System.err.println("The professor was not found");
		}
	}

	private static void professorUpdate(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Enter professor Id you wish to update:");
		int professorId = sc.nextInt();
		Professor professorModified = ProfessorDAO.findById(professorId, connection);
		if (professorModified != null) {
			System.out.println(
					"You wish to update: " + professorModified.getName() + " " + professorModified.getLastname());
			System.out.println("Please enter field you wish to update: Name; Lastname; Email; Cellphone. 0.Exit");
			String field = sc.next();
			System.out.println("Please enter field new value you have selected:");
			sc.nextLine();
			String newValue = sc.nextLine();
			int updated = ProfessorDAO.updateProfessor(professorId, field, newValue, connection);
			if (updated == 1) {
				System.out.println("Successful update");
			} else {
				System.err.println("Professor update error: " + updated);
			}
		} else {
			System.err.println("The professor was not found");
		}
	}

	private static void findProfessor(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Enter professor lastname you wish to find:");
		String professorLastname = sc.next();
		List<Professor> list = ProfessorDAO.findByName(professorLastname, connection);
		System.out.println();
		list.forEach(professor -> System.out
				.println(professor.getId() + " - " + professor.getName() + " - " + professor.getLastname()));
	}

	private static void menuRegistration(Scanner sc, Connection connection) throws SQLException {
		System.out.println();
		System.out.println("Menu");
		System.out.println("----");
		System.out.println(
				"1.Registration; 2.Registration list by students; 3.Registration list by evaluation; 4.Cancellation of registration. 0. Exit");
		System.out.println();
		System.out.println("Please enter option: ");
		int registrationOption = sc.nextInt();
		switch (registrationOption) {
		case 1:
			registration(sc, connection);
			break;

		}
	}

	private static void registration(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Please enter student id to start registration");
		int studentId = sc.nextInt();
		System.out.println("Please enter course id the student wishes to register for:");
		int courseId = sc.nextInt();
		Course course = CursoDAO.findById(courseId, connection);
		Professor professor = ProfessorDAO.findProfessorByCourse(courseId, connection);
		System.out.println(
				"You wish you register for: " + course.getName() + " course that will be teached by the professor: "
						+ course.getProfessorId() + " " + professor.getName() + professor.getLastname());
		System.out.println("Please enter commision you would like to register: 1, 2 or 3");
		int comission = sc.nextInt();
		Registration registration = new Registration(courseId, studentId, comission);
		RegistrationDAO.insert(registration, connection);
		System.out.println("Registration successful");

	}

}
