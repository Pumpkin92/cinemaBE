package com.cinema.cinemabackend.booking.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.cinemabackend.booking.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUserId(Long userId);
}
