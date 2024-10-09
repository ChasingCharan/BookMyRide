package com.example.BookMyRide.transformer;

import com.example.BookMyRide.dto.response.CustomerResponse;
import com.example.BookMyRide.dto.response.RideResponse;
import com.example.BookMyRide.model.Customer;
import com.example.BookMyRide.model.Ride;


public class CustomerTransformer {

    public static CustomerResponse customerToCustomerResponse(Customer customer) {
        return CustomerResponse.builder()
                .name(customer.getName())
                .age(customer.getAge())
                .email(customer.getEmailId())
                .gender(customer.getGender())
                .build();
    }
}
