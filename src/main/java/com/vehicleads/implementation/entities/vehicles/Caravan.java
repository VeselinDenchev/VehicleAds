package com.vehicleads.implementation.entities.vehicles;

import com.vehicleads.abstraction.vehicle.Vehicle;
import com.vehicleads.implementation.entities.ads.caravan.CaravanAd;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "caravans")
public class Caravan extends Vehicle {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "caravan")
    private List<CaravanAd> ads;

    public List<CaravanAd> getAds() {
        return ads;
    }
}
