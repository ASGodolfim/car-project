package com.car.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {

    private Long idChassi;
    private String name;
    private String brand;
    private String color;
    private String fabricationYear;

}
