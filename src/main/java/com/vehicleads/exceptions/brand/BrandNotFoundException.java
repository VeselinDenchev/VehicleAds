package com.vehicleads.exceptions.brand;

import com.vehicleads.exceptions.base.EntityNotFoundException;

public class BrandNotFoundException extends EntityNotFoundException {
    public BrandNotFoundException() {
        super("Brand");
    }
}