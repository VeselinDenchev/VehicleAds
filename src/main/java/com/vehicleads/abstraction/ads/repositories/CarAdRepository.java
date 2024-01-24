package com.vehicleads.abstraction.ads.repositories;

import com.vehicleads.abstraction.base.repositories.AdRepository;
import com.vehicleads.implementation.entities.ads.car.CarAd;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CarAdRepository extends AdRepository<CarAd> {
    @Transactional(readOnly = true)
    @Query(value = """
           SELECT user_id FROM vehicle_ads.car_ads
           WHERE id = :ad_id
           """, nativeQuery = true)
    int findUserId(@Param("ad_id") int adId);

    @Transactional(readOnly = true)
    @Query(value = """
           SELECT * FROM vehicle_ads.car_ads
           WHERE user_id = :user_id
           """, nativeQuery = true)
    List<CarAd> findAllByUserId(@Param("user_id") int userId);
}
