package com.atmAccounts;

class ATM {

	private int[][] accounts;
	private double balance;

	public ATM() {
		accounts = new int[20][10];
		balance = 0;
	}

	public void createAccount(int accountNumber, int pin) {
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i][0] == 0) {
				accounts[i][0] = accountNumber;
				accounts[i][1] = pin;
				return;
			}
		}
	}

	public boolean login(int accountNumber, int pin) {
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i][0] == accountNumber && accounts[i][1] == pin) {
				return true;
			}
		}
		return false;
	}

	public double checkBalance() {
		return balance;
	}

	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			System.out.println("Deposit successful!");
		} else {
			System.out.println("Invalid deposit amount.");
		}
	}

	public void withdraw(double amount) {
		if (amount > balance) {
			System.out.println("Insufficient balance.");
		} else if (amount <= 0) {
			System.out.println("Invalid withdrawal amount.");
		} else {
			balance -= amount;
			System.out.println("Withdrawal successful!");
		}
	}
}
