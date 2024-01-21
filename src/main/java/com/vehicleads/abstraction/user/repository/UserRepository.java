package com.vehicleads.abstraction.user.repository;

import com.vehicleads.abstraction.base.repositories.BaseRepository;
import com.vehicleads.implementation.entities.user.UserEntity;

import java.util.Optional;

public interface UserRepository extends BaseRepository<UserEntity, Integer> {
    boolean existsByEmail(String email);
    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findByUsername(String username);
}
