package com.car.repository;

import com.car.entity.CarDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "com.car.repository")
public interface CarRepository extends JpaRepository<CarDescription, Long> {
}
