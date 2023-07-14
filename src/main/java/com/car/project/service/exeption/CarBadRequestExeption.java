package com.car.project.service.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CarBadRequestExeption extends IllegalArgumentException{
    public CarBadRequestExeption(String msg){
        super(msg);
    }
}
