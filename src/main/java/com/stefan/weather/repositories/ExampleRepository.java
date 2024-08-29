package com.stefan.weather.repositories;

import com.stefan.weather.db.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExampleRepository extends JpaRepository<Example, Integer> {
}
