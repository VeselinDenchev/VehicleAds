package com.vehicleads.implementation.entities.vehicles;

import com.vehicleads.abstraction.vehicle.Vehicle;
import com.vehicleads.implementation.entities.ads.car.CarAd;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "cars")
public class Car extends Vehicle {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "car")
    private List<CarAd> ads;

    public List<CarAd> getAds() {
        return ads;
    }
}
