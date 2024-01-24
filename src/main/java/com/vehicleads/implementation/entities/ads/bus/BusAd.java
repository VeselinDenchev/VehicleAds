package com.vehicleads.implementation.entities.ads.bus;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.vehicleads.abstraction.ads.commercialvehiclead.CommercialVehicleAd;
import com.vehicleads.implementation.entities.vehicles.Bus;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bus_ads")
public class BusAd extends CommercialVehicleAd {
    @ManyToOne
    @JoinColumn(name = "bus_id", nullable = false)
    @JsonBackReference
    private Bus bus;

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }
}
