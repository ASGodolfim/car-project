package com.car.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public CarDescription getCarById (@PathVariable("carById") Long idChassi){
        return carService.getCarById(idChassi);
    }

    @PostMapping("/add")
    public CarDescription addCar (@RequestBody CarDescription carDescription){
        return carService.addCarDescription(carDescription);
    }
}
