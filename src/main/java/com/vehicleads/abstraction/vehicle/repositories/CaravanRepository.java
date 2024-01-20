package com.vehicleads.abstraction.vehicle.repositories;

import com.vehicleads.abstraction.base.repositories.VehicleRepository;
import com.vehicleads.implementation.entities.vehicles.Caravan;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CaravanRepository extends VehicleRepository<Caravan> {
    @Transactional(readOnly = true)
    @Query(value = """
           SELECT brand_id, model_name FROM vehicle_ads.caravans
           ORDER BY model_name 
           """, nativeQuery = true)
    List<Caravan> findModels() throws DataAccessException;
}
