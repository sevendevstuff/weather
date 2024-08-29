package com.stefan.weather.controllers;

import com.stefan.weather.requests.ExampleRequest;
import com.stefan.weather.services.ExampleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
    private final ExampleService service;

    public ExampleController(ExampleService service) {
        this.service = service;
    }

    @PostMapping("/createExample")
    public ResponseEntity<String> postExample(@RequestBody ExampleRequest request) {
        String response = service.addExample(request);
        return ResponseEntity.ok(response);
    }
}
