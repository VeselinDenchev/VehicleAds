package com.vehicleads.implementation.entities.ads.car;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.vehicleads.abstraction.ads.enginevehiclewithgearboxad.EngineWithGearboxVehicleAd;
import com.vehicleads.implementation.entities.vehicles.Car;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "car_ads")
public class CarAd extends EngineWithGearboxVehicleAd {
    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    @JsonBackReference
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
