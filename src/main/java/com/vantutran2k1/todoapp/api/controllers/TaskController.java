package com.vantutran2k1.todoapp.api.controllers;

import com.vantutran2k1.todoapp.api.payloads.ApiResponse;
import com.vantutran2k1.todoapp.api.payloads.CreateTaskRequest;
import com.vantutran2k1.todoapp.api.payloads.CreateTaskResponse;
import com.vantutran2k1.todoapp.api.payloads.GetTaskResponse;
import com.vantutran2k1.todoapp.api.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<GetTaskResponse>>> getTasks(@RequestParam("user_id") Long userId) {
        return ResponseEntity.ok(new ApiResponse<>(taskService.getTasks(userId)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CreateTaskResponse>> createTask(
            @RequestHeader(value = "Authorization") String token,
            @RequestBody CreateTaskRequest request
    ) {
        return new ResponseEntity<>(new ApiResponse<>(taskService.createTask(token, request)), HttpStatus.CREATED);
    }
}
