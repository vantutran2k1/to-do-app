package com.vantutran2k1.todoapp.api.services;

import com.vantutran2k1.todoapp.api.payloads.CreateTaskRequest;
import com.vantutran2k1.todoapp.api.payloads.CreateTaskResponse;
import com.vantutran2k1.todoapp.api.payloads.GetTaskResponse;

import java.util.List;

public interface TaskService {
    List<GetTaskResponse> getTasks(Long userId);

    CreateTaskResponse createTask(String token, CreateTaskRequest request);
}
