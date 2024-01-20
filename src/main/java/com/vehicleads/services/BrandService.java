package com.vehicleads.services;

import com.vehicleads.abstraction.brand.repository.BrandRepository;
import com.vehicleads.exceptions.vehicle.InvalidVehicleTypeException;
import com.vehicleads.implementation.entities.brand.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    public List<Brand> findAllBrandsByVehicleType(String vehicleType) throws InvalidVehicleTypeException {
        Optional<List<Brand>> result = switch (vehicleType.toLowerCase()) {
            case "boat" -> Optional.of(brandRepository.findAllBoatBrands());
            case "bus" -> Optional.of(brandRepository.findAllBusBrands());
            case "car" -> Optional.of(brandRepository.findAllCarBrands());
            case "caravan" -> Optional.of(brandRepository.findAllCaravanBrands());
            case "motorcycle" -> Optional.of(brandRepository.findAllMotorcycleBrands());
            case "truck" -> Optional.of(brandRepository.findAllTruckBrands());
            default -> Optional.empty();
        };

        if (result.isPresent()) return result.get();

        throw new InvalidVehicleTypeException();
    }
}
