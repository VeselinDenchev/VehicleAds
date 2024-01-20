package com.vehicleads.services;

import com.vehicleads.abstraction.ads.ad.Ad;
import com.vehicleads.abstraction.base.repositories.VehicleRepository;
import com.vehicleads.abstraction.brand.repository.BrandRepository;
import com.vehicleads.abstraction.vehicle.Vehicle;
import com.vehicleads.abstraction.vehicle.repositories.*;
import com.vehicleads.exceptions.brand.BrandNotFoundException;
import com.vehicleads.exceptions.vehicle.InvalidVehicleTypeException;
import com.vehicleads.implementation.entities.ads.boat.BoatAd;
import com.vehicleads.implementation.entities.ads.bus.BusAd;
import com.vehicleads.implementation.entities.ads.car.CarAd;
import com.vehicleads.implementation.entities.ads.caravan.CaravanAd;
import com.vehicleads.implementation.entities.ads.motorcycle.MotorcycleAd;
import com.vehicleads.implementation.entities.ads.truck.TruckAd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private BoatRepository boatRepository;

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CaravanRepository caravanRepository;

    @Autowired
    private MotorcycleRepository motorcycleRepository;

    @Autowired
    private TruckRepository truckRepository;

    public Ad getAdInstanceByVehicleType(String vehicleType) throws InvalidVehicleTypeException {
        return switch (vehicleType) {
            case "boat" -> new BoatAd();
            case "bus" -> new BusAd();
            case "car" -> new CarAd();
            case "caravan" -> new CaravanAd();
            case "motorcycle" -> new MotorcycleAd();
            case "truck" -> new TruckAd();
            case null, default -> throw new InvalidVehicleTypeException();
        };
    }

    public List<? extends Vehicle> getBrandModelsByVehicleType(String vehicleType)
        throws BrandNotFoundException,
               InvalidVehicleTypeException {
        var repository = getRepositoryByVehicleType(vehicleType).orElseThrow(InvalidVehicleTypeException::new);
        List<? extends Vehicle> models = repository.findModels();

        return models;
    }

    private Optional<VehicleRepository<? extends Vehicle>> getRepositoryByVehicleType(String vehicleTypeName) {
        return switch (vehicleTypeName.toLowerCase()) {
            case "boat" -> Optional.of(boatRepository);
            case "bus" -> Optional.of(busRepository);
            case "car" -> Optional.of(carRepository);
            case "caravan" -> Optional.of(caravanRepository);
            case "motorcycle" -> Optional.of(motorcycleRepository);
            case "truck" -> Optional.of(truckRepository);
            default -> Optional.empty();
        };
    }
}
