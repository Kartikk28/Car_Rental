package com.example.car_rental.service;


import com.example.car_rental.model.Car;
import com.example.car_rental.model.CarStatus;
import com.example.car_rental.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    // Get all cars
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    // Get a specific car by ID
    public Optional<Car> getCarById(int carId) {
        return carRepository.findById(carId);
    }

    // Add a new car to the system
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    // Update the status of a car (e.g., mark as RENTED)
    public void updateCarStatus(int carId, CarStatus status) {
        Optional<Car> car = carRepository.findById(carId);
        car.ifPresent(c -> {
            c.setStatus(status);
            carRepository.save(c);
        });
    }

    // Get all available cars
    public List<Car> getAvailableCars() {
        return carRepository.findByStatus(CarStatus.AVAILABLE);
    }

    public Car updateCar(int id, Car carDetails) {
        // Find the car by ID, or throw an error if not found
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found with ID: " + id));

        // Update the car details
        car.setBrand(carDetails.getBrand());
        car.setModel(carDetails.getModel());
        car.setYear(carDetails.getYear());
        car.setPricePerDay(carDetails.getPricePerDay());
        car.setStatus(carDetails.getStatus());

        // Save the updated car back to the database
        return carRepository.save(car);
    }
    public void deleteCar(int id) {
        carRepository.deleteById(id);
    }
}
