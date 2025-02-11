package com.vantutran2k1.todoapp.api.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateTaskRequest {
    @JsonProperty(value = "title")
    @NotEmpty(message = "must not be empty")
    private String title;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "due_date")
    private LocalDateTime dueDate;
}
