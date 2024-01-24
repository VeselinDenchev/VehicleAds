package com.vehicleads.abstraction.vehicle.repository;

import com.vehicleads.abstraction.base.repositories.BaseRepository;
import com.vehicleads.implementation.entities.vehicle.Vehicle;
import com.vehicleads.implementation.entities.vehicle.VehicleType;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface VehicleRepository extends BaseRepository<Vehicle, Integer> {
    @Transactional(readOnly = true)
    @Query(value = """
           SELECT * FROM vehicle_ads.vehicles
           WHERE vehicle_type = :vehicle_type
           ORDER BY model_name 
           """, nativeQuery = true)
    List<Vehicle> findModels(@Param("vehicle_type") VehicleType vehicleType) throws DataAccessException;

    @Transactional(readOnly = true)
    @Query(value = """
           SELECT * FROM vehicle_ads.vehicles
           WHERE brand_id = :brand_id AND model_name = :model_name AND vehicle_type = :vehicle_type
           LIMIT 1
           """, nativeQuery = true)
    Vehicle findVehicleByBrandIdAndModel(@Param("brand_id") int brandId,
                                             @Param("model_name") String modelName,
                                             @Param("vehicle_type") VehicleType vehicleType);
}
