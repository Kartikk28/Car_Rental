package com.example.car_rental.repository;

import com.example.car_rental.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findByUserId(int userId); // Get bookings by user
    List<Booking> findByCarId(int carId); // Get bookings for a specific car
}
