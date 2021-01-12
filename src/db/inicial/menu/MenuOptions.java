package db.inicial.menu;

import java.util.Scanner;

import db.inicial.io.IOBuffered;

public class MenuOptions {

	public static int printMenuOptions(Scanner sc) {
		System.out.println();
		IOBuffered.lecturaPrintMenu();
		return sc.nextInt();
	}

	public static void printPartMenu() {
		IOBuffered.lecturaPrintParteMenu();
	}
}
