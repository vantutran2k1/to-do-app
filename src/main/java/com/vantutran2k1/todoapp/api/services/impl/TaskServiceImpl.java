package com.vantutran2k1.todoapp.api.services.impl;

import com.vantutran2k1.todoapp.api.mapper.TaskMapper;
import com.vantutran2k1.todoapp.api.payloads.GetTaskResponse;
import com.vantutran2k1.todoapp.api.repositories.TaskRepository;
import com.vantutran2k1.todoapp.api.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskMapper taskMapper;
    private final TaskRepository taskRepository;

    @Override
    public List<GetTaskResponse> getTasks(Long userId) {
        return taskRepository.findByUserId(userId).stream().map(taskMapper::toGetTaskResponse).toList();
    }
}
