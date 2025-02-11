package com.vantutran2k1.todoapp.api.services.impl;

import com.vantutran2k1.todoapp.api.constants.TaskStatus;
import com.vantutran2k1.todoapp.api.exceptions.UnauthorizedException;
import com.vantutran2k1.todoapp.api.mapper.TaskMapper;
import com.vantutran2k1.todoapp.api.mapper.UserMapper;
import com.vantutran2k1.todoapp.api.models.Task;
import com.vantutran2k1.todoapp.api.payloads.CreateTaskRequest;
import com.vantutran2k1.todoapp.api.payloads.CreateTaskResponse;
import com.vantutran2k1.todoapp.api.payloads.GetTaskResponse;
import com.vantutran2k1.todoapp.api.repositories.TaskRepository;
import com.vantutran2k1.todoapp.api.services.CacheService;
import com.vantutran2k1.todoapp.api.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskMapper taskMapper;
    private final UserMapper userMapper;
    private final TaskRepository taskRepository;
    private final CacheService cacheService;

    @Override
    public List<GetTaskResponse> getTasks(Long userId) {
        return taskRepository.findByUserId(userId).stream().map(taskMapper::toGetTaskResponse).toList();
    }

    @Override
    public CreateTaskResponse createTask(String token, CreateTaskRequest request) {
        var user = cacheService.getUser(token);
        if (user == null) {
            throw new UnauthorizedException("Invalid or expired token");
        }

        var currentTime = LocalDateTime.now();
        var task = Task.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .status(TaskStatus.PENDING)
                .user(userMapper.toUser(user))
                .dueDate(request.getDueDate())
                .createdAt(currentTime)
                .updatedAt(currentTime)
                .build();

        taskRepository.save(task);
        return taskMapper.toCreateTaskResponse(task);
    }
}
