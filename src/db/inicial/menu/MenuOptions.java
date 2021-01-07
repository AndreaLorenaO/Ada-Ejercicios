package db.inicial.menu;

import java.util.Scanner;

public class MenuOptions {

	public static int printMenuOptions(Scanner sc) {
		System.out.println();
		System.out.println("Menu");
		System.out.println("----");
		System.out.println("1.Course");
		System.out.println("2.Student");
		System.out.println("3.Professor");
		System.out.println("4.Registration");
		System.out.println("0.Exit");
		System.out.println("Please enter option: ");
		return sc.nextInt();
	}
}
