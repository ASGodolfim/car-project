package com.car.project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "car_description")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chassi")
    private Long idChassi;
    @Column(name = "car_name")
    private String name;
    @Column (name = "car_brand")
    private String brand;
    @Column(name = "car_color")
    private String color;
    @Column(name = "fabrication_year")
    private String fabricationYear;

}
