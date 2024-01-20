package com.vehicleads.exceptions.base;

public class EntityNotFoundException extends Exception {
    public EntityNotFoundException(String entityName) {
        super(String.format("%s is not found", entityName));
    }
}
