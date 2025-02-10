package com.vantutran2k1.todoapp.api.controllers;

import com.vantutran2k1.todoapp.api.payloads.CreateUserRequest;
import com.vantutran2k1.todoapp.api.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid CreateUserRequest user) {
        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully");
    }
}
