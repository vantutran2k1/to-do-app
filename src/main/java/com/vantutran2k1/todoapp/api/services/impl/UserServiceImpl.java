package com.vantutran2k1.todoapp.api.services.impl;

import com.vantutran2k1.todoapp.api.exceptions.UserExistException;
import com.vantutran2k1.todoapp.api.models.User;
import com.vantutran2k1.todoapp.api.payloads.CreateUserRequest;
import com.vantutran2k1.todoapp.api.payloads.LoginUserRequest;
import com.vantutran2k1.todoapp.api.payloads.LoginUserResponse;
import com.vantutran2k1.todoapp.api.repositories.UserRepository;
import com.vantutran2k1.todoapp.api.services.LoginTokenService;
import com.vantutran2k1.todoapp.api.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final LoginTokenService loginTokenService;

    @Override
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

    @Override
    public LoginUserResponse loginUser(LoginUserRequest request) {
        var optUser = userRepository.findByUsername(request.getUsername());
        if (optUser.isEmpty() || !optUser.get().getPassword().equals(request.getPassword())) {
            throw new EntityNotFoundException("Invalid username or password");
        }

        return LoginUserResponse.builder().token(loginTokenService.generateToken(optUser.get())).build();
    }
}
