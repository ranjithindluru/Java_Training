package com.vrs.oops;

public class Car extends Vehicle {

	// Constructor
	public Car() {
		this.setLicensePlate(licensePlate);
		this.setMake(make);
		this.setModel(model);
		this.setAvailable(true);
	}

	@Override
	public String toString() {
		return "Car [licensePlate=" + licensePlate + ", make=" + make + ", model=" + model + ", isAvailable()="
				+ isAvailable() + ", getLicensePlate()=" + getLicensePlate() + ", getMake()=" + getMake()
				+ ", getModel()=" + getModel() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
