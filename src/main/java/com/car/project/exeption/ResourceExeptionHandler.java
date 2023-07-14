package com.car.project.exeption;

import com.car.project.service.exeption.CarBadRequestExeption;
import com.car.project.service.exeption.CarNotFoundExeption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExeptionHandler {

    //Bad Request Exeption, used on the Null or Brand Verification
    @ExceptionHandler(CarBadRequestExeption.class)
    public ResponseEntity<StandartError>CarBadRequestExeption(CarBadRequestExeption ex, HttpServletRequest request){
        StandartError error = new StandartError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    //Not Found Exeption used on the case of unidentified id on Get by id
    @ExceptionHandler(CarNotFoundExeption.class)
    public ResponseEntity<StandartError>CarNotFoundExeption(CarNotFoundExeption ex, HttpServletRequest request){
        StandartError error = new StandartError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
