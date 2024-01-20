package com.vehicleads.dtos;

import org.springframework.lang.Nullable;

import java.util.Optional;

public class AdSearchDto {
    private String title = "";
    private boolean isPriceNegotiable = false; // default value
    private @Nullable Double minPrice = null;
    private @Nullable Double maxPrice = null;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getIsPriceNegotiable() {
        return isPriceNegotiable;
    }

    public void setIsPriceNegotiable(boolean isPriceNegotiable) {
        this.isPriceNegotiable = isPriceNegotiable;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(@Nullable Double minPrice) {
        this.minPrice = minPrice;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(@Nullable Double maxPrice) {
        this.maxPrice = maxPrice;
    }
}
