package com.vehicleads.abstraction.vehicle.repositories;

import com.vehicleads.abstraction.base.repositories.VehicleRepository;
import com.vehicleads.implementation.entities.vehicles.Motorcycle;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MotorcycleRepository extends VehicleRepository<Motorcycle> {
    @Transactional(readOnly = true)
    @Query(value = """
           SELECT id, brand_id, model_name FROM vehicle_ads.motorcycles
           ORDER BY model_name 
           """, nativeQuery = true)
    List<Motorcycle> findModels() throws DataAccessException;

    @Transactional(readOnly = true)
    @Query(value = """
           SELECT * FROM vehicle_ads.motorcycles
           WHERE brand_id = :brand_id AND model_name = :model_name
           LIMIT 1
           """, nativeQuery = true)
    Motorcycle findMotorcycleByBrandIdAndModel(@Param("brand_id") int brandId, @Param("model_name") String modelName);
}
