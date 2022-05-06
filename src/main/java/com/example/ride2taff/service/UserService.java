package com.example.ride2taff.service;

import com.example.ride2taff.dto.NewUserDto;
import com.example.ride2taff.dto.UserDto;
import com.example.ride2taff.entity.UserEntity;
import com.example.ride2taff.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserRepository repository;

    @Override
    public UserDto toDto(UserEntity entity) {
        UserDto dto = new UserDto();

        dto.setDisplayName(entity.getFirst_name() + " " + entity.getLast_name());
        dto.setEmail(entity.getEmail());

        return dto;
    }

    @Override
    public Integer add(String first_name, String last_name, String email, String password) {

        UserEntity entity = new UserEntity();

        LocalDateTime date = LocalDateTime.now();

        entity.setLast_name(last_name);
        entity.setFirst_name(first_name);
        entity.setEmail(email);
        entity.setPassword(password);
        entity.setCreated_at(date);
        entity.setUpdated_at(date);

        repository.saveAndFlush(entity);

        return entity.getId();
    }


    @Override
    public List<UserDto> getAll() {

        List<UserEntity> listUser = repository.findAll();

        List<UserDto> listFinal = new ArrayList<>();

        for (int i = 0; i < listUser.size(); i++) {
            UserEntity entity = listUser.get(i);
            UserDto dto = this.toDto(entity);
            listFinal.add(dto);
        }
        return listFinal;
    }

    @Override
    public UserEntity toEntity(NewUserDto dto) {
        UserEntity entity = new UserEntity();

        entity.setFirst_name(dto.getFirst_name());
        entity.setLast_name(dto.getLast_name());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());

        return entity;
    }


    @Override
    public Integer newUser(UserEntity entity) {
        entity.setCreated_at(LocalDateTime.now());
        entity.setUpdated_at(LocalDateTime.now());
        repository.saveAndFlush(entity);
        return entity.getId();
    }

}
