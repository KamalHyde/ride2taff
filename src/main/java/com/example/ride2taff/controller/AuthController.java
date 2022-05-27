package com.example.ride2taff.controller;

import com.example.ride2taff.dto.UserGoogleDto;
import com.example.ride2taff.repository.UserRepository;
import com.example.ride2taff.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthService auth_service;

    @Autowired
    private UserRepository user_repository;

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestHeader("Authorization") String id_token) {

        UserGoogleDto dto = auth_service.tokenToDto(id_token);

        if (null == dto) {
            return new ResponseEntity<>("access denied", HttpStatus.UNAUTHORIZED);
        }

        user_repository.findFirstByEmail(dto.getEmail());

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
