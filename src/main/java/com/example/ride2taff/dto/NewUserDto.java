package com.example.ride2taff.dto;

import javax.persistence.Column;

public class NewUserDto {
    private String first_name;

    private String last_name;

    private String email;

    private String email_validation;

    private String password;

    private String password_validation;

    public String getEmail_validation() {
        return email_validation;
    }

    public void setEmail_validation(String email_validation) {
        this.email_validation = email_validation;
    }

    public String getPassword_validation() {
        return password_validation;
    }

    public void setPassword_validation(String password_validation) {
        this.password_validation = password_validation;
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
}
