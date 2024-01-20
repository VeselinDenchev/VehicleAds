package com.vehicleads.abstraction.vehicle;

import com.vehicleads.abstraction.base.entity.BaseEntity;
import com.vehicleads.implementation.entities.brand.Brand;
import jakarta.persistence.*;

import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class Vehicle extends BaseEntity<Integer> {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Column(name = "modelName", unique = true)
    @Size(min = 2, max = 30)
    private String modelName;

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

    public String getFullName() {
        return brand.getName() + " " + modelName;
    }
}
