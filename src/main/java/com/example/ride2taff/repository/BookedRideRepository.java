package com.example.ride2taff.repository;

import com.example.ride2taff.entity.BookedRideEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookedRideRepository extends JpaRepository<BookedRideEntity, Integer> {
}
