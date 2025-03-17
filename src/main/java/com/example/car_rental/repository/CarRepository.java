package com.example.car_rental.repository;



import com.example.car_rental.model.Car;
import com.example.car_rental.model.CarStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findByStatus(CarStatus status);
}
