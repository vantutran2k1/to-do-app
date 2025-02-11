package com.vantutran2k1.todoapp.api.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginUserResponse {
    @JsonProperty(value = "token")
    private String token;
}
