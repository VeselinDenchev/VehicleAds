package com.vehicleads.abstraction.brand.repository;

import com.vehicleads.abstraction.base.repositories.BaseRepository;
import com.vehicleads.implementation.entities.brand.Brand;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BrandRepository extends BaseRepository<Brand, Integer> {
    @Transactional(readOnly = true)
    @Query(value = """
           SELECT DISTINCT br.id, br.name FROM vehicle_ads.brands AS br
           INNER JOIN vehicle_ads.boats AS bo ON br.id = bo.brand_id
           ORDER BY br.name
           """, nativeQuery = true)
    List<Brand> findAllBoatBrands();

    @Transactional(readOnly = true)
    @Query(value = """
           SELECT DISTINCT br.id, br.name FROM vehicle_ads.brands AS br
           INNER JOIN vehicle_ads.buses AS bu ON br.id = bu.brand_id
           ORDER BY br.name
           """, nativeQuery = true)
    List<Brand> findAllBusBrands();

    @Transactional(readOnly = true)
    @Query(value = """
           SELECT DISTINCT b.id, b.name FROM vehicle_ads.brands AS b
           INNER JOIN vehicle_ads.cars AS c ON b.id = c.brand_id
           ORDER BY b.name
           """, nativeQuery = true)
    List<Brand> findAllCarBrands();

    @Transactional(readOnly = true)
    @Query(value = """
           SELECT DISTINCT b.id, b.name FROM vehicle_ads.brands AS b
           INNER JOIN vehicle_ads.caravans AS c ON b.id = c.brand_id
           ORDER BY b.name
           """, nativeQuery = true)
    List<Brand> findAllCaravanBrands();

    @Transactional(readOnly = true)
    @Query(value = """
           SELECT DISTINCT b.id, b.name FROM vehicle_ads.brands AS b
           INNER JOIN vehicle_ads.motorcycles AS m ON b.id = m.brand_id
           ORDER BY b.name
           """, nativeQuery = true)
    List<Brand> findAllMotorcycleBrands();

    @Transactional(readOnly = true)
    @Query(value = """
           SELECT DISTINCT b.id, b.name FROM vehicle_ads.brands AS b
           INNER JOIN vehicle_ads.trucks AS t ON b.id = t.brand_id
           ORDER BY b.name
           """, nativeQuery = true)
    List<Brand> findAllTruckBrands();
}
