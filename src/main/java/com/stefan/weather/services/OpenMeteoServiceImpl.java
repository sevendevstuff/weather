package com.stefan.weather.services;

import com.stefan.weather.db.WeatherCondition;
import com.stefan.weather.dto.OpenMeteoApiResponse;
import com.stefan.weather.mapper.OpenMeteoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OpenMeteoServiceImpl implements OpenMeteoService{
    private final RestTemplate restTemplate;
    private final OpenMeteoMapper mapper;

    @Override
    public WeatherCondition getWeather(double lat, double lon) {
        String url = "https://api.open-meteo.com/v1/forecast";

        Map<String, Object> params = new HashMap<>();
        params.put("latitude", lat);
        params.put("longitude", lon);
        params.put("current", List.of("temperature_2m", "wind_speed_10m"));

        OpenMeteoApiResponse response = restTemplate.getForObject(url, OpenMeteoApiResponse.class, params);

        return mapper.toDomain(response);
    }
}
