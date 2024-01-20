package com.vehicleads.services;

import com.vehicleads.abstraction.ads.repositories.*;
import com.vehicleads.abstraction.ads.ad.Ad;
import com.vehicleads.abstraction.base.repositories.AdRepository;
import com.vehicleads.abstraction.vehicle.repositories.BoatRepository;
import com.vehicleads.dtos.AdSearchDto;
import com.vehicleads.exceptions.ad.AdNotFoundException;
import com.vehicleads.implementation.entities.ads.boat.BoatAd;
import com.vehicleads.implementation.entities.ads.bus.BusAd;
import com.vehicleads.implementation.entities.ads.car.CarAd;
import com.vehicleads.implementation.entities.ads.caravan.CaravanAd;
import com.vehicleads.implementation.entities.ads.motorcycle.MotorcycleAd;
import com.vehicleads.implementation.entities.ads.truck.TruckAd;
import com.vehicleads.exceptions.ad.InvalidVehicleAdTypeException;
import com.vehicleads.exceptions.vehicle.InvalidVehicleTypeException;
import com.vehicleads.implementation.entities.vehicles.Boat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdService {
    @Autowired
    private BoatAdRepository boatAdRepository;

    @Autowired
    private BoatRepository boatRepository;

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

    public List<? extends Ad> find(String vehicleType, AdSearchDto adSearch)
        throws InvalidVehicleTypeException {
        var repository = getRepositoryByVehicleType(vehicleType).orElseThrow(InvalidVehicleTypeException::new);

        List<? extends Ad> ads = repository.findAll();
        ads = filterAds(ads, adSearch);

        return ads;
    }

    public Ad findByVehicleTypeAndId(String vehicleType, int id)
        throws InvalidVehicleTypeException, AdNotFoundException {
        var repository = getRepositoryByVehicleType(vehicleType).orElseThrow(InvalidVehicleTypeException::new);
        Ad ad = repository.findById(id).orElseThrow(AdNotFoundException::new);

        return ad;
    }

    public void save(Ad vehicleAd) throws InvalidVehicleAdTypeException {
        if (vehicleAd.getIsPriceNegotiable()) {
            vehicleAd.setPrice(null);
        }

        switch (vehicleAd) {
            case BoatAd boatAd -> saveBoatAd(boatAd);
            case BusAd busAd -> busAdRepository.save(busAd);
            case CarAd carAd -> carAdRepository.save(carAd);
            case CaravanAd caravanAd -> caravanAdRepository.save(caravanAd);
            case MotorcycleAd motorcycleAd -> motorcycleAdRepository.save(motorcycleAd);
            case TruckAd truckAd -> truckAdRepository.save(truckAd);
            case null, default -> throw new InvalidVehicleAdTypeException();
        }
    }

    public void deleteByVehicleTypeAndId(String vehicleType, int id)
        throws AdNotFoundException, InvalidVehicleTypeException {
        var repository = getRepositoryByVehicleType(vehicleType).orElseThrow(InvalidVehicleTypeException::new);

        boolean exists = repository.existsById(id);
        if (!exists) throw new AdNotFoundException();

        repository.deleteById(id);
    }

    private Optional<AdRepository<? extends Ad>>
        getRepositoryByVehicleType(String vehicleTypeName) {
        return switch (vehicleTypeName.toLowerCase()) {
            case "boat" -> Optional.of(boatAdRepository);
            case "bus" -> Optional.of(busAdRepository);
            case "car" -> Optional.of(carAdRepository);
            case "caravan" -> Optional.of(caravanAdRepository);
            case "motorcycle" -> Optional.of(motorcycleAdRepository);
            case "truck" -> Optional.of(truckAdRepository);
            default -> Optional.empty();
        };
    }

    private void saveBoatAd(BoatAd boatAd) {
        Boat boatFromDatabase = mapBoatBrandAndModel(boatAd.getBoat());
        boatAd.setBoat(boatFromDatabase);
        boatAdRepository.save(boatAd);
    }

    private Boat mapBoatBrandAndModel(Boat boat) {
        boat = boatRepository.findBoatByBrandIdAndModel(boat.getBrand().getId(), boat.getModelName());

        return boat;
    }

    private List<? extends Ad> filterAds(List<? extends Ad> ads, AdSearchDto adSearch) {
        if (!adSearch.getTitle().isEmpty()) {
            ads = filterAdsByTitle(ads, adSearch.getTitle());
        }

        Double minPrice = adSearch.getMinPrice();
        Double maxPrice = adSearch.getMaxPrice();

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
                                                @Nullable Double minPrice,
                                                @Nullable Double maxPrice) {
        if (minPrice == null) {
            minPrice = 0d;
        }

        if (maxPrice == null) {
            maxPrice = Double.MAX_VALUE;
        }

        final double MIN_PRICE = minPrice;
        final double MAX_PRICE = maxPrice;

        return ads.stream()
                  .filter(ad -> !ad.getIsPriceNegotiable() &&
                                ad.getPrice() >= MIN_PRICE &&
                                ad.getPrice() <= MAX_PRICE)
                  .collect(Collectors.toList());
    }
}
