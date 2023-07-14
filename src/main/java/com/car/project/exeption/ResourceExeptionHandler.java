package com.car.project.exeption;

import com.car.project.service.exeption.CarExeption;
import com.car.project.service.exeption.CarNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExeptionHandler {

    @ExceptionHandler(CarExeption.class)
    public ResponseEntity<StandartError>CarExeption(CarExeption ex, HttpServletRequest request){
        StandartError error = new StandartError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    @ExceptionHandler(CarNotFound.class)
    public ResponseEntity<StandartError>CarNotFound(CarNotFound ex, HttpServletRequest request){
        StandartError error = new StandartError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
