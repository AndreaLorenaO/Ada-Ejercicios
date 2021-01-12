package db.inicial.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.inicial.model.Registration;

public class RegistrationDAO {

	public static void insert(Registration registration, Connection connection) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement(
				"INSERT INTO REGISTRATION (ID_COURSE, ID_STUDENT, ID_PROFESSOR, COMMISSION, EVALUATION_1, EVALUATION_2, STATE) VALUES (?, ?, ?, ?, ?, ?, ?)");
		stmt.setInt(1, registration.getCourseId());
		stmt.setInt(2, registration.getStudentId());
		stmt.setInt(3, registration.getProfessorId());
		stmt.setInt(4, registration.getCommission());
		stmt.setInt(5, registration.getEvaluation1());
		stmt.setInt(6, registration.getEvaluation2());
		stmt.setInt(7, registration.getState());
		stmt.executeUpdate();
	}

	public static List<Registration> findAll(Connection connection) throws SQLException {
		List<Registration> listStudents = new ArrayList<Registration>();
		String sql = "SELECT * FROM REGISTRATION";
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			int registrationId = rs.getInt(1);
			int courseId = rs.getInt(2);
			int studentId = rs.getInt(3);
			int commission = rs.getInt(5);
			Registration registration = new Registration(registrationId, courseId, studentId, commission);
			registration.setRegistrationId(registrationId);
			listStudents.add(registration);
		}
		return listStudents;
	}

}
