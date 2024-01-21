package com.vehicleads.exceptions.user;

public class EmailAlreadyInUseException extends Exception {
    public EmailAlreadyInUseException() {
        super("Email already in use!");
    }
}
