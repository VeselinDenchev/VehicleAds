package com.vehicleads.exceptions.user;

public class UnauthorizedException extends Exception {
    public UnauthorizedException(String message) {
        super(message);
    }

    public UnauthorizedException() {
        super("User is unauthorized to complete the operation");
    }
}
