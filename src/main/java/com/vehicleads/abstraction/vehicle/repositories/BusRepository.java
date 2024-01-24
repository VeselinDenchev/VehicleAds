package com.vehicleads.abstraction.vehicle.repositories;

import com.vehicleads.abstraction.base.repositories.VehicleRepository;
import com.vehicleads.implementation.entities.vehicles.Bus;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BusRepository extends VehicleRepository<Bus> {
    @Transactional(readOnly = true)
    @Query(value = """
           SELECT id, brand_id, model_name FROM vehicle_ads.buses
           ORDER BY model_name 
           """, nativeQuery = true)
    List<Bus> findModels() throws DataAccessException;

    @Transactional(readOnly = true)
    @Query(value = """
           SELECT * FROM vehicle_ads.buses
           WHERE brand_id = :brand_id AND model_name = :model_name
           LIMIT 1
           """, nativeQuery = true)
    Bus findBusByBrandIdAndModel(@Param("brand_id") int brandId, @Param("model_name") String modelName);
}
