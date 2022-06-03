package com.example.ride2taff.entity;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    @Column(name = "deleted_at")
    private LocalDateTime deleted_at;

    @Column(name = "role")
    private String role;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<RateEntity> list_rate_entity;


    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<RideEntity> list_ride_entity;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<RideEntity> list_user_ride_entity;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<BookedRideEntity> list_user_bookedride_entity;

    public List<RideEntity> getList_user_ride_entity() {
        return list_user_ride_entity;
    }

    public void setList_user_ride_entity(List<RideEntity> list_user_ride_entity) {
        this.list_user_ride_entity = list_user_ride_entity;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<RateEntity> getList_rate_entity() {
        return list_rate_entity;
    }

    public void setList_rate_entity(List<RateEntity> list_rate_entity) {
        this.list_rate_entity = list_rate_entity;
    }

    public List<BookedRideEntity> getList_user_bookedride_entity() {
        return list_user_bookedride_entity;
    }

    public void setList_user_bookedride_entity(List<BookedRideEntity> list_user_bookedride_entity) {
        this.list_user_bookedride_entity = list_user_bookedride_entity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public LocalDateTime getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(LocalDateTime deleted_at) {
        this.deleted_at = deleted_at;
    }

    public List<RideEntity> getList_ride_entity() {
        return list_ride_entity;
    }

    public void setList_ride_entity(List<RideEntity> list_ride_entity) {
        this.list_ride_entity = list_ride_entity;
    }
}
