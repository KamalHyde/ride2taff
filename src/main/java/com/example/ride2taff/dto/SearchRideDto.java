package com.example.ride2taff.dto;

import java.time.LocalDate;

public class SearchRideDto {
    private Integer departure_zip_code;

    private LocalDate departure_date;

    public LocalDate getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(LocalDate departure_date) {
        this.departure_date = departure_date;
    }

    public Integer getDeparture_zip_code() {
        return departure_zip_code;
    }

    public void setDeparture_zip_code(Integer departure_zip_code) {
        this.departure_zip_code = departure_zip_code;
    }

}
