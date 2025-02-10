package com.vantutran2k1.todoapp.api.services.impl;

import com.vantutran2k1.todoapp.api.exceptions.UserExistException;
import com.vantutran2k1.todoapp.api.models.User;
import com.vantutran2k1.todoapp.api.payloads.CreateUserRequest;
import com.vantutran2k1.todoapp.api.repositories.UserRepository;
import com.vantutran2k1.todoapp.api.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public User registerUser(CreateUserRequest request) {
        if (Boolean.TRUE.equals(userRepository.existsByUsername(request.getUsername()))) {
            throw new UserExistException("Username already exists");
        }
        if (Boolean.TRUE.equals(userRepository.existsByEmail(request.getEmail()))) {
            throw new UserExistException("Email already exists");
        }

        var user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
        return userRepository.save(user);
    }
}
