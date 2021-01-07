package db.inicial.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.inicial.model.Professor;

public class ProfessorDAO {

	public static void insert(Professor professor, Connection connection) throws SQLException {
		PreparedStatement stmt = connection
				.prepareStatement("INSERT INTO PROFESSOR (NAME, LASTNAME, EMAIL, CELLPHONE) VALUES (?, ?, ?, ?)");
		stmt.setString(1, professor.getName());
		stmt.setString(2, professor.getLastname());
		stmt.setString(3, professor.getEmail());
		stmt.setString(4, professor.getCellphone());
		stmt.executeUpdate();
	}

	public static List<Professor> findAll(Connection connection) throws SQLException {
		List<Professor> professorsList = new ArrayList<Professor>();
		String sql = "SELECT * FROM PROFESSOR";
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			String professorName = rs.getString(2);
			int professorId = rs.getInt(1);
			String professorLastname = rs.getNString(3);
			String professorEmail = rs.getNString(4);
			String professorCellphone = rs.getNString(5);
			Professor professor = new Professor(professorName, professorLastname, professorEmail, professorCellphone);
			professor.setId(professorId);
			professorsList.add(professor);
		}
		return professorsList;
	}

	public static Professor findById(int professorId, Connection connection) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM PROFESSOR WHERE ID = ?");
		stmt.setInt(1, professorId);
		ResultSet rs = stmt.executeQuery();
		Professor professor = null;
		if (rs.next()) {
			professor = new Professor(rs.getInt(1), rs.getString(2), rs.getString(3));
		}
		return professor;
	}

	public static int delete(int professorId, Connection connection) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("DELETE *FROM PROFESSOR WHERE ID = ?");
		stmt.setInt(1, professorId);
		return stmt.executeUpdate();
	}

	public static int updateProfessorName(int professorId, String newName, Connection connection) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("UPDATE PROFESSOR SET NAME = ? WHERE ID = ?");
		stmt.setString(1, newName);
		stmt.setInt(2, professorId);
		return stmt.executeUpdate();
	}

	public static int updateProfessorLastname(int professorId, String newLastname, Connection connection)
			throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("UPDATE PROFESSOR SET LASTNAME = ? WHERE ID = ?");
		stmt.setString(1, newLastname);
		stmt.setInt(2, professorId);
		return stmt.executeUpdate();
	}

	public static List<Professor> findByName(String professorLastname, Connection connection) throws SQLException {
		String sql = "SELECT * FROM PROFESSOR WHERE LASTNAME LIKE '%" + professorLastname + "%' ORDER BY LASTNAME";
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		List<Professor> list = new ArrayList<Professor>();
		Professor professor = null;
		while (rs.next()) {
			professor = new Professor(rs.getInt(1), rs.getString(2), rs.getString(3));
			list.add(professor);
		}
		return list;
	}

	public static Professor findProfessorByCourse(int courseId, Connection connection) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM COURSE WHERE ID = ?");
		stmt.setInt(1, courseId);
		ResultSet rs = stmt.executeQuery();
		Professor professor = null;
		if (rs.next()) {
			professor = new Professor(rs.getInt(1), rs.getString(2), rs.getString(3));
		}
		return professor;
	}

}
