package com.car.controller;

import com.car.entity.CarDescription;
import com.car.repository.CarRepository;
import com.car.service.CarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/carros")
public class CarProjectController {

    @Autowired
    CarRepository carRepository;

    @Autowired
    CarService carService;

    @GetMapping(value = "/all")
    public @ResponseBody List<CarDescription> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping(value = "/get")
    public String get(){
        return "Greetings";
    }

    @GetMapping("/get/{carById}")
    public CarDescription getCarById(@PathVariable("carById") Long idChassi){
        return carService.getCarById(idChassi);
    }

    @PostMapping("/add")
    public @ResponseBody String addCarDescription(@RequestParam String name, @RequestParam String brand, @RequestParam String color,@RequestParam String fabricationYear){
        CarDescription car = new CarDescription();
        car.setName(name);
        car.setBrand(brand);
        car.setColor(color);
        car.setFabricationYear(fabricationYear);
        return "Saved";
    }

    @RequestMapping(value="/get/{carDescriptionId}", method=RequestMethod.DELETE)
    public void deleteCarDescription(@PathVariable(value = "carDescriptionId") Long id){
        carRepository.deleteById(id);
    }
}
