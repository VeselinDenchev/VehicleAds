package com.vehicleads.implementation.entities.ads.caravan;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.vehicleads.abstraction.ads.ad.Ad;
import com.vehicleads.abstraction.ads.interfaces.VehicleLength;
import com.vehicleads.implementation.entities.vehicles.Caravan;
import jakarta.persistence.*;

import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "caravan_ads")
public class CaravanAd extends Ad implements VehicleLength {
    @ManyToOne
    @JoinColumn(name = "caravan_id", nullable = false)
    @JsonBackReference
    private Caravan caravan;

    @Column(name = "length_in_meters", nullable = false)
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

    @Override
    public void setLengthInMeters(byte lengthInMeters) {
        this.lengthInMeters = lengthInMeters;
    }
}
