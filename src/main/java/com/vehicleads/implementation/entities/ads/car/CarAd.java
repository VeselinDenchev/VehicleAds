package com.vehicleads.implementation.entities.ads.car;

import com.vehicleads.abstraction.ads.enginevehiclewithgearboxad.EngineWithGearboxVehicleAd;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "car_ads")
public class CarAd extends EngineWithGearboxVehicleAd {
}
