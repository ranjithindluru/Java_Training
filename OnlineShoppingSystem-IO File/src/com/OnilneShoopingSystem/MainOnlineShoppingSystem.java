package com.OnilneShoopingSystem;

import java.io.IOException;
import java.util.Scanner;

public class MainOnlineShoppingSystem {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Scanner scanner = new Scanner(System.in);
		ProductCatalog productCatalog = new ProductCatalog();
		ShoppingCart shoppingCart = new ShoppingCart();
		OrderHistory orderHistory = new OrderHistory();

		System.out.println("Welcome to the Online Shopping System!");

		boolean exit = false;
		while (!exit) {
			System.out.println(" ");
			System.out.println("1. Create a new product file");
			System.out.println("2. Load an existing product file");
			System.out.println("3. Show products");
			System.out.println("4. Add product");
			System.out.println("5. Save product to the shopping cart");
			System.out.println("6. Remove a product from the shopping cart");
			System.out.println("7. View shopping cart");
			System.out.println("8. Place an order");
			System.out.println("9. Exit");
			System.out.println(" ");
			System.out.print("Enter your choice: ");
			System.out.println(" ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				System.out.print("Enter the file name to save the product file: ");
				String productFileName = scanner.nextLine();
				productCatalog.saveProducts(productFileName);

				System.out.print("Enter the file name to save the order history: ");
				String orderFileName = scanner.nextLine();
				orderHistory.saveOrderHistory(orderFileName);

				System.out.println("Product file and order history saved successfully.");
				break;
			case 2:
				System.out.print("Enter the file name to load the product file: ");
				String productFileName1 = scanner.nextLine();
				productCatalog.loadProducts(productFileName1);

				System.out.print("Enter the file name to load the order history: ");
				String orderFileName1 = scanner.nextLine();
				orderHistory.loadOrderHistory(orderFileName1);

				System.out.println("Product file and order history loaded successfully.");
				break;
			case 3:
				System.out.println("Available Products:");
				productCatalog.displayProducts();
				break;
			case 4:
				System.out.print("Enter the product name: ");
				String name = scanner.nextLine();
				System.out.print("Enter the product description: ");
				String description = scanner.nextLine();
				System.out.print("Enter the product price: ");
				double price = scanner.nextDouble();
				System.out.print("Enter the product quantity: ");
				int quantity = scanner.nextInt();

				Product product = new Product(name, description, price, quantity);
				productCatalog.addProduct(product);
				System.out.println("Product added successfully.");
				break;
			case 5:
				System.out.print("Enter the name of the product to add: ");
				String productName = scanner.next();
				Product product1 = productCatalog.getProduct(productName);

				if (product1 != null) {
					System.out.print("Enter the quantity: ");
					int quantity1 = scanner.nextInt();
					shoppingCart.addItem(product1, quantity1);
					System.out.println("Product added to the shopping cart.");
				} else {
					System.out.println("Product not found.");
				}
				break;
			case 6:
				System.out.print("Enter the name of the product to remove: ");
				String productName1 = scanner.nextLine();
				Product products = productCatalog.getProduct(productName1);

				if (products != null) {
					shoppingCart.removeItem(products);
					System.out.println("Product removed from the shopping cart.");
				} else {
					System.out.println("Product not found.");
				}
				break;

			case 7:
				System.out.println("Shopping Cart:");
				shoppingCart.displayCart();
				System.out.println("Total Price: $" + shoppingCart.getTotalPrice());
				break;
			case 8:
				System.out.println("Placing an order...");

				if (shoppingCart.isEmpty()) {
					System.out.println("Shopping cart is empty. Cannot place an order.");
				} else {
					Order order = new Order(shoppingCart.getItems(), shoppingCart.getTotalPrice());
					orderHistory.addOrder(order);
					System.out.println("Order placed successfully.");
					System.out.println("Order Confirmation Number: " + order.getConfirmationNumber());
					System.out.println("Total Price: $" + order.getTotalPrice());

					shoppingCart.clearCart();
				}
				break;

			case 9:
				System.out.print("Enter the file name to save the product file: ");
				String productFileNames = scanner.nextLine();
				productCatalog.saveProducts(productFileNames);

				System.out.print("Enter the file name to save the order history: ");
				String orderFileNames = scanner.nextLine();
				orderHistory.saveOrderHistory(orderFileNames);

				System.out.println("Exiting the program. Thank you for using the Online Shopping System!");
				break;

			default:
				System.out.println("Invalid option. Please try again.");
			}

		}

	}

}
