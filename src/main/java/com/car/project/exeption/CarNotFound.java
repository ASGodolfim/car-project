package com.car.project.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CarNotFound extends RuntimeException{
    public CarNotFound(String msg){
        super();
    }
}