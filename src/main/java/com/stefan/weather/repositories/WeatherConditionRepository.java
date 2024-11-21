package com.stefan.weather.repositories;

import com.stefan.weather.db.WeatherCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface WeatherConditionRepository extends JpaRepository<WeatherCondition, Integer> {
    @Query(value = """
            SELECT w.* FROM WeatherCondition w WHERE w.city_id = :id 
            """, nativeQuery = true)
    WeatherCondition findByCityId(Integer id);
}
