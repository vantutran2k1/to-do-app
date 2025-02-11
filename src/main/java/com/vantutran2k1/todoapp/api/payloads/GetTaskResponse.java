package com.vantutran2k1.todoapp.api.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GetTaskResponse {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("status")
    private String status;

    @JsonProperty("due_date")
    private String dueDate;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("created_at")
    private String createdAt;
}
