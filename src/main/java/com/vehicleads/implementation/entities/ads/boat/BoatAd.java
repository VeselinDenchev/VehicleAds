package com.vehicleads.implementation.entities.ads.boat;

import com.vehicleads.abstraction.ads.enginevehiclead.EngineVehicleAd;
import com.vehicleads.abstraction.ads.interfaces.VehicleLength;
import jakarta.persistence.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "boat_ads")
public class BoatAd extends EngineVehicleAd implements VehicleLength {
    @Column(name = "engines_count", nullable = false)
    @NotEmpty
    @Min(1)
    @Max(4)
    private int enginesCount;

    @Column(name = "length_in_meters", nullable = false)
    @NotEmpty
    @Min(1)
    @Max(100)
    private byte lengthInMeters;

    public int getEnginesCount() {
        return enginesCount;
    }

    public void setEnginesCount(int enginesCount) {
        this.enginesCount = enginesCount;
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
