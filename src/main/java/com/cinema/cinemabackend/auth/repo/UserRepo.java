package com.cinema.cinemabackend.auth.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.cinemabackend.auth.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
}
