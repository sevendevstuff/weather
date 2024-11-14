package com.stefan.weather.services;

import com.stefan.weather.config.WeatherProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

@RequiredArgsConstructor
public class HelloService implements ApplicationRunner {
    private final WeatherProperties properties;

    private void hello() {
        System.out.println(properties.getHelloMessage());
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        hello();
    }
}
