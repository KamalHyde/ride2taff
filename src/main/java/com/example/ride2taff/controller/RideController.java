package com.example.ride2taff.controller;

import com.example.ride2taff.dto.*;
import com.example.ride2taff.entity.RideEntity;
import com.example.ride2taff.repository.BookedRideRepository;
import com.example.ride2taff.repository.RideRepository;
import com.example.ride2taff.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("rides")
public class RideController {


    @Autowired
    RideRepository repository;


    @Autowired
    RideService service;

    @GetMapping("allRides")
    private List<RideDto> getAll() {
        return service.getAll();
    }

    @GetMapping("ridesbydriver/{id}")
    private ResponseEntity getAllRidesByDriver(@PathVariable String id) {
        Integer ID = Integer.parseInt(id);
        if (null == repository.getAllRidesByDriver(ID)) {
            return new ResponseEntity("Vous n'avez publié aucune course", HttpStatus.BAD_REQUEST);
        }
        List<RidesByDriverDto> list_rides = service.toRidesByDriverDto(repository.getAllRidesByDriver(ID));
        return new ResponseEntity(list_rides, HttpStatus.OK);

    }


    @GetMapping("addride")
    private ResponseEntity add(@RequestParam Integer departure_zip_code, @RequestParam String departure_city, @RequestParam Integer arrival_zip_code,
                                @RequestParam String arrival_city, @RequestParam Integer seats, @RequestParam Integer annee,
                                @RequestParam Integer mois, @RequestParam Integer jour, @RequestParam Integer heure, @RequestParam Integer minute) {
        if (null == departure_zip_code) {
            return new ResponseEntity("Entrer un code postal", HttpStatus.BAD_REQUEST);
        }
        if (null == departure_city) {
            return new ResponseEntity("Entrer une ville de départ", HttpStatus.BAD_REQUEST);
        }
        if (null == arrival_zip_code) {
            return new ResponseEntity("Entrer un code postal d'arrivée", HttpStatus.BAD_REQUEST);
        }
        if (null == arrival_city) {
            return new ResponseEntity("Entrer une ville d'arrivée", HttpStatus.BAD_REQUEST);
        }
        if (null == seats) {
            return new ResponseEntity("Entrer un nombre de siege", HttpStatus.BAD_REQUEST);
        }
        if (jour < 1 || jour > 31) {
            return new ResponseEntity("le jour est incorrect", HttpStatus.BAD_REQUEST);
        }
        if (mois < 1 || mois > 12) {
            return new ResponseEntity("le mois est incorrect", HttpStatus.BAD_REQUEST);
        }
        if (null == heure) {
            return new ResponseEntity("Entrer une heure valide", HttpStatus.BAD_REQUEST);
        }
        if (null == minute) {
            return new ResponseEntity("Entrer une heure valide", HttpStatus.BAD_REQUEST);
        }
        try {
            LocalDate date = LocalDate.of(annee, mois, jour);
            LocalTime time = LocalTime.of(heure, minute, 0);
            Integer Id = service.add(departure_zip_code, departure_city, arrival_zip_code, arrival_city, seats, date, time);
            return new ResponseEntity(Id, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // essai d'une méthode post
    // créer un dto (AddRideDto) pour la requete avec le format de récuperation des données via le request body
    // le jour, le mois, l'annéee doivent être séparés. de mm pour l'heure (hr, min, sec)
    @PostMapping("newride")
    private ResponseEntity newRide(@RequestBody AddRideDto ride) {

        try {
            RideEntity rideConvertToEntity = service.toEntity(ride);
            Integer Id = service.newRide(rideConvertToEntity);
            return new ResponseEntity(Id, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("searchride")
    private List <DisplaySearchRideDto> searchRide(@RequestBody SearchRideDto  searchride){
        List<RideEntity> listDeparture = repository.searchByZipDate(searchride.getDeparture_zip_code(), searchride.getDeparture_date());
        List<DisplaySearchRideDto> listDisplay = service.toDisplaySearchDto(listDeparture);
        return listDisplay;
    }

    @GetMapping("delete-ride-admin/{id}")
    private ResponseEntity deleteRideByIdAdmin(@PathVariable String id){
        Integer ID = Integer.parseInt(id);

        try {
            service.delete_ride_admin(ID);
            return new ResponseEntity(ID, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("newregularride")
    private ResponseEntity newRegularRide(@RequestBody RegularRideDto dto) {
        try {
            service.newRegularRide(dto);
            return new ResponseEntity(true, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity(false, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("delete/{id}")
    private ResponseEntity deleteById(@PathVariable String id) {
        Integer ID = Integer.parseInt(id);

        try {
            service.delete_ride_admin(ID);
            return new ResponseEntity("ride is delete", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }


}
