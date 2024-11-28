package com.stefan.weather.services;

import com.stefan.weather.db.WeatherCondition;
import com.stefan.weather.repositories.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {
    private final CityRepository repository;

    @Override
    public WeatherCondition getCityWeather(Integer city_id) {
        try {
            return repository.findById(city_id).get().getWeatherCondition();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(String.format("Weather condition for city with id %d not found", city_id));
        }
    }
}
