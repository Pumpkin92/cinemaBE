package com.cinema.cinemabackend.movies.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.cinemabackend.movies.model.Cinema;
import com.cinema.cinemabackend.movies.model.Movie;
import com.cinema.cinemabackend.movies.repo.CinemaRepository;
import com.cinema.cinemabackend.movies.repo.MovieRepository;

@Service
public class CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;
    
    @Autowired
    private MovieRepository movieRepository;

    public Cinema addCinema(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }

    public List<Cinema> getAllCinemas() {
    	List<Cinema> cinemas = cinemaRepository.findAll();
        for (Cinema cinema : cinemas) {
            cinema.getMovies().size(); 
        }
        return cinemas;
    }

    public Optional<Cinema> getCinemaById(Long id) {
        return cinemaRepository.findById(id);
    }

    public Cinema updateCinema(Long id, Cinema cinemaDetails) {
        return cinemaRepository.findById(id).map(cinema -> {
            cinema.setName(cinemaDetails.getName());
            cinema.setLocation(cinemaDetails.getLocation());
            return cinemaRepository.save(cinema);
        }).orElse(null);
    }

    public void deleteCinema(Long id) {
        cinemaRepository.deleteById(id);
    }
    
    public Cinema assignMoviesToCinema(Long theatreId, Set<Long> movieIds) {
        Optional<Cinema> cinemaOpt = cinemaRepository.findById(theatreId);
        if (cinemaOpt.isPresent()) {
            Cinema cinema = cinemaOpt.get();
            Set<Movie> movies = movieRepository.findAllById(movieIds).stream().collect(java.util.stream.Collectors.toSet());
            cinema.setMovies(movies);
            return cinemaRepository.save(cinema);
        }
        return null;
    }
    
    public List<Cinema> filterCinemasByLocation(String location) {
        return cinemaRepository.findByLocation(location);
    }
}
