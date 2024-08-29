package com.stefan.weather.services;

import com.stefan.weather.requests.ExampleRequest;
import org.springframework.stereotype.Service;

public interface ExampleService {
    String addExample(ExampleRequest request);
}
