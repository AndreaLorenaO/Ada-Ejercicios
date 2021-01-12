package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Util {

	public static List<String> lecturaArchivo(String absolutePath) {

		List<String> lineas = new ArrayList<String>();
		// Read the content from file
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutePath))) {
			String line = bufferedReader.readLine();
			while (line != null) {
				lineas.add(line);
				line = bufferedReader.readLine();
			}
		} catch (FileNotFoundException e) {
			// Exception handling
		} catch (IOException e) {
			// Exception handling
		}

		return lineas;
	}

}