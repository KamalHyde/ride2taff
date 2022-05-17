package com.example.ride2taff.repository;

import com.example.ride2taff.entity.BookedRideEntity;
import com.example.ride2taff.entity.RideEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookedRideRepository extends JpaRepository<BookedRideEntity, Integer> {


    @Query(value = "SELECT * FROM bookedrides WHERE ride_id = ?1", nativeQuery = true)
    List<BookedRideEntity> users_by_ride(Integer ride_id);

    @Query (value = "SELECT * FROM bookedrides WHERE user_id = ?1", nativeQuery = true)
    List<BookedRideEntity> searchRidesByUser(Integer user_id);

}
