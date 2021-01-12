package db.inicial.io;

import java.util.List;

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

	public static void lecturaPrintParteMenu() {
		List<String> opcionesMenu = Util.lecturaArchivo("src/db/inicial/io/printPartMenu");
		opcionesMenu.forEach(System.out::println);
	}

	public static void lecturaPrintMenuRegistration() {
		List<String> opcionesMenu = Util.lecturaArchivo("src/db/inicial/io/printMenuRegistration");
		opcionesMenu.forEach(System.out::println);
	}

}
