package db.inicial.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import db.inicial.model.Registration;

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
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			// Exception handling
		} catch (IOException e) {
			// Exception handling
		}

		return lines;
	}

	public static void writingFile(String absolutePath, Registration registration, String date) {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(absolutePath))) {
			String fileContent = "Registration date: " + date + '\n' + "Registration #: "
					+ registration.getRegistrationId() + '\n' + "Student id: " + registration.getStudentId() + '\n'
					+ "Course id: " + registration.getCourseId() + '\n' + "Professor id: "
					+ registration.getProfessorId() + '\n' + "Commission: " + registration.getCommission() + '\n'
					+ "State: " + registration.getState();
			bufferedWriter.write(fileContent);
			bufferedWriter.newLine();
			bufferedWriter.close();
		} catch (IOException e) {
			// Exception handling
		}
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
