package com.vehicleads.implementation.entities.ads.motorcycle;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.vehicleads.abstraction.ads.enginevehiclewithgearboxad.EngineWithGearboxVehicleAd;
import com.vehicleads.implementation.entities.vehicles.Motorcycle;
import jakarta.persistence.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "motorcycle_ads")
public class MotorcycleAd extends EngineWithGearboxVehicleAd {
    @ManyToOne
    @JoinColumn(name = "motorcycle_id", nullable = false)
    @JsonBackReference
    private Motorcycle motorcycle;

    @Column(name = "engine_capacity", nullable = false)
    @NotEmpty
    @Min(30)
    @Max(5_000)
    private short engineCapacity;

    public Motorcycle getMotorcycle() {
        return motorcycle;
    }

    public void setMotorcycle(Motorcycle motorcycle) {
        this.motorcycle = motorcycle;
    }

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
