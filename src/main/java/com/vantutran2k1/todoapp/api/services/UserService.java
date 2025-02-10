package com.vantutran2k1.todoapp.api.services;

import com.vantutran2k1.todoapp.api.models.User;
import com.vantutran2k1.todoapp.api.payloads.CreateUserRequest;

public interface UserService {
    public User registerUser(CreateUserRequest request);
}
