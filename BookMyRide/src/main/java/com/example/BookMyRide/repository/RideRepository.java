package com.example.BookMyRide.repository;

import com.example.BookMyRide.model.Driver;
import com.example.BookMyRide.model.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository extends JpaRepository<Ride,Integer> {
}
