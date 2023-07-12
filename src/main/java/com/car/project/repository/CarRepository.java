package com.car.project.repository;

import com.car.project.entity.CarDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<CarDescription, Long> {
}
