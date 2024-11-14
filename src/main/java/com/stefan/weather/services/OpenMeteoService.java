package com.stefan.weather.services;

import com.stefan.weather.db.WeatherCondition;

public interface OpenMeteoService {
    WeatherCondition getWeather(double lat, double lon);
}
