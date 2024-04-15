package com.bravo.jakarta.repositories;

import com.bravo.jakarta.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository <Car, Integer> {
}
