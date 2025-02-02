package com.cinema.cinemabackend.movies.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cinema.cinemabackend.movies.model.Cinema;
import com.cinema.cinemabackend.movies.model.Movie;
import com.cinema.cinemabackend.movies.repo.CinemaRepository;
import com.cinema.cinemabackend.movies.repo.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private CinemaRepository cinemaRepository;

    public Movie addMovie(Movie movie, Long cinemaId) {
    	Cinema cinema = cinemaRepository.findById(cinemaId)
                .orElseThrow(() -> new RuntimeException("Cinema not found"));

    	movie = movieRepository.save(movie); 
        cinema.getMovies().add(movie); 
        cinemaRepository.save(cinema); 
        return movie;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public Movie updateMovie(Long id, Movie movieDetails) {
        return movieRepository.findById(id).map(movie -> {
            movie.setTitle(movieDetails.getTitle());
            movie.setGenre(movieDetails.getGenre());
            movie.setLanguage(movieDetails.getLanguage());
            movie.setShowDate(movieDetails.getShowDate()); 
            movie.setShowTimes(movieDetails.getShowTimes());
            movie.setPrice(movieDetails.getPrice());
            return movieRepository.save(movie);
        }).orElse(null);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
    
    public List<Movie> getMoviesByGenre(String genre) {
        return movieRepository.findByGenre(genre);
    }

    public List<Movie> getMoviesByLanguage(String language) {
        return movieRepository.findByLanguage(language);
    }
}
