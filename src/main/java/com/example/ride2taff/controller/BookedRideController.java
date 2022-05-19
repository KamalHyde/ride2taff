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

    @GetMapping("sendrequest")
    private ResponseEntity sendARequestToDriver(@RequestParam Integer ride_id, @RequestParam Integer user_id) {
        try {
            bookedride_repository.sendARequestToDriver(ride_id, user_id);
            return new ResponseEntity("en attente", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("acceptrequest")
    private ResponseEntity acceptARequest(@RequestParam Integer ride_id, @RequestParam Integer user_id) {
        try {
            bookedride_repository.acceptARequest(ride_id, user_id);
            return new ResponseEntity(true, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("declinerequest")
    private ResponseEntity declineARequest(@RequestParam Integer ride_id, @RequestParam Integer user_id) {
        try {
            bookedride_repository.declineARequest(ride_id, user_id);
            return new ResponseEntity(true, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("deleterequest")
    private ResponseEntity deleterequest(@RequestParam Integer ride_id) {
        try {
            bookedride_repository.deleteById(ride_id);
            return new ResponseEntity(true, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
