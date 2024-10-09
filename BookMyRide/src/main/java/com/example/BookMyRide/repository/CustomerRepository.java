package com.example.BookMyRide.repository;

import com.example.BookMyRide.model.Customer;
import com.example.BookMyRide.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
