package com.example.ride2taff.service;

import com.example.ride2taff.dto.RideDto;
import com.example.ride2taff.entity.RideEntity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface IRideService {

    RideDto toDto(RideEntity entity);
    List<RideDto> getAll();

    Integer add(Integer departure_zip_code, String departure_city, Integer arrival_zip_code, String arrival_city,
                Integer seats, LocalDate date, LocalTime time);
    Integer newRide(RideEntity ride);
}
