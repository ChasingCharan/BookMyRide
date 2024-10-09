package com.example.BookMyRide.dto.response;

import com.example.BookMyRide.Enum.RideStatus;
import com.example.BookMyRide.model.Customer;
import com.example.BookMyRide.model.Driver;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class RideResponse {
    CustomerResponse customerResponse;
    DriverResponse driverResponse;
    RideStatus status;
}
