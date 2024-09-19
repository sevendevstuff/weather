package com.stefan.weather.services;

import com.stefan.weather.requests.CarRequest;

public interface CarService {
    Integer addCar(CarRequest request);
    Integer editCar(CarRequest request, Integer id);
    void deleteCar(Integer id);
}
