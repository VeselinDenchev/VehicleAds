package com.vehicleads.exceptions.ad;

import com.vehicleads.exceptions.base.EntityNotFoundException;

public class AdNotFoundException extends EntityNotFoundException {
    public AdNotFoundException() {
        super("Ad");
    }
}
