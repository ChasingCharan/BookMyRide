package com.example.BookMyRide.repository;

import com.example.BookMyRide.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver,Integer> {

    List<Driver> findAllByAvailableTrue();
}
