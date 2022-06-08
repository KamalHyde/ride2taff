package com.example.ride2taff.dto;

import java.time.LocalDate;
import java.time.LocalTime;


public class UsersByRideDto {

    private Integer id;

    private String display_departure_address;

    private String display_arrival_address;

    private Integer number_seats;

    private LocalDate departure_date;

    private LocalTime departure_time;

    private String display_user_name;

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisplay_user_name() {
        return display_user_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDisplay_user_name(String display_user_name) {
        this.display_user_name = display_user_name;
    }

    public String getDisplay_departure_address() {
        return display_departure_address;
    }

    public void setDisplay_departure_address(String display_departure_address) {
        this.display_departure_address = display_departure_address;
    }

    public String getDisplay_arrival_address() {
        return display_arrival_address;
    }

    public void setDisplay_arrival_address(String display_arrival_address) {
        this.display_arrival_address = display_arrival_address;
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
