package com.cinema.cinemabackend.booking.model;

import java.time.LocalDateTime;

import com.cinema.cinemabackend.auth.model.User;
import com.cinema.cinemabackend.movies.model.Cinema;
import com.cinema.cinemabackend.movies.model.Movie;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; 

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @Column(nullable = false)
    private int numberOfTickets;

    @Column(nullable = false)
    private double totalPrice;

    @Column(nullable = false)
    private LocalDateTime bookingTime;
    
    @Column(nullable = false)
    private String showTime;

    public Booking() {}

    public Booking(User user, Movie movie, int numberOfTickets, double totalPrice, LocalDateTime bookingTime) {
        this.user = user;
        this.movie = movie;
        this.numberOfTickets = numberOfTickets;
        this.totalPrice = totalPrice;
        this.bookingTime = bookingTime;
    }
    
   

    public Long getId() { return id; }
    public User getUser() { return user; }
    public Movie getMovie() { return movie; }
    public int getNumberOfTickets() { return numberOfTickets; }
    public double getTotalPrice() { return totalPrice; }
    public LocalDateTime getBookingTime() { return bookingTime; }

    public void setId(Long id) { this.id = id; }
    public void setUser(User user) { this.user = user; } 
    public void setMovie(Movie movie) { this.movie = movie; }
    public void setNumberOfTickets(int numberOfTickets) { this.numberOfTickets = numberOfTickets; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }
    public void setBookingTime(LocalDateTime bookingTime) { this.bookingTime = bookingTime; }
    public String getShowTime() { return showTime; }
    public void setShowTime(String showTime) { this.showTime = showTime; }
}
