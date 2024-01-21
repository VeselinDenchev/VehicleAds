package com.vehicleads.dtos.authentication;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserRegistrationDto {
    @Email
    @NotEmpty
    @Size(min = 5, max = 50)
    private String email;

    @NotEmpty
    @Size(min = 8, max = 50)
    private String password;

    @NotEmpty
    @Size(min = 2, max = 20)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 20)
    @NotEmpty
    private String lastName;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String populatedPlace;

    @NotEmpty
    @Size(min = 8, max = 20)
    @NotEmpty
    private String phoneNumber;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPopulatedPlace() {
        return populatedPlace;
    }

    public void setPopulatedPlace(String populatedPlace) {
        this.populatedPlace = populatedPlace;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
