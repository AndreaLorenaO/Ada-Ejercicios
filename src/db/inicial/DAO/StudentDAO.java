package db.inicial.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.inicial.model.Student;

public class StudentDAO {

	public static void insert(Student student, Connection connection) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement(
				"INSERT INTO STUDENT (NAME, LASTNAME, EMAIL, CELLPHONE, FACULTY) VALUES (?, ?, ?, ?, ?)");
		stmt.setString(1, student.getName());
		stmt.setString(2, student.getLastname());
		stmt.setString(3, student.getEmail());
		stmt.setString(4, student.getCellphone());
		stmt.setString(5, student.getFaculty());
		stmt.executeUpdate();
	}

	public static List<Student> findAll(Connection connection) throws SQLException {
		List<Student> listOfStudents = new ArrayList<Student>();
		String sql = "SELECT * FROM STUDENT";
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			String studentName = rs.getString(2);
			int studentId = rs.getInt(1);
			String studentLastname = rs.getString(3);
			String studentEmail = rs.getString(4);
			String studentCellphone = rs.getString(5);
			String studentFaculty = rs.getString(6);
			Student student = new Student(studentName, studentLastname, studentEmail, studentCellphone, studentFaculty);
			student.setId(studentId);
			listOfStudents.add(student);
		}
		return listOfStudents;
	}

	public static Student findById(int studentId, Connection connection) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM STUDENT WHERE ID = ?");
		stmt.setInt(1, studentId);
		ResultSet rs = stmt.executeQuery();
		Student student = null;
		if (rs.next()) {
			student = new Student(rs.getInt(1), rs.getString(2), rs.getString(3));
		}
		return student;
	}

	public static int delete(int studentId, Connection connection) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("DELETE FROM STUDENT WHERE ID = ?");
		stmt.setInt(1, studentId);
		return stmt.executeUpdate();
	}

	public static int updateStudent(int studentId, String field, String newValue, Connection connection)
			throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("UPDATE STUDENT SET " + field + " = ? WHERE ID = ?");
		stmt.setString(1, newValue);
		stmt.setInt(2, studentId);
		return stmt.executeUpdate();
	}

	public static List<Student> findByName(String studentLastname, Connection connection) throws SQLException {
		String sql = "SELECT * FROM STUDENT WHERE LASTNAME LIKE '%" + studentLastname + "%' ORDER BY LASTNAME";
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		List<Student> list = new ArrayList<Student>();
		Student student = null;
		while (rs.next()) {
			student = new Student(rs.getInt(1), rs.getString(2), rs.getString(3));
			list.add(student);
		}
		return list;
	}

}
