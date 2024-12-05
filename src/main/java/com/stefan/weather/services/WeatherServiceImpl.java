package com.stefan.weather.services;

import com.stefan.weather.db.City;
import com.stefan.weather.db.WeatherCondition;
import com.stefan.weather.repositories.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {
    private final CityRepository repository;

    @Override
    public WeatherCondition getCityWeather(Integer city_id) {
        try {
            Optional<City> cityOptional = repository.findById(city_id);
            City city = cityOptional.get();
            if (checkTimestamp(city.getLastUpdated().toInstant(ZoneOffset.ofHours(0)))) {
                // De updatat cu noile info de la open meteo si returnat noul rezultat
            }

        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(String.format("Weather condition for city with id %d not found", city_id));
        }
    }

    private boolean checkTimestamp(Instant instant) {
        Instant result = Instant.now().minus(10, ChronoUnit.MINUTES);
        return instant == null || instant.isBefore(result);
    }
}
