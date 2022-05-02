package com.example.ride2taff.service;

import com.example.ride2taff.dto.AddRideDto;
import com.example.ride2taff.dto.RideDto;
import com.example.ride2taff.entity.RideEntity;
import com.example.ride2taff.repository.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class RideService implements IRideService {

    @Autowired
    RideRepository repository;

    @Override
    public RideDto toDto(RideEntity entity) {
        RideDto dto = new RideDto();

        dto.setDisplayDepartureAddress(entity.getArrival_zip_code() + " " + entity.getDeparture_city());
        dto.setDisplayArrivalAddress(entity.getArrival_zip_code() + " " + entity.getArrival_zip_code());
        dto.setNumber_seats(entity.getNumber_seats());
        dto.setDeparture_date(entity.getDeparture_date());
        dto.setDeparture_time(entity.getDeparture_time());

        return dto;
    }

    @Override
    public List<RideDto> getAll() {

        List<RideEntity> listRide = repository.findAll();

        List<RideDto> listRideDto = new ArrayList<>();

        for (RideEntity element : listRide) {
            RideDto dto = new RideDto();
            dto = toDto(element);
            listRideDto.add(dto);
        }

        return listRideDto;
    }

    @Override
    public Integer add(Integer departure_zip_code, String departure_city, Integer arrival_zip_code, String arrival_city, Integer seats, LocalDate date, LocalTime time) {
        RideEntity entity = new RideEntity();

        entity.setDeparture_zip_code(departure_zip_code);
        entity.setDeparture_city(departure_city);
        entity.setArrival_zip_code(arrival_zip_code);
        entity.setArrival_city(arrival_city);
        entity.setNumber_seats(seats);
        entity.setDeparture_date(date);
        entity.setDeparture_time(time);
        entity.setCreated_at(LocalDateTime.now());
        entity.setUpdated_at(LocalDateTime.now());

        repository.saveAndFlush(entity);

        return entity.getId();
    }

    // conversion du format AddRideDto envoyé par la requete post en RideEntity pour ajout à la base via la methode newRide
    @Override
    public RideEntity toEntity(AddRideDto dto) {
        RideEntity entity = new RideEntity();

        entity.setDeparture_zip_code(dto.getDeparture_zip_code());
        entity.setDeparture_city(dto.getDeparture_city());
        entity.setArrival_zip_code(dto.getArrival_zip_code());
        entity.setArrival_city(dto.getArrival_city());
        entity.setNumber_seats(dto.getNumber_seats());
        entity.setNumber_seats(dto.getNumber_seats());
        entity.setDeparture_date(LocalDate.of(dto.getYear(), dto.getMonth(), dto.getDay()));
        entity.setDeparture_time(LocalTime.of(dto.getHour(), dto.getMinute(), 0));

        return entity;
    }

    // essai d'une methode post
    @Override
    public Integer newRide(RideEntity ride) {
        ride.setCreated_at(LocalDateTime.now());
        ride.setUpdated_at(LocalDateTime.now());
        repository.saveAndFlush(ride);
        return ride.getId();
    }
}
