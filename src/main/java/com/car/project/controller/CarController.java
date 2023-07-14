package com.car.project.controller;

import com.car.project.dtos.CarDto;
import com.car.project.entity.Car;
import com.car.project.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/carros")
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping(value = "/all")
    public @ResponseBody List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/get/{idChassi}")
    public CarDto getCarById(@PathVariable("idChassi") Long idChassi) {
        return carService.getCarById(idChassi);
    }

    @PostMapping("/postDto")
    public Car addCarDto (@RequestBody Car car) {
        return carService.addCarDto(car);
    }

    @PostMapping("/post")
    public Car addCar (@RequestBody Car car) {
        return carService.addCar(car);
    }
}