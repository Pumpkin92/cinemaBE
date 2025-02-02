package com.cinema.cinemabackend.movies.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private String language;

    @Column(nullable = false)
    private LocalDate showDate; 

    @Column(nullable = false)
    private String showTimes; 

    @Column(nullable = false)
    private double price;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "movies")
    private Set<Cinema> cinemas = new HashSet<>();

    public Movie() {}

    public Movie(String title, String genre, String language, LocalDate showDate, String showTimes, double price) {
       
    	this.title = title;
        this.genre = genre;
        this.language = language;
        this.showDate = showDate;
        this.showTimes = showTimes;
        this.price = price;
    }


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getLanguage() {
        return language;
    }

    public LocalDate getShowDate() {
        return showDate;
    }

    public String getShowTimes() {
        return showTimes;
    }

    public double getPrice() {
        return price;
    }
    
    public Set<Cinema> getCinemas() {
        return cinemas;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
    }

    public void setShowTimes(String showTimes) {
        this.showTimes = showTimes;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public void setCinemas(Set<Cinema> cinemas) {
        this.cinemas = cinemas;
    }

    
    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", language='" + language + '\'' +
                ", showDate=" + showDate +
                ", showTimes='" + showTimes + '\'' +
                ", price=" + price +
                '}';
    }
}
