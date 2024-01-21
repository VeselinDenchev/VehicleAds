package com.vehicleads.implementation.entities.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vehicleads.abstraction.base.entity.BaseEntity;
import com.vehicleads.implementation.entities.ads.boat.BoatAd;
import com.vehicleads.implementation.entities.ads.bus.BusAd;
import com.vehicleads.implementation.entities.ads.car.CarAd;
import com.vehicleads.implementation.entities.ads.caravan.CaravanAd;
import com.vehicleads.implementation.entities.ads.truck.TruckAd;
import jakarta.persistence.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity<Integer> {
    @Column(name = "email", nullable = false)
    @Email
    @NotEmpty
    @Size(min = 5, max = 50)
    private String email;

    @Column(name = "username", nullable = false)
    @NotEmpty
    @Size(min = 5, max = 50)
    private String username;

    @Column(name = "password_hash", nullable = false)
    @NotEmpty
    private String passwordHash;

    @Column(name = "first_name", nullable = false)
    @Size(min = 2, max = 20)
    @NotEmpty
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @Size(min = 2, max = 20)
    @NotEmpty
    private String lastName;

    @Column(name = "populated_place", nullable = false)
    @NotEmpty
    @Size(min = 2, max = 50)
    private String populatedPlace;

    @Column(name = "phone_number", nullable = false)
    @Size(min = 8, max = 20)
    @NotEmpty
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonManagedReference
    private List<BoatAd> boatAds;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonManagedReference
    private List<BusAd> busAds;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonManagedReference
    private List<CarAd> carAds;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonManagedReference
    private List<CaravanAd> caravanAds;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonManagedReference
    private List<TruckAd> truckAds;

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
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

    public List<BoatAd> getBoatAds() {
        return boatAds;
    }

    public void setBoatAds(List<BoatAd> boatAds) {
        this.boatAds = boatAds;
    }

    public List<BusAd> getBusAds() {
        return busAds;
    }

    public void setBusAds(List<BusAd> busAds) {
        this.busAds = busAds;
    }

    public List<CarAd> getCarAds() {
        return carAds;
    }

    public void setCarAds(List<CarAd> carAds) {
        this.carAds = carAds;
    }

    public List<CaravanAd> getCaravanAds() {
        return caravanAds;
    }

    public void setCaravanAds(List<CaravanAd> caravanAds) {
        this.caravanAds = caravanAds;
    }

    public List<TruckAd> getTruckAds() {
        return truckAds;
    }

    public void setTruckAds(List<TruckAd> truckAds) {
        this.truckAds = truckAds;
    }
}
