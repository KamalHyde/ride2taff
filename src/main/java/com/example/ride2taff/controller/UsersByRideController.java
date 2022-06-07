package com.example.ride2taff.controller;

import com.example.ride2taff.dto.UsersByRideDto;
import com.example.ride2taff.entity.BookedRideEntity;
import com.example.ride2taff.repository.BookedRideRepository;
import com.example.ride2taff.repository.RideRepository;
import com.example.ride2taff.service.UsersByRideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("bookedrides")
public class UsersByRideController {

    @Autowired
    private BookedRideRepository booked_ride_repository;

    @Autowired
    private UsersByRideService users_by_ride_service;

    @Autowired
    private RideRepository ride_repository;


    @GetMapping("usersbyride/{id}")
    public ResponseEntity users_by_ride(@PathVariable String id){
        Integer ID = Integer.valueOf(id);
        List<BookedRideEntity> list_entity = booked_ride_repository.users_by_ride(ID);
        List<UsersByRideDto> list_dto = users_by_ride_service.toDto(list_entity);

        if(null == list_dto){
            return new ResponseEntity("La course n'existe pas", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity(list_dto, HttpStatus.OK);
        }

    }
}
