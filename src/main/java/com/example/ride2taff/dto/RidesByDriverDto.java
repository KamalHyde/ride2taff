package com.example.ride2taff.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class RidesByDriverDto {
    private Integer id;
    private String displayDepartureAddress;

    private String displayArrivalAddress;

    private LocalDate departure_date;

    private LocalTime departure_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDisplayDepartureAddress() {
        return displayDepartureAddress;
    }

    public void setDisplayDepartureAddress(String displayDepartureAddress) {
        this.displayDepartureAddress = displayDepartureAddress;
    }

    public String getDisplayArrivalAddress() {
        return displayArrivalAddress;
    }

    public void setDisplayArrivalAddress(String displayArrivalAddress) {
        this.displayArrivalAddress = displayArrivalAddress;
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
