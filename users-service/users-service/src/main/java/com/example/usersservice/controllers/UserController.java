package com.example.usersservice.controllers;

import com.example.usersservice.models.User;
import com.example.usersservice.repositories.UserRepository;
import com.example.usersservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/all-users")
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @PostMapping("/login")
    public ResponseEntity<User> getGuestByEmail(@Validated @RequestBody User user) {
        User guest = userService.findByLoginAndPassword(user.getEmail(), user.getPassword());
        userRepository.save( guest );
        return ResponseEntity.ok().body(guest);
    }

    @PostMapping("/sign-up")
    public User signUp(@Validated @RequestBody User guest) {
        return userRepository.save(guest);
    }

}
