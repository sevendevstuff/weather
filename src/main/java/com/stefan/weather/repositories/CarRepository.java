package com.stefan.weather.repositories;

import com.stefan.weather.db.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query(value = """
        SELECT c.* FROM Car c WHERE c.doorNumber = 2;
    """, nativeQuery = true)
    List<Car> getCoupes();
}
