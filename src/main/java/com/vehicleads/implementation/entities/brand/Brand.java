package com.vehicleads.implementation.entities.brand;

import com.vehicleads.abstraction.base.entity.BaseEntity;
import com.vehicleads.abstraction.vehicle.Vehicle;
import jakarta.persistence.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity<Integer> {
    @Column(name = "name", unique = true)
    @NotEmpty
    @Size(min = 2, max = 30)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
