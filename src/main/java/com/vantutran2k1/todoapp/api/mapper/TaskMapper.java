package com.vantutran2k1.todoapp.api.mapper;

import com.vantutran2k1.todoapp.api.models.Task;
import com.vantutran2k1.todoapp.api.models.User;
import com.vantutran2k1.todoapp.api.payloads.CreateTaskResponse;
import com.vantutran2k1.todoapp.api.payloads.GetTaskResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskMapper {
    @Mapping(source = "user", target = "userId", qualifiedByName = "userToId")
    GetTaskResponse toGetTaskResponse(Task task);

    CreateTaskResponse toCreateTaskResponse(Task task);

    @Named("userToId")
    static Long userToId(User user) {
        return user.getId();
    }
}
