package com.example.BookMyRide.dto.response;

import com.example.BookMyRide.Enum.Gender;
import com.example.BookMyRide.model.Customer;
import com.example.BookMyRide.model.Driver;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class CustomerResponse {
    String name;
    int age;
    String email;
    Gender gender;
}
