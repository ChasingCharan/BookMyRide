package com.example.BookMyRide.dto.response;

import com.example.BookMyRide.model.Customer;
import com.example.BookMyRide.model.Driver;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class DriverResponse {
    String name;
    long mobileNo;

}
