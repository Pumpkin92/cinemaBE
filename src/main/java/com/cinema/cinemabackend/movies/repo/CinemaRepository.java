package com.cinema.cinemabackend.movies.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.cinemabackend.movies.model.Cinema;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {
	List<Cinema> findByLocation(String location);

}
