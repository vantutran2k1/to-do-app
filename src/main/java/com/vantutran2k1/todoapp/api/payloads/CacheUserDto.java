package com.vantutran2k1.todoapp.api.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CacheUserDto {
    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "username")
    private String username;

    @JsonProperty(value = "email")
    private String email;
}
