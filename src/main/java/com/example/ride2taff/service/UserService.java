package com.example.ride2taff.service;

import com.example.ride2taff.dto.InformationUserDto;
import com.example.ride2taff.dto.NewUserDto;
import com.example.ride2taff.dto.UserDto;
import com.example.ride2taff.entity.UserEntity;
import com.example.ride2taff.repository.BookedRideRepository;
import com.example.ride2taff.repository.RideRepository;
import com.example.ride2taff.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserRepository repository;

    @Autowired
    private BookedRideRepository bookedRideRepository;

    @Autowired
    private RideRepository rideRepository;

    @Override
    public UserDto toDto(UserEntity entity) {
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setDisplayName(entity.getFirst_name() + " " + entity.getLast_name());
        dto.setEmail(entity.getEmail());
        dto.setRole(entity.getRole());

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
    public void delete(Integer id) {
        bookedRideRepository.deleteBookedRideForDeleteUserByAdmin(id);
        bookedRideRepository.flush();
        rideRepository.deleteRidesForDeleteUserByAdmin(id);
        rideRepository.flush();
        repository.deleteById(id);
    }

    @Override
    public UserEntity getById(Integer id) {

        return repository.findById(id).get();
    }

    @Override
    public InformationUserDto informationUserDto(UserEntity entity) {
        InformationUserDto dto = new InformationUserDto();
        dto.setFirst_name(entity.getFirst_name());
        dto.setLast_name(entity.getLast_name());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());

        return dto;
    }

    @Override
    public Integer newUser(UserEntity entity) {
        entity.setCreated_at(LocalDateTime.now());
        entity.setUpdated_at(LocalDateTime.now());
        repository.saveAndFlush(entity);
        return entity.getId();
    }

}
