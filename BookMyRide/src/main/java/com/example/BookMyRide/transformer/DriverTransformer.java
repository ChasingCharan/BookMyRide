package com.example.BookMyRide.transformer;

import com.example.BookMyRide.dto.response.DriverResponse;
import com.example.BookMyRide.model.Driver;


public class DriverTransformer {
    public static DriverResponse drivertoDriverResponse(Driver driver) {
        return DriverResponse.builder()
                .name(driver.getName())
                .mobileNo(driver.getMobileNo())
                .build();

    }
}
