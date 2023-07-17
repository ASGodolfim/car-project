package com.car.project.controller;

import com.car.project.dto.CarDto;
import com.car.project.entity.Car;
import com.car.project.service.CarService;
import org.hibernate.annotations.Parent;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


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
        URI uri = ServletUriComponentsBuilder.fromPath("localhost:8080/carros/get/{idChassi}").
                buildAndExpand(newCar.getIdChassi()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
