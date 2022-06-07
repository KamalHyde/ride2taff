package com.example.ride2taff.service;


import com.example.ride2taff.dto.UsersByRideDto;
import com.example.ride2taff.entity.BookedRideEntity;
import com.example.ride2taff.repository.BookedRideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersByRideService implements IUsersByRideService{

    @Autowired
    BookedRideRepository booked_ride_repository;


    @Override
    public List<UsersByRideDto> toDto(List<BookedRideEntity> list_entity) {
        List<UsersByRideDto> list_users_by_ride_dto = new ArrayList<UsersByRideDto>();

        for ( int i = 0 ; i < list_entity.size() ; i++){
            UsersByRideDto dto = new UsersByRideDto();

            BookedRideEntity entity = list_entity.get(i);

            dto.setDisplay_departure_address(entity.getRide_entity().getDeparture_city() + " " + entity.getRide_entity().getDeparture_zip_code());
            dto.setDisplay_arrival_address(entity.getRide_entity().getArrival_city() + " " + entity.getRide_entity().getArrival_zip_code());
            dto.setNumber_seats(entity.getRide_entity().getNumber_seats());
            dto.setDeparture_date(entity.getRide_entity().getDeparture_date());
            dto.setDeparture_time(entity.getRide_entity().getDeparture_time());
            dto.setDisplay_user_name(entity.getUser_entity().getFirst_name() + " " + entity.getUser_entity().getLast_name());
            dto.setId(entity.getUser_entity().getId());

            list_users_by_ride_dto.add(dto);
        }

        return list_users_by_ride_dto;
    }
}
