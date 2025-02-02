package com.cinema.cinemabackend.auth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.cinemabackend.auth.model.User;
import com.cinema.cinemabackend.auth.repo.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    
	public User register(User user) {
        if (user.getUsername() == null || user.getPassword() == null || user.getRole() == null) {
            throw new IllegalArgumentException("Username, password, and role must be provided");
        }
        user.setRole(user.getRole().toUpperCase()); 
        return userRepo.save(user);
    }

    public User login(String username, String password) {
        Optional<User> userOptional = userRepo.findByUsername(username)
                .filter(user -> user.getPassword().equals(password));

        if (userOptional.isPresent()) {
            return userOptional.get(); 
        } else {
            throw new RuntimeException("Invalid username or password");
        }
    }
}
