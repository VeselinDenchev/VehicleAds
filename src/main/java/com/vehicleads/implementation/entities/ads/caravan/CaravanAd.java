package com.vehicleads.implementation.entities.ads.caravan;

import com.vehicleads.abstraction.ads.vehiclead.VehicleAd;
import com.vehicleads.abstraction.ads.interfaces.VehicleLength;
import com.vehicleads.implementation.entities.vehicles.Car;
import com.vehicleads.implementation.entities.vehicles.Caravan;
import jakarta.persistence.*;

import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "caravan_ads")
public class CaravanAd extends VehicleAd implements VehicleLength {
    @ManyToOne
    @JoinColumn(name = "caravan_id")
    private Caravan caravan;

    @Column(name = "length_in_meters")
    @NotEmpty
    private byte lengthInMeters;

    public Caravan getCaravan() {
        return caravan;
    }

    public void setCaravan(Caravan caravan) {
        this.caravan = caravan;
    }

    @Override
    public byte getLengthInMeters() {
        return lengthInMeters;
    }
}
