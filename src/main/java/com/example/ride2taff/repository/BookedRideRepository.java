package com.example.ride2taff.repository;

import com.example.ride2taff.entity.BookedRideEntity;
import com.example.ride2taff.entity.RideEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BookedRideRepository extends JpaRepository<BookedRideEntity, Integer> {


    @Query(value = "SELECT * FROM bookedrides WHERE ride_id = ?1", nativeQuery = true)
    List<BookedRideEntity> users_by_ride(Integer ride_id);

    @Query (value = "SELECT * FROM bookedrides WHERE user_id = ?1", nativeQuery = true)
    List<BookedRideEntity> searchRidesByUser(Integer user_id);

    @Modifying
    @Transactional
    @Query (value = "UPDATE bookedrides SET status = 'en attente' WHERE ride_id = ?1 AND user_id = ?2", nativeQuery = true)
    void sendARequestToDriver(Integer ride_id, Integer user_id);

    @Modifying
    @Transactional
    @Query (value = "UPDATE bookedrides SET status = 'acceptee' WHERE ride_id = ?1 AND user_id = ?2", nativeQuery = true)
    void acceptARequest(Integer ride_id, Integer user_id);

    @Modifying
    @Transactional
    @Query (value = "UPDATE bookedrides SET status = 'refusee' WHERE ride_id = ?1 AND user_id = ?2", nativeQuery = true)
    void declineARequest(Integer ride_id, Integer user_id);
}
