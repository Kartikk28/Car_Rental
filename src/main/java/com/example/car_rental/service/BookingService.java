package com.example.car_rental.service;



import com.example.car_rental.model.Booking;
import com.example.car_rental.model.Car;
import com.example.car_rental.model.CarStatus;
import com.example.car_rental.repository.BookingRepository;
import com.example.car_rental.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CarRepository carRepository;

    // Book a car
    public Booking createBooking(Booking booking) {
        Optional<Car> car = carRepository.findById(booking.getCar().getId());
        if (car.isPresent() && car.get().getStatus() == CarStatus.AVAILABLE) {
            car.get().setStatus(CarStatus.RENTED);
            carRepository.save(car.get());  // Update car status to RENTED
            return bookingRepository.save(booking);
        }
        throw new RuntimeException("Car is not available for booking");
    }

    // Get all bookings
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}

