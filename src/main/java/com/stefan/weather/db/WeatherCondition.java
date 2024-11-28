package com.stefan.weather.db;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.stefan.weather.util.Condition;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class WeatherCondition implements Serializable {
//    @JsonProperty(value = "condition")
//    public Condition condition;
    @JsonProperty(value = "temperature")
    public Double temperature;
    @JsonProperty(value = "wind_speed")
    public Double windSpeed;
}
