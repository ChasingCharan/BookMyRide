package com.example.BookMyRide.service;

import com.example.BookMyRide.dto.response.CustomerResponse;
import com.example.BookMyRide.dto.response.DriverResponse;
import com.example.BookMyRide.dto.response.RideResponse;
import com.example.BookMyRide.exception.CustomersNotFoundException;
import com.example.BookMyRide.exception.DriversNotFoundException;
import com.example.BookMyRide.model.Customer;
import com.example.BookMyRide.model.Driver;
import com.example.BookMyRide.model.Ride;
import com.example.BookMyRide.repository.CustomerRepository;
import com.example.BookMyRide.repository.DriverRepository;
import com.example.BookMyRide.repository.RideRepository;
import com.example.BookMyRide.transformer.RideTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class RideService {
    @Autowired
    RideRepository rideRepository;
    @Autowired
    DriverRepository driverRepository;
    @Autowired
    CustomerRepository customerRepository;

    public RideResponse allocateDriver() {

        List<Customer> customers = customerRepository.findAll();
        if(customers.isEmpty()){
            throw new CustomersNotFoundException("Seems Like On Customers in the list.");
        }

        Random random = new Random();
        Customer customer = customers.get(random.nextInt(customers.size()));

        List<Driver> availableDrivers = driverRepository.findAllByAvailableTrue();
        Driver nearestDriver = null;
        double minDistance = Double.MAX_VALUE;

        for (Driver driver : availableDrivers) {
            double distance = calculateDistance(
                    customer.getLatitude(), customer.getLongitude(),
                    driver.getLatitude(), driver.getLongitude()
            );

            if (distance < minDistance) {
                minDistance = distance;
                nearestDriver = driver;
            }
        }

        if (nearestDriver == null) {
            throw new DriversNotFoundException("Seems like all drivers are busy");
        }


        Ride ride = new Ride();
        ride.setCustomer(customer);
        ride.setDriver(nearestDriver);


        nearestDriver.setAvailable(false);
        driverRepository.save(nearestDriver);
        rideRepository.save(ride);

        return RideTransformer.rideToRideResponse(ride);

    }

    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double latDiff = Math.toRadians(lat2 - lat1);
        double lonDiff = Math.toRadians(lon2 - lon1);

        double x = latDiff * Math.cos(Math.toRadians(lat1));
        double y = lonDiff;

        return Math.sqrt(x * x + y * y) * 6371;
    }
}
