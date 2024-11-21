package com.stefan.weather.services;

import com.stefan.weather.db.WeatherCondition;

public interface WeatherService {
    WeatherCondition getCityWeather(Integer city_id);
}
