package com.example.ride2taff.dto;

public class SearchRideDto {
    private Integer departure_zip_code;
    private Integer jour;
    private Integer mois;
    private Integer annee;

    public Integer getDeparture_zip_code() {
        return departure_zip_code;
    }

    public void setDeparture_zip_code(Integer departure_zip_code) {
        this.departure_zip_code = departure_zip_code;
    }

    public Integer getJour() {
        return jour;
    }

    public void setJour(Integer jour) {
        this.jour = jour;
    }

    public Integer getMois() {
        return mois;
    }

    public void setMois(Integer mois) {
        this.mois = mois;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }
}
