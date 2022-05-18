package com.example.ride2taff.controller;

import com.example.ride2taff.dto.NewUserDto;
import com.example.ride2taff.dto.UserDto;
import com.example.ride2taff.entity.RideEntity;
import com.example.ride2taff.entity.UserEntity;
import com.example.ride2taff.repository.UserRepository;
import com.example.ride2taff.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService service;

    @Autowired
    UserRepository repository;

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

    @PostMapping("newuser")
    public ResponseEntity newUser(@RequestBody NewUserDto dto) {

        if (null == dto.getFirst_name()) {
            return new ResponseEntity("Entrer un prenom", HttpStatus.BAD_REQUEST);
        }

        if (null == dto.getLast_name()) {
            return new ResponseEntity("Entrer un nom", HttpStatus.BAD_REQUEST);
        }

        if (null == dto.getEmail()) {
            return new ResponseEntity("Entrer un email", HttpStatus.BAD_REQUEST);
        }

        if (null == dto.getPassword()) {
            return new ResponseEntity("Entrer un mot de passe", HttpStatus.BAD_REQUEST);
        }

        if (!Objects.equals(dto.getPassword(), dto.getPassword_validation())) {
            return new ResponseEntity("Le mot de passe est différent", HttpStatus.BAD_REQUEST);
        }

        if (!Objects.equals(dto.getEmail(), dto.getEmail_validation())) {
            return new ResponseEntity("L'email est différent", HttpStatus.BAD_REQUEST);
        }

        if (null != repository.existByEmail(dto.getEmail())) {
           return new ResponseEntity("Email déjà utilisé par un autre utilisateur", HttpStatus.BAD_REQUEST);
        }
        try {
            UserEntity entity = service.toEntity(dto);
            Integer Id = service.newUser(entity);
            return new ResponseEntity(Id, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

}
