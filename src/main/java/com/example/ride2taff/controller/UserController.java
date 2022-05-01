package com.example.ride2taff.controller;

import com.example.ride2taff.dto.UserDto;
import com.example.ride2taff.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("all")
    public List<UserDto> getAll() {
        return service.getAll();
    }

    @GetMapping("add")
    public ResponseEntity add(@RequestParam String first_name, @RequestParam String last_name, @RequestParam String email,
                              @RequestParam String password) {

        if (null == first_name) {
            return new ResponseEntity("Entrer un prenom", HttpStatus.BAD_REQUEST);
        }

        if (null == last_name) {
            return new ResponseEntity("Entrer un nom", HttpStatus.BAD_REQUEST);
        }

        if (null == email) {
            return new ResponseEntity("Entrer un email", HttpStatus.BAD_REQUEST);
        }

        if (null == password) {
            return new ResponseEntity("Entrer un mot de passe", HttpStatus.BAD_REQUEST);
        }

        try {
            Integer Id = service.add(first_name, last_name, email, password);
            return new ResponseEntity(Id, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
