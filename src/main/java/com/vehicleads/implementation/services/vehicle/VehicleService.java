package com.vehicleads.implementation.services.vehicle;

import com.vehicleads.abstraction.ads.ad.Ad;
import com.vehicleads.abstraction.vehicle.repository.VehicleRepository;
import com.vehicleads.implementation.entities.vehicle.Vehicle;
import com.vehicleads.implementation.entities.vehicle.VehicleType;
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

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    public Ad getAdInstanceByVehicleType(String vehicleTypeString) throws InvalidVehicleTypeException {
        try {
            VehicleType vehicleType = VehicleType.valueOfIgnoreCase(vehicleTypeString.toLowerCase());

            return switch (vehicleType) {
                case Boat -> new BoatAd();
                case Bus -> new BusAd();
                case Car -> new CarAd();
                case Caravan -> new CaravanAd();
                case Motorcycle -> new MotorcycleAd();
                case Truck -> new TruckAd();
            };
        }
        catch (IllegalArgumentException iae) {
            throw new InvalidVehicleTypeException();
        }
    }

    public List<Vehicle> getBrandModelsByVehicleType(String vehicleTypeString)
        throws InvalidVehicleTypeException {
        try {
            VehicleType vehicleType = VehicleType.valueOfIgnoreCase(vehicleTypeString.toLowerCase());
            List<Vehicle> models = vehicleRepository.findModels(vehicleType);

            return models;
        }
        catch (IllegalArgumentException iae) {
            throw new InvalidVehicleTypeException();
        }
    }
}
