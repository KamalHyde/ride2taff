package com.example.ride2taff.dto;

import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.time.LocalTime;

public class AddRideDto {
    private Integer departure_zip_code;
    private String departure_city;
    private Integer arrival_zip_code;
    private String arrival_city;
    private Integer number_seats;
    private LocalDate departure_date;
    private LocalTime departure_time;
    private Integer user_id;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
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
}
