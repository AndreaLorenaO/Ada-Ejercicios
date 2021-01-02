package db.inicial.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdminDB {

	public static Connection obtenerConexion() throws ClassNotFoundException, SQLException {
//		public static Connection obtenerConexion(String driver) throws ClassNotFoundException, SQLException{
//		Class.forName(driver);

//		Connection con = null;
//		Class.forName("com.mysql.jdbc.Driver"); deprecated
//		return con;

//		Busca y carga la clase "Driver" en la memoria (dentro del archivo .jar) con la ruta que le pase
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cursos", "root", "");
	}

//	El profe tuvo un error con respecto a la zona horario
//	Se soluciona directamente en la url
//	"jdbs:mysql://127.0.0.1:3306/cursos?serverTimezone=UTC, "root", ""
}
