package com.car.project.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CarExeption extends IllegalArgumentException{
    public CarExeption(String msg){
        super();
    }
}
