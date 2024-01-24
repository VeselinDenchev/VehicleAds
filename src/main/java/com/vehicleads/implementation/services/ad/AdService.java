package com.vehicleads.implementation.services.ad;

import com.vehicleads.abstraction.ads.repositories.*;
import com.vehicleads.abstraction.ads.ad.Ad;
import com.vehicleads.abstraction.base.repositories.AdRepository;
import com.vehicleads.abstraction.user.repository.UserRepository;
import com.vehicleads.abstraction.vehicle.repositories.*;
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
import com.vehicleads.implementation.entities.vehicles.*;
import com.vehicleads.utils.authentication.SessionUtil;
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
    private BusRepository busRepository;

    @Autowired
    private CarAdRepository carAdRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CaravanAdRepository caravanAdRepository;

    @Autowired
    private CaravanRepository caravanRepository;

    @Autowired
    private MotorcycleAdRepository motorcycleAdRepository;

    @Autowired
    private MotorcycleRepository motorcycleRepository;

    @Autowired
    private TruckAdRepository truckAdRepository;

    @Autowired
    private TruckRepository truckRepository;

    @Autowired
    private UserRepository userRepository;

    public List<? extends Ad> findMany(String vehicleType, AdSearchDto adSearch)
        throws InvalidVehicleTypeException {
        var repository = getRepositoryByVehicleType(vehicleType).orElseThrow(InvalidVehicleTypeException::new);

        List<? extends Ad> ads = repository.findAll();
        ads = filterAds(ads, adSearch);

        return ads;
    }

    public List<? extends Ad> findManyUserAds(String vehicleType, AdSearchDto adSearch)
            throws InvalidVehicleTypeException {
        String username = SessionUtil.getSessionUser();
        UserEntity user = userRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);

        var repository = getRepositoryByVehicleType(vehicleType).orElseThrow(InvalidVehicleTypeException::new);

        List<? extends Ad> ads = repository.findAllByUserId(user.getId());
        ads = filterAds(ads, adSearch);

        return ads;
    }

    public Ad findByVehicleTypeAndId(String vehicleType, int id)
        throws InvalidVehicleTypeException, AdNotFoundException {
        var repository = getRepositoryByVehicleType(vehicleType).orElseThrow(InvalidVehicleTypeException::new);
        Ad ad = repository.findById(id).orElseThrow(AdNotFoundException::new);

        return ad;
    }

    public void save(Ad ad) throws UserNotFoundException, UnauthorizedException, InvalidVehicleAdTypeException {
        String username = SessionUtil.getSessionUser();
        UserEntity user = userRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        ad.setUser(user);

        if (ad.getIsPriceNegotiable()) {
            ad.setPrice(null);
        }

        switch (ad) {
            case BoatAd boatAd -> saveBoatAd(boatAd, user.getId());
            case BusAd busAd -> saveBusAd(busAd, user.getId());
            case CarAd carAd -> saveCarAd(carAd, user.getId());
            case CaravanAd caravanAd -> saveCaravanAd(caravanAd, user.getId());
            case MotorcycleAd motorcycleAd -> saveMotorcycleAd(motorcycleAd, user.getId());
            case TruckAd truckAd -> saveTruckAd(truckAd, user.getId());
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

    private Optional<AdRepository<? extends Ad>> getRepositoryByVehicleType(String vehicleType) {
        return switch (vehicleType.toLowerCase()) {
            case "boat" -> Optional.of(boatAdRepository);
            case "bus" -> Optional.of(busAdRepository);
            case "car" -> Optional.of(carAdRepository);
            case "caravan" -> Optional.of(caravanAdRepository);
            case "motorcycle" -> Optional.of(motorcycleAdRepository);
            case "truck" -> Optional.of(truckAdRepository);
            default -> Optional.empty();
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


    private void saveBoatAd(BoatAd boatAd, int currentUserId) throws UnauthorizedException {
        // If ad is edited we must check if initially this ad was created by the same user
        if (boatAd.getId() != null) {
            int userIdOfLastUpdate = boatAdRepository.findUserId(boatAd.getId());
            if (userIdOfLastUpdate != currentUserId) throw new UnauthorizedException();
        }

        Boat boatFromDatabase = mapBoatBrandAndModel(boatAd.getBoat());
        boatAd.setBoat(boatFromDatabase);
        boatAdRepository.save(boatAd);
    }

    private Boat mapBoatBrandAndModel(Boat boat) {
        boat = boatRepository.findBoatByBrandIdAndModel(boat.getBrand().getId(), boat.getModelName());

        return boat;
    }

    private void saveBusAd(BusAd busAd, int currentUserId) throws UnauthorizedException {
        // If ad is edited we must check if initially this ad was created by the same user
        if (busAd.getId() != null) {
            int userIdOfLastUpdate = boatAdRepository.findUserId(busAd.getId());
            if (userIdOfLastUpdate != currentUserId) throw new UnauthorizedException();
        }

        Bus busFromDatabase = mapBusBrandAndModel(busAd.getBus());
        busAd.setBus(busFromDatabase);
        busAdRepository.save(busAd);
    }

    private Bus mapBusBrandAndModel(Bus bus) {
        bus = busRepository.findBusByBrandIdAndModel(bus.getBrand().getId(), bus.getModelName());

        return bus;
    }

    private void saveCarAd(CarAd carAd, int currentUserId) throws UnauthorizedException {
        // If ad is edited we must check if initially this ad was created by the same user
        if (carAd.getId() != null) {
            int userIdOfLastUpdate = boatAdRepository.findUserId(carAd.getId());
            if (userIdOfLastUpdate != currentUserId) throw new UnauthorizedException();
        }

        Car carFromDatabase = mapCarBrandAndModel(carAd.getCar());
        carAd.setCar(carFromDatabase);
        carAdRepository.save(carAd);
    }

    private Car mapCarBrandAndModel(Car car) {
        car = carRepository.findCarByBrandIdAndModel(car.getBrand().getId(), car.getModelName());

        return car;
    }

    private void saveCaravanAd(CaravanAd caravanAd, int currentUserId) throws UnauthorizedException {
        // If ad is edited we must check if initially this ad was created by the same user
        if (caravanAd.getId() != null) {
            int userIdOfLastUpdate = boatAdRepository.findUserId(caravanAd.getId());
            if (userIdOfLastUpdate != currentUserId) throw new UnauthorizedException();
        }

        Caravan caravanFromDatabase = mapCaravanBrandAndModel(caravanAd.getCaravan());
        caravanAd.setCaravan(caravanFromDatabase);
        caravanAdRepository.save(caravanAd);
    }

    private Caravan mapCaravanBrandAndModel(Caravan caravan) {
        caravan = caravanRepository.findCaravanByBrandIdAndModel(caravan.getBrand().getId(), caravan.getModelName());

        return caravan;
    }

    private void saveMotorcycleAd(MotorcycleAd motorcycleAd, int currentUserId) throws UnauthorizedException {
        // If ad is edited we must check if initially this ad was created by the same user
        if (motorcycleAd.getId() != null) {
            int userIdOfLastUpdate = boatAdRepository.findUserId(motorcycleAd.getId());
            if (userIdOfLastUpdate != currentUserId) throw new UnauthorizedException();
        }

        Motorcycle motorcycleFromDatabase = mapMotorcycleBrandAndModel(motorcycleAd.getMotorcycle());
        motorcycleAd.setMotorcycle(motorcycleFromDatabase);
        motorcycleAdRepository.save(motorcycleAd);
    }

    private Motorcycle mapMotorcycleBrandAndModel(Motorcycle motorcycle) {
        motorcycle = motorcycleRepository.findMotorcycleByBrandIdAndModel(motorcycle.getBrand().getId(),
                                                                          motorcycle.getModelName());

        return motorcycle;
    }

    private void saveTruckAd(TruckAd truckAd, int currentUserId) throws UnauthorizedException {
        // If ad is edited we must check if initially this ad was created by the same user
        if (truckAd.getId() != null) {
            int userIdOfLastUpdate = boatAdRepository.findUserId(truckAd.getId());
            if (userIdOfLastUpdate != currentUserId) throw new UnauthorizedException();
        }

        Truck truckFromDatabase = mapTruckBrandAndModel(truckAd.getTruck());
        truckAd.setTruck(truckFromDatabase);
        truckAdRepository.save(truckAd);
    }

    private Truck mapTruckBrandAndModel(Truck truck) {
        truck = truckRepository.findTruckByBrandIdAndModel(truck.getBrand().getId(), truck.getModelName());

        return truck;
    }
}
