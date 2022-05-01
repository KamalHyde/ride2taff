package com.example.ride2taff.repository;

import com.example.ride2taff.entity.RideEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository extends JpaRepository<RideEntity, Integer> {
}
