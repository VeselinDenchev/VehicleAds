package com.vehicleads.exceptions.user;

public class PasswordNotMatchedException extends Exception {
    public PasswordNotMatchedException() {
        super("Password and Cofirm Password don't match!");
    }
}
