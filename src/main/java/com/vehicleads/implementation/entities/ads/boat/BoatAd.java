package com.vehicleads.implementation.entities.ads.boat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.vehicleads.abstraction.ads.enginevehiclead.EngineVehicleAd;
import com.vehicleads.abstraction.ads.interfaces.VehicleLength;
import com.vehicleads.implementation.entities.vehicles.Boat;
import jakarta.persistence.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "boat_ads")
public class BoatAd extends EngineVehicleAd implements VehicleLength {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "boat_id", nullable = false)
    @JsonBackReference
    private Boat boat;

    @Column(name = "length_in_meters", nullable = false)
    @NotEmpty
    @Min(1)
    @Max(100)
    private byte lengthInMeters;

    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
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
