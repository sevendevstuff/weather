package com.stefan.weather.controllers;

import com.stefan.weather.db.Car;
import com.stefan.weather.repositories.CarRepository;
import com.stefan.weather.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CarController {
    private final CarService service;
    private final CarRepository repository;

    @GetMapping("/cars")
    private String getCars(Model model) {
        List<Car> cars = repository.findAll();
        model.addAttribute("dataList", cars);
        return "car";
    }
}
