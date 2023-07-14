package com.car.project.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarDtoRequest {

    private String name;
    private String brand;
    private String color;
    private String fabricationYear;



}
