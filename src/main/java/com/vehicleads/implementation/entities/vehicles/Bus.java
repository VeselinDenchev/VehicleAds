package com.vehicleads.implementation.entities.vehicles;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vehicleads.abstraction.vehicle.Vehicle;
import com.vehicleads.implementation.entities.ads.bus.BusAd;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "buses")
public class Bus extends Vehicle {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bus")
    @JsonManagedReference
    private List<BusAd> ads;

    public List<BusAd> getAds() {
        return ads;
    }
}
