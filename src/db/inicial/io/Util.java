package db.inicial.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Util {

	public static int MIN_LENGTH = 5;
	public static int MAX_LENGTH = 25;

	public static List<String> lecturaArchivo(String absolutePath) {

		List<String> lines = new ArrayList<String>();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutePath))) {
			String line = bufferedReader.readLine();
			while (line != null) {
				lines.add(line);
				line = bufferedReader.readLine();
			}
		} catch (FileNotFoundException e) {
			// Exception handling
		} catch (IOException e) {
			// Exception handling
		}

		return lines;
	}

	public static String validarlongitud(Scanner sc, String message) {
		while (message.length() < MIN_LENGTH || message.length() > MAX_LENGTH) {
			System.out.println("Lenght not valid");
			System.out.println("Please enter between 20 and 30 characters");
			message = sc.next();
		}
		return message;
	}

}
