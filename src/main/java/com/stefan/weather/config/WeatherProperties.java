package com.stefan.weather.config;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "weather.properties")
@Data
public class WeatherProperties {
    private String helloMessage;
}
