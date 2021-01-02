package db.inicial.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.inicial.model.Curso;

public class CursoDAO {

	// Data Access Object

	public static void insert(Curso curso, Connection connection) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("INSERT INTO CURSO (NAME) VALUES (?)");
		stmt.setString(1, curso.getName());
		stmt.executeUpdate();
	}

	public static List<Curso> findAll(Connection connection) throws SQLException {
		List<Curso> listarCurso = new ArrayList<Curso>();
		String sql = "SELECT * FROM CURSO";
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			String nombreCurso = rs.getString(2);
			int idCurso = rs.getInt(1);
			Curso curso = new Curso(nombreCurso);
			curso.setId(idCurso);
			listarCurso.add(curso);
		}
		return listarCurso;
	}

	public static int delete(int idCurso, Connection connection) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("DELETE FROM CURSO WHERE ID = ?");
		stmt.setInt(1, idCurso);
		return stmt.executeUpdate();
	}

	public static int updateCurso(Curso curso, Connection connection) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("UPDATE CURSO SET NAME = ? WHERE ID = ?");
		stmt.setString(1, curso.getName());
		stmt.setInt(2, curso.getId());
		return stmt.executeUpdate();
	}

	public static List<Curso> findByName(String name, Connection connection) throws SQLException {
//		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM CURSO WHERE NAME LIKE ?%");
//		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM CURSO WHERE NAME = ?");
//		stmt.setString(1, name);

		String sql = "SELECT * FROM CURSO WHERE NAME LIKE '%" + name + "%' ORDER BY NAME";
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		List<Curso> lista = new ArrayList<Curso>();
		Curso curso = null;
		while (rs.next()) {
			curso = new Curso(rs.getInt(1), rs.getString(2));
			lista.add(curso);
		}
		return lista;
	}

	public static Curso findById(int id, Connection connection) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM CURSO WHERE ID = ?");
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		Curso curso = null;
		if (rs.next()) {
			curso = new Curso(rs.getInt(1), rs.getString(2));
		}
		return curso;
	}

}