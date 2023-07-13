package com.car.project.entity;

import javax.persistence.*;

@Entity
@Table(name = "car_description")
public class CarDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chassi")
    private Long idChassi;

    public Long getIdChassi(){
        return idChassi;
    }

    public void setIdChassi(Long idChassi){
        this.idChassi = idChassi;
    }

    @Column(name = "car_name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column (name = "car_brand")
    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Column(name = "car_color")
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Column(name = "fabrication_year")
    private String fabricationYear;

    public String getFabricationYear() {
        return fabricationYear;
    }

    public void setFabricationYear(String fabricationYear) {
        this.fabricationYear = fabricationYear;
    }

    public CarDescription() {
    }

    public CarDescription( Long idChassi, String name, String brand, String color, String fabricationYear) {
        this.name = name;
        this.brand = brand;
        this.color = color;
        this.fabricationYear = fabricationYear;
    }
}
