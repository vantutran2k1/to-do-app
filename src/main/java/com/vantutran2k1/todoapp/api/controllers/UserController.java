package com.vantutran2k1.todoapp.api.controllers;

import com.vantutran2k1.todoapp.api.payloads.ApiResponse;
import com.vantutran2k1.todoapp.api.payloads.CreateUserRequest;
import com.vantutran2k1.todoapp.api.payloads.LoginUserRequest;
import com.vantutran2k1.todoapp.api.payloads.LoginUserResponse;
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
    public ResponseEntity<ApiResponse<String>> register(@RequestBody @Valid CreateUserRequest request) {
        userService.registerUser(request);
        return ResponseEntity.ok(new ApiResponse<>("User registered successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginUserResponse>> login(@RequestBody @Valid LoginUserRequest request) {
        return ResponseEntity.ok(new ApiResponse<>(userService.loginUser(request)));
    }
}
