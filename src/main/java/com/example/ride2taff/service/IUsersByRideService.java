package com.example.ride2taff.service;

import com.example.ride2taff.dto.UsersByRideDto;
import com.example.ride2taff.entity.BookedRideEntity;

import java.util.List;

public interface IUsersByRideService {

    List<UsersByRideDto> toDto(List<BookedRideEntity> entity);

}
