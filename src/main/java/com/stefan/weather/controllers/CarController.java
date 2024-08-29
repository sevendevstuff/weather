package com.stefan.weather.controllers;

import com.stefan.weather.repositories.CarRepository;
import com.stefan.weather.requests.CarRequest;
import com.stefan.weather.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CarController {
    private final CarService service;

    @PostMapping("/cars")
    public ResponseEntity<Integer> addCar(@RequestBody CarRequest request) {
        return ResponseEntity.ok(service.addCar(request));
    }
}
