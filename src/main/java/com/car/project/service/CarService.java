package com.car.project.service;

import com.car.project.dtos.CarDto;
import com.car.project.entity.Car;
import com.car.project.repository.CarRepository;
import com.car.project.service.exeption.CarExeption;
import com.car.project.service.exeption.CarNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;

    private static boolean brandCheck (Car car){
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

        public Car addCar (Car car){
//        CarDescription carDescription = new CarDescription(
//                null,
//                carDtoResponse.getName(),
//                carDtoResponse.getBrand(),
//                carDtoResponse.getColor(),
//                carDtoResponse.getFabricationYear());
            if (brandCheck(car)) {
                return carRepository.save(car);
            } else {
                throw new CarExeption("Invalid Brand");
            }
        }

    public Car addCarDto (Car car){
//        CarDescription carDescription = new CarDescription(
//                null,
//                carDtoResponse.getName(),
//                carDtoResponse.getBrand(),
//                carDtoResponse.getColor(),
//                carDtoResponse.getFabricationYear());
            return carRepository.save(car);
    }



    public CarDto getCarById (Long idChassi) {
        Car car = carRepository.findById(idChassi).orElseThrow(()-> new CarNotFound("Not Found"));
        CarDto carDto = new CarDto(car.getIdChassi(), car.getName(), car.getBrand(), car.getColor(), car.getFabricationYear());
        return carDto;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
}
