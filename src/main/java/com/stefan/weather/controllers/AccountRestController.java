package com.stefan.weather.controllers;

import com.stefan.weather.requests.RegisterRequest;
import com.stefan.weather.services.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
