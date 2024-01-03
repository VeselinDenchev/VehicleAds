package com.vehicleads.abstraction.ads.vehiclead;

import com.vehicleads.abstraction.base.entity.BaseEntity;
import jakarta.persistence.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class VehicleAd extends BaseEntity<Integer> {
    @Column(name = "vehicle_condition")
    @NotEmpty
    private VehicleCondition vehicleCondition;

    @Column(name = "is_price_negotiable")
    @NotEmpty
    private boolean isPriceNegotiable;

    @Column(name = "price", nullable = true)
    @Min(0)
    private double price;

    @Column(name = "mileage")
    @NotEmpty
    @Min(0)
    private int mileage;

    @Column(name = "manufacture_year")
    @NotEmpty
    @Min(1900)
    @Max(2023)
    private short manufactureYear;

    @Column(name = "populated_place")
    @NotEmpty
    @Size(min = 2, max = 50)
    private String populatedPlace;

    @Column(name = "color")
    @Size(min = 2, max = 20)
    private String color;

    @Column(name = "imageUrl")
    @Size(min = 2, max = 50)
    private String imageUrl;

    @Column(name = "description")
    @Size(max = 200)
    private String description;

    public VehicleCondition getVehicleCondition() {
        return vehicleCondition;
    }

    public void setVehicleCondition(VehicleCondition condition) {
        this.vehicleCondition = condition;
    }

    public boolean isPriceNegotiable() {
        return isPriceNegotiable;
    }

    public void setPriceNegotiable(boolean isPriceNegotiable) {
        this.isPriceNegotiable = isPriceNegotiable;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public short getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(short manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public String getPopulatedPlace() {
        return populatedPlace;
    }

    public void setPopulatedPlace(String populatedPlace) {
        this.populatedPlace = populatedPlace;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
