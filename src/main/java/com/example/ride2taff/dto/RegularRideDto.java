package com.example.ride2taff.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class RegularRideDto {
    private Integer departure_zip_code;
    private String departure_city;
    private Integer arrival_zip_code;
    private String arrival_city;
    private Integer number_seats;
    private LocalTime departure_time;
    private LocalDate start_date;
    private LocalDate end_date;
    private String status;
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

    public LocalTime getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(LocalTime departure_time) {
        this.departure_time = departure_time;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
