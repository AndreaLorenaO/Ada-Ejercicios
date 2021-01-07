package db.inicial.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.inicial.model.Registration;

public class RegistrationDAO {

	public static void insert(Registration registration, Connection connection) throws SQLException {
		PreparedStatement stmt = connection
				.prepareStatement("INSERT INTO REGISTRATION (ID_COURSE, ID_STUDENT, COMMISSION) VALUES (?, ?, ?)");
		stmt.setInt(1, registration.getCourseId());
		stmt.setInt(2, registration.getStudentId());
		stmt.setInt(3, registration.getCommission());
		stmt.executeUpdate();
	}

}
