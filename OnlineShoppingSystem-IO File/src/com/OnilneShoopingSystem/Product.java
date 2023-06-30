package com.OnilneShoopingSystem;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String description;
	private double price;
	private int quantity;

	public Product(String name, String description, double price, int quantity) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	/**
	 * setter and getters of the required fields
	 * 
	 * @return fields
	 */
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * checks if two `Product` objects are equal based on their names.
	 * 
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Product otherProduct = (Product) obj;
		return Objects.equals(name, otherProduct.name);
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", description=" + description + ", price=" + price + ", quantity=" + quantity
				+ "]";
	}

}
