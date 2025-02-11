package com.vantutran2k1.todoapp.api.services;

import com.vantutran2k1.todoapp.api.models.User;
import com.vantutran2k1.todoapp.api.payloads.CreateUserRequest;
import com.vantutran2k1.todoapp.api.payloads.LoginUserRequest;
import com.vantutran2k1.todoapp.api.payloads.LoginUserResponse;

public interface UserService {
    User registerUser(CreateUserRequest request);

    LoginUserResponse loginUser(LoginUserRequest request);
}
