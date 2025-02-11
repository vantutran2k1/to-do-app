package com.vantutran2k1.todoapp.api.services.impl;

import com.vantutran2k1.todoapp.api.models.User;
import com.vantutran2k1.todoapp.api.services.LoginTokenService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoginTokenServiceImpl implements LoginTokenService {
    @Override
    public String generateToken(User user) {
        return UUID.randomUUID().toString();
    }
}
