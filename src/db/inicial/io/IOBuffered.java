package db.inicial.io;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import db.inicial.model.Registration;

public class IOBuffered {

	public static void lecturaPrintMenu() {

//		String directory = System.getProperty("user.home");
//		String fileName = "printMenu";
//		String absolutePath = directory + File.separator + fileName;

		List<String> opcionesMenu = Util.lecturaArchivo("src/db/inicial/io/printMenu");
		opcionesMenu.forEach(System.out::println);
//		String printMenu = opcionesMenu.get(3);
//		System.out.println(printMenu);

	}

	public static void lecturaPrintSubMenu() {
		List<String> opcionesMenu = Util.lecturaArchivo("src/db/inicial/io/printPartMenu");
		opcionesMenu.forEach(System.out::println);
	}

	public static void lecturaPrintMenuRegistration() {
		List<String> opcionesMenu = Util.lecturaArchivo("src/db/inicial/io/printMenuRegistration");
		opcionesMenu.forEach(System.out::println);
	}

	public static void prinRegistrationCard(Connection connection, Registration registration, Scanner sc) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(new Date());
		System.out.println("Do you wish to print the registration card?: Y/N?");
		String option = sc.next();
		if (option.toUpperCase().contentEquals("Y")) {
			Util.writingFile("src/db/inicial/io/logs/logs.txt", registration, date);
			System.out.println();
			List<String> lines = Util.lecturaArchivo("src/db/inicial/io/logs/logs.txt");
			lines.forEach(System.out::println);
		} else {
			System.out.println("Registration card not printed");
		}

	}

}
