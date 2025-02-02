package com.cinema.cinemabackend.booking.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.cinemabackend.auth.model.User;
import com.cinema.cinemabackend.auth.repo.UserRepo;
import com.cinema.cinemabackend.booking.model.Booking;
import com.cinema.cinemabackend.booking.repo.BookingRepository;
import com.cinema.cinemabackend.movies.model.Cinema;
import com.cinema.cinemabackend.movies.model.Movie;
import com.cinema.cinemabackend.movies.repo.CinemaRepository;
import com.cinema.cinemabackend.movies.repo.MovieRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private MovieRepository movieRepository;
  
    public Booking createBooking(Long userId, Long movieId, int tickets, String showTime) {
       
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        Booking booking = new Booking(user, movie, tickets, movie.getPrice() * tickets, LocalDateTime.now());
        booking.setShowTime(showTime);
     
        return bookingRepository.save(booking);
    }
    
    public List<Booking> getBookingsByUser(Long userId) {
        return bookingRepository.findByUserId(userId);
    }
    
    public void cancelBooking(Long bookingId) {
        if (!bookingRepository.existsById(bookingId)) {
            throw new RuntimeException("Booking not found");
        }
        bookingRepository.deleteById(bookingId);
    }
}