package com.vehicleads.abstraction.base.entity;

import java.io.Serializable;

public interface Identity<T extends Serializable> {
    T getId();

    void setId(T id);
}
