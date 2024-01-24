package com.vehicleads.implementation.entities.vehicles;

import com.vehicleads.abstraction.vehicle.Vehicle;
import com.vehicleads.implementation.entities.ads.truck.TruckAd;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "trucks")
public class Truck extends Vehicle {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "truck")
    private List<TruckAd> ads;

    public List<TruckAd> getAds() {
        return ads;
    }
}
