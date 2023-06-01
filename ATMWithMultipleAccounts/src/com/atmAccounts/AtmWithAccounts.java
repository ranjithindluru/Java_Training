package com.atmAccounts;

import java.util.Scanner;

public class AtmWithAccounts {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ATM atm = new ATM();
		int choice;

		do {
			System.out.println("Welcome to the ATM");
			System.out.println("1. Create New Account");
			System.out.println("2. Log In");
			System.out.println("3. Exit");
			System.out.print("Choose an option: ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter account number: ");
				int accountNumber = scanner.nextInt();
				System.out.print("Enter a PIN: ");
				int pin = scanner.nextInt();
				atm.createAccount(accountNumber, pin);
				System.out.println("Account created successfully!");
				break;
			case 2:
				System.out.print("Enter your account number: ");
				int loginAccountNumber = scanner.nextInt();
				System.out.print("Enter your PIN: ");
				int loginPIN = scanner.nextInt();
				if (atm.login(loginAccountNumber, loginPIN)) {
					performAccountOperations(scanner, atm);
				} else {
					System.out.println("Invalid accountNumber or PIN. Please try again.");
				}
				break;
			case 3:
				System.out.println("Goodbye!");
				break;
			default:
				System.out.println("Invalid option. Please try again.");
			}

			System.out.println();

		} while (choice != 3);

		scanner.close();
	}

	public static void performAccountOperations(Scanner scanner, ATM atm) {
		int choice;

		do {
			System.out.println("Account Operations");
			System.out.println("1. Check Balance");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Log Out");
			System.out.print("Choose an option: ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Current balance: Rs" + atm.checkBalance());
				break;
			case 2:
				System.out.print("Enter deposit amount: Rs");
				double depositAmount = scanner.nextDouble();
				atm.deposit(depositAmount);
				break;
			case 3:
				System.out.print("Enter withdrawal amount: Rs");
				double withdrawalAmount = scanner.nextDouble();
				atm.withdraw(withdrawalAmount);
				break;
			case 4:
				System.out.println("Logged out successfully.");
				break;
			default:
				System.out.println("Invalid option. Please try again.");
			}

			System.out.println();

		} while (choice != 4);
	}

}
