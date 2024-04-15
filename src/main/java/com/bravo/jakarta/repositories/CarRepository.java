package com.bravo.jakarta.repositories;

import com.bravo.jakarta.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository <Car, Integer> {

    Optional<Car> findByPlateNumber(String plateNumber);
}
