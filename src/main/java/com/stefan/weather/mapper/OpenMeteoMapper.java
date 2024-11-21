package com.stefan.weather.mapper;

import com.stefan.weather.db.WeatherCondition;
import com.stefan.weather.dto.OpenMeteoApiResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface OpenMeteoMapper {
    @Mapping(target = "temperature", source = "current.temperature_2m")
    @Mapping(target = "windSpeed", source = "current.wind_speed_10m")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "condition", ignore = true)
    @Mapping(target = "city", ignore = true)
    WeatherCondition toDomain(OpenMeteoApiResponse response);
}
