package com.example.ride2taff.service;

import com.example.ride2taff.dto.AddRideDto;
import com.example.ride2taff.dto.DisplaySearchRideDto;
import com.example.ride2taff.dto.RideDto;
import com.example.ride2taff.dto.RidesByDriverDto;
import com.example.ride2taff.entity.RideEntity;
import com.example.ride2taff.repository.BookedRideRepository;
import com.example.ride2taff.repository.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class RideService implements IRideService {

    @Autowired
    RideRepository repository;
    @Autowired
    BookedRideRepository bookedRideRepository;

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

    @Override
    public List<DisplaySearchRideDto> toDisplaySearchDto(List<RideEntity> listEntity) {
        List <DisplaySearchRideDto> listDisplay = new ArrayList<DisplaySearchRideDto>();
        for (int i=0 ; i<listEntity.size(); i++){
            RideEntity entity1 = listEntity.get(i);
            DisplaySearchRideDto displayRideDto = new DisplaySearchRideDto();
            displayRideDto.setDate(entity1.getDeparture_date());
            displayRideDto.setTimes(entity1.getDeparture_time());
            displayRideDto.setSeats(entity1.getNumber_seats());
            displayRideDto.setDeparture_city(entity1.getDeparture_city());
            displayRideDto.setDeparture_zip_code(entity1.getDeparture_zip_code());

            listDisplay.add(displayRideDto);
        }

        return listDisplay;
    }

    @Override
    public void delete_ride_admin(Integer id) {
        bookedRideRepository.delete_booked_ride_admin(id);
        bookedRideRepository.flush();
        repository.deleteById(id);
    }
    @Override
    public List<RidesByDriverDto> toRidesByDriverDto(List<RideEntity> list_entity) {
        List<RidesByDriverDto> list_dto = new ArrayList<RidesByDriverDto>();

        for (int i = 0 ; i < list_entity.size() ; i++) {
            RideEntity entity = list_entity.get(i);
            RidesByDriverDto dto = new RidesByDriverDto();
            dto.setDisplayArrivalAddress(entity.getArrival_zip_code() + " " + entity.getArrival_city());
            dto.setDisplayDepartureAddress(entity.getDeparture_zip_code() + " " + entity.getDeparture_city());
            dto.setDeparture_date(entity.getDeparture_date());
            dto.setDeparture_time(entity.getDeparture_time());
            dto.setId(entity.getId());
            list_dto.add(dto);
        }

        return list_dto;
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
