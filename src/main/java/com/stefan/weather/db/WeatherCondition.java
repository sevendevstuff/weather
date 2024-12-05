package com.stefan.weather.db;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class WeatherCondition implements Serializable {
    @JsonProperty("temperature")
    public Double temperature;
    @JsonProperty("wind_speed")
    public Double windSpeed;
}
