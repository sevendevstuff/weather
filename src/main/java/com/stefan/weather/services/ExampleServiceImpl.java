package com.stefan.weather.services;

import com.stefan.weather.requests.ExampleRequest;
import org.springframework.stereotype.Service;

@Service
public class ExampleServiceImpl implements ExampleService {

    @Override
    public String addExample(ExampleRequest request) {
        return request.getExampleString();
    }
}
