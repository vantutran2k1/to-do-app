package com.vantutran2k1.todoapp.api.controllers;

import com.vantutran2k1.todoapp.api.payloads.GetTaskResponse;
import com.vantutran2k1.todoapp.api.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<List<GetTaskResponse>> getTasks(@RequestParam("user_id") Long userId) {
        return ResponseEntity.ok(taskService.getTasks(userId));
    }
}
