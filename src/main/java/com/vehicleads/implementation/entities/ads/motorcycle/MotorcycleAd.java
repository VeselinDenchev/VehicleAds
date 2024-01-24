package com.vehicleads.implementation.entities.ads.motorcycle;

import com.vehicleads.abstraction.ads.enginevehiclewithgearboxad.EngineWithGearboxVehicleAd;
import jakarta.persistence.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "motorcycle_ads")
public class MotorcycleAd extends EngineWithGearboxVehicleAd {
    @Column(name = "engine_capacity", nullable = false)
    @NotEmpty
    @Min(30)
    @Max(5_000)
    private short engineCapacity;

    @Column(name = "cooling_type", nullable = false)
    @NotEmpty
    private CoolingType coolingType;

    public short getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(short engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public CoolingType getCoolingType() {
        return coolingType;
    }

    public void setCoolingType(CoolingType coolingType) {
        this.coolingType = coolingType;
    }
}
