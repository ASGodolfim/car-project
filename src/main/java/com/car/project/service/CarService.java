package com.car.project.service;

import com.car.project.dtos.CarDto;
import com.car.project.entity.Car;
import com.car.project.repository.CarRepository;
import com.car.project.service.exeption.CarExeption;
import com.car.project.service.exeption.CarNotFound;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;
    @Autowired
    ModelMapper mapper;

    private static boolean brandCheck (CarDto car){
        Set<String> brands = new HashSet<>();
        brands.add("Ford");
        brands.add("Volvo");
        brands.add("Chevrolet");
        brands.add("BMW");
        if (brands.contains(car.getBrand())){
            return true;
        }else {
        return false;}
    }

    public Car addCar (@RequestBody CarDto car) {
        if (brandCheck(car)) {
            return carRepository.save(mapper.map(car, Car.class));
        } else {
            throw new CarExeption("Invalid Brand");
        }
    }

    public CarDto getCarById (Long idChassi) {
        Car car = carRepository.findById(idChassi).orElseThrow(()-> new CarNotFound("ID Not Found"));
        CarDto carDto = new CarDto(car.getIdChassi(), car.getName(), car.getBrand(), car.getColor(), car.getFabricationYear());
        return carDto;
    }
}
