package db.inicial.menu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class MenuProfessor {

	public static int printMenuProfessor(Scanner sc, Connection connection) throws SQLException {
		System.out.println();
		System.out.println("Professor menu");
		MenuOptions.printPartMenu();
		return sc.nextInt();
	}

}
