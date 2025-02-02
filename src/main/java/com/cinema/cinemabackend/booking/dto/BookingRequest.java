package com.cinema.cinemabackend.booking.dto;

public class BookingRequest {
    private int tickets;
    private String showTime; 

    public int getTickets() { return tickets; }
    public String getShowTime() { return showTime; }

    public void setTickets(int tickets) { this.tickets = tickets; }
    public void setShowTime(String showTime) { this.showTime = showTime; }
}