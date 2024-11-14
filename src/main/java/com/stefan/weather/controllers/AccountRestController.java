package com.stefan.weather.controllers;

import com.stefan.weather.requests.LoginRequest;
import com.stefan.weather.requests.RegisterRequest;
import com.stefan.weather.services.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AccountRestController {
    private final AccountService service;

    @PostMapping("/register")
    public ResponseEntity<String> registerAccount(@Valid @RequestBody RegisterRequest request) {
        try {
            String response = service.register(request);
            return ResponseEntity.ok(response);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Void> loginAccount(@Valid @RequestBody LoginRequest request) {
        try {
            service.login(request);
            return ResponseEntity.ok().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/add/{city_id}/forAccount/{account_id}")
    public ResponseEntity<Void> addCityForAccount(@Valid @PathVariable Integer city_id, @Valid @PathVariable Integer account_id) {
        try {
            service.addCityForAccount(city_id, account_id);
            return ResponseEntity.ok().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/delete/{city_id}/forAccount/{account_id}")
    public ResponseEntity<Void> deleteCityForAccount(@Valid @PathVariable Integer city_id, @Valid @PathVariable Integer account_id) {
        try {
            service.deleteCityForAccount(city_id, account_id);
            return ResponseEntity.ok().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
