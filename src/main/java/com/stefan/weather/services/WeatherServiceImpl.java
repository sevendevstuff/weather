package com.stefan.weather.services;

import com.stefan.weather.db.WeatherCondition;
import com.stefan.weather.repositories.WeatherConditionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {
    private final WeatherConditionRepository repository;

    @Override
    public WeatherCondition getCityWeather(Integer city_id) {
        return repository.findByCityId(city_id);
    }
}
