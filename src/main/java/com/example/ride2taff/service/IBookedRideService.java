package com.example.ride2taff.service;

import com.example.ride2taff.dto.DisplayRidesByUserDto;
import com.example.ride2taff.entity.BookedRideEntity;
import com.example.ride2taff.entity.RideEntity;
import com.example.ride2taff.repository.BookedRideRepository;

import java.util.List;

public interface IBookedRideService {


    List<DisplayRidesByUserDto> toDto(List<BookedRideEntity> list_entity);

}
