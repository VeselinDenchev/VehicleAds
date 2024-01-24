package com.vehicleads.implementation.entities.vehicle;

import com.vehicleads.abstraction.base.entity.BaseEntity;
import com.vehicleads.implementation.entities.brand.Brand;
import jakarta.persistence.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(
        name = "vehicles",
        uniqueConstraints = {
                @UniqueConstraint(name = "UQ_brand_model_name_vehicle_type",
                                  columnNames = {"brand_id", "model_name", "vehicle_type"})
        }
)
public class Vehicle extends BaseEntity<Integer> {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Column(name = "model_name")
    @Size(min = 2, max = 30)
    private String modelName;

    @Column(name = "vehicle_type")
    @NotEmpty
    private VehicleType vehicleType;

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getModelName() { return modelName; }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
