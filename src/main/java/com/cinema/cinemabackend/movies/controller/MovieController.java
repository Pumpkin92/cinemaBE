package com.cinema.cinemabackend.movies.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.cinemabackend.movies.model.Movie;
import com.cinema.cinemabackend.movies.repo.MovieRepository;
import com.cinema.cinemabackend.movies.service.MovieService;

@CrossOrigin(origins = "http://localhost:4200") //update when on ec2
@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/admin")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie, @RequestParam Long cinemaId) {
        Movie savedMovie = movieService.addMovie(movie, cinemaId); 
        return ResponseEntity.ok(savedMovie); 
    }


    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Optional<Movie> getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    @PutMapping("/admin/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie movieDetails) {
        return movieService.updateMovie(id, movieDetails);
    }

    @DeleteMapping("/admin/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }
    
    @GetMapping("/filter")
    public List<Movie> filterMovies(@RequestParam(required = false) String genre,
                                    @RequestParam(required = false) String language) {
        if (genre != null) {
            return movieService.getMoviesByGenre(genre);
        } else if (language != null) {
            return movieService.getMoviesByLanguage(language);
        }
        return movieService.getAllMovies();
    }
}
