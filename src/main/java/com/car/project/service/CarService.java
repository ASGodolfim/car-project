package com.car.project.service;

import com.car.project.dtos.CarDtoRequest;
import com.car.project.dtos.CarDtoResponse;
import com.car.project.entity.CarDescription;
import com.car.project.exeption.CarNotFound;
import com.car.project.repository.CarRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;


    public CarDescription addCarDescription(CarDtoRequest carDtoRequest) {
        CarDescription carDescription = new CarDescription();
        if (brandCheck(carDtoRequest)) {
            carDescription.setIdChassi(null);
            carDescription.setName(carDtoRequest.getName());
            carDescription.setBrand(carDtoRequest.getBrand());
            carDescription.setColor(carDtoRequest.getColor());
            carDescription.setFabricationYear(carDtoRequest.getFabricationYear());
            return carRepository.save(carDescription);
        }
        return carDescription;
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

    public CarDtoResponse getCarById(Long idChassi) {
        CarDescription carDescription = carRepository
                .findById(idChassi)
                .orElseThrow(() -> new CarNotFound("Invalid Id"));
        CarDtoResponse carDtoResponse = new CarDtoResponse(carDescription.getIdChassi(),carDescription.getName(),carDescription.getBrand(),carDescription.getColor(),carDescription.getFabricationYear());
        return carDtoResponse;
    }

    public List<CarDescription> getAllCars() {
        return carRepository.findAll();
    }
}
