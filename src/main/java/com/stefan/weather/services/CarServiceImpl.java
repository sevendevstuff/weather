package com.stefan.weather.services;

import com.stefan.weather.db.Car;
import com.stefan.weather.repositories.CarRepository;
import com.stefan.weather.requests.CarRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@Service
public class CarServiceImpl implements CarService {
    private final CarRepository repository;

    @Override
    public Integer addCar(CarRequest request) {
        Car car = repository.save(mapCarRequestToCarEntity(request));
        return car.getId();
    }

    private Car mapCarRequestToCarEntity(CarRequest request) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");

        return Car.builder()
                .name(request.getName())
                .doorNumber(request.getDoorNumber())
                .fabricationYear(LocalDate.parse(request.getFabricationYear(), formatter))
                .build();
    }
}
