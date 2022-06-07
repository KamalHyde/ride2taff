package com.example.ride2taff.controller;

import com.example.ride2taff.dto.AddRateDto;
import com.example.ride2taff.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("rates")
public class RateController {

    @Autowired
    RateService rate_service;

    //ajout d'une note à un user
    @PostMapping("rateuser")
    private ResponseEntity addOneRate(@RequestBody AddRateDto dto) {
        try {
            Integer ID = rate_service.addRateToUser(rate_service.toEntity(dto));
            return new ResponseEntity(ID, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
