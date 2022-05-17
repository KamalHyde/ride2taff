package com.example.ride2taff.service;

import com.example.ride2taff.dto.DisplayRidesByUserDto;
import com.example.ride2taff.entity.BookedRideEntity;
import com.example.ride2taff.entity.RideEntity;
import com.example.ride2taff.repository.BookedRideRepository;
import com.example.ride2taff.repository.RideRepository;
import com.example.ride2taff.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BookedRideService implements IBookedRideService {

    @Autowired
    private BookedRideRepository bookedride_repository;

    @Autowired
    private UserRepository user_repository;

    @Autowired
    private RideRepository ride_repository;

    @Override
    public List<DisplayRidesByUserDto> toDto(List<BookedRideEntity> list_entity) {
        List<DisplayRidesByUserDto> list_dto = new ArrayList<DisplayRidesByUserDto>();

        for (int i = 0; i<list_entity.size(); i++){
            DisplayRidesByUserDto dto = new DisplayRidesByUserDto();
            BookedRideEntity entity = list_entity.get(i);
            dto.setDisplay_name(entity.getUser_entity().getFirst_name() + " " + entity.getUser_entity().getLast_name());
            dto.setDeparture_zip_code(entity.getRide_entity().getDeparture_zip_code());
            dto.setDisplay_city(entity.getRide_entity().getDeparture_city());
            dto.setDeparture_date(entity.getRide_entity().getDeparture_date());
            dto.setDeparture_time(entity.getRide_entity().getDeparture_time());
            list_dto.add(dto);
        }

        return list_dto;
    }

}
