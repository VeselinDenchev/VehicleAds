package com.vehicleads.abstraction.brand.repository;

import com.vehicleads.abstraction.base.repositories.BaseRepository;
import com.vehicleads.implementation.entities.vehicle.VehicleType;
import com.vehicleads.implementation.entities.brand.Brand;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BrandRepository extends BaseRepository<Brand, Integer> {
    @Transactional(readOnly = true)
    @Query(value = """
           SELECT DISTINCT br.id, br.name FROM vehicle_ads.brands AS br
           INNER JOIN vehicle_ads.vehicles AS v ON br.id = v.brand_id
           WHERE v.vehicle_type = :vehicle_type
           ORDER BY br.name
           """, nativeQuery = true)
    List<Brand> findAllVehicleBrands(@Param("vehicle_type") VehicleType vehicleType);
}
