package com.example.ride2taff.service;

import com.example.ride2taff.dto.AddRateDto;
import com.example.ride2taff.entity.RateEntity;
import com.example.ride2taff.repository.RateRepository;
import com.example.ride2taff.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class RateService implements IRateService {
    @Autowired
    RateRepository rate_repository;

    @Autowired
    UserRepository user_repository;

    @Override
    public RateEntity toEntity(AddRateDto dto) {
        RateEntity entity = new RateEntity();

        entity.setRate(dto.getRate());
        entity.setUser_entity(user_repository.findById(dto.getUser_rated_id()).get());
        entity.setCreated_at(LocalDateTime.now());
        entity.setUpdated_at(LocalDateTime.now());

        return entity;
    }

    @Override
    public Integer addRateToUser(RateEntity entity) {

        rate_repository.saveAndFlush(entity);

        return entity.getId();
    }

}
