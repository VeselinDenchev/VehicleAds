package com.vehicleads.implementation.entities.ads.caravan;

import com.vehicleads.abstraction.ads.ad.Ad;
import com.vehicleads.abstraction.ads.interfaces.VehicleLength;
import jakarta.persistence.*;

import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "caravan_ads")
public class CaravanAd extends Ad implements VehicleLength {
    @Column(name = "length_in_meters", nullable = false)
    @NotEmpty
    private byte lengthInMeters;

    @Override
    public byte getLengthInMeters() {
        return lengthInMeters;
    }

    @Override
    public void setLengthInMeters(byte lengthInMeters) {
        this.lengthInMeters = lengthInMeters;
    }
}
