package com.vehicleads.controllers;

import com.vehicleads.abstraction.ads.ad.Ad;
import com.vehicleads.abstraction.vehicle.Vehicle;
import com.vehicleads.dtos.AdSearchDto;
import com.vehicleads.exceptions.ad.InvalidVehicleAdTypeException;
import com.vehicleads.exceptions.ad.AdNotFoundException;
import com.vehicleads.exceptions.brand.BrandNotFoundException;
import com.vehicleads.exceptions.vehicle.InvalidVehicleTypeException;
import com.vehicleads.implementation.entities.ads.boat.BoatAd;
import com.vehicleads.implementation.entities.ads.bus.BusAd;
import com.vehicleads.implementation.entities.ads.car.CarAd;
import com.vehicleads.implementation.entities.ads.caravan.CaravanAd;
import com.vehicleads.implementation.entities.ads.motorcycle.MotorcycleAd;
import com.vehicleads.implementation.entities.ads.truck.TruckAd;
import com.vehicleads.implementation.entities.brand.Brand;
import com.vehicleads.services.AdService;
import com.vehicleads.services.BrandService;
import com.vehicleads.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AdController {
    @Autowired
    private AdService adService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private BrandService brandService;

    @GetMapping("/ads/{vehicleType}")
    public String findByVehicleTypeAndTitle(@PathVariable("vehicleType") String vehicleType,
                                            AdSearchDto adSearch,
                                            Model model) {
        try {
            List<? extends Ad> ads = adService.find(vehicleType, adSearch);
            model.addAttribute("ads", ads);
            model.addAttribute("adSearch", adSearch);

            return String.format("%s-ad/list", vehicleType);
        }
        catch (InvalidVehicleTypeException ivte) {
            return ivte.getMessage();
        }
    }

    @GetMapping("/ads/{vehicleType}/{id}")
    public String find(@PathVariable("vehicleType") String vehicleType, @PathVariable("id") int id) {
        try {
            Ad ad = adService.findByVehicleTypeAndId(vehicleType, id);

            return "index";
        }
        catch (InvalidVehicleTypeException ivte) {
            return ivte.getMessage();
        }
        catch (AdNotFoundException vanfe) {
            return vanfe.getMessage();
        }
    }

    @GetMapping("/ads/{vehicleType}/create")
    public String create(@PathVariable("vehicleType") String vehicleType, Model model) {
        try {
            Ad ad = vehicleService.getAdInstanceByVehicleType(vehicleType);
            List<Brand> brands = brandService.findAllBrandsByVehicleType(vehicleType);
            List<? extends Vehicle> models = vehicleService.getBrandModelsByVehicleType(vehicleType);

            model.addAttribute("ad", ad);
            model.addAttribute("brands", brands);
            model.addAttribute("models", models);
        } catch (InvalidVehicleTypeException ivte) {
            return ivte.getMessage();
        } catch (BrandNotFoundException e) {
            throw new RuntimeException(e);
        }

        return String.format("%s-ad/create", vehicleType);
    }

    @GetMapping("/ads/{vehicleType}/edit/{id}")
    public String edit(@PathVariable("vehicleType") String vehicleType,
                       @PathVariable("id") int id,
                       Model model,
                       RedirectAttributes redirectAttributes) {
        try {
            Ad ad = adService.findByVehicleTypeAndId(vehicleType, id);
            List<Brand> brands = brandService.findAllBrandsByVehicleType(vehicleType);
            List<? extends Vehicle> models = vehicleService.getBrandModelsByVehicleType(vehicleType);

            model.addAttribute("ad", ad);
            model.addAttribute("brands", brands);
            model.addAttribute("models", models);

            return String.format("%s-ad/edit", vehicleType);
        }
        catch (InvalidVehicleTypeException ivte) {
            return ivte.getMessage();
        }
        catch (AdNotFoundException vadnfe) {
            return vadnfe.getMessage();
        } catch (BrandNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/ads/boat/save")
    public String save(@Valid BoatAd boatAd) {
        try {
            adService.save(boatAd);

            return "redirect:/ads/boat";
        } catch (InvalidVehicleAdTypeException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/ads/bus/save")
    public String save(@Valid BusAd busAd) {
        try {
            adService.save(busAd);

            return "boat/ads-list";
        } catch (InvalidVehicleAdTypeException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/ads/car/save")
    public String save(@Valid CarAd carAd) {
        try {
            adService.save(carAd);

            return "boat/ads-list";
        } catch (InvalidVehicleAdTypeException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/ads/caravan/save")
    public String save(@Valid CaravanAd caravanAd) {
        try {
            adService.save(caravanAd);

            return "boat/ads-list";
        } catch (InvalidVehicleAdTypeException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/ads/motorcycle/save")
    public String save(@Valid MotorcycleAd motorcycleAd) {
        try {
            adService.save(motorcycleAd);

            return "boat/ads-list";
        } catch (InvalidVehicleAdTypeException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/ads/truck/save")
    public String save(@Valid TruckAd truckAd) {
        try {
            adService.save(truckAd);

            return "boat/ads-list";
        } catch (InvalidVehicleAdTypeException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/ads/{vehicleType}/delete/{id}")
    public String delete(@PathVariable("vehicleType") String vehicleType,
                         @PathVariable("id") int id,
                         RedirectAttributes redirectAttributes) {
        try {
            adService.deleteByVehicleTypeAndId(vehicleType, id);

            return String.format("redirect:/ads/%s", vehicleType);
        } catch (InvalidVehicleTypeException ivte) {
            return ivte.getMessage();
        }
        catch (AdNotFoundException vanfe) {
            return vanfe.getMessage();
        }
    }
}
