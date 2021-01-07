package db.inicial.menu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class MenuProfessor {

	public static int printMenuProfessor(Scanner sc, Connection connection) throws SQLException {
		System.out.println();
		System.out.println("Professor menu");
		System.out.println("--------------");
		System.out.println("1.Enrollment");
		System.out.println("2.List");
		System.out.println("3.Disenrollment");
		System.out.println("4.Update");
		System.out.println("5.Search professor");
		System.out.println("0.Exit");
		System.out.println();
		System.out.println("Please enter option:");
		return sc.nextInt();
	}

}
