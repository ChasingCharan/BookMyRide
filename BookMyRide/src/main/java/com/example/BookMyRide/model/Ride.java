package com.example.BookMyRide.model;

import com.example.BookMyRide.Enum.RideStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn
    Customer customer;

    @ManyToOne
    @JoinColumn
    Driver driver;

    @Enumerated(EnumType.STRING)
    RideStatus status;
}
