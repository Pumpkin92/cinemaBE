package com.cinema.cinemabackend.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.cinemabackend.booking.dto.BookingRequest;
import com.cinema.cinemabackend.booking.model.Booking;
import com.cinema.cinemabackend.booking.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/user/{userId}/movie/{movieId}")
    public Booking bookTicket(@PathVariable Long userId, @PathVariable Long movieId, @RequestBody BookingRequest bookingRequest) {
        return bookingService.createBooking(userId, movieId, bookingRequest.getTickets(), bookingRequest.getShowTime());
    }

   
    @GetMapping("/user/{userId}")
    public List<Booking> getBookingsByUser(@PathVariable Long userId) {
        return bookingService.getBookingsByUser(userId);
    }

    
    @DeleteMapping("/{bookingId}")
    public void cancelBooking(@PathVariable Long bookingId) {
        bookingService.cancelBooking(bookingId);
    }
}
