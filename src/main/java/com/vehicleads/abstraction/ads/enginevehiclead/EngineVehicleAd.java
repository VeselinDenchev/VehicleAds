package com.vehicleads.abstraction.ads.enginevehiclead;

import com.vehicleads.abstraction.ads.vehiclead.VehicleAd;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@MappedSuperclass
public abstract class EngineVehicleAd extends VehicleAd {
    @Column(name = "engine_type")
    @NotEmpty
    private EngineType engineType;

    @Column(name = "horse_power")
    @Min(1)
    @Max(3_000)
    private int engineHorsePower;

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public int getEngineHorsePower() {
        return engineHorsePower;
    }

    public void setEngineHorsePower(int engineHorsePower) {
        this.engineHorsePower = engineHorsePower;
    }
}
