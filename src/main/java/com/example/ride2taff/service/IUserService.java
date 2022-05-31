package com.example.ride2taff.service;

import com.example.ride2taff.dto.InformationUserDto;
import com.example.ride2taff.dto.NewUserDto;
import com.example.ride2taff.dto.RidesByDriverDto;
import com.example.ride2taff.dto.UserDto;
import com.example.ride2taff.entity.RideEntity;
import com.example.ride2taff.entity.UserEntity;
import org.apache.catalina.User;

import java.util.List;

public interface IUserService {
    List<UserDto> getAll();

    UserDto toDto(UserEntity entity);

    Integer add(String first_name, String last_name, String email,
                String password);

    Integer newUser(UserEntity dto);

    UserEntity toEntity(NewUserDto dto);

    void delete (Integer id);

    UserEntity getById (Integer id);

    InformationUserDto informationUserDto (UserEntity entity);


}
