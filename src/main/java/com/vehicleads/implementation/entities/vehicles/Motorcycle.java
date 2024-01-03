package com.vehicleads.implementation.entities.vehicles;


import com.vehicleads.abstraction.vehicle.Vehicle;
import com.vehicleads.implementation.entities.ads.motorcycle.MotorcycleAd;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "motorcycles")
public class Motorcycle extends Vehicle {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "motorcycle")
    private List<MotorcycleAd> ads;

    public List<MotorcycleAd> getAds() {
        return ads;
    }
}
