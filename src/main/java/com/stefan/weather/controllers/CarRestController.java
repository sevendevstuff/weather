package com.stefan.weather.controllers;

import com.stefan.weather.requests.CarRequest;
import com.stefan.weather.services.CarService;
import jakarta.persistence.EntityNotFoundException;
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
    public ResponseEntity<Integer> editCar(@RequestBody CarRequest request, @PathVariable Integer id) {
        try {
            Integer response = service.editCar(request, id);
            return ResponseEntity.ok(response);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/cars/{id}/delete")
    public ResponseEntity<Void> deleteCar(@PathVariable Integer id) {
        try {
            service.deleteCar(id);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
