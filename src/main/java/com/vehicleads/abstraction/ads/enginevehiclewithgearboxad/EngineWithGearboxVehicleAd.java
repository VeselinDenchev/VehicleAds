package com.vehicleads.abstraction.ads.enginevehiclewithgearboxad;

import com.vehicleads.abstraction.ads.enginevehiclead.EngineVehicleAd;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@MappedSuperclass
public abstract class EngineWithGearboxVehicleAd extends EngineVehicleAd {
    @Column(name = "mileage")
    @NotEmpty
    @Min(0)
    private int mileage;

    @Column(name = "gearbox")
    @NotEmpty
    private Gearbox gearbox;

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public Gearbox getGearbox() {
        return gearbox;
    }

    public void setGearbox(Gearbox gearbox) {
        this.gearbox = gearbox;
    }
}
