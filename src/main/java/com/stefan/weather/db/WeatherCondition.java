package com.stefan.weather.db;

import com.stefan.weather.util.Condition;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity(name = "weather_condition")
public class WeatherCondition {
    @Id
    public Integer id;
    public Condition condition;
    public Double temperature;

    @OneToOne(mappedBy = "weatherCondition")
    public City city;
}
