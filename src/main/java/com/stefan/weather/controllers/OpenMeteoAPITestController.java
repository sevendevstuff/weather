package com.stefan.weather.controllers;

import com.stefan.weather.db.WeatherCondition;
import com.stefan.weather.services.OpenMeteoService;
import com.stefan.weather.services.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OpenMeteoAPITestController {
    private final WeatherService weather;
    @GetMapping("/getWeatherForCity/{id}")
    public ResponseEntity<WeatherCondition> getWeatherForCity(@PathVariable Integer id) {
        WeatherCondition condition = weather.getCityWeather(id);
        return ResponseEntity.ok(condition);
    }
}
