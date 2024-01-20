package com.vehicleads.abstraction.ads.repositories;

import com.vehicleads.abstraction.base.repositories.AdRepository;
import com.vehicleads.implementation.entities.ads.truck.TruckAd;
import com.vehicleads.implementation.entities.vehicles.Truck;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TruckAdRepository extends AdRepository<TruckAd> {
    @Transactional(readOnly = true)
    @Query(value = """
           SELECT * FROM vehicle_ads.boats
           WHERE :title IS NULL OR title = :title
           """, nativeQuery = true)
    List<TruckAd> find(@Param("title") String title);
}
