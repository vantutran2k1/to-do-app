package com.vantutran2k1.todoapp.api.services;

import com.vantutran2k1.todoapp.api.payloads.CacheUserDto;

public interface CacheService {
    void storeLoginToken(CacheUserDto user, String token, long expiresIn);
}
