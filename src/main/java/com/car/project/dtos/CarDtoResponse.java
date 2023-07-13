package com.car.project.dtos;

public class CarDtoResponse {

    private Long idChassi;

    public Long getId(){
        return idChassi;
    }

    public void setId(Long idChassi){
        this.idChassi = idChassi;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    private String fabricationYear;

    public String getFabricationYear() {
        return fabricationYear;
    }

    public void setFabricationYear(String fabricationYear) {
        this.fabricationYear = fabricationYear;
    }
}
