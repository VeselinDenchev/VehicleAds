package com.vehicleads.abstraction.vehicle.repositories;

import com.vehicleads.abstraction.base.repositories.VehicleRepository;
import com.vehicleads.implementation.entities.vehicles.Motorcycle;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MotorcycleRepository extends VehicleRepository<Motorcycle> {
    @Transactional(readOnly = true)
    @Query(value = """
           SELECT brand_id, model_name FROM vehicle_ads.motorcycle
           ORDER BY model_name 
           """, nativeQuery = true)
    List<Motorcycle> findModels() throws DataAccessException;
}
