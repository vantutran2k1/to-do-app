package com.vantutran2k1.todoapp.api.mapper;

import com.vantutran2k1.todoapp.api.models.User;
import com.vantutran2k1.todoapp.api.payloads.CacheUserDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    CacheUserDto toCacheUserDto(User user);
}
