package com.car.project.service;

import com.car.project.dto.CarDto;
import com.car.project.entity.Car;
import com.car.project.repository.CarRepository;
import com.car.project.service.exeption.CarBadRequestExeption;
import com.car.project.service.exeption.CarNotFoundExeption;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashSet;
import java.util.Set;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;
    @Autowired
    ModelMapper mapper;

    //Brand Verification by List
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
    //Null Verification
    private static boolean nullCheck(CarDto car){
        if (car.getName() != null && car.getBrand() != null && car.getColor() != null && car.getFabricationYear() != null){
            return true;
        }
        else {
            return false;
        }
    }


    //Verify Nulls and typos on Brand and save them on the Database
    public Car addCar (@RequestBody CarDto car) {
        if (brandCheck(car) && nullCheck(car)) {
            Car newCar = mapper.map(car, Car.class);
            carRepository.save(newCar);
            return newCar;
        } else if (!brandCheck(car) && !nullCheck(car)){
            throw  new CarBadRequestExeption("Null Camp And Invalid Brand");
        } else if (!nullCheck(car)) {
            throw new CarBadRequestExeption("Null Camp");
        }else{
            throw new CarBadRequestExeption("Invalid Brand");
        }
    }
    //Verify existing ids and get a Car from car_description Table by id
    public CarDto getCarById (Long idChassi) {
        Car car = carRepository.findById(idChassi).orElseThrow(()-> new CarNotFoundExeption("ID Not Found"));
        CarDto carDto = new CarDto(car.getIdChassi(), car.getName(), car.getBrand(), car.getColor(), car.getFabricationYear());
        return carDto;
    }
}
