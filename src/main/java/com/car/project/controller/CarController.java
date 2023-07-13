package com.car.project.controller;

import com.car.project.dtos.CarDtoRequest;
import com.car.project.dtos.CarDtoResponse;
import com.car.project.entity.CarDescription;
import com.car.project.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/carros")
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping(value = "/all")
    public @ResponseBody List<CarDescription> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/get")
    public String get() {
        return "Test";
    }

    @GetMapping("/get/{idChassi}")
    public CarDtoResponse getCarById(@PathVariable("idChassi") Long idChassi) {
        return carService.getCarById(idChassi);
    }

    @PostMapping("/post")
    public String addCarDescription(@RequestBody CarDtoRequest carDtoRequest) {
        carService.addCarDescription(carDtoRequest);
        if (brandCheck(carDtoRequest)) {
            return "Post saved!";
        } else {
            return "Invalid Brand";
        }
    }
    private static boolean brandCheck (CarDtoRequest carDtoRequest){
        Set<String> brands = new HashSet<>();
        brands.add("Ford");
        brands.add("Volvo");
        brands.add("Chevrolet");
        brands.add("BMW");
        if (brands.contains(carDtoRequest.getBrand())){
            return true;
        }else {
            return false;}
    }
}