package com.stefan.weather.config;

import com.stefan.weather.services.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ContextConfiguration {
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public HelloService helloService(WeatherProperties weatherProperties) { return new HelloService(weatherProperties); }

    @Bean
    public RestTemplate restTemplate() { return new RestTemplate(); }
}
