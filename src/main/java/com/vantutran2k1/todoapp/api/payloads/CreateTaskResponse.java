package com.vantutran2k1.todoapp.api.payloads;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vantutran2k1.todoapp.api.constants.TaskStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class CreateTaskResponse {
    @JsonProperty(value = "title")
    private String title;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "status")
    private TaskStatus status;

    @JsonProperty(value = "due_date")
    private LocalDateTime dueDate;

    @JsonProperty(value = "created_at")
    private LocalDateTime createdAt;
}
