package com.example.ride2taff.repository;

import com.example.ride2taff.entity.RideEntity;
import com.example.ride2taff.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query(value = "SELECT u.email FROM users u WHERE u.email = ?1", nativeQuery = true)
    String existByEmail(String email);

    UserEntity findFirstByEmail(String email);


    @Query(value = "SELECT * FROM users WHERE email = ?1 AND password = ?2", nativeQuery = true)
    UserEntity getUser(String email, String password);

    @Modifying
    @Transactional
    @Query (value = "UPDATE users SET role = 'user' WHERE id = ?", nativeQuery = true)
    void validateUserByAdmin(Integer id);

}
