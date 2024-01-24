package com.vehicleads.implementation.services.brand;

import com.vehicleads.abstraction.brand.repository.BrandRepository;
import com.vehicleads.implementation.entities.vehicle.VehicleType;
import com.vehicleads.exceptions.vehicle.InvalidVehicleTypeException;
import com.vehicleads.implementation.entities.brand.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    public List<Brand> findAllBrandsByVehicleType(String vehicleTypeString) throws InvalidVehicleTypeException {
        try {
            VehicleType vehicleType = VehicleType.valueOfIgnoreCase(vehicleTypeString.toLowerCase());
            List<Brand> brands = brandRepository.findAllVehicleBrands(vehicleType);

            return brands;
        }
        catch (IllegalArgumentException iae) {
            throw new InvalidVehicleTypeException();
        }
    }
}
