package com.vehicleads.abstraction.base.repositories;

import com.vehicleads.abstraction.vehicle.Vehicle;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface VehicleRepository<T extends Vehicle> extends BaseRepository<T, Integer> {
    List<? extends Vehicle> findModels() throws DataAccessException;
}
