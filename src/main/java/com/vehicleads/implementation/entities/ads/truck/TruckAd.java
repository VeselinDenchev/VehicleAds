package com.vehicleads.implementation.entities.ads.truck;

import com.vehicleads.abstraction.ads.commercialvehiclead.CommercialVehicleAd;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "truck_ads")
public class TruckAd extends CommercialVehicleAd {
}
