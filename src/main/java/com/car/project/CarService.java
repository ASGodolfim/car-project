package com.car.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;


    public CarDescription addCarDescription(CarDescription carDescription) {
        return carRepository.save(carDescription);
    }

    public CarDescription getCarById(Long idChassi) {
        return carRepository.findById(idChassi).get();
    }

    public List<CarDescription> getAllCars() {
        return carRepository.findAll();
    }
}
