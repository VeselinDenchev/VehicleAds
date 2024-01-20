package com.vehicleads.abstraction.ads.enginevehiclead;

import com.vehicleads.abstraction.ads.ad.Ad;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@MappedSuperclass
public abstract class EngineVehicleAd extends Ad {
    @Column(name = "engine_type", nullable = false)
    @NotEmpty
    private EngineType engineType;

    @Column(name = "horse_power", nullable = false)
    @Min(1)
    @Max(3_000)
    private int horsePower;

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
}
