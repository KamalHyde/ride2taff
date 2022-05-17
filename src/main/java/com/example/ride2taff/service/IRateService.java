package com.example.ride2taff.service;

import com.example.ride2taff.dto.AddRateDto;
import com.example.ride2taff.entity.RateEntity;

public interface IRateService {

    RateEntity toEntity(AddRateDto dto);

    Integer addRateToUser(RateEntity entity);

}
