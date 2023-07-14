package com.car.project.controller;

import com.car.project.dtos.CarDto;
import com.car.project.entity.Car;
import com.car.project.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/carros")
public class CarController {

    @Autowired
    CarService carService;
    @Autowired
    private ModelMapper mapper;

    //Getter for the Id Search
    @GetMapping("/get/{idChassi}")
    public ResponseEntity<CarDto> getCarById(@PathVariable("idChassi") Long idChassi) {
        return ResponseEntity.ok().body(mapper.map(carService.getCarById(idChassi), CarDto.class));
    }

    //Send the Car to the Service for Verification
    @PostMapping("/post")
    public ResponseEntity<CarDto> addCar(@RequestBody CarDto car) {
        Car newCar = carService.addCar(car);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/get/{idChassi}").buildAndExpand(newCar.getIdChassi()).toUri();
        System.out.println("Saved!");
        return ResponseEntity.created(uri).build();
    }
}
