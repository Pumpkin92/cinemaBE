package com.cinema.cinemabackend.movies.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.cinemabackend.movies.model.Cinema;
import com.cinema.cinemabackend.movies.repo.CinemaRepository;
import com.cinema.cinemabackend.movies.service.CinemaService;

@RestController
@RequestMapping("/cinemas")
public class CinemaController {
	
	@Autowired
	private CinemaService cinemaService;
	
	
	@PostMapping("/admin")
	public Cinema addCinema(@RequestBody Cinema cinema) {
		return cinemaService.addCinema(cinema);
	}
	
	@GetMapping
	public List<Cinema> getAllCinemas(){
		return cinemaService.getAllCinemas();
	}
	
	@GetMapping("/{id}")
	public Optional<Cinema> getCinemaById(@PathVariable Long id){
		return cinemaService.getCinemaById(id);
	}
	
	@DeleteMapping("/admin/{id}")
	public void deleteCinema(@PathVariable Long id) {
		cinemaService.deleteCinema(id);
	}
	
	@PutMapping("/admin/{id}")
	public Cinema updateCinema(@PathVariable Long id, @RequestBody Cinema cinemaDetails) {
		return cinemaService.updateCinema(id, cinemaDetails);
	}
	
	@PostMapping("/admin/{id}/movies")
    public Cinema assignMoviesToCinema(@PathVariable Long id, @RequestBody Set<Long> movieIds) {
        return cinemaService.assignMoviesToCinema(id, movieIds);
    }
	
	@GetMapping("/filter")
    public List<Cinema> filterCinemas(@RequestParam(required = false) String location) {
        if (location != null) {
            return cinemaService.filterCinemasByLocation(location);
        }
        return cinemaService.getAllCinemas();
    }

}
