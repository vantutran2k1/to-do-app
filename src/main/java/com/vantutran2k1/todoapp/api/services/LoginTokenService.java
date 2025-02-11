package com.vantutran2k1.todoapp.api.services;

import com.vantutran2k1.todoapp.api.models.User;

public interface LoginTokenService {
    String generateToken(User user);
}
