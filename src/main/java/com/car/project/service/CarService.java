package com.car.project.service;

import com.car.project.dtos.CarDtoRequest;
import com.car.project.entity.CarDescription;
import com.car.project.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;


    public CarDescription addCarDescription(CarDtoRequest carDtoRequest) {
        CarDescription carDescription = new CarDescription(
                null,
                carDtoRequest.getName(),
                carDtoRequest.getBrand(),
                carDtoRequest.getColor(),
                carDtoRequest.getFabricationYear());
        return carRepository.save(carDescription);
    }

    public CarDescription getCarById(Long idChassi) {
        return carRepository.findById(idChassi).orElseThrow();
    }

    public List<CarDescription> getAllCars() {
        return carRepository.findAll();
    }
}
