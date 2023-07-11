package com.car.entity;

import javax.persistence.*;

@Entity
@Table(name = "car_description")
public class CarDescription {
    public Long getId(){
        return id;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chassi")
        private Long id;

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

}
