package com.cinema.cinemabackend.config;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cinema.cinemabackend.auth.model.User;
import com.cinema.cinemabackend.auth.repo.UserRepo;
import com.cinema.cinemabackend.movies.model.Cinema;
import com.cinema.cinemabackend.movies.model.Movie;
import com.cinema.cinemabackend.movies.repo.CinemaRepository;
import com.cinema.cinemabackend.movies.repo.MovieRepository;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(MovieRepository movieRepository, CinemaRepository cinemaRepository) {
        return args -> {
            
            Movie movie1 = new Movie("Inception", "Sci-Fi", "English", LocalDate.of(2025, 2, 10), "10:00 AM, 2:00 PM, 6:00 PM", 12.00);
            Movie movie2 = new Movie("The Matrix", "Action", "English", LocalDate.of(2025, 2, 12), "1:00 PM, 5:00 PM, 9:00 PM", 10.00);
            Movie movie3 = new Movie("Interstellar", "Sci-Fi", "English", LocalDate.of(2025, 3, 5), "12:00 PM, 4:00 PM, 8:00 PM", 15.00);

            movieRepository.save(movie1);
            movieRepository.save(movie2);
            movieRepository.save(movie3);

           
            Cinema cinema1 = new Cinema("Cineworld Manchester", "Deansgate");
            Cinema cinema2 = new Cinema("Odeon Trafford Centre", "Trafford Centre");

        
            cinema1.setMovies(Set.of(movie1, movie2));
            cinema2.setMovies(Set.of(movie2, movie3));

            cinemaRepository.save(cinema1);
            cinemaRepository.save(cinema2);

            System.out.println("Sample movies added");
        };
    }
    
    @Bean
    CommandLineRunner initDatabase2(UserRepo userRepository) {
    	return args -> {
            if (userRepository.count() == 0) { 
                userRepository.save(new User("admin", "admin123", "ADMIN"));
                userRepository.save(new User("john_doe", "password", "USER"));
                userRepository.save(new User("jane_smith", "password", "USER"));

                System.out.println("sample users added");
            } 
        };
    }
    
}
