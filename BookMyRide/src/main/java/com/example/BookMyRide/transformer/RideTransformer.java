package com.example.BookMyRide.transformer;

import com.example.BookMyRide.Enum.RideStatus;
import com.example.BookMyRide.dto.response.RideResponse;
import com.example.BookMyRide.model.Ride;


public class RideTransformer {
    public static RideResponse rideToRideResponse(Ride ride) {
        return RideResponse.builder()
                .customerResponse(CustomerTransformer.customerToCustomerResponse(ride.getCustomer()))
                .driverResponse(DriverTransformer.drivertoDriverResponse(ride.getDriver()))
                .status(RideStatus.COMPLETED)
                .build();
    }
}
