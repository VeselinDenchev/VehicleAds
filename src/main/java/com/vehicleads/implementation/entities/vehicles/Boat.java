package com.vehicleads.implementation.entities.vehicles;

import com.vehicleads.abstraction.vehicle.Vehicle;
import com.vehicleads.implementation.entities.ads.boat.BoatAd;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "boats")
public class Boat extends Vehicle {
    @OneToMany(mappedBy = "boat")
    private List<BoatAd> ads;

    public List<BoatAd> getAds() {
        return ads;
    }
}
