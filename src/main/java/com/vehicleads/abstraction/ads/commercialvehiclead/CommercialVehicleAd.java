package com.vehicleads.abstraction.ads.commercialvehiclead;

import com.vehicleads.abstraction.ads.enginevehiclewithgearboxad.EngineWithGearboxVehicleAd;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@MappedSuperclass
public abstract class CommercialVehicleAd extends EngineWithGearboxVehicleAd {
    @Column(name = "axes_count")
    @NotEmpty
    @Min(1)
    @Max(8)
    private byte axesCount;

    @Column(name = "seats_count")
    @NotEmpty
    @Min(1)
    @Max(50)
    private byte seatsCount;

    @Column(name = "load_capacity_kg")
    @Min(100)
    @Max(100_000)
    private int loadCapacityKg;

    public byte getAxesCount() {
        return axesCount;
    }

    public void setAxesCount(byte axesCount) {
        this.axesCount = axesCount;
    }

    public byte getSeatsCount() {
        return seatsCount;
    }

    public void setSeatsCount(byte seatsCount) {
        this.seatsCount = seatsCount;
    }

    public int getLoadCapacityKg() {
        return loadCapacityKg;
    }

    public void setLoadCapacityKg(int loadCapacityKg) {
        this.loadCapacityKg = loadCapacityKg;
    }
}
