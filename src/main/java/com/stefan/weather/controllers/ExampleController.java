package com.stefan.weather.controllers;

import com.stefan.weather.requests.ExampleRequest;
import com.stefan.weather.services.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExampleController {
    private final ExampleService service;

    @PostMapping("/createExample")
    public ResponseEntity<String> postExample(@RequestBody ExampleRequest request) {
        String response = service.addExample(request);
        return ResponseEntity.ok(response);
    }
}
