package com.vehicleads.abstraction.base.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@MappedSuperclass
public abstract class BaseEntity<T extends Serializable> implements Identity<T>, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private T id;

    @Override public T getId() {
        return id;
    }
}
