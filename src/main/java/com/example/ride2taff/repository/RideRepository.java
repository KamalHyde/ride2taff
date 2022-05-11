package com.example.ride2taff.repository;

import com.example.ride2taff.entity.RideEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface RideRepository extends JpaRepository<RideEntity, Integer> {

    @Query (value = "SELECT * FROM rides r WHERE departure_zip_code = ?1 AND departure_date = ?2", nativeQuery = true)
    List<RideEntity> searchByZipDate(Integer departureZip, LocalDate departureDate);
}
