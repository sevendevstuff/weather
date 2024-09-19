package com.stefan.weather.repositories;

import com.stefan.weather.db.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query(value = """
        SELECT c.* FROM Car c WHERE c.doorNumber = 2;
    """, nativeQuery = true)
    List<Car> getCoupes();

//    @Query("UPDATE Car c SET c.name = :name, c.doorNumber = :doorNumber, c.fabricationYear = :fabricationYear WHERE c.id = :id")
//    void updateCarDetails(@Param("id") Integer id,
//                          @Param("name") String name,
//                          @Param("doorNumber") Integer doorNumber,
//                          @Param("fabricationYear") LocalDate fabricationYear);
}
