package com.car.project.controller;

import com.car.project.dtos.CarDtoRequest;
import com.car.project.entity.CarDescription;
import com.car.project.service.CarService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


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
    public String get(){
        return "Test";
    }

    @GetMapping("/get/{idChassi}")
    public CarDescription getCarById (@PathVariable("idChassi") Long idChassi){
        return carService.getCarById(idChassi);
    }

    @PostMapping("/post")
    public CarDescription addCar (@RequestBody @NotNull CarDtoRequest carDtoRequest) throws RuntimeException {
        if (carDtoRequest.getBrand().equals("Volvo") || carDtoRequest.getBrand().equals("Ford") || carDtoRequest.getBrand().equals("BMW") || carDtoRequest.getBrand().equals("Chevrolet")){
            return carService.addCarDescription(carDtoRequest);
        }
        throw new RuntimeException("Invalid Brand");
    }
}
