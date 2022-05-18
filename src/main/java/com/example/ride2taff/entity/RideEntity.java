package com.example.ride2taff.entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "rides")
public class RideEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "departure_zip_code")
    private Integer departure_zip_code;

    @Column(name = "departure_city")
    private String departure_city;

    @Column(name = "arrival_zip_code")
    private Integer arrival_zip_code;

    @Column(name = "arrival_city")
    private String arrival_city;

    @Column(name = "number_seats")
    private Integer number_seats;

    @Column(name = "departure_date")
    private LocalDate departure_date;

    @Column(name = "departure_time")
    private LocalTime departure_time;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    @Column(name = "deleted_at")
    private LocalDateTime deleted_at;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity list_user_entity;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ride_id", referencedColumnName = "id")
    private List<BookedRideEntity> list_ride_bookedride_entity;

    public List<BookedRideEntity> getList_ride_bookedride_entity() {
        return list_ride_bookedride_entity;
    }

    public void setList_ride_bookedride_entity(List<BookedRideEntity> list_ride_bookedride_entity) {
        this.list_ride_bookedride_entity = list_ride_bookedride_entity;
    }

    public UserEntity getList_user_entity() {
        return list_user_entity;
    }

    public void setList_user_entity(UserEntity list_user_entity) {
        this.list_user_entity = list_user_entity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeparture_zip_code() {
        return departure_zip_code;
    }

    public void setDeparture_zip_code(Integer departure_zip_code) {
        this.departure_zip_code = departure_zip_code;
    }

    public String getDeparture_city() {
        return departure_city;
    }

    public void setDeparture_city(String departure_city) {
        this.departure_city = departure_city;
    }

    public Integer getArrival_zip_code() {
        return arrival_zip_code;
    }

    public void setArrival_zip_code(Integer arrival_zip_code) {
        this.arrival_zip_code = arrival_zip_code;
    }

    public String getArrival_city() {
        return arrival_city;
    }

    public void setArrival_city(String arrival_city) {
        this.arrival_city = arrival_city;
    }

    public Integer getNumber_seats() {
        return number_seats;
    }

    public void setNumber_seats(Integer number_seats) {
        this.number_seats = number_seats;
    }

    public LocalDate getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(LocalDate departure_date) {
        this.departure_date = departure_date;
    }

    public LocalTime getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(LocalTime departure_time) {
        this.departure_time = departure_time;
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
}
