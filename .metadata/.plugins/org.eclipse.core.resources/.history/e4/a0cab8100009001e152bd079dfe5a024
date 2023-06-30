package com.vrs.oops;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RentalService implements RentalCostCalculator {
    private List<Vehicle> vehicles;
    private List<Rental> rentals;

    public RentalService() {
        vehicles = new ArrayList<>();
        rentals = new ArrayList<>();
    }
    
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }
    
    public List<Rental> getRentals() {
        return rentals;
    }

    // Display available vehicles
    public List<Vehicle> getAvailableVehicles() {
        List<Vehicle> availableVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.isAvailable()) {
                availableVehicles.add(vehicle);
            }
        }
        return availableVehicles;
    }

    // Rent a vehicle
    public Rental rentVehicle(Customer customer, Vehicle vehicle, LocalDateTime startTime, LocalDateTime endTime) {
        Rental rental = new Rental();
        rental.setCustomer(customer);
        rental.setRentedVehicle(vehicle);
        rental.setStartTime(startTime);
        rental.setEndTime(endTime);
        rentals.add(rental);
        vehicle.setAvailable(false);
        return rental;
    }

    // Calculate rental cost
    @Override
    public BigDecimal calculateRentalCost(Rental rental) {
        LocalDateTime startTime = rental.getStartTime();
        LocalDateTime endTime = rental.getEndTime();
        Duration duration = Duration.between(startTime, endTime);

        // Perform the calculation based on the duration
        long hours = duration.toHours();
        BigDecimal hourlyRate = BigDecimal.valueOf(10); // Assuming an hourly rate of Rs10

        BigDecimal rentalCost = hourlyRate.multiply(BigDecimal.valueOf(hours));

        // Return the calculated rental cost
        return rentalCost;
    }

    // Return a rented vehicle
    public boolean returnVehicle(Rental rental) {
        Vehicle rentedVehicle = rental.getRentedVehicle();
        if (rentedVehicle != null) {
            rentedVehicle.setAvailable(true);
            rentals.remove(rental);
            return true;
        }
        return false;
    }
}