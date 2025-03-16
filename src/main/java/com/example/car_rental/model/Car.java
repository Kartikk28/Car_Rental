package com.example.car_rental.model;



import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cars")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carId;

    private String brand;
    private String model;
    private int year;
    private double pricePerDay;

    @Enumerated(EnumType.STRING)
    private CarStatus status;
}
