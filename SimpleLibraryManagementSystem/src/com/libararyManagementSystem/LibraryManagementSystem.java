package com.libararyManagementSystem;

import java.util.Scanner;

public class LibraryManagementSystem {
    private static final int MAX_BOOKS = 20; // Maximum number of books that can be stored
    private static final int MAX_PATRONS = 20; 

    private static String[] books = new String[MAX_BOOKS]; // Array to store book titles
    private static String[] authors = new String[MAX_BOOKS]; 
    private static String[] patrons = new String[MAX_PATRONS];  
    private static boolean[] bookAvailability = new boolean[MAX_BOOKS]; 
    private static String[] borrowedBooksByPatrons = new String[MAX_PATRONS]; 

    private int bookCount = 0; // Number of books currently in the library
    private int patronCount = 0; 

 
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add Patron");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    addPatron(scanner);
                    break;
                case 3:
                    borrowBook(scanner);
                    break;
                case 4:
                    returnBook(scanner);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
    private void addBook(Scanner scanner) {
        if (bookCount >= MAX_BOOKS) {
            System.out.println("Maximum book limit reached.");
            return;
        }

        scanner.nextLine(); 
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter book author: ");
        String author = scanner.nextLine();

        // Check if the book already exists
        int existingBookIndex = findBookIndex(title);
        if (existingBookIndex != -1) {
            System.out.println("The book already exists in the library.");
            return;
        }

        books[bookCount] = title;
        authors[bookCount] = author;
        bookAvailability[bookCount] = true;
        bookCount++;

        System.out.println("Book added successfully.");
    }


    private void addPatron(Scanner scanner) {
        if (patronCount >= MAX_PATRONS) {
            System.out.println("Maximum patron limit reached.");
            return;
        }

        scanner.nextLine(); // Consume newline character
        System.out.print("Enter patron name: ");
        String name = scanner.nextLine();

        patrons[patronCount] = name;
        patronCount++;

        System.out.println("Patron added successfully.");
    }

    private void borrowBook(Scanner scanner) {
        if (bookCount == 0) {
            System.out.println("No books available in the library.");
            return;
        }

        scanner.nextLine(); 
        System.out.print("Enter patron name: ");
        String patronName = scanner.nextLine();

        int patronIndex = findPatronIndex(patronName);
        if (patronIndex == -1) {
            System.out.println("Patron not found.");
            return;
        }

        System.out.println("Books available for borrowing:");
        displayAvailableBooks();

        System.out.print("Enter the index of the book to borrow: ");
        int bookIndex = scanner.nextInt();

        if (bookIndex < 0 || bookIndex >= bookCount) {
            System.out.println("Invalid book index.");
            return;
        }

        if (!bookAvailability[bookIndex]) {
            System.out.println("Book is already borrowed.");
            return;
        }

        // Borrow the book
        bookAvailability[bookIndex] = false;
        borrowedBooksByPatrons[patronIndex] = books[bookIndex];

        System.out.println("Book borrowed successfully.");
    }

    private void returnBook(Scanner scanner) {
        if (bookCount == 0) {
            System.out.println("No books available in the library.");
            return;
        }

        scanner.nextLine(); 
        System.out.print("Enter patron name: ");
        String patronName = scanner.nextLine();
        
        System.out.print("Enter book title: ");
        @SuppressWarnings("unused")
		String title = scanner.nextLine();

        int patronIndex = findPatronIndex(patronName);
        if (patronIndex == -1) {
            System.out.println("Patron not found.");
            return;
        }

        String borrowedBook = borrowedBooksByPatrons[patronIndex];
        if (borrowedBook == null) {
            System.out.println("Patron has not borrowed any book.");
            return;
        }

        int bookIndex = findBookIndex(borrowedBook);
        if (bookIndex == -1) {
            System.out.println("Book not found.");
            return;
        }

        // Return the book
        bookAvailability[bookIndex] = true;
        borrowedBooksByPatrons[patronIndex] = null;

        System.out.println("Book returned successfully.");
    }

    private int findPatronIndex(String patronName) {
        for (int i = 0; i < patronCount; i++) {
            if (patrons[i].equalsIgnoreCase(patronName)) {
                return i;
            }
        }
        return -1;
    }

    private int findBookIndex(String bookTitle) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].equalsIgnoreCase(bookTitle)) {
                return i;
            }
        }
        return -1;
    }

    private void displayAvailableBooks() {
        for (int i = 0; i < bookCount; i++) {
            if (bookAvailability[i]) {
                System.out.println(i + ". " + books[i] + " by " + authors[i]);
            }
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();
        library.run();
    }
}


