package db.inicial.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.inicial.model.Course;

public class CursoDAO {

	// Data Access Object

	public static void insert(Course course, Connection connection) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement(
				"INSERT INTO COURSE (NAME, SCHEDULE, DURATION, START, END, ID_PROFESSOR) VALUES (?, ?, ?, ?, ?, ?)");
		stmt.setString(1, course.getName());
		stmt.setString(2, course.getSchedule());
		stmt.setString(3, course.getDuration());
		stmt.setString(4, course.getStart());
		stmt.setString(5, course.getEnd());
		stmt.setInt(6, course.getProfessorId());
		stmt.executeUpdate();
	}

	public static List<Course> findAll(Connection connection) throws SQLException {
		List<Course> listOfCourses = new ArrayList<Course>();
		String sql = "SELECT * FROM COURSE";
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			String courseName = rs.getString(2);
			int courseId = rs.getInt(1);
			String courseSchedule = rs.getString(3);
			String courseDuration = rs.getString(4);
			String courseStart = rs.getString(5);
			String courseEnd = rs.getString(6);
			int professorId = rs.getInt(7);
			Course course = new Course(courseName, courseSchedule, courseDuration, courseStart, courseEnd, professorId);
			course.setId(courseId);
//			course.setSchedule(courseSchedule);
//			course.setDuration(courseDuration);
//			course.setStart(courseStart);
//			course.setEnd(courseEnd);
			listOfCourses.add(course);
		}
		return listOfCourses;
	}

	public static int delete(int courseId, Connection connection) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("DELETE FROM COURSE WHERE ID = ?");
		stmt.setInt(1, courseId);
		return stmt.executeUpdate();
	}

	public static int updateCourse(int courseId, String field, String newValue, Connection connection)
			throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("UPDATE COURSE SET " + field + " = ? WHERE ID = ?");
		stmt.setString(1, newValue);
		stmt.setInt(2, courseId);
		return stmt.executeUpdate();
	}

	public static List<Course> findByName(String name, Connection connection) throws SQLException {
//		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM CURSO WHERE NAME LIKE ?%");
//		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM CURSO WHERE NAME = ?");
//		stmt.setString(1, name);

		String sql = "SELECT * FROM COURSE WHERE NAME LIKE '%" + name + "%' ORDER BY NAME";
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		List<Course> list = new ArrayList<Course>();
		Course course = null;
		while (rs.next()) {
			course = new Course(rs.getInt(1), rs.getString(2));
			list.add(course);
		}
		return list;
	}

	public static Course findById(int courseId, Connection connection) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM COURSE WHERE ID = ?");
		stmt.setInt(1, courseId);
		ResultSet rs = stmt.executeQuery();
		Course course = null;
		if (rs.next()) {
			course = new Course(rs.getInt(1), rs.getString(2));
		}
		return course;
	}

}
