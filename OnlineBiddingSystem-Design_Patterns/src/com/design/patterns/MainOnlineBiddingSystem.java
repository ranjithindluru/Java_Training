package com.design.patterns;

import java.util.List;
import java.util.Scanner;

public class MainOnlineBiddingSystem {

	// Declare the Static private variables of the application
	private static User currentUser;
	private static UserManagementService userManagementService;
	private static ItemManagementService itemManagementService;

	/**
	 * Execution starts with the main method.
	 * 
	 * Initializes the user management service, item management service, and
	 * notification service. Displays the initial menu to the user.
	 * 
	 * @param args The command-line arguments.
	 */
	public static void main(String[] args) {
		userManagementService = new UserManagementService();
		itemManagementService = new ItemManagementService();
		showInitialMenu();
	}

	/**
	 * Displays the initial menu to the user. Handles the user's choice and calls
	 * the corresponding methods.
	 */
	private static void showInitialMenu() {
		System.out.println();
		System.out.println("Welcome to the Online Bidding System!");
		System.out.println("1. Login");
		System.out.println("2. Create Account");
		System.out.println("3. Exit");
		System.out.print("Choose an option: ");

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int option = scanner.nextInt();

		switch (option) {
		case 1:
			loginUser();
			break;
		case 2:
			createUserAccount();
			break;

		case 3:
			System.out.println("Goodbye! Thankyou for using OnlineBiddingStstem, Visit again");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid option. Please try again.");
			showInitialMenu();
			break;
		}
	}

	/**
	 * Login the Register user to the inputs If current user not equals to null show
	 * the Main menu, or else print the invalid username or password
	 */
	private static void loginUser() {
		System.out.print("Enter your username: ");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String username = scanner.nextLine();

		System.out.print("Enter your password: ");
		String password = scanner.nextLine();
		System.out.println();

		currentUser = userManagementService.authenticateUser(username, password);
		if (currentUser != null) {
			showMainMenu();
		} else {
			System.out.println("Invalid username or password. Please try again.");
			showInitialMenu();
		}
	}

	/**
	 * . Creates a new user account using the UserManagementService. Displays a
	 * success message and shows the initial menu.
	 */
	private static void createUserAccount() {
		System.out.print("Enter a username: ");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String username = scanner.nextLine();

		System.out.print("Enter a password: ");
		String password = scanner.nextLine();

		userManagementService.createUser(username, password);
		System.out.println("Account created successfully. Please login.");
		System.out.println();
		showInitialMenu();
	}

	private static void showMainMenu() {
		Scanner scanner = new Scanner(System.in);

		int option;
		do {
			System.out.println();
			System.out.println("Welcome to the Online Bidding System!");
			System.out.println("1. Search Items");
			System.out.println("2. View Bidding History");
			System.out.println("3. Logout");
			System.out.println();
			System.out.print("Choose an option: ");
			option = scanner.nextInt();
			scanner.nextLine();

			switch (option) {
			case 1:
				/**
				 * Search the item with search keyword to display the available
				 * items in the items list 
				 */
				System.out.print("Enter a search keyword: ");
				String keyword = scanner.nextLine();
				List<Item> searchResults = itemManagementService.searchItems(keyword);
				/**If items is not there for given the  search keyword to display the 
				 * no items found
				 */
				if (searchResults.isEmpty()) {
					System.out.println("No items found.");
				} else {
					System.out.println("Search results:");
					for (Item item : searchResults) {
						System.out.println(item.getName() + " - " + item.getDescription() + " - Current highest bid: "
								+ item.getCurrentHighestBid());
					}
				}

				/**
				 * Bidding is an offer to set a price tag by an individual or business for a
				 * product or service or a demand that something be done
				 * 
				 * The best bid is the highest amount of money someone is willing to pay to
				 * acquire that security.
				 */

				// Place a bid
				System.out.println();
				System.out.print("Enter an item name to place a bid, or '0' to go back: ");
				String itemName = scanner.nextLine();
				if (!itemName.equals("0")) {
					Item selected = itemManagementService.getItemByName(itemName);
					if (selected != null) {
						System.out.print("Enter a bid amount: ");
						System.out.println();
						double bidAmount = scanner.nextDouble();
						Bid bid = new Bid(selected, currentUser, bidAmount);
						currentUser.addBid(bid);

						scanner.nextLine();
						System.out.println("1. Incremental Bidding");
						System.out.println("2. Automatic Bidding");
						System.out.print("Choose a bidding strategy: ");
						int strategyChoice = scanner.nextInt();
						scanner.nextLine();
						BiddingStrategy biddingStrategy;
						if (strategyChoice == 1) {
							biddingStrategy = new IncrementalBiddingStrategy();

						} else if (strategyChoice == 2) {
							biddingStrategy = new AutomaticBiddingStrategy();
						} else {
							System.out.println("Invalid strategy choice. Skipping bidding.");
							continue;
						}
						double placedBid = biddingStrategy.bid(selected, currentUser, bidAmount);
						System.out.println("bid amount: " + placedBid);
					} else {
						System.out.println("Item not found.");
					}
				}
				break;
			case 2:
				// View bidding history
				List<Bid> biddingHistory1 = currentUser.getBiddingHistory();
				System.out.println("Your bidding history:");
				if (biddingHistory1.isEmpty()) {
					System.out.println("No bidding history found.");
				} else {
					for (Bid bid : biddingHistory1) {
						System.out.println(bid.getItem().getName() + " - " + bid.getItem().getDescription()
								+ " - Bid amount: " + bid.getAmount() + " - Winning bid: " + bid.isWinningBid());
					}
				}
				break;
			case 3:
				// Logout
				System.out.println("Logout Successfully...");
				showInitialMenu();
				break;
			default:
				System.out.println("Invalid option. Please choose a valid option.");
			}
		} while (option != 3);

	}

}

