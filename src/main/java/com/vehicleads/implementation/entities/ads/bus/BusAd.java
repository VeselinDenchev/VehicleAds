package com.vehicleads.implementation.entities.ads.bus;

import com.vehicleads.abstraction.ads.commercialvehiclead.CommercialVehicleAd;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "bus_ads")
public class BusAd extends CommercialVehicleAd {
}
