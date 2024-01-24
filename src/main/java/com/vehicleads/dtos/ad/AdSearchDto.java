package com.vehicleads.dtos.ad;

import org.springframework.lang.Nullable;

public class AdSearchDto {
    private String title = "";
    private boolean isPriceNegotiable = false; // default value
    private @Nullable Integer minPrice = null;
    private @Nullable Integer maxPrice = null;

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

    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(@Nullable Integer minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(@Nullable Integer maxPrice) {
        this.maxPrice = maxPrice;
    }
}
