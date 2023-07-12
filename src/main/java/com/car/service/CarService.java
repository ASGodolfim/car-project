package com.car.service;

import java.util.List;

import com.car.entity.CarDescription;
import com.car.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public CarDescription addCarDescription (CarDescription carDescription) {
        return carRepository.save(carDescription);
    }

    public CarDescription getCarById(Long idChassi) {
        return carRepository.findById(idChassi).get();
    }

    public List<CarDescription> getAllCars() {
        return carRepository.findAll();
    }
}


