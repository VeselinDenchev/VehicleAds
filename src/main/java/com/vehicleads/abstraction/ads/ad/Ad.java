package com.vehicleads.abstraction.ads.ad;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.vehicleads.abstraction.base.entity.BaseEntity;
import com.vehicleads.implementation.entities.vehicle.Vehicle;
import com.vehicleads.implementation.entities.user.UserEntity;
import jakarta.persistence.*;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@MappedSuperclass
public class Ad extends BaseEntity<Integer> {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_id", nullable = false)
    @JsonBackReference
    private Vehicle vehicle;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private UserEntity user;

    @Column(name = "title", nullable = false)
    @NotEmpty
    @Size(min = 2, max = 50)
    private String title;

    @Column(name = "vehicle_condition", nullable = false)
    @NotEmpty
    private VehicleCondition vehicleCondition;

    @Column(name = "is_price_negotiable", nullable = false)
    @NotEmpty
    private boolean isPriceNegotiable;

    @Column(name = "price", nullable = true)
    @Min(0)
    private Integer price;

    @Column(name = "manufacture_year", nullable = false)
    @NotEmpty
    @Min(1_900)
    @Max(2_024)
    private short manufactureYear;

    @Column(name = "color")
    @Size(min = 2, max = 20)
    private String color;

    @Column(name = "imageUrl")
    @Size(min = 2, max = 200)
    private String imageUrl;

    @Column(name = "description")
    @Size(max = 200)
    private String description;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public VehicleCondition getVehicleCondition() {
        return vehicleCondition;
    }

    public void setVehicleCondition(VehicleCondition condition) {
        this.vehicleCondition = condition;
    }

    public boolean getIsPriceNegotiable() {
        return isPriceNegotiable;
    }

    public void setIsPriceNegotiable(boolean isPriceNegotiable) {
        this.isPriceNegotiable = isPriceNegotiable;
    }

    @Nullable
    public Integer getPrice() {
        return price;
    }

    public void setPrice(@Nullable Integer price) {
        this.price = price;
    }

    public short getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(short manufactureYear) {
        this.manufactureYear = manufactureYear;
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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
