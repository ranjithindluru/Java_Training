package com.OnilneShoopingSystem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class ProductCatalog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HashMap<String, Product> products;

	public ProductCatalog() {
		products = new HashMap<>();
	}

	/**
	 * add product based on its name.
	 * 
	 * @param product
	 */
	public void addProduct(Product product) {
		products.put(product.getName(), product);
	}

	/**
	 * remove product based on its name.
	 * 
	 * @param product
	 */
	public void removeProduct(Product product) {
		products.remove(product.getName());
	}

	/**
	 * returns a Product object based on its name.
	 * 
	 * @param name
	 * @return get the name
	 */
	public Product getProduct(String name) {
		return products.get(name);
	}

	/**
	 * display the Products based on product object.
	 * 
	 */
	public void displayProducts() {
		for (Product product : products.values()) {
			System.out.println(product);
		}
	}

	/**
	 * loads the products from a file using serialization.
	 * 
	 * @param fileName
	 */
	@SuppressWarnings("unchecked")
	public void loadProducts(String fileName) {
		try {
			FileInputStream fileIn = new FileInputStream(fileName);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			products = (HashMap<String, Product>) objectIn.readObject();
			objectIn.close();
			fileIn.close();
			System.out.println("Product catalog loaded successfully.");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error loading product catalog: " + e.getMessage());
		}
	}

	/**
	 * saves the products to a file using serialization.
	 * 
	 * @param fileName
	 */
	public void saveProducts(String fileName) {
		try {
			FileOutputStream fileOut = new FileOutputStream(fileName);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(products);
			objectOut.close();
			fileOut.close();
			System.out.println("Product catalog saved successfully.");
		} catch (IOException e) {
			System.out.println("Error saving product catalog: " + e.getMessage());
		}
	}

}
