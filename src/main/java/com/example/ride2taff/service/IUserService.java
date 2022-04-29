package com.example.ride2taff.service;

import com.example.ride2taff.dto.UserDto;
import com.example.ride2taff.entity.UserEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface IUserService {
    List<UserDto> getAll();

    UserDto toDto(UserEntity entity);

    Integer add(String first_name, String last_name, String email,
                String password);
}
