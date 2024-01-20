package com.vehicleads.implementation.entities.vehicles;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vehicleads.abstraction.vehicle.Vehicle;
import com.vehicleads.implementation.entities.ads.boat.BoatAd;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "boats")
public class Boat extends Vehicle {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "boat")
    @JsonManagedReference
    private List<BoatAd> ads;

    public List<BoatAd> getAds() {
        return ads;
    }
}
