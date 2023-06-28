package com.rgt.messaging.cli;

import java.util.Scanner;

public class RGTMain {

	public static void main(String[] args) {

		RGTMessaging rgtMessiging = new RGTMessaging();

		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome To RGTMessaging!");
		boolean exit = false;
		while (!exit) {
			System.out.println("");
			System.out.println("1. Register");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			System.out.println("");
			System.out.print("Enter your choice: ");
			System.out.println("");
			int choice = scanner.nextInt();
			
			switch(choice) {
			case 1:
				rgtMessiging.registerUser(scanner);
				break;
			case 2:
				rgtMessiging.login(scanner);
				break;
			case 3:
				exit = true;
			    System.out.println("Exit to RGTMessiging App...");
			break;
			
		 default:
             System.out.println("Invalid option. Please try again.");
		}

	}
		
	}
}
