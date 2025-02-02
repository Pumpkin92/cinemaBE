package com.cinema.cinemabackend.movies.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cinemas")
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;
    
 
    @ManyToMany
    @JoinTable(
        name = "cinema_movies",
        joinColumns = @JoinColumn(name = "cinema_id"),
        inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    
    @JsonIgnoreProperties("cinemas")
    private Set<Movie> movies = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public Set<Movie> getMovies() {
        return movies;
    }

	public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
	
	public void addMovie(Movie movie) {
        this.movies.add(movie);
    }

	public Cinema(Long id, String name, String location) {
	
		this.id = id;
		this.name = name;
		this.location = location;
	}
	
	public Cinema(String name, String location) {
        this.name = name;
        this.location = location;
    }

	public Cinema() {
	
	}

	@Override
	public String toString() {
		return "Cinema [id=" + id + ", name=" + name + ", location=" + location + "]";
	}
    
    
}
