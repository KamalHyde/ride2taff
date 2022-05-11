package com.example.ride2taff.controller;

import com.example.ride2taff.dto.DisplayRidesByUserDto;
import com.example.ride2taff.repository.BookedRideRepository;
import com.example.ride2taff.service.BookedRideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("bookedride")
public class BookedRideController {

    @Autowired
    BookedRideRepository bookedride_repository;

    @Autowired
    BookedRideService bookedride_service;

    // toutes les courses pour 1 user
    @GetMapping("ridesbyuser/{id}")
    private ResponseEntity getAllRidesForOneUser(@PathVariable String id) {
        Integer ID = Integer.parseInt(id);
        if (null == bookedride_repository.searchRidesByUser(ID)) {
            return new ResponseEntity("L'utilisateur n'a pas réservé de trajets", HttpStatus.BAD_REQUEST);
        }
        List<DisplayRidesByUserDto> list_dto = bookedride_service.toDto(bookedride_repository.searchRidesByUser(ID));
        return new ResponseEntity(list_dto, HttpStatus.OK);
    }

}