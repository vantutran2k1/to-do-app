package com.vantutran2k1.todoapp.api.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CreateUserRequest {
    @JsonProperty(value = "username")
    @NotEmpty(message = "must not be empty")
    private String username;

    @JsonProperty(value = "email")
    @NotEmpty(message = "must not be empty")
    private String email;

    @JsonProperty(value = "password")
    @NotEmpty(message = "must not be empty")
    private String password;
}
