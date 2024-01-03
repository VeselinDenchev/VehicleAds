package com.vehicleads.implementation.entities.ads.truck;

import com.vehicleads.abstraction.ads.commercialvehiclead.CommercialVehicleAd;
import com.vehicleads.implementation.entities.vehicles.Truck;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "truck_ads")
public class TruckAd extends CommercialVehicleAd {
    @ManyToOne
    @JoinColumn(name = "truck_id")
    private Truck truck;

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }
}
