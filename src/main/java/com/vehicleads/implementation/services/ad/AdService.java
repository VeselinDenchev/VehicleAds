package com.vehicleads.implementation.services.ad;

import com.vehicleads.abstraction.ads.repositories.*;
import com.vehicleads.abstraction.ads.ad.Ad;
import com.vehicleads.abstraction.base.repositories.AdRepository;
import com.vehicleads.abstraction.vehicle.repository.VehicleRepository;
import com.vehicleads.abstraction.user.repository.UserRepository;
import com.vehicleads.implementation.entities.vehicle.Vehicle;
import com.vehicleads.implementation.entities.vehicle.VehicleType;
import com.vehicleads.dtos.ad.AdSearchDto;
import com.vehicleads.exceptions.ad.AdNotFoundException;
import com.vehicleads.exceptions.user.UnauthorizedException;
import com.vehicleads.exceptions.user.UserNotFoundException;
import com.vehicleads.implementation.entities.ads.boat.BoatAd;
import com.vehicleads.implementation.entities.ads.bus.BusAd;
import com.vehicleads.implementation.entities.ads.car.CarAd;
import com.vehicleads.implementation.entities.ads.caravan.CaravanAd;
import com.vehicleads.implementation.entities.ads.motorcycle.MotorcycleAd;
import com.vehicleads.implementation.entities.ads.truck.TruckAd;
import com.vehicleads.exceptions.ad.InvalidVehicleAdTypeException;
import com.vehicleads.exceptions.vehicle.InvalidVehicleTypeException;
import com.vehicleads.implementation.entities.user.UserEntity;
import com.vehicleads.utils.authentication.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdService {
    @Autowired
    private BoatAdRepository boatAdRepository;

    @Autowired
    private BusAdRepository busAdRepository;

    @Autowired
    private CarAdRepository carAdRepository;

    @Autowired
    private CaravanAdRepository caravanAdRepository;

    @Autowired
    private MotorcycleAdRepository motorcycleAdRepository;

    @Autowired
    private TruckAdRepository truckAdRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private UserRepository userRepository;

    public List<? extends Ad> findMany(String vehicleTypeString, AdSearchDto adSearch)
        throws InvalidVehicleTypeException {
        try {
            VehicleType vehicleType = VehicleType.valueOfIgnoreCase(vehicleTypeString.toLowerCase());
            var repository = getRepositoryByVehicleType(vehicleType);

            List<? extends Ad> ads = repository.findAll();
            ads = filterAds(ads, adSearch);

            return ads;
        }
        catch (IllegalArgumentException iae) {
            throw new InvalidVehicleTypeException();
        }
    }

    public List<? extends Ad> findManyUserAds(String vehicleTypeString, AdSearchDto adSearch)
            throws InvalidVehicleTypeException {
        try {
            VehicleType vehicleType = VehicleType.valueOfIgnoreCase(vehicleTypeString.toLowerCase());
            String username = SessionUtil.getSessionUser();
            UserEntity user = userRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);

            var repository = getRepositoryByVehicleType(vehicleType);

            List<? extends Ad> ads = repository.findAllByUserId(user.getId());
            ads = filterAds(ads, adSearch);

            return ads;
        }
        catch (IllegalArgumentException iae) {
            throw new InvalidVehicleTypeException();
        }
    }

    public Ad findByVehicleTypeAndId(String vehicleTypeString, int id)
        throws InvalidVehicleTypeException, AdNotFoundException {
        try {
            VehicleType vehicleType = VehicleType.valueOfIgnoreCase(vehicleTypeString.toLowerCase());

            var repository = getRepositoryByVehicleType(vehicleType);
            Ad ad = repository.findById(id).orElseThrow(AdNotFoundException::new);

            return ad;
        }
        catch (IllegalArgumentException iae) {
            throw new InvalidVehicleTypeException();
        }
    }

    public void save(Ad ad) throws UserNotFoundException, UnauthorizedException, InvalidVehicleAdTypeException {
        String username = SessionUtil.getSessionUser();
        UserEntity user = userRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        ad.setUser(user);

        if (ad.getIsPriceNegotiable()) {
            ad.setPrice(null);
        }

        switch (ad) {
            case BoatAd boatAd -> saveAd(boatAd, boatAdRepository, VehicleType.Boat, user.getId());
            case BusAd busAd -> saveAd(busAd, busAdRepository, VehicleType.Bus, user.getId());
            case CarAd carAd -> saveAd(carAd, carAdRepository, VehicleType.Car, user.getId());
            case CaravanAd caravanAd -> saveAd(caravanAd, caravanAdRepository, VehicleType.Caravan, user.getId());
            case MotorcycleAd motorcycleAd -> saveAd(motorcycleAd,
                                                     motorcycleAdRepository,
                                                     VehicleType.Motorcycle, user.getId());
            case TruckAd truckAd -> saveAd(truckAd, truckAdRepository, VehicleType.Truck, user.getId());
            case null, default -> throw new InvalidVehicleAdTypeException();
        }
    }

    public void deleteByVehicleTypeAndId(String vehicleTypeString, int id)
        throws AdNotFoundException, InvalidVehicleTypeException {
        try {
            VehicleType vehicleType = VehicleType.valueOfIgnoreCase(vehicleTypeString.toLowerCase());

            var repository = getRepositoryByVehicleType(vehicleType);

            boolean exists = repository.existsById(id);
            if (!exists) throw new AdNotFoundException();

            repository.deleteById(id);
        }
        catch (IllegalArgumentException iae) {
            throw new InvalidVehicleTypeException();
        }
    }

    private AdRepository<? extends Ad> getRepositoryByVehicleType(VehicleType vehicleType) {
        return switch (vehicleType) {
            case Boat -> boatAdRepository;
            case Bus -> busAdRepository;
            case Car -> carAdRepository;
            case Caravan -> caravanAdRepository;
            case Motorcycle -> motorcycleAdRepository;
            case Truck -> truckAdRepository;
        };
    }

    private List<? extends Ad> filterAds(List<? extends Ad> ads, AdSearchDto adSearch) {
        if (!adSearch.getTitle().isEmpty()) {
            ads = filterAdsByTitle(ads, adSearch.getTitle());
        }

        Integer minPrice = adSearch.getMinPrice();
        Integer maxPrice = adSearch.getMaxPrice();

        if (adSearch.getIsPriceNegotiable()) {
            ads = filterNegotiablePriceAds(ads);
        }
        else if (minPrice != null || maxPrice != null) {
            ads = filterAdsByPrice(ads, minPrice, maxPrice);
        }

        return ads;
    }

    private List<? extends Ad> filterAdsByTitle(List<? extends Ad> ads, String title) {
        return ads.stream()
                  .filter(ad -> ad.getTitle().toLowerCase().startsWith(title.toLowerCase()))
                  .collect(Collectors.toList());
    }

    private List<? extends Ad> filterNegotiablePriceAds(List<? extends Ad> ads) {
        return ads.stream()
                  .filter(Ad::getIsPriceNegotiable)
                  .collect(Collectors.toList());
    }

    private List<? extends Ad> filterAdsByPrice(List<? extends Ad> ads,
                                                @Nullable Integer minPrice,
                                                @Nullable Integer maxPrice) {
        if (minPrice == null) {
            minPrice = 0;
        }

        if (maxPrice == null) {
            maxPrice = Integer.MAX_VALUE;
        }

        final int MIN_PRICE = minPrice;
        final int MAX_PRICE = maxPrice;

        return ads.stream()
                  .filter(ad -> !ad.getIsPriceNegotiable() &&
                                ad.getPrice() >= MIN_PRICE &&
                                ad.getPrice() <= MAX_PRICE)
                  .collect(Collectors.toList());
    }

    private Vehicle mapVehicleBrandAndModel(Vehicle vehicle, VehicleType vehicleType) {
        vehicle = vehicleRepository.findVehicleByBrandIdAndModel(vehicle.getBrand().getId(),
                                                                 vehicle.getModelName(),
                                                                 vehicleType);

        return vehicle;
    }

    private <T extends Ad> void saveAd(T ad, AdRepository<T> repository, VehicleType vehicleType, int currentUserId)
        throws UnauthorizedException {
        // If ad is edited we must check if initially this ad was created by the same user
        if (ad.getId() != null) {
            int userIdOfLastUpdate = repository.findUserId(ad.getId());
            if (userIdOfLastUpdate != currentUserId) throw new UnauthorizedException();
        }

        Vehicle vehicleFromDatabase = mapVehicleBrandAndModel(ad.getVehicle(), vehicleType);
        ad.setVehicle(vehicleFromDatabase);
        repository.save(ad);
    }
}
