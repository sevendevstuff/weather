package com.stefan.weather.controllers;

import com.stefan.weather.db.WeatherCondition;
import com.stefan.weather.services.OpenMeteoService;
import com.stefan.weather.services.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OpenMeteoAPITestController {
    private final WeatherService weather;
    @GetMapping("/getWeatherForCity")
    public ResponseEntity<WeatherCondition> getWeatherForCity(Integer id) {
        WeatherCondition condition = weather.getCityWeather(id);
        return ResponseEntity.ok(condition);
    }

    // De adaugat in baza de date si testat get Weather for city (dar relatia e facuta invers de cum am implementat serviciile)
}
