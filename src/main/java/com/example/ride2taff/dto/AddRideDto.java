package com.example.ride2taff.dto;

public class AddRideDto {
    private Integer departure_zip_code;
    private String departure_city;
    private Integer arrival_zip_code;
    private String arrival_city;
    private Integer number_seats;
    private Integer year;
    private Integer month;
    private Integer day;
    private Integer hour;
    private Integer minute;

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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }
}
