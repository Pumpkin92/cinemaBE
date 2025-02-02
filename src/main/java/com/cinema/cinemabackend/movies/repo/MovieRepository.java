package com.cinema.cinemabackend.movies.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.cinemabackend.movies.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	  List<Movie> findByGenre(String genre);
	    List<Movie> findByLanguage(String language);
}
