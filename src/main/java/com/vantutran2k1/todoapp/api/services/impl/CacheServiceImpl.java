package com.vantutran2k1.todoapp.api.services.impl;

import com.vantutran2k1.todoapp.api.constants.RedisConstants;
import com.vantutran2k1.todoapp.api.payloads.CacheUserDto;
import com.vantutran2k1.todoapp.api.services.CacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class CacheServiceImpl implements CacheService {
    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public void storeLoginToken(CacheUserDto user, String token, long expiresIn) {
        String key = RedisConstants.AUTH_TOKEN + ":" + token;
        redisTemplate.opsForValue().set(key, user, Duration.ofSeconds(expiresIn));
    }

    @Override
    public CacheUserDto getUser(String token) {
        String key = RedisConstants.AUTH_TOKEN + ":" + token;
        return (CacheUserDto) redisTemplate.opsForValue().get(key);
    }
}
