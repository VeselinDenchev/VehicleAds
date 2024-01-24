package com.vehicleads.implementation.entities.vehicle;

public enum VehicleType {
    Boat,
    Bus,
    Car,
    Caravan,
    Motorcycle,
    Truck;

    public static VehicleType valueOfIgnoreCase(String value) {
        for (VehicleType v : values()) {
            if (v.name().equalsIgnoreCase(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with text " + value + " found");
    }
}
