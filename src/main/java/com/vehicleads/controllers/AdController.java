package com.vehicleads.controllers;

import com.vehicleads.abstraction.ads.ad.Ad;
import com.vehicleads.implementation.entities.vehicle.Vehicle;
import com.vehicleads.dtos.ad.AdSearchDto;
import com.vehicleads.exceptions.ad.InvalidVehicleAdTypeException;
import com.vehicleads.exceptions.ad.AdNotFoundException;
import com.vehicleads.exceptions.user.UnauthorizedException;
import com.vehicleads.exceptions.vehicle.InvalidVehicleTypeException;
import com.vehicleads.implementation.entities.ads.boat.BoatAd;
import com.vehicleads.implementation.entities.ads.bus.BusAd;
import com.vehicleads.implementation.entities.ads.car.CarAd;
import com.vehicleads.implementation.entities.ads.caravan.CaravanAd;
import com.vehicleads.implementation.entities.ads.motorcycle.MotorcycleAd;
import com.vehicleads.implementation.entities.ads.truck.TruckAd;
import com.vehicleads.implementation.entities.brand.Brand;
import com.vehicleads.implementation.services.ad.AdService;
import com.vehicleads.implementation.services.brand.BrandService;
import com.vehicleads.implementation.services.vehicle.VehicleService;
import com.vehicleads.utils.error.RedirectToErrorPageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public String findMany(@PathVariable("vehicleType") String vehicleType,
                           AdSearchDto adSearch,
                           Model model,
                           RedirectAttributes redirectAttributes) {
        try {
            List<? extends Ad> ads = adService.findMany(vehicleType, adSearch);
            model.addAttribute("ads", ads);
            model.addAttribute("adSearch", adSearch);

            return String.format("ads/%s/list", vehicleType);
        }
        catch (InvalidVehicleTypeException ivte) {
            return RedirectToErrorPageUtil.redirect(redirectAttributes, HttpStatus.BAD_REQUEST, ivte.getMessage());
        }
    }

    @GetMapping("/ads/{vehicleType}/my")
    public String findManyUserAds(@PathVariable("vehicleType") String vehicleType,
                                  AdSearchDto adSearch,
                                  Model model,
                                  RedirectAttributes redirectAttributes) {
        try {
            List<? extends Ad> ads = adService.findManyUserAds(vehicleType, adSearch);
            model.addAttribute("ads", ads);
            model.addAttribute("adSearch", adSearch);

            return String.format("ads/%s/my-ads", vehicleType);
        }
        catch (InvalidVehicleTypeException ivte) {
            return RedirectToErrorPageUtil.redirect(redirectAttributes, HttpStatus.BAD_REQUEST, ivte.getMessage());
        }
    }

    @GetMapping("/ads/{vehicleType}/{id}")
    public String find(@PathVariable("vehicleType") String vehicleType,
                       @PathVariable("id") int id,
                       Model model,
                       RedirectAttributes redirectAttributes) {
        try {
            Ad ad = adService.findByVehicleTypeAndId(vehicleType, id);
            model.addAttribute("ad", ad);

            return String.format("ads/%s/details", vehicleType);
        }
        catch (InvalidVehicleTypeException ivte) {
            return RedirectToErrorPageUtil.redirect(redirectAttributes, HttpStatus.BAD_REQUEST, ivte.getMessage());
        }
        catch (AdNotFoundException vanfe) {
            return RedirectToErrorPageUtil.redirect(redirectAttributes, HttpStatus.NOT_FOUND, vanfe.getMessage());
        }
    }

    @GetMapping("/ads/{vehicleType}/create")
    public String create(@PathVariable("vehicleType") String vehicleType,
                         Model model,
                         RedirectAttributes redirectAttributes) {
        try {
            Ad ad = vehicleService.getAdInstanceByVehicleType(vehicleType);
            List<Brand> brands = brandService.findAllBrandsByVehicleType(vehicleType);
            List<? extends Vehicle> models = vehicleService.getBrandModelsByVehicleType(vehicleType);

            return buildForm("Create", vehicleType, ad, brands, models, model);
        }
        catch (InvalidVehicleTypeException ivte) {
            return RedirectToErrorPageUtil.redirect(redirectAttributes, HttpStatus.BAD_REQUEST, ivte.getMessage());
        }
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

            return buildForm("Update", vehicleType, ad, brands, models, model);
        }
        catch (InvalidVehicleTypeException ivte) {
            return RedirectToErrorPageUtil.redirect(redirectAttributes, HttpStatus.BAD_REQUEST, ivte.getMessage());
        }
        catch (AdNotFoundException anfe) {
            return RedirectToErrorPageUtil.redirect(redirectAttributes, HttpStatus.NOT_FOUND, anfe.getMessage());
        }
    }

    @PostMapping("/ads/boat/save")
    public String save(@Valid BoatAd boatAd, RedirectAttributes redirectAttributes) {
        try {
            adService.save(boatAd);

            return "redirect:/ads/boat/my";
        }
        catch (InvalidVehicleAdTypeException ivate) {
            return RedirectToErrorPageUtil.redirect(redirectAttributes, HttpStatus.BAD_REQUEST, ivate.getMessage());
        }
        catch (UnauthorizedException ue) {
            return RedirectToErrorPageUtil.redirect(redirectAttributes, HttpStatus.UNAUTHORIZED, ue.getMessage());
        }
    }

    @PostMapping("/ads/bus/save")
    public String save(@Valid BusAd busAd, RedirectAttributes redirectAttributes) {
        try {
            adService.save(busAd);

            return "redirect:/ads/bus/my";
        }
        catch (InvalidVehicleAdTypeException ivate) {
            return RedirectToErrorPageUtil.redirect(redirectAttributes, HttpStatus.BAD_REQUEST, ivate.getMessage());
        }
        catch (UnauthorizedException ue) {
            return RedirectToErrorPageUtil.redirect(redirectAttributes, HttpStatus.UNAUTHORIZED, ue.getMessage());
        }
    }

    @PostMapping("/ads/car/save")
    public String save(@Valid CarAd carAd, RedirectAttributes redirectAttributes) {
        try {
            adService.save(carAd);

            return "redirect:/ads/car/my";
        }
        catch (InvalidVehicleAdTypeException ivate) {
            return RedirectToErrorPageUtil.redirect(redirectAttributes, HttpStatus.BAD_REQUEST, ivate.getMessage());
        }
        catch (UnauthorizedException ue) {
            return RedirectToErrorPageUtil.redirect(redirectAttributes, HttpStatus.UNAUTHORIZED, ue.getMessage());
        }
    }

    @PostMapping("/ads/caravan/save")
    public String save(@Valid CaravanAd caravanAd, RedirectAttributes redirectAttributes) {
        try {
            adService.save(caravanAd);

            return "redirect:/ads/caravan/my";
        }
        catch (InvalidVehicleAdTypeException ivate) {
            return RedirectToErrorPageUtil.redirect(redirectAttributes, HttpStatus.BAD_REQUEST, ivate.getMessage());
        }
        catch (UnauthorizedException ue) {
            return RedirectToErrorPageUtil.redirect(redirectAttributes, HttpStatus.UNAUTHORIZED, ue.getMessage());
        }
    }

    @PostMapping("/ads/motorcycle/save")
    public String save(@Valid MotorcycleAd motorcycleAd, RedirectAttributes redirectAttributes) {
        try {
            adService.save(motorcycleAd);

            return "redirect:/ads/motorcycle/my";
        }
        catch (InvalidVehicleAdTypeException ivate) {
            return RedirectToErrorPageUtil.redirect(redirectAttributes, HttpStatus.BAD_REQUEST, ivate.getMessage());
        }
        catch (UnauthorizedException ue) {
            return RedirectToErrorPageUtil.redirect(redirectAttributes, HttpStatus.UNAUTHORIZED, ue.getMessage());
        }
    }

    @PostMapping("/ads/truck/save")
    public String save(@Valid TruckAd truckAd, RedirectAttributes redirectAttributes) {
        try {
            adService.save(truckAd);

            return "redirect:/ads/truck/my";
        }
        catch (InvalidVehicleAdTypeException ivate) {
            return RedirectToErrorPageUtil.redirect(redirectAttributes, HttpStatus.BAD_REQUEST, ivate.getMessage());
        }
        catch (UnauthorizedException ue) {
            return RedirectToErrorPageUtil.redirect(redirectAttributes, HttpStatus.UNAUTHORIZED, ue.getMessage());
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
            return RedirectToErrorPageUtil.redirect(redirectAttributes, HttpStatus.BAD_REQUEST, ivte.getMessage());
        }
        catch (AdNotFoundException anfe) {
            return RedirectToErrorPageUtil.redirect(redirectAttributes, HttpStatus.NOT_FOUND, anfe.getMessage());
        }
    }

    private String buildForm(String action,
                             String vehicleType,
                             Ad ad,
                             List<Brand> brands,
                             List<? extends Vehicle> models,
                             Model model) {
        model.addAttribute("pageTitle", String.format("%s Ad", action));
        model.addAttribute("ad", ad);
        model.addAttribute("brands", brands);
        model.addAttribute("models", models);

        return String.format("ads/%s/form", vehicleType);
    }
}
