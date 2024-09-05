package com.stefan.weather.controllers;

import com.stefan.weather.requests.CarRequest;
import com.stefan.weather.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CarRestController {
    private final CarService service;

    @PostMapping("/cars")
    public ResponseEntity<Integer> addCar(@RequestBody CarRequest request) {
        try {
            Integer response = service.addCar(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/cars/{id}")
    public void editCar(@RequestBody CarRequest request, @PathVariable Integer id) {

    }

    @DeleteMapping("/cars/{id}/delete")
    public void deleteCar(@PathVariable Integer id) {

    }
}
