package com.example.ride2taff.dto;

import org.springframework.data.relational.core.sql.In;

import java.time.LocalDate;
import java.time.LocalTime;

public class DisplayRidesByUserDto {
    private String display_name;

    private Integer departure_zip_code;

    private String display_city;

    private LocalDate departure_date;

    private LocalTime departure_time;
    private String status;
    private String arrival_city;

    private Integer id_request;

    private String email;

    public Integer getDeparture_zip_code() {
        return departure_zip_code;
    }

    public void setDeparture_zip_code(Integer departure_zip_code) {
        this.departure_zip_code = departure_zip_code;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getDisplay_city() {
        return display_city;
    }

    public void setDisplay_city(String display_city) {
        this.display_city = display_city;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getArrival_city() {
        return arrival_city;
    }

    public void setArrival_city(String arrival_city) {
        this.arrival_city = arrival_city;
    }

    public Integer getId_request() {
        return id_request;
    }

    public void setId_request(Integer id_request) {
        this.id_request = id_request;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
