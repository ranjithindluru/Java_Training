package com.atmAccounts;

import java.util.HashMap;
import java.util.Map;

class ATM {
	private Map<Integer, Integer> accounts;
	private double balance;

	public ATM() {
		accounts = new HashMap<>();
		balance = 0;
	}

	public void createAccount(int accountNumber, int pin) {
		accounts.put(accountNumber, pin);
	}

	public boolean login(int accountNumber, int pin) {
		Integer storedPIN = accounts.get(accountNumber);
		return storedPIN != null && storedPIN == pin;
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
